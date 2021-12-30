package Easy;

import java.util.HashMap;

public class ninteen_ninty_five {
    public static void main(String[] args){
        int[] nums = {1,2,3,6};
        Solution s1 = new Solution();
        System.out.println(s1.countQuadruplets(nums));
    }
}


class Solution {
//    public int countQuadruplets(int[] nums) {
//        int n = nums.length;
//        int res = 0;
//        for(int a=0; a<n-3; a++){
//            for(int b=a+1; b<n-2;b++){
//                for(int c=b+1; c<n-1;c++){
//                    for(int d=c+1; d<n; d++){
//                        if(nums[a] + nums[b] + nums[c] == nums[d]){
//                            res += 1;
//                        }
//                    }
//                }
//            }
//        }
//        return res;
//    }

//    public int countQuadruplets(int[] nums) {
//        int n = nums.length;
//        int res = 0;
//        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//        for(int c=n-2; c>=2; c-=1){
//            map.put(nums[c+1], map.getOrDefault(nums[c+1], 0)+1);
//            for(int a=0;a<c;a+=1){
//                for(int b=a+1;b<c;b+=1){
//                    res += map.getOrDefault(nums[a]+nums[b]+nums[c], 0);
//                }
//            }
//        }
//        return res;
//    }

    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int b=n-3;b>=1;b-=1){
            for(int d=b+2;d<n;d+=1){
                map.put(nums[d]-nums[b+1], map.getOrDefault(nums[d]-nums[b+1], 0)+1);
            }
            for(int a=0;a<b;a+=1){
                res += map.getOrDefault(nums[a]+nums[b], 0);
            }
        }
        return res;
    }
}