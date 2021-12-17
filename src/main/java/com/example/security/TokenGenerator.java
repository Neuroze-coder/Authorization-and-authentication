package com.example.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenGenerator {
    public String GetToken(Long userId, String login, String userRole) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("login", login);
        claims.put("role", userRole);
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + 60*60*99999999);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(String.valueOf(userId))
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, "verySecretCharacterSequence")
                .compact();
    }

}
