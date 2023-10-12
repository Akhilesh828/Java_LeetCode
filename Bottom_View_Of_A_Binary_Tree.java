// Bottom View Of A Binary Tree

Note:-
Here there is only 1 small difference from the Top View of the Tree. Here we don’t need 
to check whether the node is previously present on the map or not before entering it. 
We have to replace the node of each line if that was previously present on the map.

  
Explanation:
1. `Node` class: Defines the structure of a binary tree node, including its data, left, and right children.

2. `Pair` class: Represents a pair of (horizontal distance, node) for easier traversal of the binary tree. It's used in the BFS (breadth-first search) traversal.

3. `bottomView` function: This function calculates the bottom view of the binary tree using a level-order traversal (BFS).

4. Inside the `bottomView` function:
   - A queue (`q`) is used to perform a level-order traversal of the tree.
   - A TreeMap (`map`) is used to store the nodes at each horizontal distance. TreeMap automatically sorts the keys (horizontal distances) in ascending order.
   - We start with the root node (horizontal distance 0) and enqueue it.
   - While the queue is not empty, we process nodes one by one:
     - Update the `map` with the data of the current node at its horizontal distance.
     - If the left child exists, enqueue it with a decreased horizontal distance.
     - If the right child exists, enqueue it with an increased horizontal distance.

5. After processing all nodes, the `map` contains nodes in the bottom view sorted by horizontal distance. The code then extracts and stores the values (node data) in the `ans` ArrayList in left-to-right order.

6. Finally, in the `main` function, a sample binary tree is constructed and the `bottomView` function is called to find and print the bottom view of the tree.

  
```java
import java.util.*;
import java.util.Queue;

public class Tree {

    static class Node {
        int data;
        Node left = null, right = null;

        Node(int data) {
            this.data = data;
        }
    }

    static class Pair {
        int hD; // horizontal distance
        Node node;

        public Pair(int hD, Node node) {
            this.hD = hD;
            this.node = node;
        }
    }

    // Function to return a list of nodes visible from the bottom view
    // from left to right in the Binary Tree.
    static ArrayList<Integer> bottomView(Node root) {

        Queue<Pair> q = new ArrayDeque<Pair>();
        Map<Integer, Integer> map = new TreeMap<>();

        q.add(new Pair(0, root)); // Start with the root node and horizontal distance 0
        while (!q.isEmpty()) {
            Pair curPair = q.remove();
            int hD = curPair.hD;
            Node curNode = curPair.node;

            map.put(hD, curNode.data); // Store the latest node's data at this horizontal distance

            if (curNode.left != null) {
                q.add(new Pair(hD - 1, curNode.left)); // Move left with a decreased horizontal distance
            }

            if (curNode.right != null) {
                q.add(new Pair(hD + 1, curNode.right)); // Move right with an increased horizontal distance
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue()); // Extract the values (node data) in left-to-right order
        }
        return ans;
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(6);
        root.right = new Node(12);
        root.left.right = new Node(11);
        root.right.left = new Node(7);
        root.right.right = new Node(8);
        root.left.right.left = new Node(20);
        root.left.right.right = new Node(17);
        System.out.println("Bottom view of the given binary tree:");

        System.out.println(bottomView(root)); // Call the bottomView function and print the result
    }
}
```

**Time Complexity:** O(N)
The time complexity of the code is O(N), where N is the number of nodes in the binary tree. This is because the code uses a level-order traversal (BFS) 
to visit each node exactly once, and the operations performed for each node (enqueueing, map updates, etc.) are constant time operations. 

**Space Complexity:** O(N)
The space complexity of the code is O(N), where N is the number of nodes in the binary tree. This space is primarily used for the following data structures:

1. Queue (`q`): In the worst case, the queue can hold all nodes at the last level of the binary tree. In a complete binary tree, this can be roughly 
  half of the total number of nodes, resulting in O(N/2) space complexity. However, since we consider O(N) as the upper bound, we can simplify this to O(N).

2. TreeMap (`map`): The map stores the horizontal distances as keys and the node data as values. In the worst case, when the horizontal distances are 
  distinct and all nodes are at different horizontal distances, the map can have up to N entries. Therefore, the space complexity of the map is also O(N).

3. `ans` ArrayList: This list stores the node data in the bottom view, and its space complexity is O(N) because it can contain up to N elements.

Overall, the space complexity of the code is dominated by the queue, map, and `ans` ArrayList, each of which has a space complexity of O(N).
