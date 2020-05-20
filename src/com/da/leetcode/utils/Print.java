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
    }
}
