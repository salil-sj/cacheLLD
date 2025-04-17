package com.cache.lld.CacheLLD.dataStructures;

import java.util.NoSuchElementException;

public class DoublyLinkedList<Key> {

    private Node<Key> head;
    private Node<Key> tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    /*
    - addFirst
    - addLast
    - detachNode
    - getFirst
    - getLast

     */

    public Node<Key> addFirst(Key key) {
        if (head == null) {
            head = new Node<>(key);
            tail = head;
        } else {
            Node<Key> node = new Node<>(key);
            this.head.prev = node;
            node.next = head;
            head = node;
        }
        return head;
    }

    public Node<Key> addLast(Key key) {
        if (tail == null) {
            tail = new Node<>(key);
            head = tail;
        } else {
            Node<Key> node = new Node<>(key);
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        return tail;
    }

    public Node<Key> addNodeToLast(Node<Key> node) {
        if(node == null){
            return null;
        }
        node.next=null; // clearing old references
        node.prev=null;

        if (head == null) {
            head =node;
            tail = head;
        }
        else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        return tail;
    }

    public void detachNode(Node<Key> node) {
        if (node == null) {
            return;
        }
        if (node == head) {
            if (node.next != null) {
                node.next.prev = null;
            }
            head = head.next;
        } else if (node == tail) {
            if (node.prev != null) {
                node.prev.next = null;
            }
            tail = node.prev;
        } else {
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
            node.prev = null;
            node.next = null;
        }
    }

    public Node<Key> getFirst() throws NoSuchElementException {
        if (isEmpty()) {
            return null;
        }
        return head;
    }

    public boolean isEmpty() {
        return (head == null);
    }

}
