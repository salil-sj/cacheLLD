package com.cache.lld.CacheLLD.dataStructures;

import lombok.Getter;

public class Node<Key> {
    @Getter
    public Key element;
    public Node<Key> next;
    public Node<Key> prev;

    public Node(Key element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }
}
