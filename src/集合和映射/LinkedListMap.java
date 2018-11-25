package 集合和映射;


/**
 * @author whg
 */
public class LinkedListMap<K,V> implements Map<K,V> {
    private class Node {
        public K key;
        public V value;
        public Node next;
        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
            this(null, null, null);
        }
    }
    //虚拟头指针
    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if(node == null){
            dummyHead.next = new Node(key,value,dummyHead.next);
            size++;
        }else{
            node.value = value;
        }
    }
    @Override
    public void remove(K key) {
        Node currentNode  = dummyHead.next;
        Node bufferNode;
        boolean flag = false;
        while (currentNode!=null){
            if(currentNode.key.equals(key) && flag == false){
                dummyHead.next = currentNode.next;
                break;
            }
            flag = true;
            bufferNode = currentNode;
            currentNode = currentNode.next;
            if(currentNode.key.equals(key)){
                bufferNode.next = currentNode.next;
                break;
            }
        }
    }
    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node==null?null:node.value;
    }
    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if(node == null){
            throw new IllegalArgumentException(key+"不存在");
        }else{
            node.value = value;
        }
    }
    @Override
    public boolean contains(K key) {
        return getNode(key)!=null;
    }

    /**
     * 查找键对应的节点
     * @param key
     * @return
     */
    private Node getNode(K key){
        Node currentNode = dummyHead.next;
        while (currentNode != null){
            if(currentNode.key.equals(key)) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }
    public void printData(){
        Node currentNode  = dummyHead.next;
        while (currentNode!=null){
            System.out.println("key:"+currentNode.key+"    value:"+currentNode.value);
            currentNode = currentNode.next;
        }
    }
}
