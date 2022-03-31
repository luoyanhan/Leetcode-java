package Medium;

public class No97 {
    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
            if (l1+l2!=l3){
                return false;
            }
            boolean[] mapper = new boolean[l2+1];
            mapper[0] = true;
            for (int idx1=0; idx1<=l1; idx1++){
                for (int idx2=0; idx2<=l2; idx2++){
                    int idx3 = idx1 + idx2 - 1;
                    if (idx1>0){
                        mapper[idx2] = (mapper[idx2] && s1.charAt(idx1-1)==s3.charAt(idx3));
                    }
                    if (idx2>0){
                        mapper[idx2] = mapper[idx2] || (mapper[idx2-1] && s2.charAt(idx2-1)==s3.charAt(idx3));
                    }
                }
            }
            return mapper[l2];
        }
    }
//    class Solution {
//        public boolean isInterleave(String s1, String s2, String s3) {
//            int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
//            if (l1+l2!=l3){
//                return false;
//            }
//            boolean[][] mapper = new boolean[l1+1][l2+1];
//            mapper[0][0] = true;
//            for (int idx1=0; idx1<=l1; idx1++){
//                for (int idx2=0; idx2<=l2; idx2++){
//                    int idx3 = idx1 + idx2 - 1;
//                    if (idx1>0){
//                        mapper[idx1][idx2] = mapper[idx1][idx2] || (mapper[idx1-1][idx2] && s1.charAt(idx1-1)==s3.charAt(idx3));
//                    }
//                    if (idx2>0){
//                        mapper[idx1][idx2] = mapper[idx1][idx2] || (mapper[idx1][idx2-1] && s2.charAt(idx2-1)==s3.charAt(idx3));
//                    }
//                }
//            }
//            return mapper[l1][l2];
//        }
//    }
}
