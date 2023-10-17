A binary tree is called a "Sum Tree" if the value of each node is equal to the sum of the values of its left and right subtrees. 
To check if a given binary tree is a Sum Tree, you can use a recursive approach. 


// 1st Method 
Explanation 

1. We define a `TreeNode` class to represent the nodes of the binary tree. Each node contains a value and references to its left and right children.
2. In the `SumTreeChecker` class, we create a method `isSumTree` that checks if a binary tree is a Sum Tree.
3. The base case checks if the `root` is `null` or if it's a leaf node (both left and right children are `null`). In such cases, the tree is considered a Sum Tree by default.
4. In the recursive case, we recursively check if the left and right subtrees are also Sum Trees.
5. If both the left and right subtrees are Sum Trees and the current node's value is equal to the sum of its left and right subtree values, then it's a Sum Tree.
6. We use a helper function `sum` to calculate the sum of a binary tree by recursively adding the values of all nodes.
7. In the `main` method, we create a sample binary tree and call `isSumTree` to check if it's a Sum Tree. We print the result.

The code follows a recursive approach to check if the binary tree is a Sum Tree, ensuring that the sum property holds for each node.

```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class SumTreeChecker {
    public boolean isSumTree(TreeNode root) {
        // Base case: If the node is null or it's a leaf node, it is a Sum Tree by default.
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        // Recursively check if the left and right subtrees are Sum Trees.
        boolean leftSumTree = isSumTree(root.left);
        boolean rightSumTree = isSumTree(root.right);

        // If both subtrees are Sum Trees and the current node's value
        // is equal to the sum of the left and right subtree values, then it's a Sum Tree.
        if (leftSumTree && rightSumTree && (root.val == sum(root.left) + sum(root.right))) {
            return true;
        }

        return false; // If any of the conditions fail, it's not a Sum Tree.
    }

    // Helper function to calculate the sum of a binary tree.
    private int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + sum(node.left) + sum(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(26);
        root.left = new TreeNode(10);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(3);

        SumTreeChecker treeChecker = new SumTreeChecker();
        boolean isSumTree = treeChecker.isSumTree(root);

        System.out.println("Is the tree a Sum Tree? " + isSumTree);
    }
}
```
Here's the time and space complexity analysis for the given code:

**Time Complexity:** O(n)
The time complexity of this code is determined by the number of nodes in the binary tree, as each node is visited once during the recursive traversal.
- The recursive `isSumTree` function visits each node once, and the work done at each node is constant time.
- The `sum` function also visits each node once, and its work at each node is constant time.
Therefore, the overall time complexity of the code is O(n), where 'n' is the number of nodes in the binary tree.

**Space Complexity:** O(n)
The space complexity is determined by the depth of the recursive call stack, which depends on the height of the binary tree. 
In the worst case, when the tree is skewed (i.e., a singly linked list), the space complexity could be O(n), where 'n' is the number of nodes in the tree.
- The `isSumTree` function uses the call stack for recursion, which can go as deep as the height of the tree.
- The `sum` function also uses the call stack for recursion, contributing to the overall space complexity.

In typical balanced binary trees, the space complexity is O(log n), where 'n' is the number of nodes. However, in the worst case, it can be O(n) for skewed trees.

------------------------------------------------------------------------------------------------------------------------------------------------
// 2nd Method 

This code is for checking if a given binary tree is a Sum Tree. A Sum Tree is a binary tree in which the value of each node is equal to the sum of the values of its left and right subtrees. Here's the code with comments to explain each part:

Explanation 

1. The code defines a `Node` class to represent nodes in the binary tree, each containing a value (`data`) and references to their left and right children.
2. In the `Main` class, we create a method `isSumTree` to check if a given binary tree is a Sum Tree.
3. The base case checks if the `root` is null (empty tree). In this case, the function returns 0 because an empty tree is trivially a Sum Tree.
4. The special case checks if the `root` is a leaf node (both left and right children are null). If so, the function returns the value of the leaf node as the sum of its subtrees is itself.
5. In the recursive case, we calculate the sums of values in the left and right subtrees by making recursive calls to `isSumTree` for those subtrees.
6. The code then checks if the current node's value is equal to the sum of values in its left and right subtrees. If this condition is met and both the left and right subtrees are not marked as not Sum Trees (sentinel value `Integer.MIN_VALUE`), it returns twice the value of the current node, indicating it's a Sum Tree.
7. If the current node is not a Sum Tree, it returns `Integer.MIN_VALUE` as a sentinel value.
8. In the `main` method, a sample binary tree is created, and the `isSumTree` function is called to check if it's a Sum Tree. The result is printed based on the returned value.

This code uses a recursive approach to check whether the binary tree is a Sum Tree, making sure that the sum property holds for each node in the tree.


```java
class Node {
    int data;
    Node left = null, right = null;

    Node(int data) {
        this.data = data;
    }
}

class Main {
    // Recursive function to check if a given binary tree is a sum tree or not
    public static int isSumTree(Node root) {
        // Base case: empty tree
        if (root == null) {
            return 0;
        }

        // Special case: leaf node
        if (root.left == null && root.right == null) {
            return root.data;
        }

        // Recursively calculate the sum of values in the left and right subtrees
        int left = isSumTree(root.left);
        int right = isSumTree(root.right);

        // Check if the current node's value is equal to the sum of left and right subtrees
        if (left != Integer.MIN_VALUE && right != Integer.MIN_VALUE &&
                root.data == left + right) {
            // If the current node is a Sum Tree, return twice its value
            return 2 * root.data;
        }

        // If the current node is not a Sum Tree, return a sentinel value (Integer.MIN_VALUE)
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(4);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.right = new Node(2);

        int result = isSumTree(root);

        if (result != Integer.MIN_VALUE) {
            System.out.println("The tree is a Sum Tree.");
        } else {
            System.out.println("The tree is not a Sum Tree.");
        }
    }
}
```

Here's the time and space complexity analysis for the given code:

**Time Complexity:** O(n)
The time complexity of this code is determined by the number of nodes in the binary tree, as each node is visited once during the recursive traversal.
- The recursive `isSumTree` function visits each node once, and the work done at each node is constant time.
- The `isSumTree` function also calculates the sums of values in the left and right subtrees recursively, but each node is visited only once.
Therefore, the overall time complexity of the code is O(n), where 'n' is the number of nodes in the binary tree.

**Space Complexity:** O(n)
The space complexity is determined by the depth of the recursive call stack, which depends on the height of the binary tree. In the worst case, when the tree is skewed (i.e., a singly linked list), the space complexity could be O(n), where 'n' is the number of nodes in the tree.
- The `isSumTree` function uses the call stack for recursion, which can go as deep as the height of the tree.
In typical balanced binary trees, the space complexity is O(log n), where 'n' is the number of nodes. However, in the worst case, it can be O(n) for skewed trees.

In addition to the call stack, the code uses a few variables for each recursive call, but these are constant and do not significantly affect the space complexity.
