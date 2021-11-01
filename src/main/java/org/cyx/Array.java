package org.cyx;

import java.util.Arrays;

public class Array {

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        printTitle("11. 盛最多水的容器");
        /**
         * 11. 盛最多水的容器
         * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。
         * 在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
         * @sin 2021.10.28 23:27
         * @end 2021.10.29 00:19
         */
        int[] height11 = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new MaxArea().maxArea(height11));

        printTitle("26. 删除有序数组中的重复项");
        /**
         * 26. 删除有序数组中的重复项
         * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
         * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
         * @sin
         * @end
         */
        int[] nums26 = new int[]{0};
        System.out.println(new RemoveDuplicates().removeDuplicates(nums26));

        printTitle("62. 不同路径");
        /**
         * 62. 不同路径
         * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
         * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
         * 问总共有多少条不同的路径？
         * @sin 2021.11.01 23:53
         * @end 2021.11.02 00：12
         */
        System.out.println(new UniquePaths().uniquePaths(3, 7));

        printTitle("63. 不同路径 II");
        /**
         * 63. 不同路径 II
         * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
         * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
         * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
         * 网格中的障碍物和空位置分别用 1 和 0 来表示。
         * @sin 2021.11.02 00：15
         * @end 2021.11.02 00：29
         */
        int[][] obstacleGrid631 = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] obstacleGrid632 = new int[][]{{0, 1, 0}, {1, 0, 0}, {0, 0, 0}};
        System.out.println(new UniquePathsWithObstacles().uniquePathsWithObstacles(obstacleGrid632));

        printTitle("66. 加一");
        /**
         * 66. 加一
         * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
         * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
         * 你可以假设除了整数 0 之外，这个整数不会以零开头。
         * @sin
         * @end
         */
        int[] digits66 = new int[]{9, 9, 9, 9};
        Arrays.stream(new PlusOne().plusOne(digits66)).forEach(System.out::println);


    }

    static void printTitle(String title) {
        int len = title.length();
        int left = (118 - len) / 2;
        int right = 118 - len - left;
        while (left-- > 0) {
            System.out.printf("*");
        }
        System.out.printf(" " + title + " ");
        while (right-- > 0) {
            System.out.printf("*");
        }
        System.out.println();
    }
}

// 11. 盛最多水的容器
class MaxArea {
    public int maxArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            maxArea = Math.max(maxArea, (r - l) * Math.min(height[l], height[r]));
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}

// 21. 合并两个有序链表

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

// 62. 不同的路径
class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] path = new int[m][n];
        for (int i = 0; i < m; ++i) {
            path[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            path[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                path[i][j] = path[i - 1][j] + path[i][j - 1];
            }
        }
        return path[m - 1][n - 1];
    }
}

// 62. 不同的路径
class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;
        int[][] path = new int[r][c];
        for (int i = 0; i < r; ++i) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            path[i][0] = 1;
        }
        for (int j = 0; j < c; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            path[0][j] = 1;
        }
        for (int i = 1; i < r; ++i) {
            for (int j = 1; j < c; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                path[i][j] = path[i - 1][j] + path[i][j - 1];
            }
        }
        return path[r - 1][c - 1];
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