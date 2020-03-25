package Array;

public class HappyNumber {
    public boolean isHappy(int n) {
        int copy = n;
        Set<Integer> hset = new HashSet<Integer>();
        if(n == 0){
            return false;
        }
        while(true) {
            int digit = 0;
            int sum = 0;
            while(n > 0){
                digit = n%10;
                sum += digit*digit;
                n = n/10;
            }
            if(sum == 1) {
                return true;
            }
            if(hset.contains(sum) || sum == copy) {
                return false;
            }
            hset.add(sum);
            n = sum;
        }
    
}