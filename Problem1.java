//Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(h) where h is the height of the tree (due to recursion stack)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Three line explanation of solution in plain english:
// 1. We perform an inorder traversal of the binary search tree (BST) to get the elements in sorted order.
// 2. We maintain a count of the elements visited so far and check if it matches k.
// 3. When the count matches k, we store the value of the current node as the result and return it.




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
    int count=0;
    int res=-1;
    public int kthSmallest(TreeNode root, int k) {
        findkthSmallest(root,k);
        return res;
    }
    public void findkthSmallest(TreeNode root,int k){
        if(root==null){
            return;
        }
        //inorder traversal of BST gives the elements in sorted order
        //so we traverse the left subtree first, then the root, and then the right subtree
        findkthSmallest(root.left,k);
        //increment the count of elements visited so far
        count++;
        //if the count is equal to k, then we have found the kth smallest element
        if(count==k){
            res=root.val;
        }
        //if the count is less than k, then we continue to the right subtree
        //this is because we have not yet found the kth smallest element
        if(count<k){
        findkthSmallest(root.right,k);
        }
    }
}