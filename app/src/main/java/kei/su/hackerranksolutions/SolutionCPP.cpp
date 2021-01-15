//
// Created by kei on 14/01/21.
//

#include "SolutionCPP.h"

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





