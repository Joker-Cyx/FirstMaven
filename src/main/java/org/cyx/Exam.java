package org.cyx;

import org.cyx.util.PrintUtil;

import java.util.*;

public class Exam {
    public static void main(String[] args) {

        /**
         * 字符串解压缩
         * String.indexOf()
         * String.lastIndexOf(int, fromIdx);
         * String s = String.replace(tar, rep);
         * String[] s = String.split(rgx);
         */
        PrintUtil.printTitle("字符串解压缩");
        String words = "[10|[2|AB][2|AB]]";
        System.out.println(new Compress().compress(words));

        /**
         * 2020.12.04 - 1 任务规划
         * 任务列表tasks有 N 个任务，编号为 [0, N-1]
         *     任务间存在互斥关系，记录在二维数组 mutexPairs中，现对tasks进行分割，问最少能分成几组
         * ex:
         *     tasks = [1,3,2,4,6,5,0], mutexPairs = [[1,3], [4,5]]
         * out: 3
         *     [1], [3,2,4,6], [5,0] 是其中一种解法
         * @sin 2021.12.01 22:14
         * @end 2021.12.01 23:05
         */
        PrintUtil.printTitle("2020.12.04 - 1 任务规划");
        int[] tasks1204 = new int[]{1, 3, 2, 4, 6, 5, 0};
        int[][] mutexPairs = new int[][]{{1, 3}, {4, 5}, {5, 2}};
        System.out.println(new TaskCut().taskCut(tasks1204, mutexPairs));

        /**
         * 2021.03.05 - 1 最长空闲内存
         * @sin 2021.12.01 23:20
         * @end 2021.12.01 23:59
         */
        PrintUtil.printTitle("2021.03.05 - 1 最长空闲内存");
        String memory0305_1 = "..x..x..xx...";
        String memory0305_2 = "....x.";
        String memory0305_3 = "xxxxx";
        System.out.println(new MaxIdleMemory().maxIdleMemory(memory0305_1, 2));
        System.out.println(new MaxIdleMemory().maxIdleMemory(memory0305_2, 2));
        System.out.println(new MaxIdleMemory().maxIdleMemory(memory0305_3, 0));

        /**
         * 07.23-1 展厅合适人数上限
         * 总预约人数上限，以及各展厅预约人数。设置一个上限，使得总预约人数小于total
         * @sin 2021.11.17 00:00
         * @end 2021.11.17 01:10
         */
        PrintUtil.printTitle("07.23-1 展厅合适人数上限");
        int max0723 = 4;
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(new MaxLimit().maxLimit(max0723, nums));

        /**
         * 2021.09.03 - 2 船票预订系统设计
         *
         * @sin 2021.12.04 23:50
         * @end 2021.12.07 00:44
         */
        PrintUtil.printTitle("2021.09.03 - 2 船票预订系统设计");
        int[] ticket = new int[]{10, 1};
        TicketSystem ts = new TicketSystem(ticket);
        // example 1
//        System.out.println(ts.book(71, 0, 2));      // true
//        System.out.println(ts.book(73, 0, 10));     // false
//        System.out.println(ts.book(72, 0, 2));      // true
//        System.out.println(ts.query(72));                        // 2
//        System.out.println(ts.book(74, 0, 2));      // true
//        System.out.println(ts.cancel(73));                       // true
//        System.out.println(ts.query(74));                        // 4
//        System.out.println(ts.query(72));                        // 2
//        System.out.println(ts.cancel(72));                       // true
//        System.out.println(ts.book(75, 0, 3));      // true
//        System.out.println(ts.query(75));                        // 2
//        System.out.println(ts.cancel(75));                       // true
//        System.out.println(ts.book(76, 0, 2));      // true
//        System.out.println(ts.book(77, 0, 2));      // true
//        System.out.println(ts.query(77));                        // 6
//        System.out.println(ts.cancel(76));                       // true
//        System.out.println(ts.book(78, 0, 3));      // true
//        System.out.println(ts.query(78));                        // 2

        // example 2
        System.out.println(ts.book(71, 0, 10));      // true
        System.out.println(ts.book(72, 0, 1));       // false
        System.out.println(ts.book(73, 0, 2));       // false
        System.out.println(ts.book(74, 0, 3));       // false
        System.out.println(ts.book(75, 0, 4));       // false
        System.out.println(ts.cancel(71));                        // true
        System.out.println(ts.query(72));                         // 0
        System.out.println(ts.query(73));                         // 1
        System.out.println(ts.query(74));                         // 3
        System.out.println(ts.query(75));                         // 6


        /**
         * 10.22-1 子字符串个数
         * 字符串 A 和 B，求 A 中包含 B 所有字符的子字符串的个数
         * 例如：012345678
         *      DABCDEABC & ABC
         * 输出：f(0) + f(1) + f(2) + f(3) + f(4) + f(5) + f(6) + f(7) + f(8)
         *      6    + 6    + 3    + 2    + 1    + 1    + 1    + 0    + 0
         *     =20
         * @sin 2021.10.15 00:00
         * @end 2021.10.15 01:00
         */
        PrintUtil.printTitle("10.22-1 子字符串个数");
        String str10221_1 = "DABCDEABC";
        String str10221_2 = "ABCC";
        System.out.println(new SubStr().subStr(str10221_1, str10221_2));

        /**
         * 10.22-3 最便宜往返机票（专业级第3题）
         * @sin 2021.11.13 23:40
         * @end 2021.11.14 01:05
         */
        PrintUtil.printTitle("10.22-3 最便宜往返机票（专业级第3题）");
        int[] goArr = new int[]{3, 2, 1, 2, 3};
        int[] rtArr = new int[]{1, 2, 3, 2, 1};
        Arrays.stream(new CheapestTicket().cheapestTicket(goArr, rtArr, 1, 1)).forEach(System.out::println);
    }
}

class Compress {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param words string字符串
     * @return string字符串
     */
    public String compress (String words) {
        while (words.contains("[")) {
            int right = words.indexOf("]");
            int left = words.lastIndexOf("[", right);
            String subStr = words.substring(left + 1, right);
            String[] s = subStr.split("\\|");
            int times = Integer.parseInt(s[0]);
            words = words.replace(words.substring(left, right + 1),
                    String.join("", Collections.nCopies(times, s[1])));
        }
        return words;
    }
}

// 2020.12.04 - 1 任务规划
class TaskCut {
    public int taskCut(int[] tasks, int[][] mutexPairs) {
        List<Integer> muteList = new ArrayList<>();
        int res = 1;
        for (int task : tasks) {
            for (int k = 0; k < muteList.size(); k++) {
                if (task == muteList.get(k)) {
                    res++;
                    muteList.clear();
                }
            }
            for (int[] mutexPair : mutexPairs) {
                if (mutexPair[0] == task) {
                    muteList.add(mutexPair[1]);
                }
                if (mutexPair[1] == task) {
                    muteList.add(mutexPair[0]);
                }
            }
        }
        return res;
    }
}

// 2021.03.05 - 1 最长空闲内存
class MaxIdleMemory {
    public int maxIdleMemory(String memory, int cnt) {
        // 左右指针
        int l = 0;
        int r = 0;
        int maxLen = 0;
        while (r < memory.length()) {
            if (memory.charAt(r) == 'x') {
                cnt--;
            }
            while (cnt < 0) {
                if (memory.charAt(l++) == 'x') {
                    cnt++;
                }
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}

// 0723 - 1 展厅合适人数上限
class MaxLimit {
    public int maxLimit(int maxTotal, int[] nums) {
        int maxSingle = Integer.MIN_VALUE;
        int minSingle = Integer.MAX_VALUE;
        int total = 0;
        for (int v : nums) {
            total += v;
            maxSingle = Math.max(v, maxSingle);
            minSingle = Math.min(v, minSingle);
        }
        if (total <= maxTotal) {
            return maxSingle;
        }
        int r = (minSingle + maxSingle) / 2;
        int l = minSingle;
        int threshold = r;
        while (l < r) {
            int sum = calSum(threshold, nums);
            if (sum > maxTotal) {
                r = (r + l) / 2;
                threshold = r;
            } else if (sum < maxSingle) {
                l = (r + l) / 2;
                threshold = l;
            } else {
                return threshold;
            }
        }
        return calSum(l, nums) > maxTotal ? 0 : l;
    }

    private int calSum(int threshold, int[] nums) {
        int sum = 0;
        for (int v : nums) {
            sum += Math.min(v, threshold);
        }
        return sum;
    }
}

// 2021.09.03 - 2 船票预订系统设计
class TicketSystem {
    int[][] desk = new int[10][1000];
    int[] maxDeskEachCab = new int[1000];
    int[] surplusEachCab = new int[1000];
    WaitDeq[] wq = new WaitDeq[10];
    // 下标作为id，值作为该id所在cabinId；无则为-1
    int[] books = new int[1000];
    int numOfCab;

    public TicketSystem(int[] cabins) {
        numOfCab = cabins.length;
        Arrays.fill(books, -1);
        Arrays.fill(wq, new WaitDeq());
        for (int i = 0; i < numOfCab; i++) {
            Arrays.fill(desk[i], -1);
            surplusEachCab[i] = cabins[i];
        }
        System.arraycopy(cabins, 0, maxDeskEachCab, 0, numOfCab);
    }

    public boolean book(int id, int cabinId, int num) {
        // 剩余数量小于num，放入候补队列
        int temp = num;
        if (surplusEachCab[cabinId] < num) {
            wq[cabinId].list.add(new MapNum(id, num));
            return false;
        }
        // 大于，则置desk[cabin]相应座位为id（id为全局唯一）
        help(id, cabinId, num, temp);
        return true;
    }

    /**
     * 取消
     *
     * @param id 订单号
     * @return 是否取消成功
     */
    public boolean cancel(int id) {
        boolean isInBooked = query(id) != -1; // 不等于 -1 则在预定系统里
        boolean isInWq = inWaitDeq(id) != -1;
        // 既不在预定系统也不在候补队列
        if (!isInBooked && !isInWq) {
            return false;
        }
        if (isInBooked) {
            // 在预定系统里
            int cabinId = books[id];
            for (int i = 0; i < maxDeskEachCab[cabinId]; i++) {
                if (desk[cabinId][i] == id) {
                    // 重置为-1，并且canbin的剩余座位加一
                    desk[cabinId][i] = -1;
                    surplusEachCab[cabinId]++;
                }
            }
            // 重置id 对应canbinId
            books[id] = -1;
            while (wq[cabinId].list.size() >0 && (surplusEachCab[cabinId] >= wq[cabinId].list.getFirst().num)) {
                int num = wq[cabinId].list.getFirst().num;
                int temp = num;
                // 大于，则置desk[cabin]相应座位为id（id为全局唯一）
                help(wq[cabinId].list.getFirst().id, cabinId, num, temp);
                wq[cabinId].list.removeFirst();
            }
        } else {
            // 在候补队列里
            int cabinId = inWaitDeq(id);
            while (surplusEachCab[cabinId] >= wq[cabinId].list.getFirst().num) {
                int num = wq[cabinId].list.getFirst().num;
                int temp = num;
                // 大于，则置desk[cabin]相应座位为id（id为全局唯一）
                help(id, cabinId, num, temp);
                wq[cabinId].list.removeFirst();
            }
        }
        return true;
    }

    private void help(int id, int cabinId, int num, int temp) {
        for (int k = 0; k < maxDeskEachCab[cabinId] && temp > 0; k++) {
            if (desk[cabinId][k] == -1) {
                desk[cabinId][k] = id;
                temp--;
            }
        }
        books[id] = cabinId;
        surplusEachCab[cabinId] -= num;
    }

    public int query(int id) {
        int cabinId = books[id];
        if (cabinId != -1) {
            for (int i = 0; i < maxDeskEachCab[cabinId]; i++) {
                if (desk[books[id]][i] == id) {
                    return i;
                }
            }
        }
        return -1;
    }

    private int inWaitDeq(int id) {
        for (int i = 0; i < numOfCab; i++) {
            for (MapNum m : wq[i].list) {
                if (m.id == id) {
                    return i;
                }
            }
        }
        return -1;
    }

    class WaitDeq {
        Deque<MapNum> list = new LinkedList<>();
//
//        public void add(int idInput, int num) {
//            list.add(new MapNum(idInput, num));
//        }
//
//        public void delete(int idInput) {
//            list.removeIf(m -> m.id == idInput);
//        }
    }

    class MapNum {
        int id;
        int num;

        public MapNum(int id, int num) {
            this.id = id;
            this.num = num;
        }
    }

}

// 1022 - 1 子字符串个数
class SubStr {
    public long subStr(String messages, String keys) {
        // window：实时记录当前子串中各个字符的个数
        Map<Character, Integer> window = new HashMap<>();
        // 记录keys 中各个字符的个数
        Map<Character, Integer> pattern = new HashMap<>();
        for (int i = 0; i < keys.length(); i++) {
            if (pattern.get(keys.charAt(i)) == null) {
                pattern.put(keys.charAt(i), 1);
            } else {
                pattern.put(keys.charAt(i), pattern.get(keys.charAt(i)) + 1);
            }
        }
        long res = 0;
        // i, j：左右窗
        int i = 0;
        int j = 0;
        while (i <messages.length() && j < messages.length()) {
            while (!match(window, pattern) && j < messages.length()) {
                if (window.get(messages.charAt(j)) == null) {
                    window.put(messages.charAt(j), 1);
                } else {
                    window.put(messages.charAt(j), window.get(messages.charAt(j)) + 1);
                }
                j++;
            }
            while (match(window, pattern) && i < messages.length()) {
                res += messages.length() - j + 1;
                window.put(messages.charAt(i), window.get(messages.charAt(i)) - 1);
                i++;
            }
        }
        return res;
    }

    private boolean match(Map<Character, Integer> window, Map<Character, Integer> pattern) {
        if (window.isEmpty()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : pattern.entrySet()) {
            // 一旦当前子串window中不包含keys中的字符，则不匹配
            if (window.get(entry.getKey()) == null || window.get(entry.getKey()) == 0) {
                return false;
            }
        }
        return true;
    }
}

// 1022 - 2 实验室预约系统
class BookinSystem {
    // 存放实验室 & 实验室开放的时段
    private final Map<Integer, List<Integer[]>> labMap = new HashMap<>();

    // 存放特定实验室的可预约时段
    private final Map<Integer, Set<Integer>> labCanBookTime = new HashMap<>();

    // 实验室
    private final List<Integer> labList = new ArrayList<>();

    //
    private final Map<Integer, Integer[]> bookRecord = new HashMap<>();

    public BookinSystem() {

    }

    public boolean addLab(int labId, int startTime, int endTime) {
        List<Integer[]> timeList = new ArrayList<>();
        Set<Integer> canBookTime = new HashSet<>();
        if(labMap.containsKey(labId)) {
            timeList = labMap.get(labId);
            if(hasOverTime(timeList, startTime, endTime)) {
                return false;
            }
            canBookTime = labCanBookTime.get(labId);
        } else {
            labList.add(labId);
        }
        timeList.add(new Integer[]{startTime, endTime});
        labMap.put(labId, timeList);
        for (int i = startTime; i < endTime; i++) {
            canBookTime.add(i);
        }
        labCanBookTime.put(labId, canBookTime);
        return true;
    }

    private boolean hasOverTime(List<Integer[]> timeList, int startTime, int endTime) {
        for(Integer[] time : timeList) {
            if(!(endTime <= time[0] || startTime >= time[1])) {
                return true;
            }
        }
        return false;
    }

//    public int bookTime(int recordId, int fromTime, int toTime) {
//        for (Integer labId : labList) {
//            if (canBookLa)
//        }
//    }
}

// 1022 - 3 最便宜往返机票
class CheapestTicket {
    public int[] cheapestTicket(int[] goArr, int[] rtArr, int minDays, int maxDays) {
        // 停留的第min & max天之间的最便宜的返程机票的【坐标】
        int[] minRtTicInMinMaxDay = new int[goArr.length];
        int i;
        int k = minDays;
        Deque<Integer> minRtTic = new LinkedList<>();
        // 寻找minRtTicInMinMaxDay
        for (i = minDays; i <= maxDays; i++) {
            while (!minRtTic.isEmpty() && rtArr[minRtTic.getLast()] > rtArr[i]) {
                minRtTic.pollLast();
            }
            minRtTic.addLast(i);
        }
        minRtTicInMinMaxDay[k] = minRtTic.getFirst();
        for (; i < goArr.length; i++) {
            if (rtArr[k] == rtArr[minRtTic.getFirst()]) {
                minRtTic.pollFirst();
            }
            while (!minRtTic.isEmpty() && rtArr[minRtTic.getLast()] > rtArr[i]) {
                minRtTic.pollLast();
            }
            minRtTic.addLast(i);
            minRtTicInMinMaxDay[++k] = minRtTic.getFirst();
        }
        while (i < goArr.length + maxDays - minDays) {
            if (minRtTic.getFirst() == k) {
                minRtTic.pollFirst();
            }
            minRtTicInMinMaxDay[++k] = minRtTic.getFirst();
            i++;
        }
        //
        int minCost = Integer.MAX_VALUE;
        int[] rt = new int[2];
        for (int j = 0; j < goArr.length - minDays; j++) {
            int cost = goArr[j] + rtArr[minRtTicInMinMaxDay[j + minDays]];
            if (cost < minCost) {
                minCost = cost;
                rt = new int[]{j, minRtTicInMinMaxDay[j + minDays]};
            }
        }
        return rt;
    }
}