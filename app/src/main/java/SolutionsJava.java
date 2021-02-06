import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;




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

    // Complete the hasCycle function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static boolean hasCycle(SinglyLinkedListNode head) {
        SinglyLinkedListNode slowPtr=head;
        SinglyLinkedListNode fastPtr=head;

        //loop until fastPtr reach the end of the linked list
        while(fastPtr!=null){

            // advance slowPtr to the next node or else break;
            if (slowPtr.next!=null)
                slowPtr=slowPtr.next;
            else
                break;

            // advance fastPtr to the next node or else break;
            if(fastPtr.next!=null&&fastPtr.next.next!=null){
                fastPtr=fastPtr.next.next;
            } else
                break;

            // if fastPtr meet with slowPtr again, there is a loop
            if(slowPtr==fastPtr)
                return true;

        }

        // return false when reaching the end of the linkedlist
        return false;
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




    // this is actually building a full binary tree;
    // all the data are inserted one node at a time
    public static Node insert(Node root,int data) {
        Node current = root;
        Node newNode = new Node(data);

        //
        if(current==null){
            root=newNode;
            return root;
        }

        while(current!=null){

            // put the data on the left side of the tree
            if(current.data>data){
                // insert the node here
                if(current.left==null){
                    current.left=newNode;
                    break;
                }

                // update the new current and continue the while loop
                current=current.left;
            }else{
                if(current.right==null){
                    current.right=newNode;
                    break;
                }

                current=current.right;
            }
        }

        return root;
    }


    // Binary search tree: Lowest Common Ancestor
    public static Node lca(Node root, int v1, int v2) {
        // set the root to the current common parent
        Node currentParent=root;

        while(root!=null){
            //if both v1 and v2 are on the left of the root,
            // we set root.left as the current common parent
            if(root.data>v1 && root.data>v2){
                currentParent=root.left;
                root=root.left;
                // if both v1 and v2 are on the right of the root,
                // we set root.right as the current common parent
            }else if (root.data<v1 && root.data<v2){
                currentParent=root.right;
                root=root.right;
                // if v1 and v2 is not on the same side, we stop there because
                // the common parent is found
            } else
                break;
        }

        return currentParent;
    }


    //Using Stack to keep track of the maximum element in the stack while adding and deleting nodes.
    public class Solution {
        private static class StackNode{
            int val;
            int curMax;

            public StackNode(int val, int curMax){
                this.val = val;
                this.curMax = curMax;
            }
        }


        public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

            Scanner sc = new Scanner(System.in);
            // there are n queryies
            int n = sc.nextInt();
            int max = Integer.MIN_VALUE;

            Stack<StackNode> stack = new Stack<StackNode>();

            while (n > 0) {
                int choice = sc.nextInt();

                switch(choice){
                    // adding a node to the top of stack.  Also storing the max at that node
                    case 1:
                        int val = sc.nextInt();
                        max = Math.max(val, max);
                        stack.push(new StackNode(val, max));
                        break;

                     // reset the max depending if the stack is empty or not.
                    //  If not empty, get the max from the current node by using peek.
                    case 2:
                        if(!stack.isEmpty())
                            stack.pop();

                        // reset max
                        if(stack.isEmpty()){
                            max = Integer.MIN_VALUE;
                        } else
                            max = stack.peek().curMax;

                        break;

                    // Print the stack's current max value
                    case 3:
                        System.out.println(stack.peek().curMax);
                        break;


                }

                n--;
            }
            sc.close();
        }


        /*
         * Complete the cookies function below.
         *   Given k you need to have elements greater than k
            if a element is less than k perform :
            ( Least no+2* 2nd least number).
            *
            * Idea is to use min heap (priority Queque), and keep calculate the top two values until greater than k.
         */
        static int cookies(int k, int[] A) {
            /*
             * Write your code here.
             */

            PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
            int arrSize=A.length;

            for (int i=0; i<arrSize; i++){
                pq.add(A[i]);
            }

            int count=0;
            while(pq.size() > 1 && pq.peek() < k){
                int smallest = pq.poll();
                int second = pq.poll();

                int newVal = smallest + 2*second;
                pq.add(newVal);
                count++;
            }

            if (pq.peek() < k){
                return -1;
            }

            return count;
        }


        /*
         * Complete the 'equalStacks' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER_ARRAY h1
         *  2. INTEGER_ARRAY h2
         *  3. INTEGER_ARRAY h3
         */

        public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
            // Write your code here

            //Declare stacks
            Stack<Integer> s1= new Stack<Integer>();
            Stack<Integer> s2= new Stack<Integer>();
            Stack<Integer> s3= new Stack<Integer>();

            // calculate the sum in each list and assign values in list of reverse
            // to stack
            int sumS1 = 0;
            for (int i=h1.size()-1; i>=0; i--){
                s1.push(h1.get(i));
                sumS1 = sumS1 + h1.get(i);
            }

            int sumS2 = 0;
            for (int i=h2.size()-1; i>=0; i--){
                s2.push(h2.get(i));
                sumS2 = sumS2 + h2.get(i);
            }

            int sumS3 = 0;
            for (int i=h3.size()-1; i>=0; i--){
                s3.push(h3.get(i));
                sumS3 = sumS3 + h3.get(i);
            }

            // get the min height of the stacks
            int min = Math.min(Math.min(sumS1, sumS2), sumS3);

            // set all the stack flags to false
            boolean s1Flag=false;
            boolean s2Flag=false;
            boolean s3Flag=false;

            // if the height is larger than min, we take away the top element of the stack.
            // and then calculate the new min if it is smaller than the min.
            // if the height is the same as min, we set the flag to true.
            // when all the flags are set to true, meaning the heights of the stacks are same
            while(true){
                if (sumS1 > min){
                    s1Flag=false;
                    int val = s1.pop();
                    sumS1=sumS1-val;
                    if (sumS1 < min)
                        min=sumS1;
                } else if (sumS1== min){
                    s1Flag=true;
                }

                if (sumS2 > min){
                    s2Flag=false;
                    int val = s2.pop();
                    sumS2=sumS2-val;
                    if (sumS2 < min)
                        min=sumS2;
                } else if (sumS2== min){
                    s2Flag=true;
                }

                if (sumS3 > min){
                    s3Flag=false;
                    int val = s3.pop();
                    sumS3=sumS3-val;
                    if (sumS3 < min)
                        min=sumS3;
                } else if (sumS3== min){
                    s3Flag=true;
                }

                if (s1Flag && s2Flag && s3Flag)
                    break;

            }




            return min;

        }







    }
