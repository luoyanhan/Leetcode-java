package Medium.NO131;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] records = new boolean[len][len];
        for (int j=0; j<len; j++){
            for (int i=0; i<=j; i++){
                if (s.charAt(i)==s.charAt(j)){
                    if (j-i<2){
                        records[i][j] = true;
                    }else {
                        records[i][j] = records[i+1][j-1];
                    }
                }
            }
        }

        List<List<String>> answers = new ArrayList<List<String>>();
        List<String> answer = new ArrayList<>();
        recursion(answers, answer, records, s, 0);
        return answers;
    }

    public void recursion(List<List<String>> answers, List<String> answer, boolean[][] records, String s, int start){
        if (start==s.length()){
            answers.add(new ArrayList<>(answer));
            return;
        }
        for (int end=start; end<s.length(); end++){
            if (records[start][end]){
                answer.add(s.substring(start, end+1));
                recursion(answers, answer, records, s, end+1);
                answer.remove(answer.size()-1);
            }
        }
    }
}
