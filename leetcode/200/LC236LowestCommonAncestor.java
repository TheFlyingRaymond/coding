public class LC236LowestCommonAncestor {
    CheckRet nothing = new CheckRet();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q).ans;
    }

    private CheckRet dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return nothing;
        }

        CheckRet checkLeft = dfs(root.left, p, q);
        CheckRet checkRight = dfs(root.right, p, q);
        if (checkLeft.ans != null) {
            return checkLeft;
        }
        if (checkRight.ans != null) {
            return checkRight;
        }

        CheckRet me = new CheckRet();
        me.hasP =root.val == p.val || checkLeft.hasP || checkRight.hasP;
        me.hasQ = root.val == q.val || checkLeft.hasQ || checkRight.hasQ;
        if(me.hasP && me.hasQ){
            me.ans = root;
        }
        return me;
    }

    class CheckRet{
        boolean hasP;
        boolean hasQ;
        TreeNode ans;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
