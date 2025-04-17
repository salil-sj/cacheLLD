package com.cache.lld.CacheLLD.evictionPolicies;

import com.cache.lld.CacheLLD.dataStructures.DoublyLinkedList;
import com.cache.lld.CacheLLD.dataStructures.Node;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {

    private DoublyLinkedList<Key> doublyLinkedList;
    private Map<Key, Node<Key>> nodeMap;

    public LRUEvictionPolicy() {
        this.doublyLinkedList = new DoublyLinkedList<>();
        this.nodeMap = new HashMap<>();
    }



    @Override
    public void keyAccessed(Key key) {
        if(nodeMap.containsKey(key)) {
            Node<Key> node = nodeMap.get(key);
            doublyLinkedList.detachNode(nodeMap.get(key));
            doublyLinkedList.addNodeToLast(nodeMap.get(key));
        }
        else {
            Node<Key> node = doublyLinkedList.addLast(key);
            nodeMap.put(key, node);
        }
    }

    @Override
    public Key evict() {
        Node<Key> node = doublyLinkedList.getFirst();
        if(node == null){
            return null;
        }
        doublyLinkedList.detachNode(node);
        return node.getElement();
    }
}
