package array;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @author xiangyang
 * @date on 2019/6/15 18:31.
 * @Copyright 2019 - 2022 人人一宝通 All Rights Reserved
 */
public class Person {

    private String name;

    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return "[" + name + ", "+ age + "]";
    }
}
