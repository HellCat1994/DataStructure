package 集合和映射;

import 二叉树.TreeBin;

public class BstSet<T extends Comparable<T>> implements Set<T> {
    private TreeBin<T> treeBin;
    public BstSet() {
        treeBin = new TreeBin<>();
    }
    /**
     * 添加元素，不可以重复
     * @param e
     */
    @Override
    public void add(T e) {
        treeBin.add(e);
    }
    @Override
    /**
     * 删除某个元素
     */
    public void remove(T e) {
        treeBin.deleteAnyNode(e);
    }

    /**
     * 查看是否包含某个元素
     * @param e
     * @return
     */
    @Override
    public boolean contains(T e) {
        return treeBin.contains(e);
    }

    /**
     * 层次遍历打印数据
     */
    public void printData(){
        treeBin.sequenceTraversal();
    }
}
