package Medium.NO229;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int num1;
    int num2;
    int vote1=0;
    int vote2=0;

    public List<Integer> majorityElement(int[] nums) {
        for (int num:nums){
            if (num==num1){
                vote1++;
            }else if (num==num2){
                vote2++;
            }else if (vote1==0){
                num1=num;
                vote1=1;
            }else if (vote2==0){
                num2=num;
                vote2=1;
            }else {
                vote1--;
                vote2--;
            }
        }
        int cnt1=0;
        int cnt2=0;
        for (int num:nums){
            if (num==num1 && vote1>0){
                cnt1++;
            }
            if (num==num2 && vote2>0){
                cnt2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if (cnt1>nums.length/3){
            res.add(num1);
        }
        if (cnt2>nums.length/3){
            res.add(num2);
        }
        return res;
    }
}
