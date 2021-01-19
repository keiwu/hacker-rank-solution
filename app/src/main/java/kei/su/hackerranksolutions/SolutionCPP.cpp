//
// Created by kei on 14/01/21.
//

#include "SolutionCPP.h"

//Node **head; //in c++, this meaning pointer to a pointer

int a;                // integer
int *ptrA = &a        // pointer to a integer  // “&” means “addressof”
int **PtrPtrA = &ptrA // point to pointer to a integer

How can it be used:

void function_nochange(int *pA  ) {   pA   = &b;  }
void function_change  (int **ppA) {   *ppA = &b;  }

int a;
int b;
void test()
{
  int *ptrA = &a

  function_nochange(ptrA)
  // here ptrA still point to int a since ptrA was copied

  function_change(&ptrA)
  // here ptrA point to int b since ptrA was passed as pointer
}



// Reverse a linked list and return the head of the reversed list
SinglyLinkedListNode* reverse(SinglyLinkedListNode* head) {
    SinglyLinkedListNode* current = head;
    SinglyLinkedListNode *prev = NULL, *next = NULL;

    while (current != NULL) {
        // Store next
        next = current->next;

        // Reverse current node's pointer
        current->next = prev;

        // Move pointers one position ahead.
        prev = current;
        current = next;
    }
    head = prev;

    return prev;

}


// Complete the printLinkedList function below.

/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     int data;
 *     SinglyLinkedListNode* next;
 * };
 *
 */
void printLinkedList(SinglyLinkedListNode* head) {
    SinglyLinkedListNode* temp = head;

    while (temp->next != NULL){
        cout << temp->data << "\n";
        temp = temp->next;
    }

    cout << temp->data << "\n";

}

// Complete the insertNodeAtTail function below.

/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     int data;
 *     SinglyLinkedListNode* next;
 * };
 *
 */
SinglyLinkedListNode* insertNodeAtTail(SinglyLinkedListNode* head, int data) {
    //use the default constructor to constrct the newNode to be inserted at the tail
    SinglyLinkedListNode* newNode = new SinglyLinkedListNode(data);

    // if the list is empty, assign the newNode to the head
    if (head == NULL){
        head = newNode;
        return head;
    }

    // the following portion is for when the list has at least one element

    //copy the head of the list to temp
    SinglyLinkedListNode* temp = head;

    //loop the link list till the end
    while (temp->next != NULL){
        temp = temp->next;
    }

    // assign the newNode to the end of the linked list
    temp->next = newNode;

    return head;



}


SinglyLinkedListNode* insertNodeAtHead(SinglyLinkedListNode* llist, int data) {
    // create a node with the value to be inserted
    SinglyLinkedListNode* newNode = new SinglyLinkedListNode(data);

    // if we have an empty list, just assign the newNode to the list and return
    if (llist == NULL){
        llist = newNode;
        return llist;
    }

    // we insert the newNode to the beginning of the list by assigning its next to
    // the head of linked list
    newNode->next = llist;

    // return the head of the linkedList
    return newNode;
}

// Complete the compare_lists function below.

/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     int data;
 *     SinglyLinkedListNode* next;
 * };
 *
 */
bool compare_lists(SinglyLinkedListNode* head1, SinglyLinkedListNode* head2) {
    // loop and compare each node until the data differs or when one linked list exhausts
    while (head1!=NULL && head2!=NULL){
        if (head1->data != head2->data)
            return 0;

        head1 = head1->next;
        head2 = head2->next;
    }

    // if after the above loop the two lists reched the end, meaning they are the same
    if (head1 == NULL && head2 == NULL)
        return 1;
    else
        return 0;

}

void moveNode(SinglyLinkedListNode** destPtr, SinglyLinkedListNode** srcPtr){
    SinglyLinkedListNode* newNode = *srcPtr;
    //advance the src pointer
    *srcPtr = newNode->next;

    /* Link the old dest off the new node */
    newNode->next = *destPtr;

    //move destination to point to the new Node
    *destPtr = newNode;


}

// Complete the mergeLists function below.
/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     int data;
 *     SinglyLinkedListNode* next;
 * };
 *
 */
SinglyLinkedListNode* mergeLists(SinglyLinkedListNode* head1, SinglyLinkedListNode* head2) {
    SinglyLinkedListNode* result;
    SinglyLinkedListNode** lastPtrRef = &result;

    while(1){
        if(head1 == NULL){
            *lastPtrRef = head2;
            break;
        } else if (head2 == NULL){
            *lastPtrRef = head1;
            break;
        }

        if (head1->data <= head2->data){
            moveNode(lastPtrRef, &head1);
        } else {
            moveNode(lastPtrRef, &head2);
        }

        lastPtrRef = &((*lastPtrRef)->next);

    }

    return result;
}

// Version 2 of reverse a linked list
// reverse a linked list and return the head of the linked list
// written in Java
static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        SinglyLinkedListNode preNode = null;
        while(head!=null){
            // get the crrent's next node
            SinglyLinkedListNode nextNode = head.next;

            // assign the preNode to be the next node of head;
            head.next = preNode;

            //update the preNode;
            preNode = head;

            // advance the head to next node
            head = nextNode;

        }

        // since the head is null after the while loop, we will have to
        // go back to the previous node which is the begining of the reversed list
        return preNode;


    }

// Java version of merge two sorted linked list;
// Main idea is create a dummy node to hang the result to.
// Assign the dummy node to a new variable and use that variable to do the work;
// When the work is done, return the dummy variable pointing the head of the merged list;
static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        // a dummy first node to hang the result on
        SinglyLinkedListNode result = new SinglyLinkedListNode(0);
        //we will work using the currentNode
        SinglyLinkedListNode currentNode = result;

        while(true){
            if (head1==null){
                // append head2 to the currentNode
                currentNode.next = head2;
                break;

            } else if (head2==null){
                // append head1 to the currentNode
                currentNode.next=head1;
                break;

            }

            if (head1.data <= head2.data){
                // append head1 to the next of current node
                currentNode.next = head1;
                // advance head1
                head1 = head1.next;
            } else {
                // append head2 to the next of current node
                currentNode.next = head2;
                //advance head2
                head2 = head2.next;

            }
            // advance current node
            currentNode = currentNode.next;

        }

        //move the dummy node to the next node which is the true beginning of the linked
        // list
        result = result.next;

        return result;




    }






