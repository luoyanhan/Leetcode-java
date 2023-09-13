package Medium.NO274;

//class Solution {
//    public int hIndex(int[] citations) {
//        int len = citations.length;
//        int[] quoteNums = new int[len+1];
//        for (int i=0; i<len; i++){
//            if (citations[i]>len){
//                quoteNums[len]++;
//            }else {
//                quoteNums[citations[i]]++;
//            }
//        }
//        int h=0;
//        for (int idx=len; idx>=0; idx--){
//            h += quoteNums[idx];
//            if (h>=idx){
//                return idx;
//            }
//        }
//        return 0;
//    }
//}


class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int left=0, right=len;
        int mid=0,cnt=0;
        while (left<right){
            mid = (right+left+1)/2;
            cnt = 0;
            for (int i=0; i<len; i++){
                if (citations[i]>=mid){
                    cnt ++;
                }
            }
            if (cnt>=mid){
                left = mid;
            }else {
                right = mid-1;
            }
        }
        return left;
    }
}
