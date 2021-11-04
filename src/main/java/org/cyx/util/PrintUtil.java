package org.cyx.util;

public class PrintUtil {
    // help print title
    public static void printTitle(String title) {
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
