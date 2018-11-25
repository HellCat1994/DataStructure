package 递归;
/***
 *
 */
public class SUM {
    public static int sum(int []arr,int size){
        if(size == -1)
            return 0;
        else
            return arr[size]+sum(arr,size-1);
    }
    public static void main(String[] args){
        int arr[] = new int[]{1,3,5,7};
        System.out.println(SUM.sum(arr,arr.length-1));
    }
}
