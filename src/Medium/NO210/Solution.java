package Medium.NO210;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> edges;
    boolean valid = true;
    int[] visited;
    int[] result;
    int idx;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i=0; i<numCourses; i++){
            edges.add(new ArrayList<>());
        }
        for (int[] each: prerequisites){
            edges.get(each[1]).add(each[0]);
        }
        visited = new int[numCourses];
        result = new int[numCourses];
        idx = numCourses-1;
        for (int i=0; i<numCourses; i++){
            if(visited[i]==0) {
                dfs(i);
                if (!valid) {
                    break;
                }
            }
        }
        if (!valid){
            return new int[0];
        }
        return result;
    }

    public void dfs(int num){
        visited[num] = 1;
        for (int i:edges.get(num)){
            if (visited[i]==1){
                valid = false;
                return;
            }else if (visited[i]==0){
                dfs(i);
                if (!valid){
                    return;
                }
            }
        }
        visited[num] = 2;
        result[idx] = num;
        idx--;
    }
}
