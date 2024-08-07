package com.BurakAciker.AuthService.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class jwtTokenService {
    private final Logger logger = LogManager.getLogger(RoleServiceImpl.class);
    private static final String SECRET_KEY = "404E635266556A586E3372357538782F413F4428452B4B6250645367566B5970";

    /**
     * Bir token içerisindeki bütün alanları getirir.
     * @param token
     *
     * @return Claims
     */
    private Claims getAllClaimsFromToken(String token) {
        logger.info("getAllClaimsFromToken method parameter:" + token);

        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    public <T> T getClaimFromToken(String token, String claimName, Class<T> tClass) {
        Claims claims = getAllClaimsFromToken(token);
        return claims.get(claimName, tClass);
    }

    /**
     * Bir token içerisindeki username alanını getirir.
     * @param token
     *
     * @return String
     */
    public String getUsernameFromToken(String token) {
        logger.info("getUsernameFromToken method parameter:" + token);
        Claims claims = getAllClaimsFromToken(token);
        return claims.getSubject();
    }
    /**
     * Token validasyonu yapar.
     * @param token
     * @param username
     *
     * @return boolean
     */
    public boolean validateToken(String token, String username ) {
        logger.info("validateToken method Token:" + token + "  Username: " + username);
        return (username.equals(getUsernameFromToken(token)) && !isTokenExpired(token));
    }

    /**
     * Token zamanaşımı kontrolü yapar.
     * @param token
     *
     * @return boolean
     */
    private boolean isTokenExpired(String token) {
        return getExpirationDateFromToken(token).before(new java.util.Date());
    }

    /**
     * Bir token içerisindeki expiration alanını getirir.
     * @param token
     *
     * @return Date
     */
    public java.util.Date getExpirationDateFromToken(String token) {
        Claims claims = getAllClaimsFromToken(token);
        return claims.getExpiration();
    }

    /**
     * Bir token oluşturur.
     * @param user
     *
     * @return String
     */
    public String generateToken( UserDetails user){
        logger.info("generateToken method parameter:" + user);
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new java.util.Date())
                .setExpiration(new java.util.Date((new java.util.Date()).getTime() + 1000 * 60 * 60 * 10))
                .signWith(getSignInKey())
                .compact();
    }

    /**
     * Token imzası getirir.
     *
     * @return Key
     */
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
