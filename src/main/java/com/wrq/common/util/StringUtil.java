package com.wrq.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	private static final String CHAR_ARRAY="aqwertyuiopsdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
	private static final String NUM="1234567890";
	
	//判断源字符串是否有值，空引号也算没值
	public static boolean isEmpty(String str) {
		return str!=null && !"".equals(str);
	}
	
	//	判断源字符串是否有值，空引号和空格也算没值
	public static boolean isEmptyAndSpace(String str) {
		return str!=null && !"".equals(str.trim());
	}
	
	//判断是否为手机号码
	public static boolean isPhone(String phone) {
		// 验证手机号的正则表达式
		String zz="^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
		if(isEmptyAndSpace(phone)) {
			// 第一种  对于多次使用推荐此方式
//			Pattern compile = Pattern.compile(zz);
//			Matcher matcher = compile.matcher(phone);
//			return matcher.matches();
			// 第二种   Pattern自己的验证   没有查找 替换等等
//			boolean matches = Pattern.matches(zz, phone);
			// 第三种  字符串中验证的方法
			return phone.matches(zz);
		}
		return false;
	}
	
	//判断是否为电子邮箱
	public  static boolean isEmail(String email) {
		String emailzz="^\\w+@\\w+(.com.cn|.com|.net)$";
		if(isEmptyAndSpace(email)) {
			return email.matches(emailzz);
		}
		return false;
	}
	//判断是否全部为字母
	public static boolean isCode(String str) {
		String zz="^[a-zA-Z]+$";
		if(isEmptyAndSpace(str)) {
			return str.matches(zz);
		}
		return false;
	}
	
	//获取n位随机英文字符串
	// A-Z  65-90  a-z  97-122
	public static String getStr(int length) {
		StringBuffer sb=new StringBuffer();
		char[] charArray2 = CHAR_ARRAY.toCharArray();
		// 从 数组中任意取出一个字符  0,
		for(int i=0;i<length;i++) {
			int index=(int)(Math.random()*(charArray2.length));
			char c=charArray2[index];
			sb.append(c);
		}
		return sb.toString();
	}
	
	//获取n位随机英文和数字字符串
	public static String getStrAndNum(int length) {
		StringBuffer sb=new StringBuffer();
		char[] charArray2 = (CHAR_ARRAY+NUM).toCharArray();
		// 从 数组中任意取出一个字符  0,
		for(int i=0;i<length;i++) {
			int index=(int)(Math.random()*(charArray2.length));
			char c=charArray2[index];
			sb.append(c);
		}
		return sb.toString();
	}
	
	//获取n个随机中文字符串
	public static String getStrRandom(int length) {
//		4e00~9fa5  16进制
		StringBuffer sb=new StringBuffer();
		int parseInt1 = Integer.parseInt("4e00",16);
		int parseInt2 = Integer.parseInt("9fa5",16);
		// 随机数= Math.random()*(最大值-最小值+1)+最小值  [最小值，最大值]
		for(int i=0;i<length;i++) {
			int num=(int)(Math.random()*(parseInt2-parseInt1+1)+parseInt1);
			sb.append((char)num);
		}
		return sb.toString();
	}
	
	
	
	
}
