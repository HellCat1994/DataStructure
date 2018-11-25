package 二叉树;


public class TreeBinarySearch {
    public static void main(String[] args) {
        TreeBin<Integer> tree = new TreeBin<>();
        tree.add(12);
        tree.add(36);
        tree.add(24);
        tree.add(8);
        tree.add(54);
        tree.add(7);
        tree.add(9);
        /*
                        12
                   8            36
                7     9      24     54
         */
        System.out.println(tree.findMax());
        System.out.println(tree.findMin());
        tree.deleteAnyNode(36);
        System.out.println("********");
        tree.sequenceTraversal();
        System.out.println("********");
        tree.preorderTraversal();
        System.out.println("*******");
        tree.mediumOrderTraversal();
        System.out.println("*******");
        tree.postOrderTraversal();
        System.out.println("*******");
        tree.preorderTraversal();
    }
}
