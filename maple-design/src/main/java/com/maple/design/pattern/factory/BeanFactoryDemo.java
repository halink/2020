package com.maple.design.pattern.factory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONWriter;
import org.springframework.beans.factory.BeanFactory;

import java.util.Calendar;
import java.util.Random;

public class BeanFactoryDemo {
    public static void main(String[] args) {
        //01 09 11 12 16 19 -》 16
        int i = (int) (1 + Math.random() * (16 - 1 + 1));
        while (lanqiu(i)){
            i = (int) (1 + Math.random() * (16 - 1 + 1));
        }
        System.out.println(i);
        int[] k = new int[7];

        for(int m= 1;m<=6;m++){
            int yao = yao();

            k[m] = yao;
        }
        System.out.println(JSON.toJSONString(k));
    }
    private static boolean lanqiu(int i){
        int[]  lanqiu = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        int[]  already = {12,10,06,16,03};
        for (int i1 : already) {
            if(i1==i){
                return true;
            }
        }
        return false;
    }
    private static boolean hongqiu(int i){
        int[]  already = {1,9,11,12,16,19,2,21,23,26,31,32,14,29,30};
        for (int i1 : already) {
            if(i1==i){
                return true;
            }
        }
        return false;
    }
    private static int yao(){
        int j  = (int) (1 + Math.random() * (33 - 1 + 1));

        while (hongqiu(j)){
            j = (int) (1 + Math.random() * (33 - 1 + 1));
        }
        return j;
    }
}
