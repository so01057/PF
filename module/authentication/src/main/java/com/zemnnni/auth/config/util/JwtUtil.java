package com.zemnnni.auth.config.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

/**
 * @작성자 : DATA
 * @파일명 : JwtUtil
 * @작성일 : 2025-05-07
 * @설명 :
 */

@Component
public class JwtUtil {

    @Value("${authentication.jwt.secret-key}")
    private String jwtSecretKey;

    @Value("${authentication.jwt.access-token.expiration-time}")
    private int accessTokenExpiration;

    @Value("${authentication.jwt.refresh-token.expiration-time}")
    private int refreshTokenExpiration;

    /* HS256 알고리즘 */
    private static final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    private Key getByteKey(){
        return Keys.hmacShaKeyFor(jwtSecretKey.getBytes());
    }

    public String generateAccessToken(Map<String,Object> claimMap, String tokenName){
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + accessTokenExpiration);

        return Jwts.builder()
                .setClaims(claimMap) // 페이로드에 클레임 설정
                .setSubject(tokenName) // 토큰 제목 (일반적으로 사용자 ID)
                .setIssuedAt(now) // 토큰 발행 시간
                .setExpiration(expiryDate) // 토큰 만료 시간
                .signWith(getByteKey(), signatureAlgorithm) // 서명 알고리즘과 키 설정
                .compact(); // JWT 문자열로 압축
    }

    public String generateRefreshToken(Map<String,Object> claimMap, String tokenName){
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + refreshTokenExpiration);

        return Jwts.builder()
                .setClaims(claimMap) // 페이로드에 클레임 설정
                .setSubject(tokenName) // 토큰 제목 (일반적으로 사용자 ID)
                .setIssuedAt(now) // 토큰 발행 시간
                .setExpiration(expiryDate) // 토큰 만료 시간
                .signWith(getByteKey(), SignatureAlgorithm.HS256) // 서명 알고리즘과 키 설정
                .compact(); // JWT 문자열로 압축
    }

    // JWT에서 특정 클레임 추출
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    // JWT에서 모든 클레임 추출 (검증 없이)
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getByteKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // JWT에서 Subject 추출
    public String getSubjectFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    // JWT에서 만료 시간 추출
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    // 토큰이 만료되었는지 확인
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    // Access Token 유효성 검증
    public Boolean validateAccessToken(String token, String subject) {
        final String tokenSubject = getSubjectFromToken(token);
        return (tokenSubject.equals(subject) && !isTokenExpired(token));
    }

    // Refresh Token 유효성 검증 (만료 여부만 확인하는 경우가 많음)
    public Boolean validateRefreshToken(String token) {
        return !isTokenExpired(token);
    }


}
