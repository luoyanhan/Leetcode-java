package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class No56 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            List<int[]> res = new ArrayList<>();
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
                }
            });
            for (int idx=0; idx<intervals.length; idx++){
                int left=intervals[idx][0], right=intervals[idx][1];
                if (res.size()==0 || left>res.get(res.size()-1)[1]){
                    res.add(intervals[idx]);
                }else {
                    int[] last = res.get(res.size()-1);
                    res.get(res.size()-1)[1] = Math.max(last[1], right);
                }
            }
            return res.toArray(new int[res.size()][]);
        }
    }
}
