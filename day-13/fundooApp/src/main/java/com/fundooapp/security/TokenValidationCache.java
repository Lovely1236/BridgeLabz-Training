package com.fundooapp.security;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import java.time.Duration;

@Component
public class TokenValidationCache {
    private final StringRedisTemplate redis;
    public TokenValidationCache(StringRedisTemplate redis) { this.redis = redis; }

    public String get(String token) {
        try { return redis.opsForValue().get(key(token)); }
        catch (RuntimeException ignored) { return null; }
    }

    public void put(String token, String subject, long ttlSeconds) {
        try { redis.opsForValue().set(key(token), subject, Duration.ofSeconds(Math.max(1, ttlSeconds))); }
        catch (RuntimeException ignored) { }
    }

    private String key(String token) { return "jwt:valid:" + token; }
}
