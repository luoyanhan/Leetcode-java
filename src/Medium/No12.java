package Medium;

public class No12 {
//    class Solution {
//        public String intToRoman(int num) {
//            int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
//            String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
//            StringBuilder res = new StringBuilder();
//            while (num>0){
//                for (int idx=0; idx<values.length; idx++){
//                    int val = values[idx];
//                    String sym = symbols[idx];
//                    if (val<=num){
//                        res.append(sym);
//                        num -= val;
//                        break;
//                    }
//                }
//            }
//            return res.toString();
//        }
//    }
    class Solution {
        public String intToRoman(int num) {
            int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            StringBuilder res = new StringBuilder();
            for (int idx=0; idx<values.length; idx++){
                int val = values[idx];
                String sym = symbols[idx];
                while (num >= val){
                    num -= val;
                    res.append(sym);
                }
                if (num == 0){
                    break;
                }
            }
            return res.toString();
        }
    }
}
