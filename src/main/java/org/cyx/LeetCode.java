package org.cyx;

import java.util.Arrays;
import java.util.Collection;
import java.util.Stack;

/**
 * Hello world!
 */
public class LeetCode {
    public static void main(String[] args) {
        /** 503. 下一个更大元素 II
         * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
         * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
         *   输入: [1,2,1]
         *   输出: [2,-1,2]
         * @since 2021.10.18 22:46
         * @end
         */
        System.out.println("*********************** 503. 下一个更大元素 II ***********************");
        int[] nums503 = new int[]{4, 2, 3, 2};  // -1 3 4 4
        int[] ret503 = new NextGreaterElements().nextGreaterElements(nums503);
        Arrays.stream(ret503).forEach(System.out::println);

    }

}

// 503. 下一个更大元素 II
class NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
      return new int[0];
    }
}
