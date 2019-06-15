package Array;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int i=0, j=len-1;

        while(i <= j){
            if(nums[j] == val){
                j--;
                continue;
            }

            if(nums[i] == val){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
            i++;
        }
        return j+1;
    }

    public static void main(String args[]){
        RemoveElement re = new RemoveElement();
        int len = re.removeElement(new int[]{3,2,2,3},3);
    }
}
