package Medium.NO57;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int length = intervals.length;
        if (length==0){
            return new int[][]{newInterval};
        }
        boolean inserted=false;
        List<int[]> answers = new ArrayList<int[]>();
        int left=newInterval[0], right=newInterval[1];
        for (int pos=0; pos<length; pos++){
            if (right<intervals[pos][0]){
                if (!inserted){
                    answers.add(new int[]{left, right});
                    inserted=true;
                }
                answers.add(intervals[pos]);
            }else if (left>intervals[pos][1]){
                answers.add(intervals[pos]);
            }else {
                left = Math.min(left, intervals[pos][0]);
                right = Math.max(right, intervals[pos][1]);
            }
        }
        if (!inserted){
            answers.add(new int[]{left, right});
        }
        return answers.toArray(new int[answers.size()][]);
    }
}
