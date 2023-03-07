package Medium.NO165;

class Solution {
//    public int compareVersion(String version1, String version2) {
//        String[] li1 = version1.split("\\.");
//        String[] li2 = version2.split("\\.");
//        int maxLen = Math.max(li1.length, li2.length);
//        for (int idx=0; idx<maxLen; idx++){
//            String s1 = idx<li1.length?li1[idx]:"0";
//            String s2 = idx<li2.length?li2[idx]:"0";
//            if ((Integer.parseInt(s1) > Integer.parseInt(s2))){
//                return 1;
//            }else if ((Integer.parseInt(s1) < Integer.parseInt(s2))){
//                return -1;
//            }
//        }
//        return 0;
//    }
    public int compareVersion(String version1, String version2) {
        int len1 = version1.length();
        int len2 = version2.length();
        int ptr1 = 0, ptr2 = 0;
        while (ptr1<len1 || ptr2<len2){
            int sum1 = 0;
            while (ptr1<len1&&version1.charAt(ptr1)!='.'){
                //先减后加防溢出
                sum1 = sum1*10 - '0' + version1.charAt(ptr1);
                ptr1++;
            }
            ptr1++;
            int sum2 = 0;
            while (ptr2<len2&&version2.charAt(ptr2)!='.'){
                //先减后加防溢出
                sum2 = sum2*10 - '0' + version2.charAt(ptr2);
                ptr2++;
            }
            ptr2++;
            if (sum1>sum2){
                return 1;
            }
            if (sum1<sum2){
                return -1;
            }
        }
        return 0;
    }
}
