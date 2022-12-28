package Medium.NO12;


class Solution {
    public String intToRoman(int num) {
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new  String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();
        for (int i=0; i<nums.length; i++){
            while (num>=nums[i]){
                roman.append(romans[i]);
                num -= nums[i];
            }
        }
        return roman.toString();
    }
}
