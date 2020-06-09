package com.da.leetcode.utils;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Da
 * @date 2020/5/20 10:59
 * 快捷输出
 */
public class Print {

    /**
     * 打印 描述信息 + 数据 不换行输出
     * @param msg 描述信息
     * @param object 数据
     * @param <T> 数据类型
     */
    public static <T> void printObject(String msg,T object){
        System.out.print("msg:" + msg + ": [ ");
        printObjectNotLn(object);
        System.out.println(" ] ");
    }

    /**
     * 打印 object 数据 不换行
     * @param object 数据
     * @param <T> 数据类型
     */
    public static <T> void printObjectNotLn(T object){
        if (object == null){
            System.out.print("NULL");
            return;
        }

        if(object.getClass().isArray()){
            System.out.print(arraysToString(object));
        }else{
            System.out.print(object.toString());
        }
    }

    /**
     * 打印 object 数据 换行
     * @param object 数据
     * @param <T> 数据类型
     */
    public static <T> void printObject(T object){
        if (object == null){
            System.out.println("NULL");
            return;
        }

        if(object.getClass().isArray()){
            System.out.println(arraysToString(object));
        }else{
            System.out.println(object.toString());
        }
    }

    /**
     * 处理 数组类型 数据拼装成String
     * @param object 数据
     * @param <T> 数组类型数据
     * @return 拼装后String数据
     */
    private static <T> String arraysToString(T object){
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
        return strb.toString();
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
