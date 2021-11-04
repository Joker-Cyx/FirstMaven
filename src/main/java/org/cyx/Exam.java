package org.cyx;

import org.cyx.util.PrintUtil;

import java.util.Collections;

public class Exam {
    public static void main(String[] args) {

        /**
         * 字符串解压缩
         * String.indexOf()
         * String.lastIndexOf(int, fromIdx);
         * String.replace(tar, rep);
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