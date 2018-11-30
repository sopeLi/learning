package com.jcloud.learn.test;

/**
 * Created by lixin32 on 2018/9/14.
 */
public class ReverseLinkedList {
    static class Node {
        Integer data;
        Node next;
    }

    static Node readyNode() {
        Node linkNode1 = new Node();
        linkNode1.data = 1;
        Node linkNode2 = new Node();
        linkNode2.data = 2;
        Node linkNode3 = new Node();
        linkNode3.data = 3;
        Node linkNode4 = new Node();
        linkNode4.data = 4;
        Node linkNode5 = new Node();
        linkNode5.data = 5;
        Node linkNode6 = new Node();
        linkNode6.data = 6;
        linkNode1.next = linkNode2;
        linkNode2.next = linkNode3;
        linkNode3.next = linkNode4;
        linkNode4.next = linkNode5;
        linkNode5.next = linkNode6;
        return linkNode1;
    }

    public static void main(String[] args) {
        Node n=readyNode();
        Node newNode=reverseLinkedList(n);
    }

    static Node reverseLinkedList(Node node) {
        if (node == null || node.next == null) {
            return node;
        } else {
            Node headNode = reverseLinkedList(node.next);
            node.next.next = node;
            node.next = null;
            return headNode;
        }
    }
}
