package com.jmeter;
/*
 * @author lizi

 * @date  2020/7/6 10:35
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        md5("519986123456");
    }
    private static String md5(String pwd) throws NoSuchAlgorithmException {

        MessageDigest instance = MessageDigest.getInstance("MD5");
        // 将字符串变成byte数组
        byte[] bs = pwd.getBytes();
        // 得到128位字节数组
        byte[] digest = instance.digest(bs);
        // 转换成16进制
        String md5 = bytesToHex(digest);
        System.out.println(md5);
        return md5;
    }
    private static String bytesToHex(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        int dig = 0;
        for (byte b : bytes) {
            dig = b;
            if (dig < 0) {
                dig += 256;
            }
            if (dig < 16) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(dig));
        }
        return sb.toString().toLowerCase();
    }


}
