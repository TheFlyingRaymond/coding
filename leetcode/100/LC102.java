import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        List<TreeNode> layer = new LinkedList<>();
        layer.add(root);

        while (!layer.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int cnt = layer.size();
            for(int i = 0; i < cnt; i++) {
                TreeNode node = layer.removeFirst();
                tmp.add(node.val);
                if (node.left != null) {
                    layer.add(node.left);
                }
                if (node.right != null) {
                    layer.add(node.right);
                }
            }
            ret.add(tmp);
        }
        return ret;
    }

    class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
}