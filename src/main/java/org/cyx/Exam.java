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
         * 10.22 最便宜往返机票（专业级第3题）
         * @sin 2021.11.13 23:40
         * @end 2021.11.14 01:05
         */
        PrintUtil.printTitle("10.22 最便宜往返机票（专业级第3题）");
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
                    String.join("", Collections.nCopies(times, s[1]))) ;
        }
        return words;
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