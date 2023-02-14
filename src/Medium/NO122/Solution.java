package Medium.NO122;

class Solution {
    public int maxProfit(int[] prices) {
        int days = prices.length;
        int[][] records = new int[days][2];
        records[0][0] = 0;
        records[0][1] = -prices[0];
        for (int day=1; day<days; day++){
            records[day][0] = Math.max(records[day-1][0], records[day-1][1]+prices[day]);
            records[day][1] = Math.max(records[day-1][1], records[day-1][0]-prices[day]);
        }
        return records[days-1][0];
    }
}
