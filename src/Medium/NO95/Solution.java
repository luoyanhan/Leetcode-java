package Medium.NO95;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> trees = generateTrees(1, n);
        return trees;
    }

    public List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> trees = new ArrayList<TreeNode>();
        if (start>end){
            trees.add(null);
            return trees;
        }
        for (int root=start; root<=end; root++){
            List<TreeNode> leftTrees = generateTrees(start, root-1);
            List<TreeNode> rightTrees = generateTrees(root+1, end);
            for (TreeNode leftTree:leftTrees){
                for (TreeNode rightTree:rightTrees){
                    TreeNode rootNode = new TreeNode(root);
                    rootNode.left = leftTree;
                    rootNode.right = rightTree;
                    trees.add(rootNode);
                }
            }
        }
        return trees;
    }
}
