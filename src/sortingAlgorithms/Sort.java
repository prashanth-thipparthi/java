package sortingAlgorithms;

import java.util.Arrays;

public class Sort {

    public static void insertionSort(int a[]){
        int len = a.length;
        //System.out.println("length(a):"+len);
        int i,j;
        int ele;
        for(i=1;i<len;i++){
            ele = a[i];
            for(j=i-1;j>=0 && a[j] > ele;j--){
                    a[j+1] = a[j];
            }
            a[j+1] = ele;
        }
        for(i=1;i<len;i++){
            System.out.println("a:"+a[i]);
        }
    }

    public static int partitionPivotLastElement(int a[],int low,int high){
        int pivot = a[high];
        int i = low-1,j = low;
        int temp;
        for(j=low;j<=high;j++){
            if(a[j]<pivot){
                i+=1;
                temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }
        temp = a[high];
        a[high] = a[i+1];
        a[i+1] = temp;
        return i+1;
    }

    public static void quickSortPivotLastElement(int a[],int low, int high){
        if(high>low) {
            int pivot = partitionPivotLastElement(a, low, high);
            quickSortPivotLastElement(a, low, pivot - 1);
            quickSortPivotLastElement(a, pivot + 1, high);
        }
    }
    public static void quickSortMainPivotLastElement(int a[]){
        quickSortPivotLastElement(a,0,a.length-1);
        for(int i=0;i<=a.length-1;i++) {
            System.out.println(a[i]);
        }
    }

    public static int partitionPivotFirstElement(int a[],int low,int high){
        int pivot = a[low];
        int i = low;
        int j = high;
        if(i+1<=high){
            j = i+1;
        }
        int temp;
        for(;j<=high;j++){
            if(a[j]<pivot){
                i+=1;
                temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }
        temp = a[low];
        a[low] = a[i];
        a[i] = temp;
        return i;
    }

    public static void quickSortPivotFirstElement(int a[],int low, int high){
        if(high>low) {
            int pivot = partitionPivotFirstElement(a, low, high);
            quickSortPivotFirstElement(a, low, pivot - 1);
            quickSortPivotFirstElement(a, pivot+1, high);
        }
    }

    public static void quickSortMainPivotFirstElement(int a[]) {
        quickSortPivotFirstElement(a, 0, a.length - 1);
        for (int i = 0; i <= a.length - 1; i++) {
            System.out.println(a[i]);
        }
    }

    public static void main(String args[]) {
        int a[] = {9,10,3,6,2,1,5};
        //int a[] = {3,6,8,4,1,5,7};
        //int a[] = {31,2,34,66,12,90,32};
        //int a[] = {9,2,99,3,11,6,8,4,1,5,7};
        //insertionSort(a);

        //quickSortMainPivotLastElement(a);
        //quickSortMainPivotFirstElement(a);

        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
        Arrays.sort(a,0,a.length);


        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
