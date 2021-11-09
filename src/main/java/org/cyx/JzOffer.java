package org.cyx;

import org.cyx.util.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
         * JZ51 数组中的逆序对
         * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
         * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P mod 1000000007
         * 要求：空间复杂度 O(n)，时间复杂度 O(nlogn)
         * @sin 2021.11.09 23:50
         * @end 2021.11.10 00:42
         */
        PrintUtil.printTitle("JZ51 数组中的逆序对");
        int[] nums = new int[]{364, 637, 341, 406, 747, 995, 234, 971, 571, 219, 993, 407, 416, 366, 315, 301, 601, 650,
                418, 355, 460, 505, 360, 965, 516, 648, 727, 667, 465, 849, 455, 181, 486, 149, 588, 233, 144, 174, 557,
                67, 746, 550, 474, 162, 268, 142, 463, 221, 882, 576, 604, 739, 288, 569, 256, 936, 275, 401, 497, 82,
                935, 983, 583, 523, 697, 478, 147, 795, 380, 973, 958, 115, 773, 870, 259, 655, 446, 863, 735, 784, 3,
                671, 433, 630, 425, 930, 64, 266, 235, 187, 284, 665, 874, 80, 45, 848, 38, 811, 267, 575};
        System.out.println(new InversePairs().inversePairs(nums));


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

// JZ30 包含min函数的栈
class StackWithMinMethod {
    private final Stack<Integer> norStk = new Stack<>();
    private final Stack<Integer> minStk = new Stack<>();

    public void push(int node) {
        norStk.push(node);
        if (minStk.empty()) {
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

// JZ51 数组中的逆序对
class InversePairs {

    private int numOfInvPairs = 0;

    // 记录左节点个数的最小堆
    class BstNode {
        int val;
        int leftNum;
        BstNode left;
        BstNode right;

        public BstNode(int v) {
            this.val = v;
            this.leftNum = 0;
            this.left = null;
            this.right = null;
        }
    }

    private void addBstNode(BstNode root, BstNode node) {
        if (node.val <= root.val) {
            root.leftNum++;
            if (root.left != null) {
                addBstNode(root.left, node);
            } else {
                root.left = node;
            }
        } else {
            numOfInvPairs = (numOfInvPairs + root.leftNum + 1) % 1000000007;
            if (root.right != null) {
                addBstNode(root.right, node);
            } else {
                root.right = node;
            }
        }
    }

    public int inversePairs(int[] array) {
        if (array.length <= 1) {
            return 0;
        }
        List<BstNode> listBstNode = new ArrayList<>();
//        Arrays.stream(array).forEach(i -> listBstNode.add(new BstNode(i)));
        for (int j : array) {
            listBstNode.add(new BstNode(j));
        }
        for (int i = listBstNode.size() - 2; i >= 0; i--) {
            addBstNode(listBstNode.get(listBstNode.size() - 1), listBstNode.get(i));
        }
        return this.numOfInvPairs;
    }
}

// JZ73 翻转单词序列
class ReverseSentence {
    public String reverseSentence(String str) {
        String[] s = str.split(" ");
        StringBuilder ret = new StringBuilder();
        for (int i = s.length - 1; i > 0; i--) {
            ret.append(s[i]).append(" ");
        }
        return ret + s[0];
    }
}