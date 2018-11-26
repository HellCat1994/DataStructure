package 平衡二叉树;
import java.util.ArrayList;
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
        //LL平衡的维护,左侧的左侧添加了节点，进行右旋转
        if(balanceFactor > 1 && getBalanceFactor(rootNode.left)>=0){
            return rightRotate(rootNode);
        }
        //RR左旋转
        if(balanceFactor<-1 && getBalanceFactor(rootNode.right)<=0){
            return leftRotate(rootNode);
        }
        //LR
        if(balanceFactor > 1 && getBalanceFactor(rootNode.left)<0){
            rootNode.left = leftRotate(rootNode.left);
            return rightRotate(rootNode);
        }
        //RL
        if(balanceFactor < -1 && getBalanceFactor(rootNode.right)>0){
            rootNode.right = rightRotate(rootNode.right);
            return leftRotate(rootNode);
        }
        return rootNode;
    }

    /**
     * 右旋转
     * @param y
     * @return
     */
    private Node rightRotate(Node y){
        Node x = y.left;
        Node t3 = x.right;
        //向右旋转过程
        x.right = y;
        y.left = t3;
        //更新height值
        y.height  = Math.max(getHeight(y.left),getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    /**
     * 左旋转
     * @param y
     * @return
     */
    private Node leftRotate(Node y){
        Node x = y.right;
        Node t2 = x.left;
        //向左旋转过程
        x.left = y;
        y.right = t2;
        //更新height值
        y.height  = Math.max(getHeight(y.left),getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
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
    /**
     * 删除AVL中的节点
     * @param node
     * @param key
     * @return
     */
    private Node deleteAnyNode(Node node,K key){
        if(node == null){
            return null;
        }
        //最后返回的节点
        Node returnNode;
        if(key.compareTo(node.key)<0){
            node.left = deleteAnyNode(node.left,key);
            returnNode = node;
        }else if(key.compareTo(node.key)>0){
            node.right = deleteAnyNode(node.right,key);
            returnNode = node;
        }else {
            //如果待删除的节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                returnNode = rightNode;
            }
            //如果待删除的节点右子树为空的情况
            else if(node.right==null){
                Node leftNode = node.left;
                node.left = null;
                returnNode = leftNode;
            }else {
                //待删除的节点左右子树均不为空的情况
                Node successor = minValue(node.right);
                successor.right = deleteAnyNode(node.right, successor.key);
                successor.left = node.left;
                node.right = node.left = null;
                returnNode = successor;
            }
        }
        //如果节点是叶子节点
        if(returnNode == null){
            return null;
        }

        //更新当前节点的height值,更新的值是当前左右节点的最大值
        returnNode.height = 1 + Math.max(getHeight(returnNode.left),getHeight(returnNode.right));
        int balanceFactor = getBalanceFactor(returnNode);
        if(Math.abs(balanceFactor) > 1){
            System.out.println("unbalanced"+ balanceFactor);
        }
        //LL平衡的维护,左侧的左侧添加了节点，进行右旋转
        if(balanceFactor > 1 && getBalanceFactor(returnNode.left)>=0){
            return rightRotate(returnNode);
        }
        //RR左旋转
        if(balanceFactor<-1 && getBalanceFactor(returnNode.right)<=0){
            return leftRotate(returnNode);
        }
        //LR
        if(balanceFactor > 1 && getBalanceFactor(returnNode.left)<0){
            returnNode.left = leftRotate(returnNode.left);
            return rightRotate(returnNode);
        }
        //RL
        if(balanceFactor < -1 && getBalanceFactor(returnNode.right)>0){
            returnNode.right = rightRotate(returnNode.right);
            return leftRotate(returnNode);
        }
        return returnNode;
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
            /**
             * 如果是集合
             */
            System.out.println(currentNode.key);
            /**
             * 如果是映射
             */
            //System.out.println(currentNode.key+" "+currentNode.value);
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

    /**
     * 判断当前的树是不是二分搜索树
     * 使用中序遍历时，所有元素都是顺序的
     * @return
     */
    public boolean isBST(){
        ArrayList<K> arrayList = new ArrayList<>();
        inOrderTraversal(root,arrayList);
        for (int i = 1; i < arrayList.size(); i++) {
            if(arrayList.get(i-1).compareTo(arrayList.get(i))> 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 判断当前的树是不是平衡树
     * @return
     */
    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(Node node){
        if(node == null){
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        if(Math.abs(balanceFactor)>1){
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);

    }
    /**
     * 中序遍历
     * @param node
     * @param arrayList
     */
    private void inOrderTraversal(Node node,ArrayList<K> arrayList){
        if(node == null){
            return;
        }
        inOrderTraversal(node.left,arrayList);
        arrayList.add(node.key);
        inOrderTraversal(node.right,arrayList);

    }
}

