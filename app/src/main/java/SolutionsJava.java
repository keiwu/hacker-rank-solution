public class SolutionsJava {

    class SinglyLinkedListNode {
        public Integer data;
        public SinglyLinkedListNode next;

    }


    // Java version of remove duplicates; after convert to Kotlin it doesn't work
    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        /*Another reference to head*/
        SinglyLinkedListNode curr = head;


        /* Traverse list till the last node */
        while (curr != null) {
            SinglyLinkedListNode temp = curr;
            /*Compare current node with the next node and
            keep on deleting them until it matches the current
            node data */
            while(temp!=null && temp.data==curr.data) {
                temp = temp.next;
            }
            /*Set current node next to the next different
            element denoted by temp*/
            curr.next = temp;
            curr = curr.next;
        }

        return head;

    }

    // my version of remove duplicates;
    static SinglyLinkedListNode removeDuplicatesMyversion(SinglyLinkedListNode head) {
        /*Another reference to head*/
        SinglyLinkedListNode curr = head;


        /* Traverse list till the last node */
        while (curr != null) {
            SinglyLinkedListNode nextNode = curr.next;
            //make sure to do a null check for the next node
            // kotlin version doesn't have the null check.  Maybe because of that the 2 to 6 test cases fails
            if (nextNode!= null && curr.data == nextNode.data){
                nextNode = nextNode.next;
                curr.next = nextNode;
            } else {
                curr = curr.next;
            }

        }

        return head;

    }

    // Complete the findMergeNode function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */

    // given two head nodes of two linked list, find the common node which points to the same memory address
    // algorithm: compare each node of list 1 to each node in list 2 using two while loop
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        while(head1!=null){
            // assign head2 to a temp variable;
            SinglyLinkedListNode temp=head2;
            while (temp!=null){
                // compare head to each of the 2nd linked list node
                if (head1 == temp)
                    return head1.data;  // if node in list 1 == node in list 2; return

                temp=temp.next; //advance to the next node of list2
            }
            //advance to the next node of list 1
            head1=head1.next;
        }

        // no node is equal
        return -1;

    }



    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    // Complete the sortedInsert function below.

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */

    // Insert a node into a doubly linked list in a sorted list and maintained the sorting property
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        // create the node with data
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

        //assign head to current, and use current to do iterations
        DoublyLinkedListNode current;

        // if the lined list is empty, the newNode is the head of the list
        if (head==null){
            head=newNode;
        } else if (head.data >= data){ // insert new node to the front of the list
            //head's prev is newNOde
            head.prev=newNode;
            // newNode's next is head
            newNode.next=head;
            // newNode becomes the head of the linked list
            head=newNode;

        } else{
            current=head;
            while(current.next!=null && data>=current.next.data){
                current=current.next;
            }

            if (current.next!=null){
                // if current next is not null, have that node's prev point to the newNode
                current.next.prev=newNode;
            }

            //newNode's prev point to current
            newNode.prev=current;
            //newNode's next point to current next.  if current next is null, it points              //to null
            newNode.next=current.next;
            //current's next point to new node
            current.next=newNode;


        }

        //head is not changed, but the underlying nodes changed
        return head;

    }










}
