package day26;

/*
This problem was asked by Google.

Given a singly linked list and an integer k, remove the kth last element from the list.
k is guaranteed to be smaller than the length of the list.

The list is very long, so making more than one pass is prohibitively expensive.

Do this in constant space and in one pass.
 */
class Solution {

    void onePassRemove(SinglyLinkedList singlyLinkedList,
                              int k) {

    }

}


class SinglyLinkedList {

    private Node head;
    private Node tail;

    void addNode(int node) {

        Node newNode = new Node(node);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    class Node {
        private final int value;
        private Node next;

        Node(int value) {
            this.value = value;
        }
    }
}
