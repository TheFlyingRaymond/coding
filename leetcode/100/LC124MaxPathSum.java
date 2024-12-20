import java.util.Arrays;

public class LC124MaxPathSum {

    private CalRet EMTPY = new CalRet(0, 0);
    private int max = -10000;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        recursive(root);
        return max;
    }

    private CalRet recursive(TreeNode node) {
        if (node == null) {
            return EMTPY;
        }

        CalRet leftC = recursive(node.left);
        CalRet rightC = recursive(node.right);
        int left = leftC.getAsPath(), right = rightC.getAsPath();

        int curAsPath = max(node.val, node.val + left, node.val + right);
        int curAsRoot = max(curAsPath, node.val + left + right);

        max = max(max, curAsRoot);

        return new CalRet(curAsRoot, curAsPath);
    }

    private int max(Integer... nums) {
        return Arrays.stream(nums).sorted((a, b) -> b - a).findFirst().orElse(null);
    }

    class CalRet {
        int asRoot;
        int asPath;

        public int getAsRoot() {
            return asRoot;
        }

        public int getAsPath() {
            return asPath;
        }

        CalRet(int asRoot, int asPath) {
            this.asRoot = asRoot;
            this.asPath = asPath;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}