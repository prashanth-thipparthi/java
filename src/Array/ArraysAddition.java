package Array;
/*
02/27/2019
 */
public class ArraysAddition {

    public int [] addArrays(int arr1[], int arr2[]){
        int l = Math.max(arr1.length,arr2.length);
        int result[] = new int[l];
        int i = arr1.length-1;
        int j = arr2.length-1;
        int c=0,r=0;
        l--;
        while(i>=0 && j>= 0){
            r = arr1[i--] + arr2[j--] + c;
            c = r/10;
            result[l--] = r%10;
        }

        while(i>=0){
            r = arr1[i--]+c;
            c = r/10;
            result[l--] = r%10;
        }

        while(j>=0){
            r = arr2[j--]+c;
            c = r/10;
            result[l--] = r%10;
        }

        if(c!=0){
            l = result.length+1;
            int newarr[] = new int[l];
            for(int k = l-1;k>0;k--){
                newarr[k] = result[k-1];
            }
            newarr[0] = c;
            return  newarr;
        }
        return result;
    }
    public static void main(String args[]){
        int arr1[] = {9,9,9,9,9,9,9};
        int arr2[] = {1,6,8,2,6,7};
        ArraysAddition ar = new ArraysAddition();
        int res[] = ar.addArrays(arr1,arr2);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]);
        }
    }
}
