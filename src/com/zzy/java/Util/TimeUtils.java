package com.zzy.java.Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TimeUtils {

    public static void main(String[] args) {
        long now = System.currentTimeMillis();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
//        Date date = new Date(now);
//        System.out.println("now:" + simpleDateFormat.format(date) + " diff:" + simpleDateFormat.format(getDateWithDiff(date, -4)));

        System.out.println(makeDateList(1667825467000L, 1667825480000L));

    }

    public static long parseTime(String timeStr, String format) {
        long timeStamp;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            timeStamp = dateFormat.parse(timeStr).getTime();
        } catch (ParseException e) {
            timeStamp = -1;
        }
        return timeStamp;
    }

    /**
     * 将long型的时间戳转换为固定格式
     */
    public static String getTimeFormat(long time, String format) {
        if (time < 0) return null;
        Date date = new Date(time);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.US);
        return simpleDateFormat.format(date);
    }

    /**
     * 获取相对于当前日期相差几天的日期
     * @param date 参照日期
     * @param diff 日期偏移
     * @return 偏移后的日期
     */
    public static Date getDateWithDiff(Date date, int diff) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, diff);
        return calendar.getTime();
    }


    /**
     * 获取两个日期间相差的天数
     * @param date1 参照日期
     * @param date2 目标日期
     * @return 目标日期相对于参照日期的相差天数
     */
    public static int getDiffDays(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        calendar1.set(Calendar.HOUR_OF_DAY, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);
        calendar1.set(Calendar.MILLISECOND, 0);

        Calendar calender2 = Calendar.getInstance();
        calender2.setTime(date2);
        calender2.set(Calendar.HOUR_OF_DAY, 0);
        calender2.set(Calendar.MINUTE, 0);
        calender2.set(Calendar.SECOND, 0);
        calender2.set(Calendar.MILLISECOND, 0);

        return (int) (calendar1.getTime().getTime() - calender2.getTime().getTime()) / (24 * 3600 * 1000);
    }


    private static final long DAY_MILLS = 24 * 60 * 60 * 1000;

    public static Set<String> makeDateList(long start, long end) {
        Set<String> dates = new HashSet<>();
        long left = start % DAY_MILLS;
        long startDay = start - left;
        dates.add(makeTimeStampToDateStr(startDay));
        while ((startDay + DAY_MILLS) <= end) {
            startDay += DAY_MILLS;
            dates.add(makeTimeStampToDateStr(startDay));
        }
        return dates;
    }

    public static String makeTimeStampToDateStr(long time) {
        Date date = new Date(time);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.US);
        return simpleDateFormat.format(date);
    }

}
