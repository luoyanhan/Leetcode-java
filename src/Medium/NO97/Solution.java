package Medium.NO97;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len1+len2!=len3){
            return false;
        }
        boolean[][] map = new boolean[len1+1][len2+1];
        map[0][0] = true;
        for (int i=0; i<=len1; i++){
            for (int j=0; j<=len2; j++){
                int p = i+j-1;
                if (i>0){
                    if (s3.charAt(p)==s1.charAt(i-1)){
                        map[i][j] = map[i-1][j] || map[i][j];
                    }
                }
                if (j>0){
                    if (s3.charAt(p)==s2.charAt(j-1)){
                        map[i][j] = map[i][j-1] || map[i][j];
                    }
                }
            }
        }
        return map[len1][len2];
    }
}
