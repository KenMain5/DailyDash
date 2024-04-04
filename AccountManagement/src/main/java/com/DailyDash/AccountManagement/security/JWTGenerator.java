package com.DailyDash.AccountManagement.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JWTGenerator {

    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    //Authentication is being passed in
    public String generateToken(Authentication authentication){
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expirationDate = new Date(currentDate.getTime() + SecurityConstants.JWT_EXPIRATION);

        //Generating the JWT, we put the claims, the header is auto insertted by the signWith method
        //its encoded using the compact method.. not enough claims here..
        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
        return token;
    }



    public String getUsernameFromJWT(String token){
        Claims claims = Jwts
                .parserBuilder()
                .setSigningKey(key) //give it the signing key..
                .build() //build the JWT parser
                .parseClaimsJws(token) //parse and validate signature. . It returns a Jws<Claims> object
                .getBody(); //: This method is called on the Jws<Claims> object to extract the Claims object, which represents the payload of the JWT
        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            return false;        }
    }





}
