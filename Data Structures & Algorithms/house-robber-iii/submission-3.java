/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private Map<TreeNode, Integer> cache;

    public int rob(TreeNode root) {
        cache = new HashMap<>();
        cache.put(null, 0);
        return dp(root);
    }

    public int dp(TreeNode root){
        if(cache.containsKey(root)){
            return cache.get(root);
        }

        int res = root.val;

        if(root.left != null){
            res += dp(root.left.left) + dp(root.left.right);
        }

        if(root.right != null){
            res += dp(root.right.left) + dp(root.right.right);
        }

        res = Math.max(res, dp(root.left) + dp(root.right));
        cache.put(root, res);
        return res;
    }

}