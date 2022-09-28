package com.zhuolu.leetcode.solution;

public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }
    
    private TreeNode buildTree(int[] preorder, int[] inorder, int preorderStart, int preorderEnd, int inorderStart, int inorderEnd) {
        if (preorderEnd - preorderStart != inorderEnd - inorderStart) {
            throw new IllegalArgumentException("preorderEnd - inorderEnd must be equal to inorderEnd - inorderStart");
        }
        if (preorderEnd - preorderStart <= 0) {
            return null;
        }
        if (preorderEnd - preorderStart == 1) {
            return new TreeNode(preorder[preorderStart]);
        }
        int val = preorder[preorderStart];
        TreeNode left = null;
        TreeNode right = null;
        for (int i = inorderStart; i < inorderEnd; i++) {
            if (inorder[i] == val) {
                left = buildTree(preorder, inorder, preorderStart + 1, preorderStart + 1 + i - inorderStart, inorderStart, i);
                right = buildTree(preorder, inorder, preorderStart + 1 + i - inorderStart, preorderEnd, i + 1, inorderEnd);
                break;
            }
        }
        return new TreeNode(val, left, right);
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
