public class LC105BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int leftPre, int rightPre, int[] inorder, int leftMid ,int rightMid) {
        if(leftPre > rightPre){
            return null;
        }

        TreeNode root = new TreeNode(preorder[leftPre]);
        for(int i = leftMid; i <= rightMid; i++){
            if (inorder[i] == root.val) {
                int leftLen = i - leftMid;
                root.left = buildTree(preorder, leftPre + 1, leftPre + leftLen, inorder, leftMid, i - 1);
                root.right = buildTree(preorder, leftPre + leftLen + 1, rightPre, inorder, i + 1, rightMid);
                break;
            }
        }

        return root;
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
