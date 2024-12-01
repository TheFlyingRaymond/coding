import java.util.ArrayList;
import java.util.List;

public class LC653 {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null || (root.left == null && root.right == null)) {
            return false;
        }

        List<Integer> list = new ArrayList<>();
        midOrder(root, list);

        int left = 0, right = list.size() - 1;
        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum == k) {
                return true;
            }

            if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    private void midOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        midOrder(root.left, list);
        list.add(root.val);
        midOrder(root.right, list);
    }

    class TreeNode {
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
