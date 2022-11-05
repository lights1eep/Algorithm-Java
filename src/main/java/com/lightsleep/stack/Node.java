package com.lightsleep.stack;

/**
 * 链表实现栈的基础节点
 */
class Node {
    private int value;
    private Node next;

    Node() {
        this(0, null);
    }

    Node(int value) {
        this(value, null);
    }
    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
