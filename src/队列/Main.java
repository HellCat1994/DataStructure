package 队列;

public class Main {
    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>(4);
        long startTime=System.currentTimeMillis();
        System.out.println(Integer.MAX_VALUE);
            for(int i=0;i<100000;i++) {
                arrayQueue.enqueue(1);
                arrayQueue.enqueue(2);
                arrayQueue.enqueue(3);
                arrayQueue.enqueue(4);
                arrayQueue.enqueue(5);
                arrayQueue.dequeue();
                arrayQueue.dequeue();
                arrayQueue.enqueue(6);
            }
        long endTime=System.currentTimeMillis();
        System.out.println("time="+String.valueOf(endTime-startTime));
        LoopQueue<Integer> loopQueue = new LoopQueue<Integer>(4);
        long start1Time=System.currentTimeMillis();
        for(int i=0;i<100000;i++) {
            loopQueue.enqueue(1);
            loopQueue.enqueue(2);
            loopQueue.enqueue(3);
            loopQueue.enqueue(4);
            loopQueue.enqueue(5);
            loopQueue.dequeue();
            loopQueue.dequeue();
            loopQueue.enqueue(6);
        }
        long end1Time=System.currentTimeMillis();
        System.out.println("time="+String.valueOf(end1Time-start1Time));
    }
}
