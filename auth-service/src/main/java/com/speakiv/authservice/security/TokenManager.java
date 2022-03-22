package com.speakiv.authservice.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Configuration
public class TokenManager {
    private final int expiration_time = 20*60*1000;
    private final String secretKey = "secretkey";

    public String generateToken(UserDetails userDetails ){

        Map<String,Object> claims = new HashMap<>();
        claims.put("roles",userDetails.getAuthorities());
        SignatureAlgorithm algorithm = SignatureAlgorithm.HS256;
        String accessToken = Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuer("speakiv.com")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration_time))
                .signWith(algorithm,secretKey)
                .compact();
        return accessToken;
    }


    public boolean isTokenValid(String token,String subject){
        return this.extractSubject(token).equals(subject) && !isExpired(token);
    }

    public boolean isExpired(String token){
        Date expirationDate = this.extractExpirationDate(token);
        return expirationDate.before(new Date(System.currentTimeMillis()));
    }

    public String extractSubject(String token){
        return this.extractCliam(token, Claims::getSubject);
    }

    public Date extractExpirationDate(String token){
        return this.extractCliam(token,Claims::getExpiration);
    }

    public List<String> extractRoles(String token){
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        return (List<String>) claims.get("roles");
    }

    public <T> T extractCliam(String token, Function<Claims,T> extractionFunc){
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        return extractionFunc.apply(claims);

    }

}
