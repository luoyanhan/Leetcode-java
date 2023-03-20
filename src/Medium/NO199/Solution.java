package Medium.NO199;

import java.util.*;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root==null){
            return res;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Deque<TreeNode> nodeStack = new ArrayDeque<TreeNode>();
        Deque<Integer> depthStack = new ArrayDeque<Integer>();
        nodeStack.push(root);
        depthStack.push(0);
        int maxDepth = -1;
        while (!nodeStack.isEmpty()){
            TreeNode node = nodeStack.pop();
            Integer depth = depthStack.pop();
            if (node.left!=null){
                nodeStack.push(node.left);
                depthStack.push(depth+1);
            }
            if (node.right!=null){
                nodeStack.push(node.right);
                depthStack.push(depth+1);
            }
            if (depth>maxDepth && !map.containsKey(depth)){
                map.put(depth, node.val);
                maxDepth = depth;
            }
        }
        for (int i=0; i<=maxDepth; i++){
            res.add(map.get(i));
        }
        return res;
    }
}
