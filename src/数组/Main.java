package 数组;

public class Main {
    public static void main(String[] args) {
        Array <Integer>arr = new Array<Integer>(10);
        for (int i = 0; i < 2; i++) {
            arr.addLast(i);
        }
        arr.addLast(12);
        System.out.println(arr);;
    }
}
