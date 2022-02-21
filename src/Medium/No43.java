package Medium;

public class No43 {
    class Solution {
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")){
                return "0";
            }
            String res = "0";
            for (int idx2=num2.length()-1; idx2>=0; idx2--){
                StringBuilder sbuilder = new StringBuilder();
                int innerNum2 = num2.charAt(idx2)-'0', add=0;
                for (int i2=num2.length()-1; i2>idx2; i2--){
                    sbuilder.append(0);
                }
                for (int idx1=num1.length()-1; idx1>=0; idx1--){
                    int innerNum1 = num1.charAt(idx1)-'0';
                    int s = innerNum1 * innerNum2 + add;
                    sbuilder.append(s%10);
                    add = s/10;
                }
                if (add!=0){
                    sbuilder.append(add);
                }
                sbuilder.reverse();
                res = addNums(res, sbuilder.toString());
            }
            return res;
        }

        public String addNums(String num1, String num2){
            int idx1=num1.length()-1, idx2=num2.length()-1, add=0;
            StringBuilder res = new StringBuilder();
            while (idx1>=0 || idx2>=0 || add!=0){
                int innerNum1 = idx1>=0 ? num1.charAt(idx1)-'0' : 0;
                int innerNum2 = idx2>=0 ? num2.charAt(idx2)-'0' : 0;
                int s = innerNum1 + innerNum2 + add;
                res.append(s%10);
                add = s/10;
                idx1--;
                idx2--;
            }
            res.reverse();
            return res.toString();
        }
    }
}
