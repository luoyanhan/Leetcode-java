package Medium.NO96;

class Solution {
    public int numTrees(int n) {
        int[] answer = new int[n+1];
        answer[0] = 1;
        answer[1] = 1;
        for (int num=2; num<=n; num++){
            for (int rootIdx=1; rootIdx<=num; rootIdx++){
                answer[num] += answer[rootIdx-1]*answer[num-rootIdx];
            }
        }
        return answer[n];
    }
}
