package array;

/**
 * @author xiangyang
 * @date on 2019/6/15 17:43.
 * @Copyright 2019 - 2022 人人一宝通 All Rights Reserved
 */
public class DynamicGenericArray<T> {

    private T[] data;

    private int count;

    DynamicGenericArray(){
        this(10);
    }


    DynamicGenericArray(int capacity){
        this.data = (T[]) new Object[capacity];
        this.count = 0;
    }

    public int getCapacity(){
        return this.data.length;
    }

    public int getCount() {
        return this.count;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == this.data.length;
    }

    /**
     * 删除指定下标元素
     * 删除后 往前移动 从删除的地方开始遍历
     * @param index
     * @return
     */
    public boolean delete(int index){ // 可以搞一个扩缩容的数组 但是时间复杂度事O(n)
        checkIndex(index);

        for (int i = index; i < count-1; i++) {
            data[i] = data[i+1];
        }

        return true;
    }


    /**
     * 插入 则说明之前的这个下标及其之后的元素需要向后移动
     * 插入 只能在已有元素范围之内插入
     * @param index
     * @param t
     * @return
     */
    public boolean insert(int index, T t) {
        checkIndex(index);
        if (count == data.length) {
            resize(data.length * 2);
        }

        for (int i = count-1; i >= index ; --i) {
            data[i+1] = data[i];    // count - index
        }
        data[index] = t;
        count++;
        return true;
    }

    public void resize(int capacity) {
//        data = (T[]) new Object[capacity]; 错误的
        T[] newData = (T[]) new Object[capacity];

        for (int i = 0; i < count; i++) {   // 注意是count
            newData[i] = data[i];
        }
        data = newData;
        newData = null;
    }

    public void checkIndex(int index) {
        if (index < 0 || index > count) {
            throw new RuntimeException("index shoud >= 0  && <= count");
        }
    }

    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.print("data[" + i + "]： " + data[i] + "  ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {

        Person p1 = new Person("Alice", 1);
        Person p2 = new Person("Bob", 2);
        Person p3 = new Person("cat", 3);
        Person p4 = new Person("dog", 4);
        Person p5 = new Person("envy", 5);

        Person p6 = new Person("friend", 6);
        Person p7 = new Person("gay", 7);
        Person p8 = new Person("halo", 8);
        Person p9 = new Person("iya", 9);
        Person p10 = new Person("jack", 10);

        DynamicGenericArray<Person> arr = new DynamicGenericArray(5);
        System.out.println("count: " + arr.count + ", capacity: " + arr.getCapacity());

        arr.insert(0,p1);
        arr.insert(0,p2);
        arr.insert(0,p3);
        arr.insert(0,p4);
        arr.insert(0,p5);

        System.out.println("count: " + arr.count + ", capacity: " + arr.getCapacity());
        arr.printAll();

        arr.insert(1,p7);
        arr.insert(2,p8);
        arr.insert(6,p9);
        arr.insert(8,p10);
        arr.printAll();
        System.out.println("count: " + arr.count + ", capacity: " + arr.getCapacity());

        arr.insert(0,p6);
        arr.insert(0,p8);
        arr.printAll();
        System.out.println("count: " + arr.count + ", capacity: " + arr.getCapacity());



    }


}
