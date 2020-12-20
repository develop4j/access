package com.levy.access.utils;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author levy
 * @date 2020/12/20
 */
public class TokenUtils {
    private static final String DES = "DES";
    private static final String MD5 = "MD5";
    public static final String KEY = "YzcmCZNvbXocrsz9dm8e";

    /**
     * 根据key进行加密处理
     *
     * @param key  秘钥
     * @param data 待加密内容
     * @return
     */
    public static String encryptDes(String key, String data) {
        try {
            // 生成一个可信任的随机数源
            SecureRandom sr = new SecureRandom();
            // 从原始密钥数据创建DESKeySpec对象
            DESKeySpec dks = new DESKeySpec(key.getBytes(StandardCharsets.UTF_8));
            // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
            SecretKey secureKey = keyFactory.generateSecret(dks);
            // Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance(DES);
            // 用密钥初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, secureKey, sr);
            // 现在，获取数据并加密
            byte[] bytes = Base64.encodeBase64(cipher.doFinal(data.getBytes()));
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * des解密
     *
     * @param key  解密秘钥
     * @param data 待解密内容
     * @return
     */
    public static String decryptDes(String key, String data) {
        try {
            // 生成一个可信任的随机数源
            SecureRandom sr = new SecureRandom();
            // 从原始密钥数据创建DESKeySpec对象
            DESKeySpec dks = new DESKeySpec(key.getBytes(StandardCharsets.UTF_8));
            // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
            SecretKey secureKey = keyFactory.generateSecret(dks);
            // Cipher对象实际完成解密操作
            Cipher cipher = Cipher.getInstance(DES);
            // 用密钥初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE, secureKey, sr);
            byte[] bytes = cipher.doFinal(Base64.decodeBase64(data));
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * md5加密
     *
     * @param data
     * @return
     */
    public static String encryptMd5(String data) {
        try {
            MessageDigest mds = MessageDigest.getInstance(MD5);
            // 获取二进制内容
            byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
            // 加密
            byte[] digest = mds.digest(bytes);
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                int c = b & 0xff;
                if (c < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(c));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * md5解密
     *
     * @param data
     * @return
     */
    public static String decryptMd5(String data) {
        char[] chars = data.toCharArray();
        for (char c : chars) {
            c = (char) (c ^ 't');
        }
        return new String(chars);
    }


    public static void main(String[] args) {
        String key = "YzcmCZNvbXocrsz9dm8e";
        String data = "admin-123";
        System.out.println("加密前的内容：" + data);
//        String encrypt = encryptDes(key, data);
//        System.out.println("加密后的内容：" + encrypt);
        String decrypt = decryptDes(key, "admin");
        System.out.println("解密后的内容：" + decrypt);
//        String s = encryptMd5(data);
//        System.out.println("加密后的内容：" + s);
//        String s1 = decryptMd5(s);
//        System.out.println("解密后的内容：" + s1);

    }
}
