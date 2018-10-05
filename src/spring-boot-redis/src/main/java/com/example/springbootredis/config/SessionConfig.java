package com.example.springbootredis.config;

import org.springframework.context.annotation.Configuration;

/**
 * @Author: ming.zhao
 * @Date: 2018-10-05 22:46
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)
public class SessionConfig {

}
