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
