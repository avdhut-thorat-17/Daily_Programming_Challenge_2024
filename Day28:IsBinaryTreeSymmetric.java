// Definition for a binary tree node.
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

public class SymmetricTree {
    
    // Function to check if the tree is symmetric
    public boolean isSymmetric(TreeNode root) {
        // An empty tree is symmetric
        if (root == null) {
            return true;
        }
        // Check if the left and right subtrees are mirror images of each other
        return isMirror(root.left, root.right);
    }
    
    // Helper function to check if two trees are mirror images of each other
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // If both are null, they are symmetric (mirrors of each other)
        if (t1 == null && t2 == null) {
            return true;
        }
        // If only one is null, they are not symmetric
        if (t1 == null || t2 == null) {
            return false;
        }
        // Check if the current nodes are the same and their subtrees are mirrors
        return (t1.val == t2.val)
                && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
    }
    
    public static void main(String[] args) {
        // Test case 1
        TreeNode root1 = new TreeNode(1, 
                                new TreeNode(2, new TreeNode(3), new TreeNode(4)), 
                                new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        SymmetricTree solution1 = new SymmetricTree();
        System.out.println(solution1.isSymmetric(root1));  // Output: true
        
        // Test case 2
        TreeNode root2 = new TreeNode(1, 
                                new TreeNode(2, null, new TreeNode(3)), 
                                new TreeNode(2, null, new TreeNode(3)));
        SymmetricTree solution2 = new SymmetricTree();
        System.out.println(solution2.isSymmetric(root2));  // Output: false
    }
}