package org.cyx;

import org.cyx.util.PrintUtil;

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
        PrintUtil.printTitle("JZ9 用两个栈实现队列");
        Stack<Integer> s1 = new Stack<Integer>();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        System.out.println(s1);
        Stack<Integer> s2 = new Stack<>();

        /**
         * JZ30 包含min函数的栈
         * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的 min 函数，
         * 输入操作时保证 pop、top 和 min 函数操作时，栈中一定有元素。
         * @sin 2021.11.08 23:40
         * @end 2021.11.08 23:50
         */
        PrintUtil.printTitle("JZ30 包含min函数的栈");


        /**
         * JZ73 翻转单词序列
         * “nowcoder. a am I”
         * “I am a nowcoder.”
         * @sin 2021.11.08 23:24
         * @end 2021.11.08 23:34
         */
        PrintUtil.printTitle("JZ73 翻转单词序列");
        String strJz73 = "nowcoder. a am I";
        System.out.println(new ReverseSentence().reverseSentence(strJz73));
    }

}
// JZ9 用两个栈实现队列
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

//JZ30 包含min函数的栈
public class StackWithMinMethod {
    private Stack<Integer> norStk = new Stack<>();
    private Stack<Integer> minStk = new Stack<>();

    public void push(int node) {
        norStk.push(node);
        if(minStk.empty()) {
            minStk.push(node);
        } else {
            minStk.push(Math.min(minStk.peek(), node));
        }
    }

    public void pop() {
        if(!norStk.empty()) {
            norStk.pop();
            minStk.pop();
        }
    }

    public int top() {
        return norStk.peek();
    }

    public int min() {
        return minStk.peek();
    }
}

// JZ73 翻转单词序列
class ReverseSentence {
    public String reverseSentence(String str) {
        String[] s = str.split(" ");
        StringBuilder ret = new StringBuilder();
        for(int i = s.length - 1; i > 0; i--) {
            ret.append(s[i]).append(" ");
        }
        return ret + s[0];
    }
}