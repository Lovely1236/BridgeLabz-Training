package com.fundooapp.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
import java.time.Duration;
import java.util.Date;

@Service
public class JwtService {
    private final SecretKey key;
    private final long expirationMs;

    public JwtService(@Value("${fundoo.jwt.secret}") String secret,
                      @Value("${fundoo.jwt.expiration-ms}") long expirationMs) {
        String material = secret.length() >= 32 ? secret : secret + "-fundoo-secret-padding-123456789";
        this.key = Keys.hmacShaKeyFor(material.getBytes(java.nio.charset.StandardCharsets.UTF_8));
        this.expirationMs = expirationMs;
    }

    public String generate(String email) {
        Date now = new Date();
        return Jwts.builder().subject(email).issuedAt(now)
                .expiration(new Date(now.getTime() + expirationMs)).signWith(key).compact();
    }

    public String extractSubject(String token) {
        return parse(token).getPayload().getSubject();
    }

    public long remainingTtlSeconds(String token) {
        long seconds = Duration.ofMillis(parse(token).getPayload().getExpiration().getTime() - System.currentTimeMillis()).toSeconds();
        return Math.max(1, seconds);
    }

    public boolean isValid(String token) {
        try { parse(token); return true; }
        catch (JwtException | IllegalArgumentException ex) { return false; }
    }

    private Jws<Claims> parse(String token) {
        return Jwts.parser().verifyWith(key).build().parseSignedClaims(token);
    }
}
