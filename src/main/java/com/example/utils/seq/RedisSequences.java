package com.example.utils.seq;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: ld
 * @Date: 2019/4/28 11:56
 * @Param ${tags}
 * @Description:
 */
public class RedisSequences {
	private static final String DEFAULT_SEQUENCE_PREFIX = "gxb:seq:";
	private String prefix = "gxb:seq:";
	private static final long DEFAULT_CACHE = 1000L;
	private final ConcurrentMap<String, AtomicInteger> cached = new ConcurrentHashMap();
	private final ConcurrentMap<String, Long> currVal = new ConcurrentHashMap();
	private final ConcurrentMap<String, Object> locks = new ConcurrentHashMap();
	private final RedisScript<Long> sequenceScript;
	private final RedisScript<Long> sequenceCycleSettingScript;
	private final RedisScript<Long> sequenceValInitScript;
	private final RedisScript<Long> sequenceCacheScript;
	private final RedisTemplate<String, Long> stringLongRedisTemplate;

	public RedisSequences(RedisConnectionFactory redisConnectionFactory, RedisScript<Long> sequenceScript, RedisScript<Long> sequenceCycleSettingScript, RedisScript<Long> sequenceValInitScript, RedisScript<Long> sequenceCacheScript) {
		this.sequenceScript = sequenceScript;
		this.sequenceCycleSettingScript = sequenceCycleSettingScript;
		this.sequenceValInitScript = sequenceValInitScript;
		this.sequenceCacheScript = sequenceCacheScript;
		this.stringLongRedisTemplate = this.createTemplate(redisConnectionFactory);
	}

	private RedisTemplate<String, Long> createTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Long> redisTemplate = new RedisTemplate();
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new GenericToStringSerializer(Long.class));
		redisTemplate.setExposeConnection(true);
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}

	public Long nextVal(String seqName) {
		this.cached.putIfAbsent(seqName, new AtomicInteger(-1));
		this.currVal.putIfAbsent(seqName, 0L);
		this.locks.putIfAbsent(seqName, new Object());
		int curCache = ((AtomicInteger)this.cached.get(seqName)).incrementAndGet();
		Long curv;
		if (curCache == 0) {
			synchronized(this.locks.get(seqName)) {
				curv = (Long)this.currVal.get(seqName);
				curv = (Long)this.stringLongRedisTemplate.execute(this.sequenceScript, Collections.singletonList(this.keyForName(seqName)), new Object[0]);
				this.currVal.put(seqName, curv);
				this.prelocateValue(seqName);
				return (Long)this.currVal.get(seqName);
			}
		} else if ((long)curCache > 1000L) {
			synchronized(this.locks.get(seqName)) {
				curv = (Long)this.currVal.get(seqName) + 1L;
				this.currVal.put(seqName, curv);
				this.prelocateValue(seqName);
				((AtomicInteger)this.cached.get(seqName)).set(0);
				return (Long)this.currVal.get(seqName);
			}
		} else {
			synchronized(this.locks.get(seqName)) {
				long val = (Long)this.currVal.get(seqName) + 1L;
				this.currVal.put(seqName, val);
				return (Long)this.currVal.get(seqName);
			}
		}
	}

	private void prelocateValue(String seqName) {
		long next = (Long)this.stringLongRedisTemplate.execute(this.sequenceCacheScript, Collections.singletonList(this.keyForName(seqName)), new Object[]{1000L});
		if ((Long)this.currVal.get(seqName) > next) {
			this.currVal.put(seqName, next);
			this.stringLongRedisTemplate.execute(this.sequenceCacheScript, Collections.singletonList(this.keyForName(seqName)), new Object[]{1000L});
		}

	}

	public boolean setCycleMaxValue(String seqName, Long maxValue) {
		return (Long)this.stringLongRedisTemplate.execute(this.sequenceCycleSettingScript, Collections.singletonList(this.keyForName(seqName)), new Object[]{maxValue}) == 1L;
	}

	public boolean initVal(String seqName, Long initValue) {
		return (Long)this.stringLongRedisTemplate.execute(this.sequenceValInitScript, Collections.singletonList(this.keyForName(seqName)), new Object[]{initValue}) == 1L;
	}

	public void setPrefix(String prefix) {
		if (!prefix.endsWith(":")) {
			prefix = prefix + ":";
		}

		this.prefix = prefix;
	}

	private String keyForName(String name) {
		return this.prefix + name;
	}
}
