package AVL的Set和Map;

import 平衡二叉树.AVLTree;
import 集合和映射.Set;

public class AVLSet<T extends Comparable<T>> implements Set<T> {
    private AVLTree<T,Object> avlTree;
    public AVLSet() {
        avlTree = new AVLTree<>();
    }

    @Override
    public void add(T e) {
        avlTree.add(e,null);
    }
    @Override
    public void remove(T e) {
        avlTree.remove(e);
    }

    @Override
    public boolean contains(T e) {
        return avlTree.contains(e);
    }
    public void printData(){
        avlTree.printData();
    }
}
