package Array;

/*import javafx.util.Pair;

import java.util.*;

public class MostProfitAssigningWork {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<Pair<Integer, Integer>> jobs = new ArrayList<>();
        int N = profit.length, res = 0, i = 0, maxp = 0;
        for (int j = 0; j < N; ++j) jobs.add(new Pair<Integer, Integer>(difficulty[j], profit[j]));
        Collections.sort(jobs, Comparator.comparing(Pair::getKey));
        Arrays.sort(worker);
        for (int ability : worker) {
            while (i < N && ability >= jobs.get(i).getKey())
                maxp = Math.max(jobs.get(i++).getValue(), maxp);
            res += maxp;
        }
        return res;
    }
    public static void main(String args[]){
        MostProfitAssigningWork mpaw = new MostProfitAssigningWork();
        int[] difficulty = {2,4,6,8,10};
        int[] profit = {10,20,30,40,50};
        int[] worker = {4,5,6,7};

        System.out.println("ans: "+ mpaw.maxProfitAssignment(difficulty,profit,worker));
    }
}*/
