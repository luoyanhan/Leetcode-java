package Medium;

import java.util.ArrayList;
import java.util.List;

public class No57 {
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> res = new ArrayList<>();
            boolean placed = false;
            for (int[] each:intervals){
                if (each[1]<newInterval[0]){
                    res.add(each);
                }else if (each[0]>newInterval[1]){
                    if (!placed){
                        res.add(newInterval);
                        placed = true;
                    }
                    res.add(each);
                }else {
                    newInterval[0] = Math.min(each[0], newInterval[0]);
                    newInterval[1] = Math.max(each[1], newInterval[1]);
                }
            }
            if (!placed){
                res.add(newInterval);
            }
            return res.toArray(new int[res.size()][2]);
        }
    }
}
