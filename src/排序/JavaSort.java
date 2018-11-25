package 排序;

public class JavaSort {
    public static int[] insertSort(int[] insertSortArray){
        int key,iinsert;
        for(int j=1;j<insertSortArray.length;j++){
            key = insertSortArray[j];
            iinsert=j-1;
            while(iinsert>-1&&insertSortArray[iinsert]>key){
                insertSortArray[iinsert+1]=insertSortArray[iinsert];
                iinsert=iinsert-1;
            }
            insertSortArray[iinsert+1]=key;
        }
        return insertSortArray;
    }
    public static int[] shellSort(int [] shellSortArray){
        int j;
        for(int gap=shellSortArray.length/2;gap>0;gap/=2){
            for(int i = gap;i<shellSortArray.length;i++){
                int tmp = shellSortArray[i];
                for(j=i;j>=gap&&tmp<shellSortArray[j-gap];j-=gap){
                    shellSortArray[j] = shellSortArray[j-gap];
                }
                shellSortArray[j] = tmp;
            }
        }
        return shellSortArray;
    }
}
