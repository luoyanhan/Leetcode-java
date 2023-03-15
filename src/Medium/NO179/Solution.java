package Medium.NO179;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String largestNumber(int[] nums){
        int len = nums.length;
        if (len==1){
            return String.valueOf(nums[0]);
        }
        String[] strs = new String[len];
        for (int idx=0; idx<len; idx++){
            strs[idx] = String.valueOf(nums[idx]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String tmp1 = o1 + o2;
                String tmp2 = o2 + o1;
                return tmp2.compareTo(tmp1);
            }
        });

        if (strs[0].equals("0")){
            return "0";
        }

        StringBuffer res = new StringBuffer();
        for (String each:strs){
            res.append(each);
        }
        return res.toString();
    }
}
