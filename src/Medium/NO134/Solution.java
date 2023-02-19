package Medium.NO134;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int numOfStations = gas.length;
        int start = 0;
        while (start<numOfStations){
            int step = 0;
            int sumGas = 0;
            int sumCost = 0;
            while (step<numOfStations){
                int pos = (start+step)%numOfStations;
                sumGas += gas[pos];
                sumCost += cost[pos];
                if (sumCost>sumGas){
                    break;
                }
                step++;
            }
            if (step==numOfStations){
                return start;
            }else {
                start = start + step + 1;
            }
        }
        return -1;
    }
}
