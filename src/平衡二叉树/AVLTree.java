package 平衡二叉树;
import java.util.LinkedList;
import java.util.Queue;

public class AVLTree<K extends Comparable<K>,V>{
    private class Node{
        public K key;
        public V value;
        public Node left;
        public Node right;
        /**
         * 记录节点的高度值
         */
        public int height;
        public Node(K key,V value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            //默认节点高度为1
            this.height = 1;
        }
    }
    private Node root;
    private int size;
    public AVLTree() {
        root = null;
        size = 0;
    }

    /**
     * 在树添加键值对（key，value）
     * @param key
     * @param value
     */
    public void add(K key, V value) {
        if(root == null){
            root = new Node(key,value);
        }else{
            root = add(root,key,value);
        }
    }

    /**
     * 如果当前键对应有数值，则更新为新的数值
     * @param rootNode
     * @param key
     * @param value
     * @return
     */
    private Node add(Node rootNode,K key,V value){
        if(rootNode == null){
            return new Node(key,value);
        }
        if(key.compareTo(rootNode.key)>0){
            rootNode.right = add(rootNode.right,key,value);
        }else if(key.compareTo(rootNode.key)<0){
            rootNode.left = add(rootNode.left,key,value);
        }else{
            rootNode.value = value;
        }
        //更新当前节点的height值,更新的值是当前左右节点的最大值
        rootNode.height = 1 + Math.max(getHeight(rootNode.left),getHeight(rootNode.right));
        int balanceFactor = getBalanceFactor(rootNode);
        if(Math.abs(balanceFactor) > 1){
            System.out.println("unbalanced"+ balanceFactor);
        }
        return rootNode;
    }

    /**
     * 删除二分搜索树中的某个节点
     * @param key
     */
    public void remove(K key) {
        Node node = getNode(root,key);
        if(node!=null){
            root = deleteAnyNode(root,key);
        }

    }
    private Node deleteAnyNode(Node node,K key){
        if(node == null){
            return null;
        }
        if(key.compareTo(node.key)<0){
            node.left = deleteAnyNode(node.left,key);
            return node;
        }else if(key.compareTo(node.key)>0){
            node.right = deleteAnyNode(node.right,key);
        }else {
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                return rightNode;
            }
            if(node.right==null){
                Node leftNode = node.left;
                node.left = null;
                return leftNode;
            }
            Node successor = minValue(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.right = node.left = null;
            return successor;
        }
        return node;
    }

    /**
     * 返回树中最小值的节点
     * @param node
     * @return
     */
    private Node minValue(Node node){
        if(node.left == null){
            return node;
        }
        return minValue(node.left);

    }

    /**
     * 删除最小节点，返回新的搜索树的根
     * @param node
     * @return
     */
    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public V get(K key) {
        Node node = getNode(root,key);
        return node==null?null:node.value;
    }

    /**
     * 给某个节点赋值
     * @param key
     * @param value
     */
    public void set(K key, V value) {
        Node node = getNode(root,key);
        if(node == null){
            throw new IllegalArgumentException(key+"不存在");
        }
        node.value = value;
    }

    public boolean contains(K key) {
        return getNode(root,key)!=null;
    }

    /**
     * 获取key值随对应的节点
     * @param node
     * @param key
     * @return
     */
    private Node getNode(Node node,K key){
        if(node == null){
            return null;
        }
        if(key.compareTo(node.key)==0){
            return node;
        }else if(key.compareTo(node.key)<0){
            return getNode(node.left,key);
        }else {
            return getNode(node.right,key);
        }
    }
    public void printData(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node currentNode = queue.remove();
            System.out.println(currentNode.key+" "+currentNode.value);
            if(currentNode.left!=null){
                queue.add(currentNode.left);
            }
            if(currentNode.right!=null){
                queue.add(currentNode.right);
            }
        }
    }

    /**
     * 获取当前节点的高度值
     * @param node
     * @return
     */
    private int getHeight(Node node){
        if(node == null){
            return 0;
        }
        return node.height;
    }

    /**
     * 计算节点的平衡因子
     * @param node
     * @return
     */
    private int getBalanceFactor(Node node){
        if (node == null){
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }
}

