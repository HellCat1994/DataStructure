package 堆;
import 数组.Array;
/**
 * @author whg
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;
    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }
    public MaxHeap(){
        data = new Array<>();
    }
    public int size(){
        return data.getSize();
    }
    public boolean isEmpty(){
        return data.isEmpty();
    }

    /**
     * 当前节点的父亲节点位置，当前是从位置0开始的
     * @param index
     * @return
     */
    private int parent(int index){
        if(index == 0){
            throw new IllegalArgumentException("0 no parent");
        }
        return (index-1)/2;
    }

    /**
     * 当前节点的左孩子节点位置
     * @param index
     * @return
     */
    private int leftChild(int index){
        return index*2+1;
    }

    /**
     * 当前节点的右孩子节点位置
     * @param index
     * @return
     */
    private int rightChild(int index){
        return index*2+2;
    }
    /**
     *  向堆中添加元素
     */

    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize()-1);
    }
    private void siftUp(int k){
        while(k > 0 && data.get(parent(k)).compareTo(data.get(k))<0){
            data.swap(k,parent(k));
            k = parent(k);
        }
    }
    /**
     * 取出堆中的最大元素
     */
    public E findMax(){
        if(data.getSize() == 0){
            throw new IllegalArgumentException("Can not findMax when heap is empty");
        }
        return data.get(0);
    }
    public E extractMax(){
        E ret = findMax();
        data.swap(0,data.getSize()-1);
        data.removeLast();
        siftDown(0);
        return ret;
    }
    public void printHeap(){
        for (int i = 0; i < data.getSize(); i++) {
            System.out.print(data.get(i)+" ");
        }
    }
    private void siftDown(int k){
        while(leftChild(k)<data.getSize()){
            int j = leftChild(k);
            if(j+1 < data.getSize() && data.get(j+1).compareTo(data.get(j))>0){
                j = rightChild(k);
            }
            //data[j]是leftChild和rightChild中的最大值
            if(data.get(k).compareTo(data.get(j))>=0){
                break;
            }
            data.swap(k,j);
            k = j;
        }
    }

    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for(int i=parent(arr.length-1);i>=0;i--){
            siftDown(i);
        }
    }

}
