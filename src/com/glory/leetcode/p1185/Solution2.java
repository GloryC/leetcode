package com.glory.leetcode.p1185;

/**
 * @author Glory
 * @date 2022/1/3 22:53
 */
public class Solution2 {

    /**
     * 通过查询日历可知，1970年 12 月 31 日是星期四，我们只需要算出输入的日期距离
     * 1970 年 12 月 31 日有几天，再加上 3 后对 7 求余，即可得到输入日期是一周中的第几天。
     */
    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        /* 输入年份之前的年份的天数贡献 */
        int days = 365 * (year - 1971) + (year - 1969) / 4;
        /* 输入年份中，输入月份之前的月份的天数贡献 */
        for (int i = 0; i < month - 1; ++i) {
            days += monthDays[i];
        }
        if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3) {
            days += 1;
        }
        /* 输入月份中的天数贡献 */
        days += day;
        return week[(days + 3) % 7];
    }

    public static void main(String[] args) {
        DayOfTheWeek.Solution solution = new DayOfTheWeek.Solution();
        System.out.println(solution.dayOfTheWeek(18, 7, 1999));
    }

}
