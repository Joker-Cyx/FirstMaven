package org.cyx;

import org.cyx.util.PrintUtil;

import java.util.*;

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

        /**
         * 11. 盛最多水的容器
         * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。
         * 在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
         * @sin 2021.10.28 23:27
         * @end 2021.10.29 00:19
         */
        PrintUtil.printTitle("11. 盛最多水的容器");
        int[] height11 = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new MaxArea().maxArea(height11));

        /**
         * 26. 删除有序数组中的重复项
         * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
         * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
         * @sin
         * @end
         */
        PrintUtil.printTitle("26. 删除有序数组中的重复项");
        int[] nums26 = new int[]{0};
        System.out.println(new RemoveDuplicates().removeDuplicates(nums26));

        /**
         * 36. 有效的数独
         * 请你判断一个9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
         *   数字1-9在每一行只能出现一次。
         *   数字1-9在每一列只能出现一次。
         *   数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
         * @sin 2021.12.01 21:04
         * @end 2021.12.01 21:41
         */
        PrintUtil.printTitle("36. 有效的数独");
        char[][] board36 = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(new IsValidSudoku().isValidSudoku(board36));

        /**
         * 45. 跳跃游戏 II
         * 给你一个非负整数数组nums ，你最初位于数组的第一个位置。
         * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
         * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
         * 假设你总是可以到达数组的最后一个位置。
         * @sin 2021.11.02 23:50
         * @end 2021.11.03 00:26
         */
        PrintUtil.printTitle("45. 跳跃游戏 II");
        int[] nums451 = new int[]{2, 3, 1, 1, 4};
        int[] nums452 = new int[]{2, 3, 0, 1, 4};
        System.out.println(new Jump().jump(nums451));

        /**
         * 55. 跳跃游戏
         * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
         * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
         * 判断你是否能够到达最后一个下标。
         * @sin 2021.11.02 23:25
         * @end 2021.11.02 23:44
         */
        PrintUtil.printTitle("55. 跳跃游戏");
        int[] nums551 = new int[]{3, 2, 1, 0, 1};
        int[] nums552 = new int[]{2, 3, 1, 1, 4};
        System.out.println(new CanJump().canJump(nums551));

        /**
         * 62. 不同路径
         * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
         * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
         * 问总共有多少条不同的路径？
         * O(mn), O(mn)，传统 DP 方案空间复杂度可优化至O(min(m,n))
         * @sin 2021.11.01 23:53
         * @end 2021.11.02 00：12
         */
        PrintUtil.printTitle("62. 不同路径");
        System.out.println(new UniquePaths().uniquePaths(3, 7));

        /**
         * 63. 不同路径 II
         * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
         * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
         * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
         * 网格中的障碍物和空位置分别用 1 和 0 来表示。
         * O(mn), O(mn)，传统 DP 方案空间复杂度可优化至O(min(m,n))
         * @sin 2021.11.02 00：15
         * @end 2021.11.02 00：29
         */
        PrintUtil.printTitle("63. 不同路径 II");
        int[][] obstacleGrid631 = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] obstacleGrid632 = new int[][]{{0, 1, 0}, {1, 0, 0}, {0, 0, 0}};
        System.out.println(new UniquePathsWithObstacles().uniquePathsWithObstacles(obstacleGrid632));

        /**
         * 66. 加一
         * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
         * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
         * 你可以假设除了整数 0 之外，这个整数不会以零开头。
         * @sin
         * @end
         */
        PrintUtil.printTitle("66. 加一");
        int[] digits66 = new int[]{9, 9, 9, 9};
        Arrays.stream(new PlusOne().plusOne(digits66)).forEach(System.out::println);

        /**
         * 200. 岛屿数量
         * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
         * @sin 2021.11.17 22:55
         * @end 2021.11.17 23:25
         */
        PrintUtil.printTitle("200. 岛屿数量");
        char[][] grid200_1 = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        char[][] grid200_2 = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        char[][] grid200_3 = new char[][]{
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };
        System.out.println(new NumIslands().numIslands(grid200_1));
        System.out.println(new NumIslands().numIslands(grid200_2));
        System.out.println(new NumIslands().numIslands(grid200_3));

        /**
         * 215. 数组中的第K个最大元素
         * @sin 2021.12.15 00：10
         * @end 2021.12.15 00:
         */
        PrintUtil.printTitle("215. 数组中的第K个最大元素");
        int[] nums215 = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        System.out.println(new FindKthLargest().partition(nums215, 0, nums215.length - 1));

        /**
         * 239. 滑动窗口最大值
         * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。
         * 你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
         * 返回滑动窗口中的最大值。
         * @sin 2021.11.11 00:00
         * @end 2021.11.11 00:
         */
        PrintUtil.printTitle("239. 滑动窗口最大值");
        int[] nums239 = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        Arrays.stream(new MaxSlidingWindow().maxSlidingWindow(nums239, 3)).forEach(System.out::println);

        /**
         * 874. 模拟行走机器人
         * 机器人在一个无限大小的 XY 网格平面上行走，从点(0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ：
         *     -2 ：向左转90 度
         *     -1 ：向右转 90 度
         *     1 <= x <= 9 ：向前移动x个单位长度
         * 在网格上有一些格子被视为障碍物obstacles 。第 i个障碍物位于网格点 obstacles[i] = (xi, yi) 。
         * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。
         * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。
         * @sin 2021.12.13 23:15
         * @end 2021.12.13 23:50
         */
        PrintUtil.printTitle("874. 模拟行走机器人");
        int[] cmd = new int[]{4, -1, 4, -2, 4};
        int[][] obs = new int[][]{
                {2,4}
        };
        System.out.println(new RobotSim().robotSim(cmd, obs));
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

// 36. 有效的数独
class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // row: idx表示当前所在行。row[idx] 的int值的各个位表示某值是否在第idx行出现。1表示出现
        int[] row = new int[10];
        int[] col = new int[10];
        int[] blk = new int[10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '0';
                int blkIdx = (i / 3) * 3 + j / 3;
                // 行、列、块中是否已经有此num了
                if (((row[i] >> num) & 1) == 1 || ((col[j] >> num) & 1) == 1 || ((blk[blkIdx] >> num) & 1) == 1) {
                    return false;
                }
                row[i] |= (1 << num);
                col[j] |= (1 << num);
                blk[blkIdx] |= (1 << num);
            }
        }
        return true;
    }
}

// 45. 跳跃游戏 II
class Jump {
    public int jump(int[] nums) {
        int maxPosNextStep = 0;
        int steps = 0;
        int maxPosCurrStep = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosNextStep = Math.max(i + nums[i], maxPosNextStep);
            if (maxPosNextStep >= nums.length - 1) {
                return steps + 1;
            }
            if (i == maxPosCurrStep) {
                maxPosCurrStep = maxPosNextStep;
                steps++;
            }
        }
        return steps;
    }
}

// 55. 跳跃游戏
class CanJump {
    public boolean canJump(int[] nums) {
        int maxCan = 0;
        for (int i = 0; i < nums.length && i <= maxCan; i++) {
            maxCan = Math.max(maxCan, i + nums[i]);
            if (maxCan >= nums.length - 1) {
                return true;
            }
        }
        return false;
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

// 200. 岛屿数量
class NumIslands {
    public int numIslands(char[][] grid) {
        int nums = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] used = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1' && used[r][c] == 0) {
                    dfs(r, c, grid, used);
                    nums++;
                }
            }
        }
        return nums;
    }

    /**
     * dfs 工具函数
     *
     * @param ir 起始点所在行
     * @param ic 起始点所在列
     */
    void dfs(int ir, int ic, char[][] grid, int[][] used) {
        used[ir][ic] = 1;
        // 模拟上下左右运动
        int[] dir = new int[]{-1, 0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int nextRow = ir + dir[i];
            int nextCol = ic + dir[i + 1];
            if (0 <= nextRow && nextRow < grid.length && 0 <= nextCol && nextCol < grid[0].length) {
                if (grid[nextRow][nextCol] == '1' && used[nextRow][nextCol] == 0) {
                    dfs(ir + dir[i], ic + dir[i + 1], grid, used);
                }
            }
        }
    }
}

// 215. 数组中的第K个最大元素
class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        return 0;
    }

    /**
     * 快速排序的part帮助函数
     *
     * @param nums  待分隔数组
     * @param left  左边界，初始所选的值
     * @param right 右边界
     * @return 返回最终分隔所在的下标
     */
    public int partition(int[] nums, int left, int right) {
        int idx = left;
        int vi = nums[idx];
        while (left < right) {
            while (nums[right] > vi && right > left) {
                right--;
            }
            while (nums[left] <= vi && right > left) {
                left++;
            }
            swap(nums, left, right);
        }
        swap(nums, idx, left);
        return left;
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

// 239. 滑动窗口最大值
class MaxSlidingWindow {

    Deque<Integer> maxQue = new LinkedList<>();

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ret = new int[nums.length - k + 1];
        int l = 0;

        for (int i = 0; i < k - 1; i++) {
            addQue(maxQue, nums[i]);
        }

        for (int i = k - 1; i < nums.length; i++) {
            addQue(maxQue, nums[i]);
            if (nums[i - k + 1] != maxQue.getFirst()) {
                ret[l++] = maxQue.getFirst();
            } else {
                ret[l++] = maxQue.pollFirst();
            }
        }
        return ret;
    }

    private void addQue(Deque<Integer> deque, int val) {
        while (!deque.isEmpty() && deque.getLast() < val) {
            deque.pollLast();
        }
        deque.add(val);
    }
}

// 874. 模拟行走机器人
class RobotSim {
    public int robotSim(int[] commands, int[][] obstacles) {
        // tip：用两个数组表示方向：N, E, S, W
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int di = 0;                         // 方向坐标，初始为北方
        int ret = 0;
        int x = 0;
        int y = 0;

        // tip: 将障碍物坐标编码为字符串"x+y"，避免后续寻找障碍物时遍历障碍物数组
        Set<String> ob = new HashSet<>();
        for (int[] o : obstacles) {
            ob.add("" + o[0] + "+" + o[1]);
        }

        // 遍历cmd
        for (int c : commands) {
            if (c == -1) {          // 右转
                di = di + 1 == 4 ? 0 : di + 1;
            } else if (c == -2) {   // 左转
                di = di - 1 == -1 ? 3 : di - 1;
            } else {                // 走
                for (int k = 0; k < c; k++) {
                    // 每走一步，x & y在其方向上加上步数
                    x += dx[di];
                    y += dy[di];
                    if (ob.contains("" + x + "+" + y)) {
                        x -= dx[di];
                        y -= dy[di];
                        break;
                    }
                    // 不处在障碍物时，计算最大欧式距离
                    ret = Math.max(ret, x * x + y * y);
                }
            }
        }
        return ret;
    }
}