package com.company;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class SecurityUtil {
    public static String DES = "AES"; // optional value AES/DES/DESede

    public static String CIPHER_ALGORITHM = "AES"; // optional value AES/DES/DESede


    public static Key getSecretKey(String key) throws Exception {
        SecretKey secureKey = null;
        if (key == null) {
            key = "";
        }
        KeyGenerator keyGenerator = KeyGenerator.getInstance(DES);
        keyGenerator.init(new SecureRandom(key.getBytes()));
        secureKey = keyGenerator.generateKey();
        return secureKey;
    }

    public static String encrypt(String data, String key) throws Exception {
        SecureRandom sr = new SecureRandom();
        Key secureKey = getSecretKey(key);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secureKey, sr);
        byte[] bt = cipher.doFinal(data.getBytes());
        String strs = new BASE64Encoder().encode(bt);
        return strs;
    }


    public static String detrypt(String message, String key) throws Exception {
        SecureRandom sr = new SecureRandom();
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        Key secureKey = getSecretKey(key);
        cipher.init(Cipher.DECRYPT_MODE, secureKey, sr);
        byte[] res = new BASE64Decoder().decodeBuffer(message);
        res = cipher.doFinal(res);
        return new String(res);
    }

    public static void main(String[] args) throws Exception {
        String message = "123456";
        String key = "landLeaf";
        String entryptedMsg = encrypt(message, key);
        System.out.println("encrypted message is below :");
        System.out.println(entryptedMsg);

        String decryptedMsg = detrypt(entryptedMsg, key);
        System.out.println("decrypted message is below :");
        System.out.println(decryptedMsg);
    }
}
