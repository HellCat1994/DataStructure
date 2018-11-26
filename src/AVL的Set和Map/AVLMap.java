package AVL的Set和Map;

import 平衡二叉树.AVLTree;
import 集合和映射.Map;

public class AVLMap<K extends Comparable<K>,V> implements Map<K,V> {
    AVLTree<K,V> avlTree;

    public AVLMap() {
        avlTree = new AVLTree<>();
    }

    @Override
    public void add(K key, V value) {
        avlTree.add(key,value);
    }

    @Override
    public void remove(K key) {
        avlTree.remove(key);
    }

    @Override
    public V get(K key) {
        return avlTree.get(key);
    }

    @Override
    public void set(K key, V value) {
        avlTree.set(key,value);
    }

    @Override
    public boolean contains(K key) {
        return avlTree.contains(key);
    }

    public void printData(){
        avlTree.printData();
    }
}
