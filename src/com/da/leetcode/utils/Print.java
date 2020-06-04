package com.da.leetcode.utils;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Da
 * @date 2020/5/20 10:59
 * 快捷输出
 */
public class Print {

    public static <T> void printObject(T object){
        if (object == null){
            System.out.println("NULL");
            return;
        }

        if(object.getClass().isArray()){
            StringBuilder strb = new StringBuilder();
            strb.append("[ ");
            int len = Array.getLength(object);
            for (int i = 0; i < len; i++){
                strb.append(Array.get(object,i));
                if(i == len-1){
                    strb.append("]");
                }else{
                    strb.append(" ,");
                }
            }
            System.out.println(strb.toString());
        }else{
            System.out.println(object.toString());
        }
    }

    public static void main(String[] args) {
        String str = "str";
        printObject(str);
        List<String> listString = new ArrayList<>();
        listString.add("listString");
        printObject(listString);
        Map<String,Integer> mapStringInt = new HashMap<>();
        mapStringInt.put("1",10);
        mapStringInt.put("2",5);
        printObject(mapStringInt);
        int[] ints = new int[]{2,7,4,8};
        printObject(ints);

        List<List<String>> listString2 = new ArrayList<>();
        List<String> a = new ArrayList<>();
        a.add("1231465");
        a.add("8552225");
        listString2.add(a);
        List<String> a2 = new ArrayList<>();
        a2.add("1231465");
        a2.add("8552225");
        listString2.add(a2);
        printObject(listString2);

        Map<String,List<List<String>>> mapStringInt2 = new HashMap<>();
        mapStringInt2.put("1",listString2);
        mapStringInt2.put("2",listString2);
        printObject(mapStringInt2);


    }
}
