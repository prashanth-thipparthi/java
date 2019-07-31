package sortingAlgorithms;

public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if(m==0)
            nums1[0] = nums2[0];
        int i=m-1;
        int j=n-1;
        int index = m+n-1;

        while(i>=0 && j>=0){
            if(nums1[i] >= nums2[j]){
                nums1[index--] = nums1[i--];
            }else{
                nums1[index--] = nums2[j--];
            }
        }

        while(j>=0)
            nums1[index--] = nums2[j--];

    }
}
