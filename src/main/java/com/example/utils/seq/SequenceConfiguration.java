package com.example.utils.seq;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.script.RedisScript;

/**
 * @Auther: ld
 * @Date: 2019/4/29 09:24
 * @Param ${tags}
 * @Description:
 */
@Configuration
public class SequenceConfiguration {
	@Bean
	public RedisScript<Long> sequenceScript() {
		return SequenceScriptHelper.sequenceScript();
	}

	@Bean
	public RedisScript<Long> sequenceCycleSettingScript() {
		return SequenceScriptHelper.sequenceCycleSettingScript();
	}

	@Bean
	public RedisScript<Long> sequenceValinitScript() {
		return SequenceScriptHelper.sequenceValinitScript();
	}

	@Bean
	public RedisScript<Long> sequenceCacheScript() {
		return SequenceScriptHelper.sequenceCacheScript();
	}

	@Bean
	RedisSequences redisSequences(RedisConnectionFactory redisConnectionFactory,
								  RedisScript<Long> sequenceScript,
								  RedisScript<Long> sequenceValinitScript,
								  RedisScript<Long> sequenceCycleSettingScript, RedisScript<Long> sequenceCacheScript) {
		return new RedisSequences(redisConnectionFactory, sequenceScript, sequenceCycleSettingScript, sequenceValinitScript, sequenceCacheScript);
	}
}
