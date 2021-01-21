
class SinglyLinkedListNode(nodeData: Int) {
    public var data: Int
    public var next: SinglyLinkedListNode?

    init {
        data = nodeData
        next = null
    }
}

// In place array swap to save space without creating a new a
// new array.
// Loop thru the first N/2 elements, and swap the
// first with last element in the array, second to second
// last...
fun reverseArray(a: Array<Int>): Array<Int> {
    var temp: Int
    val arrSize = a.size
    for (i in 0 until arrSize/2){       // in 0 until 10 prints: 0 1 2 3 4 5 6 7 8 9 only
        temp = a[i]
        a[i] = a[arrSize - i - 1]
        a[arrSize - i - 1] = temp
    }

    return a

}

/*
 * Complete the 'dynamicArray' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. 2D_INTEGER_ARRAY queries
 */

fun dynamicArray(n: Int, queries: Array<Array<Int>>): Array<Int> {
    var sequencesList = Array(n){ArrayList<Int>()} //create n ArrayList of type Int
    var lastAnswer = 0
    var outputArray = ArrayList<Int>()
    var sequenceNumber : Int

    for (i in queries.indices){
        //calculate which sequence in the sequence list
        sequenceNumber = (queries[i].get(1).xor(lastAnswer))%n

        //if query type is 1
        if (queries[i].get(0) == 1){
            sequencesList[sequenceNumber].add(queries[i].get(2))
        } else if (queries[i].get(0) == 2){
            val sequenceSize = sequencesList[sequenceNumber].size
            // find the value of element y% size of the sequence and assign to lastAnswer
            lastAnswer = sequencesList[sequenceNumber][queries[i].get(2) % sequenceSize]
            //add lastAnswer to the output array
            outputArray.add(lastAnswer)
        }
    }

    //convert to typed array before return
    return outputArray.toTypedArray()
}

/*
 * Complete the 'rotateLeft' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER d
 *  2. INTEGER_ARRAY arr
 */


// d is the number of steps to rotate left
fun rotateLeft(d: Int, arr: Array<Int>): Array<Int> {
    // If number of rotation is the same as the input array size, return the input array
    if (d == arr.size)
        return arr

    // Declare a dynamic arry of type Int to hold the result
    var resultArr = ArrayList<Int>()

    // Begining at the item at index d, all the way to end of the item in array,
    // we add each to the result array
    for (i in d..arr.size - 1)
        resultArr.add(arr[i])

    // Begining at the first item of the array, all the way to the item at the index
    // d - 1, we append each item to the result array
    for (i in 0..d-1)
        resultArr.add(arr[i])

    return resultArr.toTypedArray()
}

fun deleteNode(llist: SinglyLinkedListNode?, position: Int): SinglyLinkedListNode? {
    // assign the head of the list to a new variable;
    // this new variable head is for using traverse the linked list
    var head: SinglyLinkedListNode? = llist

    var index: Int = 0

    // if we want to delete the first item in the linked list
    // and if the linked list is not empty
    if (position == index && head!=null){
        head = head.next
        return head
    }

    // preNode keeps track of the preNode of the head
    var preNode: SinglyLinkedListNode? = head
    // we move to the 2nd item of the linked list
    head = head?.next
    while (head!= null && head.next!= null){
        // at the first time running the while loop, we are starting to check the
        // node at position 1;  because position 0 is handled in the if condition
        // above the while loop
        index++

        // if we found the node at position specified,
        // we direct the previous node to point to current node's next node
        if (position == index){
            preNode?.next = head.next
            return llist
        }

        // current node become previous node
        preNode = head

        // go to the next item of the linked list and continue the while loop
        head = head.next

    }

    // when we get to the last item, we set the previous node of the last item to
    // point to null
    preNode?.next = null

    return llist

}

fun reversePrint(llist: SinglyLinkedListNode?): Unit {

    var newHead: SinglyLinkedListNode?

    //we start at the 2nd item of the link list
    var head = llist?.next

    // assign head to the previous node
    var preNode = llist

    // last element (head) points to null
    preNode?.next = null

    //reverse the list; this revers something in between the first and last item
    while (head!= null && head.next != null){
        // point the newHead to the next node
        newHead = head.next

        // head.next points the previous
        head.next = preNode

        // make the current head the previous node
        preNode = head

        // move the head to the newHead
        head = newHead
    }

    // assign the last node to point to the preNode
    head?.next = preNode

    // traverse the reversed linklist
    while (head!= null && head.next != null){
        System.out.println(head.data)
        head = head.next
    }

    // print the last element which doesn't print in the for loop
    System.out.println(head?.data)

}


fun reverse(llist: SinglyLinkedListNode?): SinglyLinkedListNode? {
    var current = llist
    var preNode: SinglyLinkedListNode? = null
    var next: SinglyLinkedListNode?
    //reverse the list; this revers something in between the first and last item
    while (current!= null){
        //next is assigned to current next
        next = current.next

        //current next should point back to previous node
        current.next = preNode

        //previous node becomes current node
        preNode = current

        //current move to the current next
        current = next
    }

    //when we exit the whileloop, preNode is the last element of the reversed link list
    // ths assign it to head

    return preNode



}


// Complete the getNode function below.

/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     data: Int
 *     next: SinglyLinkedListNode
 * }
 *
 */


fun getNode(llist: SinglyLinkedListNode?, positionFromTail: Int): Int {
    // reverse the linked list
    var reversedList = reverse(llist)

    // keep tracks of the position of the linked list
    var index = 0

    while (reversedList != null){
        //System.out.println(reversedList.data)
        if (positionFromTail == index)
            return reversedList.data

        //increase the index
        index++

        //advance to the next node
        reversedList = reversedList.next
    }

    return 0

}


// Kotlin version of reverse a linked list

fun reverseLinkedList(llist: SinglyLinkedListNode?): SinglyLinkedListNode? {
    var current = llist
    var preNode: SinglyLinkedListNode? = null
    var next: SinglyLinkedListNode?
    //reverse the list; this revers something in between the first and last item
    while (current!= null){
        //next is assigned to current next
        next = current.next

        //current next should point back to previous node
        current.next = preNode

        //previous node becomes current node
        preNode = current

        //current move to the current next
        current = next
    }

    //when we exit the whileloop, preNode is the last element of the reversed link list
    // ths assign it to head

    return preNode



}







