package Medium;

public class No91 {
//    class Solution {
//        public int numDecodings(String s) {
//            int length = s.length();
//            int[] mapper = new int[length+1];
//            mapper[0] = 1;
//            for (int i=1; i<length+1; i++){
//                if (s.charAt(i-1)!='0'){
//                    mapper[i] += mapper[i-1];
//                }
//                if (i>1 && s.charAt(i-2)!='0' && (s.charAt(i-2)-'0')*10 + s.charAt(i-1)-'0' <=26){
//                    mapper[i] += mapper[i-2];
//                }
//            }
//            return mapper[length];
//        }
//    }

    class Solution {
        public int numDecodings(String s) {
            int length = s.length();
            int a=0, b=1, c=0;
            for (int i=1; i<length+1; i++){
                c=0;
                if (s.charAt(i-1)!='0'){
                    c += b;
                }
                if (i>1 && s.charAt(i-2)!='0' && (s.charAt(i-2)-'0')*10 + s.charAt(i-1)-'0' <=26){
                    c += a;
                }
                a=b;
                b=c;
            }
            return c;
        }
    }
}
