package org.cyx;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        /**
         * 26. 删除有序数组中的重复项
         * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
         * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
         */
        int[] nums26 = new int[]{0};
        System.out.println(new RemoveDuplicates().removeDuplicates(nums26));

        /**
         * 66. 加一
         * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
         * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
         * 你可以假设除了整数 0 之外，这个整数不会以零开头。
         */
        int[] digits66 = new int[]{9, 9, 9, 9};
        Arrays.stream(new PlusOne().plusOne(digits66)).forEach(System.out::println);
    }
}

// 26. 删除有序数组中的重复项(Array)
class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            if (l == r || nums[l] == nums[r]) {
                r++;
            } else if (nums[l] != nums[r]) {
                nums[++l] = nums[r++];
            }
        }
        return l + 1;
    }
}

// 66. 加一(Array)
class PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0)
                return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}