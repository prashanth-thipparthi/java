package Array;

public class FindCelebrity {
    public int findCelebrity(int n) {
        /*
        The entire gist of the problem is eliminating one node evernode everytime you traverse through an edge. Like if there is an edge from a->b, then 'a' is not celebrity_candidate because 'a' knows someone, then we make 'b' as celebrity_candidate and check on 'b' and so on..
        For the final celebrity_candidate, we check whether everyone knows him or not.
        */
        
        if(n==0) {
            return 0;
        }
        int celebrity_candidate = 0;
        for(int i=0; i<n; i++) {
            if(i==celebrity_candidate) {
                continue;
            }
            if(knows(celebrity_candidate,i)) {
                celebrity_candidate = i;
            }
        }
        
        boolean isCelebrity = isCelebrityCheck(celebrity_candidate, n);
        if(isCelebrity) {
            return celebrity_candidate;
        }
        return -1;
    }
    
    public boolean isCelebrityCheck(int celebrity_candidate, int n) {
        for(int i=0; i<n; i++) {
            if(i==celebrity_candidate) {
                continue;
            }
            if(knows(celebrity_candidate,i) || !knows(i,celebrity_candidate)) {
                return false;
            }
        }  
        return true;
    } 
}