package com.korit.springboot.jwt;

import com.korit.springboot.entity.UserEntity;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private final SecretKey key;

    public JwtTokenProvider(@Value("${jwt.secret}") String secret) {
        key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    public String createAccessToken(UserEntity userEntity) {
        Date now = new Date();
        long expiredTime = now.getTime() + (1000l * 60l * 60l * 24l);
        Date expiredDate = new Date(expiredTime);

        return Jwts.builder()
                .subject("server Access Token")
                .issuer("박성은")
                .issuedAt(new Date())
                .expiration(expiredDate) //필수
                .claim("userId", userEntity.getUserId())//필수
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            JwtParser jwtParser = Jwts.parser()
                    .setSigningKey(key)
                    .build();
            jwtParser.parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            //예외시에 그냥 claims에 들어있는 null을 리턴하기위함
            return false;
        }

    }

    public int getUserId(String token) {
        return (int) Jwts.parser()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getPayload()
                .get("userId");
    }
}