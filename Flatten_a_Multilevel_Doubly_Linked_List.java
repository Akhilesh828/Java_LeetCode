# 1st Method :- Brute force
>The brute-force approach involves using recursion to traverse the nested doubly linked list and flatten it. Here's how you can do it step by step:

1. Start at the head of the doubly linked list.
2. Initialize a helper recursive function that takes a node as an argument.
3. In the helper function:
    - Check if the current node has a child (sub-list).
    - If it does, recursively call the helper function on the child node to flatten it.
    - After flattening the child list, connect the current node's `next` pointer to the flattened child's head.
    - Update the child's `prev` pointer to point back to the current node.
    - Set the current node's `child` pointer to null to remove the child link
4. Continue this process for each node in the doubly linked list


# Code
``` Java []
class Solution {

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        
        // Helper function to flatten a node and its children
        flattenNode(head);
        
        return head;
    }

    private Node flattenNode(Node node) {
        Node current = node;
        Node tail = node; // To keep track of the tail of the flattened list
        
        while (current != null) {
            if (current.child != null) {
                Node child = current.child;
                current.child = null;
                
                // Flatten the child list and get the child list's tail
                Node childTail = flattenNode(child);
                
                // Connect the current node to the flattened child
                childTail.next = current.next;
                if (current.next != null) {
                    current.next.prev = childTail;
                }
                current.next = child;
                child.prev = current;
                
                // Update the tail to be the tail of the merged list
                tail = childTail;
            }
            
            // Move to the next node in the original list
            current = current.next;
            if (current != null) {
                tail = current; // Update the tail for non-null current nodes
            }
        }
        
        return tail; // Return the tail of the merged list
    }
}
```
# Complexity
#### Time complexity: O(N) ;
- The time complexity of the brute-force approach is O(N), where N is the total number of nodes in the doubly linked list. This is because we visit each node exactly once while flattening the list.
#### Space complexity: O(n) ; 
- The space complexity of the brute-force approach is O(H), where H is the maximum depth of the nested structure. This is because the recursion depth is bounded by the depth of the nested lists. In the worst case, when the list is completely nested, H can be equal to N (the total number of nodes), leading to a space complexity of O(N).

> This brute-force approach recursively flattens the nested doubly linked list. However, it can be inefficient for large input lists with deep nesting because of the recursion overhead.

# 2nd Method :- Efficient Method
>To optimize the solution, we can use an iterative approach without recursion. Here's the step-by-step explanation:

1. Start at the head of the doubly linked list.
2. Use a stack to keep track of nodes with potential child lists.
3. While traversing the list:
    - If the current node has a child (sub-list):
        - Save the next node in the main list.
        - Connect the current node to the child list.
        - Push the next node onto the stack for later processing.
        - Update the current node to be the child list's last node.
    - If the current node does not have a child and there are nodes in the stack, pop a node from the stack and connect it to the current node.
4. Continue this process until you have processed all nodes in the list.

``` Java []
class Solution {

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        
        Node current = head;
        Stack<Node> stack = new Stack<>();
        
        while (current != null) {
            if (current.child != null) {
                Node nextNode = current.next;
                
                // Connect current node to the child list
                current.next = current.child;
                current.child.prev = current;
                current.child = null;
                
                // Push the next node onto the stack for later processing
                if (nextNode != null) {
                    stack.push(nextNode);
                }
            } else if (current.next == null && !stack.isEmpty()) {
                // If there are no more nodes in the current level,
                // pop a node from the stack and connect it to the current node
                Node nextNode = stack.pop();
                current.next = nextNode;
                nextNode.prev = current;
            }
            
            current = current.next;
        }
        
        return head;
    }
}
```
This efficient approach uses an iterative process with a stack to flatten the nested doubly linked list, avoiding the overhead of recursion and making it more suitable for large input lists.


# Complexity
#### Time complexity: O(N) ;
- The time complexity of the efficient approach is also O(N), where N is the total number of nodes in the doubly linked list. This is because we traverse each node in the list exactly once.
#### Space complexity: O(1) ;
- The space complexity of the efficient approach is O(1) because we use a constant amount of extra space, mainly for variables like current, stack, and temporary pointers. The space used is independent of the input size and does not depend on the depth of nesting. Therefore, it is a constant space algorithm.
