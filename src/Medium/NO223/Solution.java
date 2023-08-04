package Medium.NO223;

class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2-ax1)*(ay2-ay1);
        int area2 = (bx2-bx1)*(by2-by1);
        int overLapWidth = Math.max(0, Math.min(bx2, ax2)-Math.max(ax1, bx1));
        int overLapHeight = Math.max(0, Math.min(ay2, by2)-Math.max(ay1, by1));
        int overLapArea = overLapWidth*overLapHeight;
        return area1 + area2 - overLapArea;
    }
}
