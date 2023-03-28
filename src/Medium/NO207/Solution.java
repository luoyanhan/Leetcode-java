package Medium.NO207;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> records;
    int[] visited;
    boolean vaild;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        records = new ArrayList<>();
        vaild = true;
        for (int i=0; i<numCourses; i++){
            records.add(new ArrayList<>());
        }
        for (int[] each: prerequisites){
            records.get(each[0]).add(each[1]);
        }
        visited = new int[numCourses];
        for (int i=0; i<numCourses; i++){
            if (visited[i]==0 && vaild){
                recursion(i);
            }
        }
        return vaild;
    }

    public void recursion(int num){
        visited[num] = 1;
        for (int i:records.get(num)){
            if (visited[i]==0){
                recursion(i);
            }else if (visited[i]==1){
                vaild = false;
                break;
            }
        }
        visited[num] = 2;
    }
}
