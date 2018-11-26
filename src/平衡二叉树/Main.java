package 平衡二叉树;

public class Main {
    public static void main(String[] args) {
        AVLTree<Integer,String>avlTree = new AVLTree();
        avlTree.add(8,"cat");
        avlTree.add(6,"cat");
        avlTree.add(7,"cat");
        avlTree.add(4,"cat");
        avlTree.remove(4);
        avlTree.printData();
        System.out.println(avlTree.isBalanced());
    }
}
