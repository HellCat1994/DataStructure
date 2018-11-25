package 栈;

public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<Integer>();
        arrayStack.push(23);
        arrayStack.push(45);
        arrayStack.pop();
        System.out.println(arrayStack);
    }
}
