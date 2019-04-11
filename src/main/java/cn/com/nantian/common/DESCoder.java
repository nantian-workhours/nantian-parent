//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.com.nantian.common;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class DESCoder {
    private static final String KEY = "qinggang";
    public static String SECONDKEY = "qinggang";

    public DESCoder() {
    }

    public static byte[] desEncrypt(byte[] plainText) throws Exception {
        SecureRandom sr = new SecureRandom();
        DESKeySpec dks = new DESKeySpec("qinggang".getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey key = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(1, key, sr);
        byte[] encryptedData = cipher.doFinal(plainText);
        return encryptedData;
    }

    public static byte[] desDecrypt(byte[] encryptText) throws Exception {
        SecureRandom sr = new SecureRandom();
        DESKeySpec dks = new DESKeySpec("qinggang".getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey key = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(2, key, sr);
        byte[] decryptedData = cipher.doFinal(encryptText);
        return decryptedData;
    }

    public static String encrypt(String input) throws Exception {
        return base64Encode(desEncrypt(input.getBytes()));
    }

    public static String decrypt(String input) throws Exception {
        byte[] result = base64Decode(input);
        return new String(desDecrypt(result));
    }

    public static String base64Encode(byte[] s) {
        if (s == null) {
            return null;
        } else {
            BASE64Encoder b = new BASE64Encoder();
            return b.encode(s);
        }
    }

    public static byte[] base64Decode(String s) throws IOException {
        if (s == null) {
            return null;
        } else {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] b = decoder.decodeBuffer(s);
            return b;
        }
    }

    public static String md5(String s) throws Exception {
        MessageDigest messageDigest = null;

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(s.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException var5) {
            System.out.println("NoSuchAlgorithmException caught!");
            System.exit(-1);
        } catch (UnsupportedEncodingException var6) {
            var6.printStackTrace();
        }

        byte[] byteArray = messageDigest.digest();
        StringBuffer md5StrBuff = new StringBuffer();

        for(int i = 0; i < byteArray.length; ++i) {
            if (Integer.toHexString(255 & byteArray[i]).length() == 1) {
                md5StrBuff.append("0").append(Integer.toHexString(255 & byteArray[i]));
            } else {
                md5StrBuff.append(Integer.toHexString(255 & byteArray[i]));
            }
        }

        return md5StrBuff.toString();
    }

    public static void main(String[] args) {
        try {
            System.out.println(encrypt("1"));
            System.out.println(decrypt("XHDcnN3xxow="));
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }
}
