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
    // reverse a doubly linked list
    // Same version of code doesn't work on Kotlin.
    // So remember if you think your Kotlin code is right but still fail some of the test cases,
    // , be sure to write the same version of code (usually just change the way variable is declared plus semicolon;),
    // and then it will pass the test cases.  It happened couple of times already.
    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode temp = null;
        DoublyLinkedListNode current = head;

        while(current!=null){
            // if the current's next pointer is null, we point the current's next to current's prev node and break out of the loop
            if (current.next==null){
                current.next=current.prev;
                break;
            }

            // make sure to store the current's previous node first; critical step
            DoublyLinkedListNode pre=current.prev;
            // current's prev node becomes current's next when reversing
            // make sure to use an example to walk thru the code if confused
            current.prev=current.next;
            // holding the next node before making change to it
            temp=current.next;
            // current's next is the previous node when reversing
            current.next=pre;

            // advance the next node
            current=temp;

        }

        return current;

    }


    class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // Binary tree preorder traversal using recursive
    public static void preOrder(Node root) {
        while(root!=null){      //we should use if(root!=null) instead of a while loop
            System.out.print(root.data + " ");
            if(root.left!=null)
                preOrder(root.left);

            if (root.right!=null)
                preOrder(root.right);

            break;

        }
    }

    // post order traversal using recursive method.
    // same idea as preOrder traversal, but delaying printing the node value until all the left/right childs are print
    public static void postOrder(Node root) {
        while(root!=null){

            if(root.left!=null)
                postOrder(root.left);

            if (root.right!=null)
                postOrder(root.right);

            System.out.print(root.data + " ");

            break;

        }
    }

    // in order traverse of a binary tree;
//    1. Traverse the left subtree, i.e., call Inorder(left-subtree)
//   2. Visit the root.
//   3. Traverse the right subtree, i.e., call Inorder(right-subtree)
    public static void inOrder(Node root) {
        if(root!=null)

            if(root.left!=null)
                inOrder(root.left);

        System.out.print(root.data + " ");  //visit the root

        if (root.right!=null)
            inOrder(root.right);

    }



    // find the height of a binary tree
    public static int height(Node root) {
        // if root is null, the height is 0
        if (root==null)
            return 0;

        // initialize left and right subtree height to 0;
        int leftTreeHeight=0;
        int rightTreeHeight=0;

        // if left subtree is not null, we have one more level plus the height of
        // its subtree
        if (root.left!=null)
            leftTreeHeight = height(root.left)+1;

        // same as the right subtree
        if (root.right!=null)
            rightTreeHeight=height(root.right)+1;

        // compare the height of the left and right subtree, we return the max of the two trees
        return Math.max(leftTreeHeight, rightTreeHeight);
    }

    //Breath first printing a binary tree values
    //It prints out the tree values at each level from root to leaves
    public static void printLevelOrder(Node node){
        //loop from level 1 to height of the tree
        // getHeight is another helper function to calculate the height of the tree
        for (int level=1; level<=height(node); level++)
            printGivenLevel(node, level);
    }

    // print the node in a given level
    public static void printGivenLevel(Node root, int level){
        // if the tree is null, return
        if(root==null)
            return;
        // if we arrive at that level, print the value out.
        if(level==1)
            System.out.println(root.data);
        else if(level>1){
            //we print its left child, in order to print it, its level has to decrease
            //(because we only printing it when level==1)
            //the more further traversing down, the level is higher to compensate that
            // for printing the value at level==1
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }




        public static int getLeftHeight(Node root) {
            // if root is null, the height is 0
            if (root==null)
                return 0;

            // initialize left and right subtree height to 0;
            int leftTreeHeight=0;

            // if left subtree is not null, we have one more level plus the height of
            // its subtree
            if (root.left!=null)
                leftTreeHeight = getLeftHeight(root.left)+1;


            return leftTreeHeight;
        }

        public static int getRightHeight(Node root) {
            // if root is null, the height is 0
            if (root==null)
                return 0;

            // initialize left and right subtree height to 0;
            int rightTreeHeight=0;

            // if left subtree is not null, we have one more level plus the height of
            // its subtree
            if (root.right!=null)
                rightTreeHeight = getRightHeight(root.right)+1;


            return rightTreeHeight;
        }

        public static void traverseRightTree(Node root){
            while(root!=null){
                System.out.print(root.data + " ");
                if (root.right!=null){
                    root=root.right;
                } else
                    break;
            }
        }

        public static void traverseLeftTree(Node root){
            while(root!=null){
                System.out.print(root.data + " ");
                if (root.left!=null){
                    root=root.left;
                } else
                    break;
            }
        }

        // Given a pointer to the root of a binary tree, print the top view of the binary tree.
        //
        //The tree as seen from the top the nodes, is called the top view of the tree.
        public static void topView(Node root) {
            // get the height of the straight left tree
            int leftHeight=getLeftHeight(root);

            // get the height of the straight right tree
            int rightHeight=getRightHeight(root);

            // if rightHeight is longer, print the right tree
            if (leftHeight<rightHeight){
                traverseRightTree(root);
            } else
                traverseLeftTree(root); // if leftHeight is longer, print the left tree
        }

    }












}
