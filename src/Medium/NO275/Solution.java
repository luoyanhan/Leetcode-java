package Medium.NO275;

class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int left = 0, right = len;
        while (left<right){
            int mid = (left+right+1)/2;
            int cnt = 0;
            for (int idx=0; idx<len; idx++){
                if (citations[idx]>=mid){
                    cnt++;
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
