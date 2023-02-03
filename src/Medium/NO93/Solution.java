package Medium.NO93;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> answers = new ArrayList<String>();
        List<String> answer = new ArrayList<String>();
        backTrack(answers, answer, s, 0);
        return answers;
    }

    public void backTrack(List<String> answers, List<String> answer, String s, int idx){
        if (answer.size()==4){
            if (idx==s.length()){
                StringBuilder sb = new StringBuilder();
                for (int i=0; i<4; i++){
                    sb.append(answer.get(i));
                    if (i<3){
                        sb.append('.');
                    }
                }
                answers.add(sb.toString());
            }
            return;
        }

        if (idx==s.length()){
            return;
        }

        if (s.charAt(idx)=='0'){
            answer.add("0");
            backTrack(answers, answer, s, idx+1);
            answer.remove(answer.size()-1);
        }else {
            int addr = 0;
            for (int i=idx; i<s.length(); i++){
                addr = addr*10 + (s.charAt(i)-'0');
                if (addr>255){
                    break;
                }
                answer.add(Integer.toString(addr));
                backTrack(answers, answer, s, i+1);
                answer.remove(answer.size()-1);
            }
        }
    }
}
