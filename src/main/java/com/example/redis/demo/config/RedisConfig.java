package com.example.redis.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    //2 things are needed , jedisConnectionFactory to maintain the connections
    //JedisTemplate to interact with redis.

    @Bean
    public JedisConnectionFactory getConnectionFactory()
    {
        RedisStandaloneConfiguration conf = new RedisStandaloneConfiguration();
        conf.setHostName("127.0.0.1");
        conf.setPort(6379);

        JedisConnectionFactory factory = new JedisConnectionFactory(conf);
        //here we can change default connection pool size , max idle time etc.
        return factory;
    }

    @Bean
    public RedisTemplate<String , Object> getRedisTemplate()
    {
        RedisTemplate<String , Object> template = new RedisTemplate<>();
        template.setConnectionFactory(this.getConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new JdkSerializationRedisSerializer());
        template.setValueSerializer(new JdkSerializationRedisSerializer());
        template.setEnableTransactionSupport(true); //as we are using it as a NOSQL store.
        template.afterPropertiesSet();
        return template;
    }


}
