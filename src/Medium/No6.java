package Medium;

import java.util.ArrayList;
import java.util.List;

public class No6 {
    class Solution {
        public String convert(String s, int numRows) {
            if (numRows<2){
                return s;
            }
            List<StringBuilder> rows = new ArrayList<>();
            for (int i=0; i<Math.min(numRows, s.length()); i++){
                rows.add(new StringBuilder());
            }
            Boolean goingDown = false;
            int curRow = 0;
            for (char c:s.toCharArray()){
                rows.get(curRow).append(c);
                if (curRow==0 || curRow==numRows-1){
                    goingDown = !goingDown;
                }
                curRow += goingDown?1:-1;
            }
            StringBuilder res = new StringBuilder();
            for (StringBuilder row: rows){
                res.append(row);
            }
            return res.toString();
        }
    }
}
