package model;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode createTree(int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(mid);
        root.left = createTree(start, mid - 1);
        root.right = createTree(mid + 1, end);
        return root;
    }
}
