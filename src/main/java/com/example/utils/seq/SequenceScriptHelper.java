package com.example.utils.seq;

import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.scripting.support.ResourceScriptSource;

/**
 * @Auther: ld
 * @Date: 2019/4/29 09:26
 * @Param ${tags}
 * @Description:
 */
public class SequenceScriptHelper {
	private SequenceScriptHelper() {
	}

	public static final RedisScript<Long> sequenceScript() {
		DefaultRedisScript<Long> redisScript = new DefaultRedisScript();
		redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("META-INF/scripts/sequences.lua")));
		redisScript.setResultType(Long.class);
		return redisScript;
	}

	public static final RedisScript<Long> sequenceCycleSettingScript() {
		DefaultRedisScript<Long> redisScript = new DefaultRedisScript();
		redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("META-INF/scripts/sequencescycleset.lua")));
		redisScript.setResultType(Long.class);
		return redisScript;
	}

	public static final RedisScript<Long> sequenceValinitScript() {
		DefaultRedisScript<Long> redisScript = new DefaultRedisScript();
		redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("META-INF/scripts/sequencesvalinit.lua")));
		redisScript.setResultType(Long.class);
		return redisScript;
	}

	public static final RedisScript<Long> sequenceCacheScript() {
		DefaultRedisScript<Long> redisScript = new DefaultRedisScript();
		redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("META-INF/scripts/sequencescache.lua")));
		redisScript.setResultType(Long.class);
		return redisScript;
	}
}
