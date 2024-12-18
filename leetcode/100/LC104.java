import java.util.ArrayList;
import java.util.List;

public class LC104 {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepth2(TreeNode root) {
        int cnt = 0;
        if(root == null) {
            return cnt;
        }

        List<TreeNode> layer = new ArrayList<>();
        layer.add(root);

        while (!layer.isEmpty()) {
            cnt++;
            List<TreeNode> tmpLayer = new ArrayList<>();

            int size = layer.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = layer.get(i);
                if (node.left != null) {
                    tmpLayer.add(node.left);
                }
                if (node.right != null) {
                    tmpLayer.add(node.right);
                }
            }

            layer = tmpLayer;
        }
        return cnt;
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
