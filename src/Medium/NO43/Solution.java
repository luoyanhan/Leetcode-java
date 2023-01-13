package Medium.NO43;

class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int len1 = num1.length(), len2 = num2.length();
        int[] res = new int[len1+len2];
        for (int i=len1-1; i>=0; i--){
            int n1 = num1.charAt(i) - '0';
            for (int j=len2-1; j>=0; j--){
                int n2 = num2.charAt(j) - '0';
                res[i+j+1] += n1*n2;
            }
        }
        for (int i=len1-1; i>=0; i--){
            for (int j=len2-1; j>=0; j--){
                int idx = i+j+1;
                int add = res[idx]/10;
                res[idx] %= 10;
                res[idx-1] += add;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<len1+len2; i++){
            if (i==0 && res[i]==0){
                continue;
            }
            stringBuilder.append(Integer.toString(res[i]));
        }
        return stringBuilder.toString();
    }
}

