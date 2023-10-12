Sort a linked list of 0s, 1s and 2s

***Input:** 1 -> 1 -> 2 -> 0 -> 2 -> 0 -> 1 -> NULL*
**Output:** 0 -> 0 -> 1 -> 1 -> 1 -> 2 -> 2 -> NULL
  
1st Method :- Brute Force Approach (Counting Sort)
Steps
  1. Traverse the linked list and count the number of occurrences of each element (0, 1, and 2).
  2. Create a new linked list, and insert the counted elements in the sorted order (first all 0s, then all 1s, and finally all 2s).
  3. Replace the original linked list with the new sorted linked list.
This approach has a time complexity of O(n) but may require extra space for counting.

``` JAVA 
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
```

Time Complexity: O(n)
1. First Pass: Counting the number of occurrences of 0, 1, and 2 in the linked list has a time complexity of O(N), where N is the number of elements in the linked list. 
  This is because you traverse the entire list once.

2. Second Pass: The second while loop iterates through the list again to rearrange the elements based on the counts. 
  This pass also has a time complexity of O(N) since you go through the list exactly once.

In total, the time complexity of this sorting algorithm is O(N), where N is the number of elements in the linked list.

Space Complexity: O(1)
The space complexity in this implementation is constant O(1) because the algorithm only uses a fixed-size array 'count' with three elements (count[0], count[1], and count[2]) to keep track of the counts, and it uses a few extra variables. Regardless of the size of the linked list, the space used by the algorithm remains constant.

In summary, this algorithm sorts the linked list in O(N) time complexity and uses O(1) space complexity, making it an efficient in-place sorting algorithm for linked lists with a small range of values.

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
``` JAVA
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
```

# Time Complexity: O(n)
The algorithm has a time complexity of O(N), where N is the number of nodes in the linked list. This is because it performs a single pass through the entire list while rearranging the nodes based on their values (0, 1, or 2).

# Space Complexity: O(1)
The algorithm has a space complexity of O(1), meaning it uses a constant amount of extra space, regardless of the size of the input linked list. This is because it only uses a fixed number of pointers (`zero`, `one`, `two`, and `current`) to keep track of different parts of the list and rearranges the nodes in-place. The space used for the pointers does not depend on the size of the input list. Therefore, it's considered an in-place sorting algorithm with constant space complexity.

/*------------------------------------------------------------------------------------------*/
3rd Method :- Same as above Method but wtring less code by using three references

    ++++Code+++++
``` JAVA
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
```

# Time Complexity: O(n)
1. The code uses a single pass through the entire linked list, visiting each node once.
2. For each node, it checks its data value and appends it to one of the three separate lists (0, 1, or 2). This operation is done in constant time, O(1).
3. After splitting the original list into three sublists, it combines these sublists back together. This is also done in constant time, O(1).
4. The time complexity of this algorithm is O(n), where n is the number of nodes in the linked list, as it performs a single pass through the list.

# Space Complexity: O(n)
1. The code uses three dummy nodes (first, second, and third) and three references (zero, one, and two). These dummy nodes and references occupy constant space, O(1).
2. There is no additional data structure or recursion involved, and the code does not create new nodes or lists. It rearranges the existing nodes in the original list.
3. The space complexity of this algorithm is O(1), as it uses a fixed and constant amount of space regardless of the size of the input linked list.
