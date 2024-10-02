class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class LCA {

    // Function to find the lowest common ancestor (LCA)
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if the root is null, return null
        if (root == null) {
            return null;
        }
        
        // If we find either p or q, return the current node
        if (root == p || root == q) {
            return root;
        }

        // Recur for left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right are non-null, root is the LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, return the non-null value (either left or right subtree)
        return (left != null) ? left : right;
    }

    public static void main(String[] args) {
        // Test Case 1
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode p = root.left;  // Node 5
        TreeNode q = root.right; // Node 1

        TreeNode lca = lowestCommonAncestor(root, p, q);
        System.out.println("LCA of 5 and 1 is: " + lca.val); // Output: 3

        // Test Case 2
        p = root.left;        // Node 5
        q = root.left.right.right; // Node 4
        lca = lowestCommonAncestor(root, p, q);
        System.out.println("LCA of 5 and 4 is: " + lca.val); // Output: 5

        // Test Case 3
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        p = root2;  // Node 1
        q = root2.left; // Node 2
        lca = lowestCommonAncestor(root2, p, q);
        System.out.println("LCA of 1 and 2 is: " + lca.val); // Output: 1
    }
}