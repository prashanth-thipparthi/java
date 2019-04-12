package Array;

public class FirstLastPositionInArray{

    public int binarySearch(int low, int high, int target, int [] nums){
        if(low<=high){
            int mid = (high+low)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                return binarySearch(low, mid-1, target, nums);
            }else{
                return binarySearch(mid+1, high,target, nums);
            }
        }
        return -1;
    }

    public int leftSubarraySearch(int low, int high, int index, int target, int [] nums){
        int pos = binarySearch(low,high,target,nums);
        if(pos != -1){
            index = pos;
            return leftSubarraySearch(low,pos-1,index,target,nums);
        }
        return index;
    }

    public int rightSubarraySearch(int low, int high, int index, int target, int [] nums){
        int pos = binarySearch(low,high,target,nums);
        if(pos != -1){
            index = pos;
            return rightSubarraySearch(pos+1,high,index,target,nums);
        }
        return index;
    }

    public int[] searchRange(int [] nums, int target){
        int length = nums.length;
        int index = binarySearch(0,length-1,target,nums);
        int leftindex;
        int rightIndex;
        if(index != -1){
            leftindex = leftSubarraySearch(0,index,-1,target,nums);
            rightIndex = rightSubarraySearch(index+1,length-1,-1,target,nums);
            if(leftindex ==-1 && rightIndex == -1 ){
                return new int[]{index,index};
            }else if(leftindex == -1 && rightIndex != -1 ){
                return new int[]{index,rightIndex};
            }else if(leftindex != -1 && rightIndex == -1 ){
                return new int[]{leftindex,index};
            }
        }else{
            return new int[] {-1,-1};
        }

        return new int[]{leftindex,rightIndex};
    }

    public static void main(String args[]){
        FirstLastPositionInArray flpos = new FirstLastPositionInArray();
        int[] nums = {5,7,7,8,8,10};
        int target = 6;
        int indices[] = flpos.searchRange(nums,target);
        System.out.println("left index:"+indices[0]);
        System.out.println("right index:"+indices[1]);
    }
}