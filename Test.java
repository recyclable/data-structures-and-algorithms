package array;

/**
 * @author xiangyang
 * @date on 2019/6/15 18:12.
 * @Copyright 2019 - 2022 人人一宝通 All Rights Reserved
 */
public class Test {

    public static void main(String[] args) {

        int a = -16;

        System.out.println("res = " + (a << 1) );   // -32  没搞清楚溢出之前 慎用
        System.out.println("res = " + (a << 2) );   //-64

        System.out.println("res = " + (a >> 1) );   // -8

        System.out.println("res = " + (a >>> 2) );  //

    }

}
