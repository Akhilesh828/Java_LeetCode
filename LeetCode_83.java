//Remove duplicate elements from sorted linked list

// Method 1 : Stack

public ListNode deleteDuplicates(ListNode head) {
    
    if(head == null) return null;
    ListNode curr = head;

    Stack<ListNode> stack = new Stack<>(); 
    while(curr != null){
        if(stack.isEmpty()){ 
            stack.push(curr);
        }else{
            if(stack.peek().val != curr.val){ 
                
                stack.push(curr); 
            }
        }
        curr = curr.next; 
    }

    ListNode newHead = null;
    while(!stack.isEmpty()){
        ListNode tmp = stack.pop(); 
        
        tmp.next = newHead; 
        newHead = tmp; 
    }
    return newHead;
}


//-------------------------------------------------------------------------------------------

//Method 2

public static Node removeDuplicates(Node head) {
    // do nothing if the list is empty
    if (head == null) {
        return null;
    }

    Node current = head;

    while (current.next != null) {
        if (current.data == current.next.data) {
            Node nextNext = current.next.next;
            current.next = nextNext;
        }
        else {
            current = current.next;  
        }
    }

    return head;
}


//-------------------------------------------------------------------------------------

//Method 3

public Node deleteDuplicates(Node head) { 

    Node curr = head;

    while (curr != null) {
        Node temp = curr;
        while (temp != null && temp.val == curr.val) {
            temp = temp.next;
        }
        curr.next = temp; 
        curr = curr.next;
    }
        return head;
}

//-----------------------------------------------------------------------------------------

//Method 4 : Dummy Node

public ListNode deleteDuplicates(ListNode head) {
    if(head == null) return null;
    ListNode dummyHead = new ListNode(-1);
    dummyHead.next = head;
    ListNode curr = head, prev = dummyHead;
    while(curr != null){
        if(curr.next != null && curr.val == curr.next.val){
            while(curr.next != null && curr.val == curr.next.val){
                curr = curr.next;
            }
            prev.next = curr;
            prev = curr;
        }else{
            prev = curr;
        }
        curr = curr.next;
    }
    return dummyHead.next;
}

