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
