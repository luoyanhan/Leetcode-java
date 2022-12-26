package Medium.NO6;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String convert(String s, int numRows) {
        if (numRows<2){
            return s;
        }
        List<StringBuilder> list = new ArrayList<StringBuilder>();
        for (int i=0; i<numRows; i++){
            list.add(new StringBuilder());
        }
        int row = 0, flag = -1;
        for (char c : s.toCharArray()){
            list.get(row).append(c);
            if (row==0 || row==numRows-1){
                flag = -flag;
            }
            row += flag;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder builder : list){
            stringBuilder.append(builder);
        }
        return stringBuilder.toString();
    }
}
