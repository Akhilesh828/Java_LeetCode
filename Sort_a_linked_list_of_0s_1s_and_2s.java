Sort a linked list of 0s, 1s and 2s

***Input:** 1 -> 1 -> 2 -> 0 -> 2 -> 0 -> 1 -> NULL*
**Output:** 0 -> 0 -> 1 -> 1 -> 1 -> 2 -> 2 -> NULL
  
1st Method :- Brute Force Approach (Counting Sort)
Steps
  1. Traverse the linked list and count the number of occurrences of each element (0, 1, and 2).
  2. Create a new linked list, and insert the counted elements in the sorted order (first all 0s, then all 1s, and finally all 2s).
  3. Replace the original linked list with the new sorted linked list.
This approach has a time complexity of O(n) but may require extra space for counting.

  ++++Code+++++
void sortList(Node head) {
    // initialise count of 0 1 and 2 as 0
    int count[] = { 0, 0, 0 };

    Node curNode = head;
    /*
    * count total number of '0', '1' and '2'
    * count[0] will store total number of '0's
    * count[1] will store total number of '1's
    * count[2] will store total number of '2's
    */
    while (curNode != null) {
        count[curNode.data]++; //c[2]++ = 0++ = 1
        curNode = curNode.next;
    }

    int i = 0;
    curNode = head;
    /*
    * Let say count[0] = n1, count[1] = n2 and count[2] = n3
    * now start traversing list from head node,
    * 1) fill the list with 0, till n1 > 0
    * 2) fill the list with 1, till n2 > 0
    * 3) fill the list with 2, till n3 > 0
    */           
    
    while (curNode != null) {
        if (count[i] == 0)
            i++; 
        else {
            curNode.data = i;
            --count[i]; 
            curNode = curNode.next;
        }
    }
}

/*----------------------------------------------------------------------------*/

2nd Method :- Efficient Approach (Dutch National Flag Algorithm)

  The Dutch National Flag algorithm is the most efficient way to sort a linked list 
containing 0s, 1s, and 2s. It works in a single pass through the linked 
list and has a time complexity of O(n).

steps:
  1. Initialize three pointers: zero, one, and two to null. These pointers will be used to maintain three sublists - one for 0s, one for 1s, and one for 2s.
  2. Traverse the linked list, and for each node, update the pointers accordingly based on the node's value:
    - If the node's value is 0, attach it to the end of the 0s sublist and update the zero pointer.
    - If the node's value is 1, attach it to the end of the 1s sublist and update the one pointer.
    - If the node's value is 2, attach it to the end of the 2s sublist and update the two pointer.
  3. After traversing the entire list, merge the three sublists together in the order: 0s -> 1s -> 2s.

This approach sorts the linked list efficiently without using extra space.

  ++++Code+++++
ListNode sortLinkedList(ListNode head) {
    ListNode zero = null, one = null, two = null;
    ListNode current = head;
    
    while (current != null) {
        if (current.val == 0) {
            if (zero == null) {
                zero = current;
            } else {
                zero.next = current;
                zero = current;
            }
        } else if (current.val == 1) {
            if (one == null) {
                one = current;
            } else {
                one.next = current;
                one = current;
            }
        } else { // current.val == 2
            if (two == null) {
                two = current;
            } else {
                two.next = current;
                two = current;
            }
        }
        
        current = current.next;
    }
    
    if (zero != null) {
        head = zero;
        if (one != null) {
            zero.next = one;
            if (two != null) {
                one.next = two;
                two.next = null;
            } else {
                one.next = null;
            }
        } else if (two != null) {
            zero.next = two;
            two.next = null;
        }
    } else if (one != null) {
        head = one;
        if (two != null) {
            one.next = two;
            two.next = null;
        }
    } else if (two != null) {
        head = two;
        two.next = null;
    }
    
    return head;
}

/*------------------------------------------------------------------------------------------*/
3rd Method :- Same as above Method but wtring less code by using three references

    ++++Code+++++
Node sortList(Node head) {
    // base case
    if (head == null || head.next == null) {
        return head;
    }

    // maintain three dummy nodes
    Node first = new Node(), second = new Node(), third = new Node();

    // maintain three references
    Node zero = first, one = second, two = third;

    // traverse the list
    Node curr = head;
    while (curr != null) {
        if (curr.data == 0) {
            zero.next = curr;
            zero = zero.next;
        } else if (curr.data == 1) {
            one.next = curr;
            one = one.next;
        } else {
            two.next = curr;
            two = two.next;
        }
        curr = curr.next;
    }

    // combine lists containing 0's, 1's, and 2's
    zero.next = (second.next != null) ? (second.next) : (third.next);
    one.next = third.next;
    two.next = null;

    // change head
    return first.next;
}
