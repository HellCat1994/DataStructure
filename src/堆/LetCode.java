package 堆;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 *给定一个非空的整数数组，返回其中出现频率前k高的元素
 * @author Administrator
 */
public class LetCode {
    private class Freq implements Comparable<Freq>{
        public int e,freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq o) {
            if(this.freq<o.freq){
                return 1;
            }else if(this.freq == o.freq){
                return 0;
            }else{
                return -1;
            }
        }
    }
    public List<Integer> tookFrequent(int [] nums,int k){
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for (int num : nums) {
            if(treeMap.containsKey(num)){
                treeMap.put(num,treeMap.get(num)+1);
            }else{
                treeMap.put(num,1);
            }
        }
        PriorityQueue<Freq> priorityQueue = new PriorityQueue<>();
        for (int integer : treeMap.keySet()) {
            if(priorityQueue.getSize()< k) {
                priorityQueue.enqueue(new Freq(integer, treeMap.get(integer)));
            }else if(treeMap.get(integer)>priorityQueue.getFront().freq){
                priorityQueue.dequeue();
                priorityQueue.enqueue(new Freq(integer, treeMap.get(integer)));
            }
        }
        LinkedList<Integer> linkList = new LinkedList<>();
        while(!priorityQueue.isEmpty()){
            linkList.add(priorityQueue.dequeue().e);
        }
        System.out.println(linkList);
        return linkList;

        /**
        Iterator inter = treeMap.entrySet().iterator();
        while(inter.hasNext()){
            Map.Entry entry = (Map.Entry) inter.next();
            Integer key = (Integer) entry.getKey();
            Integer value = (Integer) entry.getValue();
            System.out.println(key+" "+value);
        }
        return null;
         */
    }

    public static void main(String[] args) {
        int []arr = {1,1,1,1,1,2,2,3,3,3,5,5,3,3};
        new LetCode().tookFrequent(arr,2);
        //tookFrequent(arr,2);
    }
}
