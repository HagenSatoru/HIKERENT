package com.Hikerent.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    // Minimal 256 bit (32 karakter)
    private static final String SECRET_KEY =
            "12345678901234567890123456789012";

    private SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(
                java.util.Base64.getEncoder().encodeToString(SECRET_KEY.getBytes())
        );
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(String username) {

        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(getSignInKey())
                .compact();
    }

    public String extractUsername(String token) {

        return extractClaim(token, Claims::getSubject);

    }

    public <T> T extractClaim(String token,
                              Function<Claims, T> resolver) {

        Claims claims = Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return resolver.apply(claims);

    }

    public boolean isTokenValid(String token,
                                String username) {

        return extractUsername(token).equals(username)
                && !isTokenExpired(token);

    }

    private boolean isTokenExpired(String token) {

        return extractClaim(token,
                Claims::getExpiration).before(new Date());

    }

}