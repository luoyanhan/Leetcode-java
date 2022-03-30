package Medium;

import java.util.ArrayList;
import java.util.List;

public class No93 {
    class Solution {
        private List<String> res = new ArrayList<>();
        private int[] tmp = new int[4];
        public List<String> restoreIpAddresses(String s) {
           dfs(s, 0, 0);
           return res;
        }

        public void dfs(String s, int partId, int curIdx){
            if(partId==4){
                if (curIdx==s.length()){
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i=0; i<3; i++){
                        stringBuilder.append(tmp[i]);
                        stringBuilder.append(".");
                    }
                    stringBuilder.append(tmp[3]);
                    res.add(stringBuilder.toString());
                }
            }else {
                if (curIdx==s.length()){
                    return;
                }else {
                    if (s.charAt(curIdx)=='0'){
                        tmp[partId] = 0;
                        dfs(s, partId+1, curIdx+1);
                    }else {
                        int sum = 0;
                        for (int newIdx = curIdx; newIdx < s.length(); newIdx++) {
                            sum = (s.charAt(newIdx) - '0') + sum * 10;
                            if (sum < 0 || sum > 255) {
                                break;
                            }
                            tmp[partId] = sum;
                            dfs(s, partId + 1, newIdx + 1);
                        }
                    }
                }
            }
        }
    }
}
