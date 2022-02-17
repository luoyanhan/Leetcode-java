package Medium;

public class No38 {
    public static void main(String[] args){
        No38 n = new No38();
        Solution s = n.new Solution();
        System.out.println(s.countAndSay(4));
    }

    class Solution {
        public String countAndSay(int n) {
            String res = "1";
            for (int i=1; i<n; i++){
                StringBuilder tmp = new StringBuilder();
                int left=0, right=0, len=res.length();
                while (right<len){
                    while (right<len&&res.charAt(left)==res.charAt(right)){
                        right++;
                    }
                    tmp.append(Integer.toString(right-left));
                    tmp.append(res.charAt(left));
                    left = right;
                }
                res = tmp.toString();
            }
            return res;
        }
    }

//    class Solution {
//        public String countAndSay(int n) {
//            String res = "1";
//            if (n==1){
//                return res;
//            }
//            for (int time=1; time<n; time++){
//                StringBuilder tmp = new StringBuilder();
//                int idx=0, num=1;
//                int len = res.length();
//                if (len==1){
//                    res = "1" + res.charAt(0);
//                }else {
//                    while (idx<len){
//                        if (idx>0&&res.charAt(idx)==res.charAt(idx-1)){
//                            num++;
//                            if (idx==len-1){
//                                tmp.append(num);
//                                tmp.append(res.charAt(idx));
//                            }
//                        }else if (idx>0&&res.charAt(idx)!=res.charAt(idx-1)){
//                            tmp.append(num);
//                            tmp.append(res.charAt(idx-1));
//                            num=1;
//                            if (idx==len-1){
//                                tmp.append(num);
//                                tmp.append(res.charAt(idx));
//                            }
//                        }
//                        idx++;
//                    }
//                    res = tmp.toString();
//                }
//            }
//            return res;
//        }
//    }
}
