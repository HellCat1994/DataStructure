package 红黑树;
import java.util.LinkedList;
import java.util.Queue;

public class RedBlackTree<K extends Comparable<K>,V>{
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private class Node{
        public K key;
        public V value;
        public Node left;
        public Node right;
        public boolean color;
        public Node(K key,V value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.color = RED;
        }
    }
    private Node root;
    private int size;
    public RedBlackTree() {
        root = null;
        size = 0;
    }

    /**
     * 判断节点node的颜色
     * @param node
     * @return
     */
    private boolean isRed(Node node){
        if(node == null){
            return BLACK;
        }
        return node.color;
    }

    /**
     * 红黑树进行左旋转的过程
     * @param node
     * @return
     */
    private Node leftRotate(Node node){
        Node x = node.right;
        //左旋转
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    /**
     * 红黑树的右旋转
     * @param node
     * @return
     */
    private Node rightRotate(Node node){
        Node x  = node.left;
        //右旋转
        node.left = x.right;
        x.right = node;

        x.color = node.color;
        node.color = RED;
        return x;
    }
    /**
     * 红黑树进行颜色的反转
     * @param node
     */
    private void flipColors(Node node){
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    /**
     * 在红黑树添加键值对（key，value）
     * @param key
     * @param value
     */
    public void add(K key, V value) {
        root = add(root,key,value);
        //保证根节点是黑色的
        root.color = BLACK;
    }
    /**
     * 向红黑树中添加新的元素
     * @param rootNode
     * @param key
     * @param value
     * @return
     */
    private Node add(Node rootNode,K key,V value){
        if(rootNode == null){
            //默认插入红色节点
            return new Node(key,value);
        }
        if(key.compareTo(rootNode.key)>0){
            rootNode.right = add(rootNode.right,key,value);
        }else if(key.compareTo(rootNode.key)<0){
            rootNode.left = add(rootNode.left,key,value);
        }else{
            rootNode.value = value;
        }
        /**
         * 需要每次都看三个条件
         */
        //左旋转
        if(isRed(rootNode.right) && ! isRed(rootNode.left)){
            rootNode = leftRotate(rootNode);
        }
        //右旋转
        if(isRed(rootNode.left) && isRed(rootNode.left.left)){
            rootNode = rightRotate(rootNode);
        }
        //着色
        if(isRed(rootNode.left) && isRed(rootNode.right)){
            flipColors(rootNode);
        }
        return rootNode;
    }
    public void printData(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node currentNode = queue.remove();
            if(currentNode.color == false) {
                System.out.println(currentNode.key + " Black");
            }else{
                System.out.println(currentNode.key + " Red");
            }
            if(currentNode.left!=null){
                queue.add(currentNode.left);
            }
            if(currentNode.right!=null){
                queue.add(currentNode.right);
            }
        }
    }
}


