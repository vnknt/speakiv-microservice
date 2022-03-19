package com.speakiv.speakivcore.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.Configuration;
//import io.jsonwebtoken.Jwts;
//import org.springframework.security.core.userdetails.UserDetails;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.function.Function;

@Configuration
public class TokenManager {
//    private final Integer EXPIRATION_TIME_IN_MILLISECOND  =20*60*1000;
//    private final String secret_key = "secretkey";
//
//    public String generateToken(UserDetails userDetails){
//        HashMap<String,Object> claims = new HashMap<>();
//        SignatureAlgorithm algorithm = SignatureAlgorithm.HS256;
//        String token = Jwts.builder()
//                .setSubject(userDetails.getUsername())
//                .setClaims(claims)
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME_IN_MILLISECOND))
//                .signWith(algorithm,secret_key)
//                .compact();
//        return token;
//    }
//
//    public boolean isTokenValid(String token,String subject){
//        return  extractSubject(token).equals(subject) && !isTokenExpired(token) ;
//    }
//
//    private boolean isTokenExpired(String token){
//        Date expirationDate = this.extractClaim(token,Claims::getExpiration);
//        return expirationDate.before(new Date(System.currentTimeMillis()));
//    }
//
//    private String extractSubject(String token){
//        return this.extractClaim(token,Claims::getSubject);
//    }
//
//    private <T> T extractClaim(String token, Function<Claims,T> extractFunction){
//
//        Claims claims = Jwts.parser().setSigningKey(secret_key).parseClaimsJws(token).getBody();
//        return extractFunction.apply(claims);
//
//    }



}
