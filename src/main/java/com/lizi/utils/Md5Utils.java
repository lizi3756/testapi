package com.lizi.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangjing115 on 2020/10/16
 * 复制 菁菁荣 的；
 */
public class Md5Utils {

	public static String md5(String input){
		try {
			MessageDigest instance = MessageDigest.getInstance("MD5");
			byte[] bytes = input.getBytes(StandardCharsets.UTF_8);
			byte[] digest = instance.digest(bytes);
			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
				sb.append(String.format("%02x", b & 0xff));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据MD5的值获取对应的表号  maohang add 2018/5/9
	 * @param str
	 * @return
	 */
	public static int getNum(String str) {
		//获取MD5值
		String md5Str = getMD5(str);
		//截取最后两个字符，并转换成16进制再转10进制
		String low16BitString = md5Str.substring(md5Str.length() - 2, md5Str.length());
		return Integer.parseInt(low16BitString, 16);
	}

	public static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	public static String getMD5(String str) {
		String strDigest = "";
		try {
			// 此 MessageDigest 类为应用程序提供信息摘要算法的功能，必须用try,catch捕获
			MessageDigest md5 = MessageDigest.getInstance("MD5");

			byte[] data;
			data = md5.digest(str.getBytes("utf-8"));// 转换为MD5码
			strDigest = bytesToHexString(data);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return strDigest;
	}

	public static void main(String[] args) {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}
}
