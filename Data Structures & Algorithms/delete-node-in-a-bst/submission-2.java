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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }
        if(root.val == key){
            TreeNode left = root.left;
            TreeNode right = root.right;
            if(left == null && right == null){
                return null;
            }
            else if(left == null){
                return root.right;
            }
            else if(right == null){
                return root.left;
            }
            else{
                TreeNode curr = root.right;
                while(curr.left != null){
                    curr = curr.left;
                }
                root.val = curr.val;
                root.right = deleteNode(root.right, root.val);
            }
        }
        else if(key < root.val){
            root.left = deleteNode(root.left, key);
        }
        else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}