package 二叉树;
import java.util.LinkedList;
import java.util.Queue;

public class TreeBin<T extends Comparable<T>>{
    class Node{
        public T e;
        public Node left;
        public Node right;
        public int height;
        public Node(T e){
            this.e = e;
            this.height = 1;
        }
    }
    Node root = null;
    /**
     * 添加元素，如果是第一次添加，则设置为根节点的数据
     * 否则，进行add(root,e)函数
     * @param e
     */
    public void add(T e){
        if(root == null){
            root = new Node(e);
        }else{
            add(root,e);
        }
    }

    /**
     * 返回的条件是rootNode的节点为空，则返回一个新的节点
     * 此时如果添加的数据大于根节点数据，则执行add(rootNode.right,e);
     * 此时进行递归，如果是添加一个元素，此时的rootNode.right的节点为空的，则执行
     * return new Node(e);则操作即为rootNode.right = new Node(e)，实现了插入操作
     * @param rootNode
     * @param e
     * @return
     */
    private Node add(Node rootNode,T e){
        if(rootNode == null){
            return new Node(e);
        }
        if(e.compareTo(rootNode.e)>0){
            rootNode.right = add(rootNode.right,e);
        }else if(e.compareTo(rootNode.e)<0){
            rootNode.left = add(rootNode.left,e);
        }
        return rootNode;
    }

    /**
     * 找出最大元素
     * @return
     */
    public T findMax(){
        return findMax(root).e;
    }

    /**
     * 找出最小元素
     * @return
     */
    public T findMin(){
        return findMin(root).e;
    }

    /**
     * 如果当前的左节点为空，则说明遍历到最左边的一个节点，此时返回
     * 否则，循环将此节点的左节点赋值给此节点
     * @param node
     * @return
     */
    private Node findMin(Node node){
        if(node.left == null){
            return node;
        }else {
            return findMin(node.left);
        }
    }
    private Node findMax(Node node){
        if(node.right == null){
            return node;
        }else {
            return findMax(node.right);
        }
    }
    public void preorderTraversal(){
        preorderTraversal(root);
    }

    /**
     * 前序遍历，顺序为打印节点，遍历左节点，遍历右节点
     * @param node
     */
    private void preorderTraversal(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.e);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    public void mediumOrderTraversal(){
        mediumOrderTraversal(root);
    }
    private void mediumOrderTraversal(Node node){
        if(node == null){
            return;
        }
        mediumOrderTraversal(node.left);
        System.out.println(node.e);
        mediumOrderTraversal(node.right);
    }
    public void postOrderTraversal(){
        postOrderTraversal(root);
    }
    private void postOrderTraversal(Node node){
        if(node == null){
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.println(node.e);
    }

    /**
     * 层序遍历
     */
    public void sequenceTraversal(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node currentNode = queue.remove();
            System.out.println(currentNode.e);
            if(currentNode.left!=null){
                queue.add(currentNode.left);
            }
            if(currentNode.right!=null){
                queue.add(currentNode.right);
            }
        }
    }

    /**
     * 删除最大节点
     */
    public T deleteMax(){
        T maxValue = findMax();
        root = deleteMax(root);
        return maxValue;
    }
    private Node deleteMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            return leftNode;
        }
        node.right = deleteMax(node.right);
        return node;
    }


    /**
     * 删除最小节点，并且返回最小值
     */
    public T deleteMin(){
        T minValue = findMin();
        root = deleteMin(root);
        return minValue;
    }
    private Node deleteMin(Node node){
        /**
         * 如何遍历的当前节点是没有左孩子节点，则为最小节点
         * 此时将该孩子节点的右子树保存给新的节点
         * 遍历到最后，将这个新的节点放置在上一层节点的左子树
         */
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            return rightNode;
        }
        node.left = deleteMin(node.left);
        return node;
    }
    public void deleteAnyNode(T e){
        root = deleteAnyNode(root,e);
    }

    /**
     * 删除任意节点
     * @param node
     * @param e
     * @return
     */
    private Node deleteAnyNode(Node node,T e){
        if(node == null){
            return null;
        }
        if(e.compareTo(node.e)<0){
            node.left = deleteAnyNode(node.left,e);
            return node;
        }else if(e.compareTo(node.e)>0){
            node.right = deleteAnyNode(node.right,e);
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
            Node successor = findMin(node.right);
            successor.right = deleteMin(node.right);
            successor.left = node.left;
            node.right = node.left = null;
            return successor;
        }
        return node;
    }

    /**
     * 查看树结构中是否包含某个节点
     * @param e
     * @return
     */
    public boolean contains(T e){
        return contains(root,e);
    }
    private boolean contains(Node node, T e){
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
}
