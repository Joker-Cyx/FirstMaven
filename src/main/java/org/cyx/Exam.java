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