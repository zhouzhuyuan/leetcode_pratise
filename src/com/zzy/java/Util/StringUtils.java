package com.zzy.java.Util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.Collator;
import java.util.*;

public class StringUtils {

    public static String zipStr(String str) {

        byte[] b = str.getBytes();

        int count = str.hashCode() & Integer.MAX_VALUE;
//        for (int i = 0; i < str.length(); i++) {
//            count = (62 * count) % 1000000 + b[i];
//        }

        return toBase62(count);

    }

    public static int hashCode(String value) {
        int h = 0;
        int length = value.length() >> 1;

        for(int i = 0; i < length; ++i) {
            h = 31 * h + value.charAt(i);
        }

        return h;
    }

    public static int hashCode2(byte[] value) {
        int h = 0;
        byte[] var2 = value;
        int var3 = value.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            byte v = var2[var4];
            h = 4 * h + (v & 255);
        }

        return Math.abs(h);
    }

    private static final char[] encodes = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();


    public static String toBase62(int num) {
        int length = encodes.length;

        Stack<Integer> stack = new Stack<>();

        while (num >= 0) {
            stack.push(num % length);
            num = Math.floorDiv(num, length); // num/length 向下取整
            if (num == 0) {
                break;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (stack.size() > 0) {
            stringBuilder.append(encodes[stack.pop()]);
        }

        return stringBuilder.toString();
    }

    static class Test {
        String test;
    }

    public static String[] clone(String... values) {
        List<String> typeList = new ArrayList<>(Arrays.asList(values));
        return typeList.toArray(new String[0]);
    }

    /**
     * String 转 unicode
     */
    public static String stringToUnicode(String string) {
        StringBuilder unicode = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            unicode.append("\\u").append(Integer.toHexString(c));
        }
        String str = unicode.toString();

        return str.replaceAll("\\\\", "0x");
    }

    /**
     * unicode 转 String
     */
    public static String unicodeToString(String unicode) {

        String str = unicode.replace("0x", "\\");

        StringBuilder string = new StringBuilder();
        String[] hex = str.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            int data = Integer.parseInt(hex[i], 16);
            string.append((char) data);
        }
        return string.toString();
    }


    /**
     * 对 String List 按照首字拼音排序
     */
    public static void sortWithFirstWord(List<String> list) {
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String t, String t1) {
                return Collator.getInstance(Locale.CHINESE).compare(t, t1);
            }
        });
    }

    /**
     * 字符串转MD5
     * @param string 待转换字符串
     * @return 转后后的MD5字符串，装换异常返回null;
     */
    public static String md5(String string) {
        byte[] hash = null;
        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException ignored) {
        }

        if (hash != null) {
            StringBuilder hex = new StringBuilder(hash.length * 2);
            for (byte b : hash) {
                if ((b & 0xFF) < 0x10) hex.append('0');
                hex.append(Integer.toHexString(b & 0xFF));
            }
            return hex.toString();
        }
        return null;
    }

}
