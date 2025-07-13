package com.example.hello.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtils {
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private long expiration;

    // 生成签名密钥
    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    /**
     * Generate JWT token
     */
    public String generateToken(Integer id, String username) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", id);
        claims.put("username", username);

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSigningKey(), SignatureAlgorithm.HS512) // 使用Key对象签名
                .compact();
    }

    /**
     * Get username from token
     */
    public String getUsernameFromToken(String token) {
        return getClaimsFromToken(token).get("username", String.class);
    }

    /**
     * Verify if token is valid
     */
    public boolean validateToken(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            return !claims.getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Get claims from token
     */
    private Claims getClaimsFromToken(String token) {
        return Jwts.parserBuilder() // 使用新的parserBuilder()
                .setSigningKey(getSigningKey()) // 使用Key对象验证
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}