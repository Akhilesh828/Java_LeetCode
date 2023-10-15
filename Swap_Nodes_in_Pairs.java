// ============== Swap node's values ============

//----------Iterative ----------------
// 1st Method

public ListNode swapPairs(ListNode head) {
    ListNode curNode = head;

    /* Traverse only till there are atleast 2 nodes left */
    while (curNode != null && curNode.next != null) {

        /* Swap the data */
        int temp = curNode.val;
        curNode.val = curNode.next.val;
        curNode.next.val = temp;
        curNode = curNode.next.next;
    }
    return head;
}

Time Complexity:
The time complexity of this code is O(n), where 'n' is the number of nodes in the linked list. 
    This is because the code iterates through the linked list, swapping adjacent nodes, and the number of iterations is directly proportional to the number of nodes.

Space Complexity:
The space complexity of this code is O(1), which means it uses constant space. 
Regardless of the size of the linked list, the code uses a fixed amount of additional space for variables (e.g., curNode, temp). 
It does not create any data structures that grow with the input size, so the space complexity remains constant.
    
// ------------ Recursion ---------
// 2nd Method

public ListNode swapPairs(ListNode head) {
    /* There must be at-least two nodes in the list */
    if (head != null && head.next != null) {

        /* Swap the node's data with data of next node */
        int temp = head.val;
        head.val = head.next.val;
        head.next.val = temp;

        /* Call pairWiseSwap() for rest of the list */
        swapPairs(head.next.next);
    }
    return head;
}

Time Complexity:
The time complexity of this code is also O(n), where 'n' is the number of nodes in the linked list. 
The reason is that it swaps adjacent nodes one pair at a time, and the number of recursive calls is directly proportional to the number of nodes. 
However, it's important to note that the code is not very efficient due to the excessive function call overhead associated with recursion, and 
it may not be the most optimal way to solve this problem.

Space Complexity:
The space complexity of this code is O(1), which means it uses constant space. 
Although it's a recursive function, it doesn't create additional data structures or maintain a call stack that grows with the input size. 
The space used for the function call stack is limited to a constant amount since the function calls are tail-recursive.

While the space complexity is constant, the recursive approach can be less efficient in practice due to the overhead of function calls, especially for a large number of nodes. It may result in a stack overflow error if the linked list is too long.
    
    
//=================== Swap node's ======================
//3rd Method

solving this problem might involve multiple passes through the linked list and repeatedly swapping pairs 
of nodes. Here are the steps:

1. If the linked list is empty or has only one node, return it as there's nothing to swap.
2. Create a dummy node at the beginning of the list to simplify handling the edge case where the head node needs to be swapped.
3. Initialize two pointers, prev and curr, initially pointing to the dummy node.
4. In a loop:
  a. Check if there are at least two nodes remaining to swap (curr.next != null and curr.next.next != null).
  b. If there are, swap the next two nodes (i.e., curr.next and curr.next.next), and update the pointers accordingly.
  c. Move curr two steps ahead (i.e., curr = curr.next.next).
5. Return the new head of the linked list, which is the next node of the dummy node.

  
public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }

    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode prev = dummy;
    ListNode curr = head;

    while (curr != null && curr.next != null) {
        ListNode first = curr;
        ListNode second = curr.next;

        prev.next = second;
        first.next = second.next;
        second.next = first;

        prev = first;
        curr = first.next;
    }

    return dummy.next;
}

Time Complexity:
The time complexity of this code is O(n), where 'n' is the number of nodes in the linked list. The code iterates through the 
linked list once, and the number of iterations is directly proportional to the number of nodes. Each iteration involves constant time operations, making the time complexity linear.

Space Complexity:
The space complexity of this code is O(1), which means it uses constant space. The code only uses a constant amount of extra space for variables such 
as dummy, prev, curr, first, and second. It does not create any data structures or maintain a data structure that grows with the input size. 
Therefore, the space complexity remains constant.

This approach is efficient in terms of both time and space complexity and is a recommended way to swap nodes in pairs in a linked list.

    
-------------------------------------------------------------
// 4th Method

aims to swap adjacent nodes in a single pass through the linked list by maintaining 
three pointers: prev, curr, and next. Here are the steps:

1. If the linked list is empty or has only one node, return it as there's nothing to swap.
2. Initialize a dummy node at the beginning of the list to simplify handling the edge case where the head node needs to be swapped.
3. Initialize three pointers: prev, curr, and next.
 - prev initially points to the dummy node.
 - curr initially points to the first node to be swapped (prev.next).
 - next initially points to the second node to be swapped (curr.next).
4. In a loop:
  a. Check if there are at least two nodes remaining to swap (curr != null and curr.next != null).
  b. Swap the next two nodes (i.e., curr and next) by adjusting the pointers.
  c. Move prev to the current pair's second node (i.e., prev = curr).
  d. Move curr to the next pair's first node (i.e., curr = next).
  e. Move next to the next pair's second node (i.e., next = curr.next).
5. Return the new head of the linked list, which is the next node of the dummy node.

  
public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }

    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode prev = dummy;
    ListNode curr = head;
    ListNode next = head.next;

    while (curr != null && next != null) {
        // Swap nodes
        prev.next = next;
        curr.next = next.next;
        next.next = curr;

        // Move pointers
        prev = curr;
        curr = curr.next;
        if (curr != null) {
            next = curr.next;
        }
    }

    return dummy.next;
}

Time Complexity:
The time complexity of this code is O(n), where 'n' is the number of nodes in the linked list. 
The reason is that it iterates through the list once, processing two nodes at a time (swapping them), and the number of iterations is directly 
proportional to the number of nodes. The while loop runs until both curr and next are not null, and it processes each pair of nodes in constant time.

Space Complexity:
The space complexity of this code is O(1), which means it uses constant space. Regardless of the size of the linked list, 
the code uses a fixed amount of additional space for variables (e.g., dummy, prev, curr, next). It does not create additional 
data structures or maintain a call stack that grows with the input size. The space used is constant and does not depend on the number of nodes in the linked list.

This solution is efficient both in terms of time and space complexity, and it's a recommended approach for swapping pairs of nodes in a linked list.

----------------------- Recursion ----------------------------
// 5th Method

public ListNode swapPairs(ListNode head) {
    // Base case: If the list is empty or has only one node, return head.
    if (head == null || head.next == null) {
        return head;
    }

    // Store the second node (next) in the pair.
    ListNode next = head.next;

    // Recursively swap the remaining list (head.next.next).
    head.next = swapPairs(next.next);

    // Make the second node's next point to the first node.
    next.next = head;

    // Return the new head of this swapped pair.
    return next;
}

Time Complexity:

The time complexity of this code is O(n), where 'n' is the number of nodes in the linked list. The reason is that it processes each node exactly once. 
The recursive approach visits each pair of adjacent nodes exactly once, and the number of recursive calls is proportional to the number of nodes.

Space Complexity:

The space complexity of this code is O(n), where 'n' is the number of nodes in the linked list. This is due to the space used by the function call stack during the recursion. 
In the worst case, if the linked list has 'n' nodes, the function will be recursively called 'n' times, leading to a call stack of depth 'n'. Therefore, the space complexity is O(n).

While this code is efficient in terms of time complexity, it uses additional space for the recursive calls, which could be a concern for very long linked lists. Nevertheless, 
it's a straightforward and clear way to solve the problem of swapping nodes in pairs in a linked list.
