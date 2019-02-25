package DynamicProgramming;

public class LongestIncreasingSubsequence {

    public static void lis(int arr[]){
        int len = arr.length;
        int lengthIndex[] = new int[len];
        int sequenceIndex[] = new int[len];
        for(int i =0;i<len;i++){
            lengthIndex[i] = 1;
            sequenceIndex[i] = -1;
        }
        for(int i =0;i<len;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    lengthIndex[i]+=1;
                }
            }
        }

    }
    public static void main(String args[]){
        int a[] = {0,4,12,2,10,6,9,13,3,11,7,15};
        lis(a);
    }

}
