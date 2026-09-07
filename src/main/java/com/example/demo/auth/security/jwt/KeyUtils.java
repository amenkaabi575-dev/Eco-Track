package com.example.demo.auth.security.jwt;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class KeyUtils {

    private static String readKeyFromResource(String path) throws IOException {

        try (InputStream inputStream = KeyUtils.class.getResourceAsStream(path)){

            return new String(inputStream.readAllBytes());
        }

    }

    public static PrivateKey loadPrivateKey(String path){

        try {

            String key = readKeyFromResource(path).replace("-----BEGIN PRIVATE KEY-----","")
                    .replace("-----END PRIVATE KEY-----","")
                    .replaceAll("\\s","");

            byte[] decoded = Base64.getDecoder().decode(key);
            PKCS8EncodedKeySpec spec =new PKCS8EncodedKeySpec(decoded);
            return KeyFactory.getInstance("RSA").generatePrivate(spec);

        }
        catch (NoSuchAlgorithmException | InvalidKeySpecException | IOException | IllegalArgumentException e){

            throw new IllegalStateException("Failed to load RSA private key from " + path, e);

        }

    }

    public static PublicKey loadPublicKey(String path){

        try {

            String key = readKeyFromResource(path).replace("-----BEGIN PUBLIC KEY-----","")
                    .replace("-----END PUBLIC KEY-----","")
                    .replaceAll("\\s","");

            byte[] decoded = Base64.getDecoder().decode(key);
            X509EncodedKeySpec spec =new X509EncodedKeySpec(decoded);
            return KeyFactory.getInstance("RSA").generatePublic(spec);

        }
        catch (NoSuchAlgorithmException | InvalidKeySpecException | IOException | IllegalArgumentException e){

            throw new IllegalStateException("Failed to load RSA public key from " + path, e);

        }

    }


}