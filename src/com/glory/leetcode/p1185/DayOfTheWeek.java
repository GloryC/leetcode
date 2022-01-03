package com.glory.leetcode.p1185;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhanggc
 * @date 2021-05-08 09:32:50
 */
public class DayOfTheWeek {

    static class Solution {
        /**
         * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
         * <p>
         * 输入为三个整数：day、month 和 year，分别表示日、月、年。
         * <p>
         * 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
         * <p>
         * <p>
         * 示例 1：
         * <p>
         * 输入：day = 31, month = 8, year = 2019
         * 输出："Saturday"
         * <p>
         * 示例 2：
         * <p>
         * 输入：day = 18, month = 7, year = 1999
         * 输出："Sunday"
         */
        public String dayOfTheWeek(int day, int month, int year) {
            try {
                String dateString = String.format("%04d-%02d-%02d", year, month, day);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = sdf.parse(dateString);
                String subDayOfWeek = date.toString().substring(0, 3);
                switch (subDayOfWeek) {
                    case "Sun":
                        return "Sunday";
                    case "Mon":
                        return "Monday";
                    case "Tue":
                        return "Tuesday";
                    case "Wed":
                        return "Wednesday";
                    case "Thu":
                        return "Thursday";
                    case "Fri":
                        return "Friday";
                    case "Sat":
                        return "Saturday";
                    default:
                        return "";
                }
            } catch (ParseException e) {
                e.printStackTrace();
                return "";
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.dayOfTheWeek(18, 7, 1999));
    }

}