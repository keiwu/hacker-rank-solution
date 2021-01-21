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
}
