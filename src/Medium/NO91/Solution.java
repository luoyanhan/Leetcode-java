package Medium.NO91;

class Solution {
    public int numDecodings(String s) {
        int length = s.length();
        int[] answer = new int[length+1];
        answer[0] = 1;
        for (int i=1; i<=length; i++){
            if (s.charAt(i-1)-'0'>0){
                answer[i] += answer[i-1];
            }
            if (i>1 && s.charAt(i-2)!='0' && ((s.charAt(i-2)-'0')*10 + s.charAt(i-1)-'0' <=26)){
                answer[i] += answer[i-2];
            }
        }
        return answer[length];
    }
}
