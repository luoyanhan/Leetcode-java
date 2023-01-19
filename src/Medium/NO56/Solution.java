package Medium.NO56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> answers = new ArrayList<int[]>();
        int length = intervals.length;
        if (length==0){
            return answers.toArray(new int[0][]);
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        for (int i=0; i<length; i++){
            int left=intervals[i][0], right=intervals[i][1];
            if (answers.isEmpty() || answers.get(answers.size()-1)[1]<left){
                answers.add(new int[]{left, right});
            }else {
                answers.get(answers.size()-1)[1] = Math.max(answers.get(answers.size()-1)[1], right);
            }
        }
        return answers.toArray(new int[answers.size()][]);
    }
}
