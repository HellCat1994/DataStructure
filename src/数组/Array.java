package 数组;

/**
 * Created by Administrator on 2018/8/24 0024.
 */
public class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }
    public Array(E[] arr){
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }

    //无参数的构造函数，默认数组的容量是10
    public Array() {
        this(10);
    }

    //获取数组中的元素个数
    public int getSize(){
        return size;
    }

    //获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size==0;
    }
    //在最后位置添加元素
    public void addLast(E e){
        add(size,e);
    }

    public void addFirst(E e){
        add(0,e);
    }
    //插入元素
    public void add(int index,E e){

        if(index < 0  || index > size)
            throw new IllegalArgumentException("add failed,Require index >=0 and index<=size");
        if(size == data.length)
            resize(2*data.length);
        for(int i=size-1;i>=index;i--)
            data[i+1] = data[i];
        data[index] = e;
        size ++;
    }
    //查询元素
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d, capacity = %d \n",size,data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i!=size-1){
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
    //获取某个位置元素
    public E get(int index){
        if(index < 0 || index >=size)
            throw new IllegalArgumentException("get failed,index is illegal");
        return data[index];
    }
    //设置某个位置元素
    void set(int index,E e){
        if(index < 0 || index >=size)
            throw new IllegalArgumentException("set failed,index is illegal");
        data[index] = e;
    }
    //是否包含某元素
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }
    //返回某元素的索引
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }
    //删除指定位置元素
    public E remove(int index){
        if(index < 0 || index >=size)
            throw new IllegalArgumentException("remove failed,index is illegal");
        E buf = data[index];
        for (int i = index+1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;     //闲散的对象
        if(size == data.length/4 && data.length/2!=0)
            resize(data.length/2);
        return buf;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    public boolean removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
            return true;
        }else {
            return false;
        }
    }
    private void resize(int capacity){
        E[] newData = (E[])new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
    public void swap(int i, int j){
        if(i<0 || i>=size || j<0 || j>=size){
            throw new IllegalArgumentException("Index is illegal");
        }
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
}
