package Medium;

public class No5 {

    class Solution {
        public String longestPalindrome(String s) {
            int start=0, maxLength=1, n=s.length();
            if (n<2){
                return s;
            }
            Boolean[][] dp = new Boolean[n][n];
            for (int i=0; i<n; i++){
                dp[i][i] = true;
            }
            char[] charArray = s.toCharArray();

            for (int len=2; len<=n; len++){
                for (int i=0; i<n; i++){
                    int j = i + len -1;
                    if (j>n-1){
                        break;
                    }
                    if (charArray[i]!=charArray[j]){
                        dp[i][j] = false;
                    }else {
                        if (len<3){
                            dp[i][j] = true;
                        }else {
                            dp[i][j] = dp[i+1][j-1];
                        }
                    }
                    if (dp[i][j]&&len>maxLength){
                        maxLength = len;
                        start = i;
                    }
                }
            }

            return s.substring(start, start+maxLength);
        }
    }

    class Solution2{
        public String longestPalindrome(String s) {
            int start=0, maxLength=1, n=s.length();
            if (n<2){
                return s;
            }
            for (int i=0; i<n; i++){
                int len1 = expandAroundCenter(s, i, i);
                int len2 = expandAroundCenter(s, i, i+1);
                int len = Math.max(len1, len2);
                if (len>maxLength){
                    maxLength = len;
                    start = i-(len-1)/2;
                }
            }
            return s.substring(start, start+maxLength);
        }

        public int expandAroundCenter(String s, int left, int right){
            while (left>=0 && right<s.length() && left<=right && s.charAt(left)==s.charAt(right)){
                left -= 1;
                right += 1;
            }
            return right -left -1;
        }
    }
}
