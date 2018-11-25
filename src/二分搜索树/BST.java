package 二分搜索树;


public class BST<E extends Comparable<E>> {
    private class Node{
        public E e;
        public Node left,right;
        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }
    private Node root;
    private int size;
    public BST(){
        root = null;
        size = 0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size ==0;
    }
    public void add(E e){
        if(root == null){
            root = new Node(e);
            size++;
        }else{
            add(root,e);
        }
       // root = add(root,e);
    }
    //向以node为根的二分搜索树中插入元素e，递归算法
//    private void add(Node node,E e){
//        if(e.equals(node.e)){
//            return;
//        }else if(e.compareTo(node.e)<0 && node.left == null){
//            node.left = new Node(e);
//            size++;
//            return;
//        }else if(e.compareTo(node.e)>0 && node.right == null){
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//        if(e.compareTo(node.e)<0){
//            add(node.left,e);
//        }else{
//            add(node.right,e);
//        }
//    }

    /**
     *
     * @param node
     * @param e
     * @return
     */
    private Node add(Node node,E e){
        if(node  == null){
            return new Node(e);
        }
        if(e.compareTo(node.e)<0){
            node.left = add(node.left,e);
        }else if(e.compareTo(node.e)>=0){
            node.right = add(node.right,e);
        }
        return node;
    }
    public boolean contains(E e){
        return contains(root,e);
    }
    private boolean contains(Node node,E e){
        if(node == null){
            return false;
        }
        if(node.e.compareTo(e)==0){
            return true;
        }else if(e.compareTo(node.e)<0){
            return contains(node.left,e);
        }else{
            return contains(node.right,e);
        }
    }
    //二分搜索树的前序遍历
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        inOrder(node.right);
        System.out.println(node.e);
    }
    /**
     * 前序遍历的非递归实现
     */
    public void preOrderNR(){

    }

    /**
     * 层序遍历的实现
     * @return
     */
    /*
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);
            if(cur.left!=null){
                queue.add(cur.left);
            }
            if(cur.right!=null){
                queue.add(cur.right);
            }
        }
    }
    */
    /**
     * 寻找二分搜索树里面的最小值
     */
    public E findMinNodeValue(){
        if(size == 0){
            throw new IllegalArgumentException("bst is empty");
        }else{
            return findMinNodeValue(root).e;
        }
    }
    private Node findMinNodeValue(Node node){
        if(node.left == null){
            return node;
        }
        return findMinNodeValue(node.left);
    }

    public E findMaxNodeValue(){
        if(size == 0){
            throw new IllegalArgumentException("bst is empty");
        }else{
            return findMaxNodeValue(root).e;
        }
    }
    private Node findMaxNodeValue(Node node){
        if(node.right == null){
            return node;
        }
        return findMaxNodeValue(node.right);
    }
    public E removeMaxNode(){
        E ret = findMaxNodeValue();
        root = removeMaxNode(root);
        return ret;
    }

    private Node removeMaxNode(Node node){
        if(node.right == null){
            Node leftnode = node.left;
            node.left = null;
            size -- ;
            return leftnode;
        }
        node.right = removeMaxNode(node.right);
        return node;
    }
    public E removeMinNode(){
        E ret = findMinNodeValue();
        root = removeMinNode(root);
        return ret;
    }
    //删除掉以node为根的二分搜索树的最小节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMinNode(Node node){
        if(node.left == null){
            Node rightnode = node.right;
            node.right = null;
            size -- ;
            return rightnode;
        }
        node .left = removeMinNode(node.left);
        return node;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }
    private void generateBSTString(Node node,int depth,StringBuilder res){
        if(node == null){
            res.append(generateDepthString(depth)+"null\n");
            return;
        }
        res.append(generateDepthString(depth)+node.e+"\n");
        generateBSTString(node.left,depth+1,res);
        generateBSTString(node.right,depth+1,res);

    }
    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("-");
        }
        return res.toString();
    }
}
