
1st Method :- Brute Force Method:

In the brute force method, you can use two nested loops to check each node in the linked list against 
all other nodes to detect if there is a loop. This method is not efficient as it has a 
time complexity of O(n^2) where n is the number of nodes in the linked list.

  /////////////////////////////code///////////////////////////////////
void detectAndRemoveLoop(Node head) {
    Node slow = head;
    Node fast = head;
    boolean loopDetected = false;

    while (slow != null && fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;

        // If fast pointer meets slow pointer, a loop is detected
        if (slow == fast) {
            loopDetected = true;
            break;
        }
    }

    // If a loop is detected, remove it
    if (loopDetected) {
        slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        // Set the next node of the fast pointer to null to remove the loop
        fast.next = null;
    }
}
// O(n^2) O(1)
/*-----------------------------------------------------------------------------*/

2nd Method :- Efficient Method (Floyd's Cycle Detection Algorithm):

Floyd's Cycle Detection Algorithm, also known as the "tortoise and hare" algorithm, provides an efficient 
way to detect a loop in a linked list with a time complexity of O(n).
  
Steps:-
  1. Initialize two pointers, slow and fast, both initially pointing to the head of the linked list.
  2. Traverse the list using two pointers:
   - Move the slow pointer one step at a time.
   - Move the fast pointer two steps at a time.
  3. If there is a loop, the fast pointer will eventually catch up to the slow pointer, resulting in them 
     meeting at some point within the loop. If there is no loop, the fast pointer will reach the end of the list.
  4. Once they meet, reset one of the pointers (either fast or slow) to the head of the list and keep the other pointer at the meeting point.
  5. Move both pointers one step at a time. The point where they meet again is the start of the loop.

  /////////////////////////Code/////////////////////////////////
  public void detectAndRemoveLoop(Node head) {
    Node slow = head;
    Node fast = head;
    boolean loopDetected = false;

    // Detect loop
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
            loopDetected = true;
            break;
        }
    }

    if (loopDetected) {
        // Remove loop
        slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null; // Remove the loop
    }
} 
//O(n) , O(1)

/*-------------------------------------------------------*/
similar to above method, without using boolean

  ////////////////code///////////////////////////
void detectAndRemoveLoop(Node head) {

    // If list is empty or has only one node without loop
    if (head == null || head.next == null){
        return;
    }

    Node slow = head, fast = head;

    // Move slow 1 and fast 2 steps ahead respectively.
    slow = slow.next;
    fast = fast.next.next;

    // Search for loop using slow and fast pointers
    while (fast != null && fast.next != null) {
        if (slow == fast)
            break;

        slow = slow.next;
        fast = fast.next.next;
    }

    /* If loop exists */
    if (slow == fast) {
        slow = head;
        //its possible that head node is the one where the cycle start
        if (slow != fast) { // if our fast pointer is not same as head 
            while (slow.next != fast.next) {//move fast pointer one step at a time
                slow = slow.next;
                fast = fast.next;
            }
            /* since fast->next is the looping point */
            fast.next = null; /* remove loop */
        }else {
            /* This case is added if fast and slow pointer meet at first position. */
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null;
        }
    }
}

/*-----------------------------------------------------------------*/

3rd Method :- Hashing: Hash the address of the linked list nodes*

We can hash the addresses of the linked list nodes in an unordered map and just check 
if the element already exists in the map. If it exists, we have reached a node 
that already exists by a cycle, hence we need to make the last node’s next pointer NULL.


static void removeCycle(Node head) {
    Node prev = null; // previous pointer
    Node curr = head; // current pointer

    // maintain a set to store visited nodes
    Set<Node> set = new HashSet<>();

    // traverse the list
    while (curr != null) {

        if (set.contains(curr)) {//if set contains current node then
            prev.next = null;
            return;
        }

        // insert the current node into the set
        set.add(curr);

        // update the prev pointer to the current node and
        // move the curr pointer to the next node
        prev = curr;
        curr = curr.next;
    }
}
//O(n) , O(n)
