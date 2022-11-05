package com.lightsleep.tree.rbtree;

/**
 * 红黑树节点
 */
public class RBNode {
    int data;
    RBNode parent;
    RBNode left;
    RBNode right;
    RBColor color;

    public RBNode(int data) {
        this.data = data;
        this.parent = null;
        this.left = null;
        this.right = null;
        this.color = RBColor.RED;
    }

    @Override
    public String toString() {
        return "RBNode{" +
                "data=" + data +
                ", color=" + color +
                '}';
    }
}
