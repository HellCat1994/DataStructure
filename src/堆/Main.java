package 堆;

import java.util.Random;

/**
 * @author whg
 */
public class Main {
    private static double testHeap(Integer[] testData,boolean isHeapify){
        long startTime = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if(isHeapify == true){
            maxHeap = new MaxHeap<>(testData);
        }else{
            maxHeap = new MaxHeap<>();
            for (Integer testDatum : testData) {
                maxHeap.add(testDatum);
            }
        }
        int [] arr = new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            arr[i] = maxHeap.extractMax();
        }
        for (int i = 1;i<testData.length;i++){
            if(arr[i-1] < arr [i]) {
                throw new IllegalArgumentException("Error");
            }
        }
        long endTime = System.nanoTime();
        return (endTime - startTime)/1000000000.0;
    }
    public static void main(String[] args) {
//        int n = 1000;
//        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
//        Random random = new Random();
//        for(int i=0;i<n;i++){
//            maxHeap.add(random.nextInt(150));
//        }
//        int [] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = maxHeap.extractMax();
//            System.out.println(arr[i]);
//        }
//        for (int i=1;i < n ; i++){
//            if(arr[i-1] <arr [i]){
//                throw new IllegalArgumentException("Error");
//            }
//        }
//        System.out.println("Test successful");
        int n = 1000;
        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }
        double time1 = testHeap(testData,false);
        System.out.println(time1);
        double time2 = testHeap(testData,true);
        System.out.println(time2);
    }
}
