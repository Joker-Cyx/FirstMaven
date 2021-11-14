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
         * 10.22 - 1 子字符串个数
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
         * 10.22 - 3 最便宜往返机票（专业级第3题）
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

// 1022 -1 子字符串个数
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