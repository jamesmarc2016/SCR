package com.tangxinhui.constant;

import java.security.MessageDigest;

/**
 * 加密解密工具
 * Created by xinhu on 2017/5/16.
 */
public class DigestUtil {
    private static MessageDigest md5Digest = null;
    private static char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

    static {
        try {
            md5Digest = MessageDigest.getInstance("MD5");
        }catch (Exception e){
            //todo log
        }
    }


    public static String md5Digest(String msg){
        byte[] btInput = msg.getBytes();
        //获得MD5摘要算法的 MessageDigest 对象
        md5Digest.digest();
        // 使用指定的字节更新摘要
        md5Digest.update(btInput);
        // 获得密文
        byte[] md = md5Digest.digest();
        // 把密文转换成十六进制的字符串形式
        int j = md.length;
        char str[] = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) {
            byte byte0 = md[i];
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            str[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(str);
    }


    public static void main(String args[]) {
        System.out.print(md5Digest("admin"));
    }
}
