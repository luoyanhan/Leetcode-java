package Medium.NO5;

class Solution {
//    public String longestPalindrome(String s) {
//        int maxLength = 1, len = s.length(), begin=0;
//        if (len<=1){
//            return s;
//        }
//        char[] charArray = s.toCharArray();
//        boolean map[][] = new boolean[len][len];
//        for (int i=0; i<len; i++){
//            map[i][i] = true;
//        }
//        for (int L=2; L<=len; L++){
//            for (int left=0; left<len; left++){
//                int right = left + L - 1;
//                if (right > len-1){
//                    break;
//                }
//                if (charArray[left] != charArray[right]){
//                    map[left][right] = false;
//                }else {
//                    if (right-left<3){
//                        map[left][right] = true;
//                    }else {
//                        map[left][right] = map[left+1][right-1];
//                    }
//                }
//                if (map[left][right] && right-left+1>maxLength){
//                    maxLength = right-left+1;
//                    begin = left;
//                }
//            }
//        }
//        return s.substring(begin, begin+maxLength);
//    }
    public String longestPalindrome(String s) {
        if (s.length()<2){
            return s;
        }
        int left = 0, right = 0;
        for (int mid=0; mid<s.length(); mid++){
            int len1 = expand(mid, mid, s);
            int len2 = expand(mid, mid+1, s);
            int len = Math.max(len1, len2);
            if (len > right-left+1){
                left = mid - (len-1)/2;
                right = mid + len/2;
            }
        }
        return s.substring(left, right+1);
    }

    public int expand(int left, int right, String s){
        int len = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left -= 1;
            right += 1;
        }
        return right-left-1;
    }
}
