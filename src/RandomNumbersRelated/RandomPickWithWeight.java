import java.util.Random;
public class RandomPickWithWeight {
    
    int[] weightedArray = null;
    Random rand = new Random();

    public RandomPickWithWeight(int[] w) {
        weightedArray = new int[w.length];
        weightedArray[0] = w[0];

        for(int i=1; i<w.length; i++){
            weightedArray[i] = weightedArray[i-1] + w[i];
        }
    }

    public int pickIndex() {
        int len = weightedArray.length;
        int low = 0, high = len-1;
        /* In "rand.nextInt()" adding +1 is very important beacuse it generated the "0" index also which is not needed" */
        int randomNumber = rand.nextInt(weightedArray[len-1])+1;

        while(low < high){
            int mid = (low+high)/2;
            if(weightedArray[mid] == randomNumber){
                return mid;
            }else if(weightedArray[mid] < randomNumber){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return low;
    }
}
