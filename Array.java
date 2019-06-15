package array;

/** 数组一旦创建之后，大小不可更改，除非重新创建数组
 *  1.注意边界
 *  2.熟练两种遍历方法
 * @author xiangyang
 * @date on 2019/6/15 16:40.
 * @Copyright 2019 - 2022 人人一宝通 All Rights Reserved
 */
public class Array {

    // 整形数组
    private int[] data;

    // 容量
    private int capacity;

    // 实际包含元素的个数
    private int count;

    Array(){}

    Array(int capacity){
        this.capacity = capacity;
        this.data = new int[capacity];
        this.count = 0;
    }


    public int find(int index) {

        if (index < 0 || index >= count) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return data[index];
    }


    /**
     * insert 向后移 从尾部开始遍历
     * @param index
     * @param data
     * @return
     */
    public boolean insert(int index, int data) {
        boolean r = false;

        if (count == capacity) {    // count 不可能 也不应该大于capacity
            throw new RuntimeException("array is full ");
        }

        if (index < 0 || index > count){ // 前开后闭
            throw new RuntimeException("index is invalid ");
        }

        // 后移元素 可以取等 注意边界
        for (int i = count; i > index; --i) {  // 注意边界 该不该取等 很重要
            this.data[i] = this.data[i-1];
        }

        this.data[index] = data;
        ++count;

        return true;
    }

    /**
     * replace可以有多重替换方法
     * 1.按下表替换
     * 2.按值替换 --> 仅在值只有一个的时候替换
     * 3.按值替换 --> 存在多个值得时候替换    替换前k个 和 后k个元素   只保留一个中间索引位置的旧值
     * 这里只做最简单的实现 按下表替换
     * @return old value
     */
    public int replace(int oldIndex, int data) {
        if (oldIndex < 0 || oldIndex >= count) {    // 一共有5个元素 你要替换下标为5的第六个元素必然有问题
            throw new RuntimeException("index is invalid ");
        }

        int old = this.data[oldIndex];
        this.data[oldIndex] = data;
        return old;
    }

    /**
     * 同样，删除可以有多种删除方法，这里按最简单的删除实现
     * delete向前移，从index开始遍历 i=index; 赋值count-index次
     * @return 被删除元素的值
     */
    public int delete(int index) {

        if (index < 0 || index >= count) {  // 注意边界
            throw new RuntimeException("index is invalid ");
        }

        int old = this.data[index];
        for (int i = index; i < count-1; i++) { // 注意边界 不能取等
            this.data[i] = this.data[i+1];
        }
        --count;

        return old;
    }



    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.printf("a[" + i + "]: " + this.data[i] + "  ");
        }
        System.out.println("");
    }

    public void printCount() {
        System.out.println("count: " + this.count);
    }

    public static void main(String[] args) {
        Array arr = new Array(5);
        arr.insert(0,100);
        arr.insert(1,200);
        arr.insert(2,300);
        arr.insert(3,400);

        arr.printAll();
        arr.printCount();


        arr.insert(2,250);
        arr.printAll();
        arr.printCount();


//        arr.insert(0,0);
//        arr.printAll();

        arr.replace(0,0);
        arr.printAll();
        arr.printCount();


        arr.replace(2,111);
        arr.printAll();
        arr.printCount();


//        arr.replace(5,888);
//        arr.printAll();
//        arr.printCount();

        arr.delete(4);
        arr.printAll();
        arr.printCount();


    }

}
