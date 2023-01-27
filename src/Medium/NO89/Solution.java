package Medium.NO89;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> answers = new ArrayList<Integer>();
        answers.add(0);
        for (int i=1; i<=n; i++){
            int lastNum = answers.size();
            for (int j=lastNum-1; j>=0; j--){
                answers.add(answers.get(j) | (1<<(i-1)));
            }
        }
        return answers;
    }
}
