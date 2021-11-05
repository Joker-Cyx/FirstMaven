package org.cyx;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class JzOffer {

    public static void main(String[] args) {
        /**
         * JZ9 用两个栈实现队列
         * 数据范围：n≤1000
         * 要求：存储n个元素的空间复杂度为 O(n)，插入与删除的时间复杂度都是 O(1)
         * @sin 2021.11.05 23:35
         * @end 2021.11.05 23:55
         */
        Stack<Integer> s1 = new Stack<Integer>();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        System.out.println(s1);
        Stack<Integer> s2 = new Stack<>();
    }

}

class StackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();   // push
    Stack<Integer> stack2 = new Stack<Integer>();   // pop

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}