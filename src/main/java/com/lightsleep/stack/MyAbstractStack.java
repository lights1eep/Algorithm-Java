package com.lightsleep.stack;

public interface MyAbstractStack {
    /**
     * 判断栈是否为空
     * @return  true表示空 false表示不空
     */
    boolean isEmpty();
    /**
     * 获取栈内元素数量
     * @return  栈内元素数量
     */
    int size();
    /**
     * 在栈顶添加元素
     * @param value 需要入栈的元素
     */
    void push(int value);
    /**
     * 弹出栈顶元素
     * @return  栈顶元素
     */
    int pop();

    /**
     * 获取栈顶元素
     * @return 栈顶元素
     */
    int peek();
}
