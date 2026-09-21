package com.example.demo.auth.security.jwt;

import com.example.demo.auth.security.CustomUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class JwtService {


    private final PrivateKey privateKey;
    private final PublicKey publicKey;
    public static final String TOKEN_TYPE = "token_type";
    public static final String ACCESS_TOKEN = "ACCESS_TOKEN";
    public static final String REFRESH_TOKEN = "REFRESH_TOKEN";
    @Value("${app.security.jwt.refresh-token-expiration}")
    private long refreshTokenExpiration;
    @Value("${app.security.jwt.access-token-expiration}")
    private long accessTokenExpiration;

    public JwtService() {
        this.privateKey = KeyUtils.loadPrivateKey("/keys/local-only/private_key.pem");
        this.publicKey = KeyUtils.loadPublicKey("/keys/public/public_key.pem");
    }

    private static Map<String,Object> prepareCustomClaims(CustomUserDetails userDetails, String tokenType){

        Map<String, Object> claims = new HashMap<>();

        claims.put("id", userDetails.getId());
        claims.put("role", userDetails.getRole());
        claims.put(TOKEN_TYPE, tokenType);

        if (userDetails.getOrganizationId() != null) {
            claims.put("organizationId", userDetails.getOrganizationId());
        }

        return claims;

    }

    private String buildToken(String username, Map<String,Object> customClaims, long expiration){

        return Jwts.builder()
                .subject(username)
                .claims(customClaims)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+expiration))
                .signWith(privateKey)
                .compact()
                ;
    }

    public String generateRefreshToken(CustomUserDetails userDetails){

        Map<String,Object> customClaims = prepareCustomClaims(userDetails, REFRESH_TOKEN);
        return buildToken(userDetails.getUsername(),customClaims, this.refreshTokenExpiration);

    }

    public String generateAccessToken(CustomUserDetails userDetails){

        Map<String,Object> customClaims = prepareCustomClaims(userDetails, ACCESS_TOKEN);
        return buildToken(userDetails.getUsername(), customClaims, this.accessTokenExpiration);

    }

    public Claims extractClaims(String token){

        return Jwts.parser()
                .verifyWith(this.publicKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();

    }

    public String extractUsername(String token){

        return extractClaims(token).getSubject();

    }

    public UUID extractId(String token){

        return extractClaims(token).get("id", UUID.class);

    }

    public String extractTokenType(String token){

        return extractClaims(token).get(TOKEN_TYPE,String.class);

    }

    public boolean isTokenValid(String token, String expectedUsername){

        return expectedUsername.equals(extractUsername(token));

    }

}
