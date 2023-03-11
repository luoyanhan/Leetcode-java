package Medium.NO173;

import java.util.ArrayDeque;
import java.util.Deque;

class BSTIterator {
    private Deque<TreeNode> stack;
    private TreeNode cur;

    public BSTIterator(TreeNode root) {
        this.stack = new ArrayDeque<>();
        this.cur = root;
    }

    public int next() {
        while (cur!=null){
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int res = cur.val;
        cur = cur.right;
        return res;
    }

    public boolean hasNext() {
        return cur!=null || !stack.isEmpty();
    }
}
