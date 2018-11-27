package 红黑树;

public class Main {
    public static void main(String[] args) {
        RedBlackTree<Integer,String> redBlackTree = new RedBlackTree<>();
        redBlackTree.add(8,"cat");
        redBlackTree.add(7,"cat");
        redBlackTree.add(6,"cat");
        redBlackTree.printData();
    }
}
