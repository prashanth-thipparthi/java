package sortingAlgorithms;

public class BinarySearch {

    public static int binarySearch(int a[],int element, int low,int high){
        if(high>=low) {
            int mid = (high + low) / 2;
            if (a[mid] == element) {
                return mid;
            } else if (a[mid] > element) {
                high = mid - 1;
                return binarySearch(a, element, low, high);
            } else {
                low = mid + 1;
                return binarySearch(a, element, low, high);
            }
        }
        return -1;
    }
    public static void main(String args[]){
        int a[] = {1,2,3,4,5,9,12,14};
        int len = a.length;
        int element = 9;
        int ret = binarySearch(a,element,0,len-1);
        if(ret !=-1){
            System.out.println("Element found");
        }else{
            System.out.println("Element not found");
        }
    }

}
