package com.da.leetcode.test;

import com.da.leetcode.utils.Print;

import java.util.StringTokenizer;

/**
 * @author Da
 * @date 2020/5/21 11:25
 */
public class test {
    public static void main(String[] args) {

//        String s = "aa";
//        String s2 = "aa";
//        String[] as = s.split("a",s.length());
//        String[] as2 = s2.split("a");
//        System.out.println(as.length);
//        System.out.println(as2.length);
//        Print.printObject(s.split("a",s.length()));
//        Print.printObject(s2.split("a"));

//        StringTokenizer stringTokenizer = new StringTokenizer("aa","a",true);
//        while (stringTokenizer.hasMoreTokens()){
//            System.out.println(stringTokenizer.nextToken());
//        }

//        char c = '.';
//        System.out.println(Integer.valueOf(c));
//
//        String s = "123456789";
//        System.out.println(s.substring(8,9));

//        Integer integer = Integer.valueOf("+123");
//        System.out.println(integer);
//        StringBuilder stringBuilder[] = new StringBuilder[2];
//        stringBuilder[0].append("123");
//        System.out.println(stringBuilder[0]);

        int num = 40;
        int[] f = new int[]{num/1000,num/100%10,num/10%10,num%10};

        Print.printObject(f);

    }
}
