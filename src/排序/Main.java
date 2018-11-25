package 排序;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Random random = new Random(10);
        int []randomArray = new int[10];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt();
        }
        long current = System.currentTimeMillis();
        JavaSort.shellSort(randomArray);
        long further = System.currentTimeMillis();
        System.out.println("时间"+(double)(further - current));
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt();
        }
        long current1 = System.currentTimeMillis();
        JavaSort.insertSort(randomArray);
        long further1 = System.currentTimeMillis();
        System.out.println("时间"+(double)(further1 - current1));
    }
}
