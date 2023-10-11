The problem is to find the top view of a binary tree. The top view of a binary tree is defined as the set of nodes visible when the tree is viewed from the top. 
To find the top view, we need to print the nodes that would be visible from left to right when looking at the tree from the top.

# 1st Method
**Brute Force Approach (Using Level Order Traversal):**

  **Brute Force Approach Explanation:**
1. We use a level-order traversal (BFS) to traverse the tree.
2. We use a queue to store a pair of nodes and their horizontal distances from the root node.
3. We maintain a map to store the first node encountered at each horizontal distance.
4. While traversing the tree, if we encounter a node at a new horizontal distance, we update the map with the node's value.
5. Finally, we print the values from the map, which will give us the top view of the binary tree.


```java
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class Pair {
    TreeNode node;
    int horizontalDistance;

    Pair(TreeNode node, int horizontalDistance) {
        this.node = node;
        this.horizontalDistance = horizontalDistance;
    }
}

public class BinaryTreeTopView {
    public static void topView(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int horizontalDistance = pair.horizontalDistance;

            if (!map.containsKey(horizontalDistance)) {
                map.put(horizontalDistance, node.val);
            }

            if (node.left != null) {
                queue.offer(new Pair(node.left, horizontalDistance - 1));
            }

            if (node.right != null) {
                queue.offer(new Pair(node.right, horizontalDistance + 1));
            }
        }

        // Print the top view nodes from left to right
        for (int key : map.keySet()) {
            System.out.print(map.get(key) + " ");
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);

        System.out.println("Top View of Binary Tree:");
        topView(root);
    }
}
```
# Time Complexity: O(n)
  The time complexity of the brute-force approach is O(N), where N is the number of nodes in the binary tree.
  This is because we perform a level-order traversal of the entire tree, visiting each node once.

# Space Complexity: O(n)
  The space complexity is determined by the space used for the queue and the map.
  In the worst case, if the tree is completely unbalanced, the queue can hold up to O(N) nodes (all nodes on one level), and the map can hold O(N) entries (each horizontal distance is unique).
  Therefore, the space complexity is O(N + N) = O(N), where the first N is for the queue, and the second N is for the map.

# 2nd Method 
**Optimized Approach (Using Vertical Order Traversal):**
**Optimized Approach Explanation:**
1. Instead of using a regular HashMap, we use a TreeMap to maintain the horizontal distances in sorted order.
2. This allows us to avoid sorting the distances later when printing the top view nodes.
3. The rest of the code remains mostly the same as the brute-force approach.
  
```java
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class Pair {
    TreeNode node;
    int horizontalDistance;

    Pair(TreeNode node, int horizontalDistance) {
        this.node = node;
        this.horizontalDistance = horizontalDistance;
    }
}

public class BinaryTreeTopView {
    public static void topView(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int horizontalDistance = pair.horizontalDistance;

            if (!map.containsKey(horizontalDistance)) {
                map.put(horizontalDistance, node.val);
            }

            if (node.left != null) {
                queue.offer(new Pair(node.left, horizontalDistance - 1));
            }

            if (node.right != null) {
                queue.offer(new Pair(node.right, horizontalDistance + 1));
            }
        }

        // Print the top view nodes from left to right
        for (int value : map.values()) {
            System.out.print(value + " ");
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);

        System.out.println("Top View of Binary Tree:");
        topView(root);
    }
}
``` 
# Time Complexity:
  The time complexity of the optimized approach is O(N * log(N)), where N is the number of nodes in the binary tree.
  The TreeMap is used to store the top view nodes, and inserting a key-value pair into a TreeMap has a time complexity of O(log(N)).

# Space Complexity:
  The space complexity is determined by the space used for the TreeMap and the queue.
  In the worst case, if the tree is completely unbalanced, the queue can hold up to O(N) nodes, and the TreeMap can hold O(N) entries (each horizontal distance is unique).
  Therefore, the space complexity is O(N + N) = O(N), where the first N is for the queue, and the second N is for the TreeMap.

The optimized approach improves efficiency by eliminating the need for sorting the horizontal distances when printing the top view nodes. The TreeMap naturally maintains the distances in ascending order, providing a more efficient solution.
