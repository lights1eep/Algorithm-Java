package com.lightsleep.skiplist;

class Node {
    int val;
    Node[] next;

    Node(int val, int maxLevel) {
        this.val = val;
        this.next = new Node[maxLevel];
    }
}
