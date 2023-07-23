package com.lee.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    private static final String SECRET_KEY = "0123456789"; // 密钥，请使用足够复杂的随机字符串

    private static final long EXPIRATION_TIME = 86400000; // 过期时间，这里设置为24小时（以毫秒为单位）

    public String generateToken(String username) {
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC256(SECRET_KEY));
    }

    public String getUsernameFromToken(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getSubject();
    }

    public boolean isTokenValid(String token, String username) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET_KEY))
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getSubject().equals(username);
        } catch (Exception e) {
            return false;
        }
    }
}
