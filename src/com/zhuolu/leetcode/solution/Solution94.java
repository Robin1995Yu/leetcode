package com.zhuolu.leetcode.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode node = addToLeftest(root, stack);
        while (node != null) {
            result.add(node.val);
            if (node.right != null) {
                node = addToLeftest(node.right, stack);
            } else {
                node = stack.isEmpty() ? null : stack.pop();
            }
        }
        return result;
    }

    private TreeNode addToLeftest(TreeNode node, Stack<TreeNode> stack) {
        while (node.left != null) {
            stack.push(node);
            node = node.left;
        }
        return node;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
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
