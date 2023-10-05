// Diameter of a Binary Tree

1st Method :- Brute Force

// Function to find the diameter of the binary tree
public int diameterOfBinaryTree() {
    return diameter(root);
}

// Helper function to find the diameter of a binary tree
private int diameter(TreeNode node) {
    if (node == null) {
        return 0;
    }

    // Calculate the height of the left and right subtrees
    int leftHeight = height(node.left);
    int rightHeight = height(node.right);

    // Calculate the diameter passing through the current node
    int throughRoot = leftHeight + rightHeight;

    // Calculate the diameter in the left subtree
    int inLeftSubtree = diameter(node.left);

    // Calculate the diameter in the right subtree
    int inRightSubtree = diameter(node.right);

    // Return the maximum of the three diameters
    return Math.max(throughRoot, Math.max(inLeftSubtree, inRightSubtree));
}

// Helper function to calculate the height of a binary tree
private int height(TreeNode node) {
    if (node == null) {
        return 0;
    }
    return 1 + Math.max(height(node.left), height(node.right));
}

----------------------------------------------------------------------------------------------
2nd Method 
  
static int diameter(Node root) {
    // base case if tree is empty
    if (root == null)
        return 0;

    // get the height of left and right sub-trees
    int lheight = height(root.left);
    int rheight = height(root.right);

    // get the diameter of left and right sub-trees
    int ldiameter = diameter(root.left);
    int rdiameter = diameter(root.right);

    /*
     * Return max of following three
     * 1) Diameter of left subtree
     * 2) Diameter of right subtree
     * 3) Height of left subtree + height of right
     * subtree + 1
     */
    return Math.max(lheight + rheight + 1,
            Math.max(ldiameter, rdiameter));
}

static int height(Node node) {
    // base case tree is empty
    if (node == null)
        return 0;

    // If tree is not empty then height = 1 + max of
    // left height and right heights
    return (1 + Math.max(height(node.left), height(node.right)));
}

------------------------------------------------------------------------------------------------
3rd Method 

class TreeInfo {
    int height;
    int diameter;

    TreeInfo(int height, int diameter) {
        this.height = height;
        this.diameter = diameter;
    }
}

// Function to find the diameter of the binary tree
public int diameterOfBinaryTree() {
    TreeInfo treeInfo = calculateDiameter(root);
    return treeInfo.diameter;
}

// Helper function to calculate the height and diameter of a binary tree
private TreeInfo calculateDiameter(TreeNode node) {
    if (node == null) {
        return new TreeInfo(0, 0);
    }

    // Recursively calculate the height and diameter of left and right subtrees
    TreeInfo leftInfo = calculateDiameter(node.left);
    TreeInfo rightInfo = calculateDiameter(node.right);

    // Calculate the height of the current node
    int height = 1 + Math.max(leftInfo.height, rightInfo.height);

    // Calculate the diameter passing through the current node
    int throughRoot = leftInfo.height + rightInfo.height;

    // Calculate the diameter in the left subtree
    int inLeftSubtree = leftInfo.diameter;

    // Calculate the diameter in the right subtree
    int inRightSubtree = rightInfo.diameter;

    // Calculate the final diameter by taking the maximum of the three diameters
    int diameter = Math.max(throughRoot, Math.max(inLeftSubtree, inRightSubtree));

    // Return the height and diameter of the current node
    return new TreeInfo(height, diameter);
}


