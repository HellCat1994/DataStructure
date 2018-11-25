package 二分搜索树;

public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<Integer>();
        int[] nums={5,3,6,8,4,2};
        for (int num : nums) {
            bst.add(num);
        }
        /**
         *
         */
        //bst.levelOrder();
        System.out.println("-------");
        System.out.println(bst.findMinNodeValue());
        System.out.println("-------");
        System.out.println(bst.findMaxNodeValue());
        System.out.println("-------");
        System.out.println(bst.removeMinNode());
        System.out.println("-------");
        System.out.println(bst.removeMaxNode());
        System.out.println("-------");
        //bst.removeMinNode();
        //bst.levelOrder();

        /*
                    5
                   / \
                  3   6
                 / \   \
                2   4   8
         */
//        bst.preOrder();
//        System.out.println("----");
//        bst.inOrder();
//        System.out.println("----");
//        bst.postOrder();
    }
}
