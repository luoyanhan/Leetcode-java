package Medium.NO38;

class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for (int i=2; i<=n; i++){
            int start = 0, pos = 0;
            StringBuilder stringBuilder = new StringBuilder();
            while (pos<res.length()){
                while (pos<res.length() && res.charAt(start)==res.charAt(pos)){
                    pos++;
                }
                stringBuilder.append(Integer.toString(pos-start));
                stringBuilder.append(res.charAt(start));
                start = pos;
            }
            res = stringBuilder.toString();
        }
        return res;
    }
}
