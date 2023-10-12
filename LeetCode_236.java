// Lowest_Common_Ancestor_of_a_Binary_Tree

//1st Method
**Brute Force Approach:**

In the brute force approach, we can start from the root and traverse the tree to find the paths from the root to each of the given nodes. 
Once we have the paths, we can compare them to find the lowest common ancestor.

Here's the code with comments for the brute force approach:

```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) {
        val = x;
    }
}

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    // Helper function to find the path from root to a given node
    List<TreeNode> pathP = findPath(root, p);
    List<TreeNode> pathQ = findPath(root, q);

    // Initialize the lowest common ancestor
    TreeNode lca = null;

    // Compare the paths to find the LCA
    int minLength = Math.min(pathP.size(), pathQ.size());
    for (int i = 0; i < minLength; i++) {
        if (pathP.get(i) == pathQ.get(i)) {
            lca = pathP.get(i);
        } else {
            break;
        }
    }

    return lca;
}

// Helper function to find the path from root to a given node
private List<TreeNode> findPath(TreeNode root, TreeNode target) {
    List<TreeNode> path = new ArrayList<>();
    findPathRecursive(root, target, path);
    return path;
}

// Recursive function to find the path
private boolean findPathRecursive(TreeNode node, TreeNode target, List<TreeNode> path) {
    // Base case: If the current node is null, return false
    if (node == null) {
        return false;
    }

    // Add the current node to the path
    path.add(node);

    // If the current node is the target, return true
    if (node == target) {
        return true;
    }

    // Recur on the left and right subtrees
    if (findPathRecursive(node.left, target, path) || findPathRecursive(node.right, target, path)) {
        return true;
    }

    // If the target is not found in the subtree, remove the current node from the path
    path.remove(path.size() - 1);

    return false;
}
```
# Time Complexity:
Finding the path from the root to each of the two nodes takes O(N) in the worst case, where N is the number of nodes in the tree.
Comparing the two paths takes O(min(M, N)) time, where M and N are the lengths of the paths from the root to the given nodes.
So, the overall time complexity is O(N).

# Space Complexity:
The space complexity is O(N) due to the space used for storing the paths (the size of the paths can be at most N).

----------------------------------------------------------------------------

// 2nd Method
**Efficient Approach:**

The brute force approach has a time complexity of O(N) in the worst case, where N is the number of nodes in the tree. 
We can improve the efficiency of the algorithm by making use of a more elegant approach, which utilizes the properties of binary trees.

Here's the efficient code with comments:

```java
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) {
        return root;
    }

    // Recur on the left and right subtrees
    TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
    TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

    // If one of the subtrees contains both p and q, that's the LCA
    if (leftLCA != null && rightLCA != null) {
        return root;
    }

    // If one subtree contains either p or q, and the other is null, the non-null one is the LCA
    return (leftLCA != null) ? leftLCA : rightLCA;
}
```

In this efficient approach, we recursively search for the lowest common ancestor. 
The key insight is that if we find both `p` and `q` in the left and right subtrees, then the current node is the lowest common ancestor. 
If one subtree contains either `p` or `q`, and the other subtree is null, then the non-null subtree is the LCA. This approach has a time complexity of O(N),
where N is the number of nodes in the tree, and it doesn't require constructing and comparing paths.

# Time Complexity:
In the efficient approach, we traverse the binary tree in a depth-first manner once.
The time complexity is O(N), where N is the number of nodes in the tree. This is because we visit each node exactly once.

# Space Complexity:
The space complexity is determined by the call stack during the recursive calls.
In the worst case, the space complexity is O(H), where H is the height of the binary tree. In the average case, the space complexity is O(log N) for a balanced binary tree. However, in the worst case, for a skewed tree, the space complexity can be O(N).
This space is used for the recursive function calls.
