//Middle of a given linked list

//Brute Force

public ListNode middleNode(ListNode head) {
	ListNode curNode = head;
	int count = 0;

	while(curNode != null){
		count++; // count length of linkedList
		curNode = curNode.next; 
	}

	curNode = head;
	for(int i=0; i<count/2; i++){ //middle = count/2
		curNode = curNode.next;
	}

	return curNode;
}

/*-----------------------------------------------------------*/
// little improve

public ListNode middleNode(ListNode head) {
	ListNode curNode = head;
	int count = 0;

	while(curNode != null){
		count++; // count length of linkedList
		curNode = curNode.next; 
	}

	curNode = head;
	while(curNode != count/2){ //middle = count/2
		curNode = curNode.next;
	}

	return curNode;
}

/*-----------------------------------------------------------*/
// little improve

public ListNode middleNode(ListNode head) {
	ListNode curNode = head;
	int count = 0;

	while(curNode != null){
		count++; // count length of linkedList
		curNode = curNode.next; 
	}

	curNode = head;
  int mid = count/2;
	while(curNode != mid){ //middle = count/2
		curNode = curNode.next;
	}

	return curNode;
}

/*-----------------------------------------------------------*/
// Two pointer - Best Method

public ListNode middleNode(ListNode head) {
	ListNode slow = head;
	ListNode fast = head;

	while(fast != null && fast.next != null){
		slow = slow.next;
		fast = fast.next.next; 
	}

	return slow;
}

/*-----------------------------------------------------------*/
// Check Even Index

public ListNode middleNode(ListNode head) {
	int count = 0;
	ListNode middleNode = head;

	while(head != null){
		count++; // count length of linkedList

        if((count %2) == 0){ //even index
            middleNode = middleNode.next;
        }
		head = head.next; 
	}

	return middleNode;
}

/*======================================================================================*/



/*-----------------------------------------------------------*/
// UseLess

public ListNode middleNode(ListNode head) {
	ListNode curNode = head;
	int count = 0;

	while(curNode != null){
		count++; // count length of linkedList
		curNode = curNode.next; 
	}

	ListNode findNode = head;
  int middle = count/2;

	while(middle != 0){
		findNode = findNode.next;
		middle--;
	}

	return findNode;
}

/*-----------------------------------------------------------*/
// UseLess

public ListNode middleNode(ListNode head) {
    int length=0;
    ListNode currNode = head;
    while (currNode != null) {
        currNode = currNode.next ;
        length = length + 1 ;
    }
    currNode = head;
    int mid= 0;
    while (mid < length/2) {
        currNode = currNode.next;
        mid= mid+ 1;
    }
    return currNode;
}

