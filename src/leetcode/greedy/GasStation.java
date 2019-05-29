package leetcode.greedy;

/* https://leetcode.com/problems/gas-station/
 *
  * https://leetcode.com/problems/gas-station/discuss/42568/Share-some-of-my-ideas.
  * */

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {



        int tank = 0;
        int sumGas = 0;
        int sumCost = 0;
        int startIndex = 0;
        int len = gas.length;

        for(int i=0; i < len; i++){

            sumGas += gas[i];
            sumCost += cost[i];

            tank += gas[i] - cost[i];
            if(tank < 0){
                startIndex = i + 1;
                tank = 0;
            }

        }

        if(sumGas >= sumCost){
            return startIndex;
        }else{
            return -1;
        }
    }
}
