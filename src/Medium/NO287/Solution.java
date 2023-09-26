package Medium.NO287;

//class Solution {
//    public int findDuplicate(int[] nums) {
//        int len = nums.length;
//        int left = 1, right = len;
//        while (left<right){
//            int mid = (left+right)/2;
//            int cnt = 0;
//            for (int num:nums){
//                if (num<=mid){
//                    cnt++;
//                }
//            }
//            if (cnt<=mid){
//                left = mid+1;
//            }else {
//                right = mid;
//            }
//        }
//        return right;
//    }
//}


//class Solution {
//    public int findDuplicate(int[] nums) {
//        int slow = 0, fast = 0;
//        do {
//            slow = nums[slow];
//            fast = nums[nums[fast]];
//        }while (fast!=slow);
//        int ptr = 0;
//        while (ptr!=slow){
//            ptr = nums[ptr];
//            slow = nums[slow];
//        }
//        return slow;
//    }
//}


class Solution {
    public int findDuplicate(int[] nums) {
        int bitMax = 30;
        int len = nums.length;
        while (bitMax>0){
            if (((1<<bitMax)&(len-1))!=0){
                break;
            }
            bitMax--;
        }
        int res = 0;
        for (int i=0; i<=bitMax; i++){
            int findOne = 1<<i;
            int x=0, y=0;
            for (int idx=0; idx<len; idx++){
                if (idx>0&(idx&findOne)!=0){x++;}
                if ((nums[idx]&findOne)!=0){y++;}
            }
            if (y>x){res = res|findOne;}
        }
        return res;
    }
}
