class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

class IsBST {

    // Helper function that checks if the tree is a valid BST
    private boolean isBSTUtil(TreeNode node, long minValue, long maxValue) {
        // Base case: If the node is null, it's a valid BST
        if (node == null) {
            return true;
        }
        
        // The current node's value must be between minValue and maxValue
        if (node.val <= minValue || node.val >= maxValue) {
            return false;
        }
        
        // Recursively check the left and right subtrees
        // The left subtree must have all values < node.val, so maxValue is node.val
        // The right subtree must have all values > node.val, so minValue is node.val
        return isBSTUtil(node.left, minValue, node.val) && 
               isBSTUtil(node.right, node.val, maxValue);
    }

    // Public function to call the helper function with initial range
    public boolean isBST(TreeNode root) {
        // Use long.MIN_VALUE and long.MAX_VALUE to handle boundary cases like large integers
        return isBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static void main(String[] args) {
        // Test case 1: Tree [2, 1, 3]
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        IsBST bstChecker = new IsBST();
        if (bstChecker.isBST(root)) {
            System.out.println("Tree is a valid BST");
        } else {
            System.out.println("Tree is not a valid BST");
        }

        // Test case 2: Tree [5, 1, 4, null, null, 3, 6]
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);

        if (bstChecker.isBST(root2)) {
            System.out.println("Tree is a valid BST");
        } else {
            System.out.println("Tree is not a valid BST");
        }
    }
}