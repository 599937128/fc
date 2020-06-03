package com.lv.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TimeUtil {

    /**
     * 获取将两个时间点之间的时间,转化为小时
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static Double getHour(String startTime, String endTime) {

        // 设置转化时间格式
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
        Double finHour = null;
        try {
            Long result = sdf.parse(endTime).getTime() - sdf.parse(startTime).getTime() + sdfYear.parse("1970").getTime();
            Date dateResult = new Date(result);
            String finallyTime = sdf.format(dateResult).toString();
            Double hour = Double.valueOf(finallyTime.substring(0, 2));
            Double min = Double.valueOf(finallyTime.substring(3, 5)) / 60;
            Double second = Double.valueOf(finallyTime.substring(6, 8)) / 60 / 60;
            // 进行四舍五入
            Double finMIn = (double) Math.round(min * 100) / 100;
            Double finSec = (double) Math.round(second * 100) / 100;
            finHour = hour + finMIn + finSec;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return finHour;
    }

    /**
     * String 类型 转化为 Long 类型的毫秒数
     *
     * @param time
     * @return
     */
    public static Long stringToTime(String time) {

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Long finTime = null;
        try {
            finTime = sdf.parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return finTime;
    }

    /**
     * 获取当前时间转化为字符串,精确到秒
     *
     * @return
     */
    public static String dateToTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String finTime = sdf.format(new Date());
        return finTime;
    }

    /**
     * 获取当前时间转化为字符串,精确到秒 时间格式不加空格和分隔符
     *
     * @return
     */
    public static String getDateTime14String() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String finTime = sdf.format(new Date());
        return finTime;
    }

    /**
     * 获取当前时间转化为字符串,精确到年月日
     *
     * @return
     */
    public static String dateToMonthAndDay() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String finTime = sdf.format(new Date());
        return finTime;
    }

    /**
     * 获取现在时间的前一天时间
     *
     * @return
     */
    public static String getBeforeTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -1);
        Date time = calendar.getTime();
        String finTime = sdf.format(time);
        return finTime;
    }

    /**
     * 获取现在时间的上一个月的日期
     *
     * @return
     */
    public static String getBeforeMonthTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -1);
        Date time = calendar.getTime();
        String finTime = sdf.format(time);
        return finTime;
    }

    /**
     * 获取现在时间的前一分钟时间
     *
     * @return
     */
    public static String getBeforeMinute() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MINUTE, -1);
        Date time = calendar.getTime();
        String finTime = sdf.format(time);
        return finTime;
    }

    /**
     * 获取当月的第一天日期
     *
     * @return
     */
    public static String getMonthFirstDay() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String time = sdf.format(new Date());
        String firstDay = time.concat("-01");
        return firstDay;
    }


    /**
     * 获取当前的年月
     *
     * @return
     */
    public static String getYearAndMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String time = sdf.format(new Date());
        return time;
    }

    /**
     * 获得该月最后一天
     *
     * @return
     */
    public static String getLastDayOfMonth() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        String days = format.format(ca.getTime());
        return days;
    }

    /**
     * 获取上个月的年月
     *
     * @return
     */
    public static String getLastYearAndMonth() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -1);
        Date month = calendar.getTime();
        String yearAndMonth = format.format(month);
        return yearAndMonth;
    }

    /**
     * 获取上个月的年月的第一天
     *
     * @return
     */
    public static String getLastYearAndMonthFirstDay() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -1);
        Date month = calendar.getTime();
        String yearAndMonth = format.format(month).concat("-01");
        return yearAndMonth;
    }

    /**
     * 获取上个月的最后一天
     *
     * @return
     */
    public static String getLastDayOfLastMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        //设置为指定日期
        c.setTime(new Date());
        //指定日期月份减去一
        c.add(Calendar.MONTH, -1);
        //指定日期月份减去一后的 最大天数
        c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));
        //获取最终的时间
        Date lastDateOfPrevMonth = c.getTime();
        String days = sdf.format(lastDateOfPrevMonth);
        return days;
    }

    /**
     * 获取下个月的年月
     *
     * @return
     */
    public static String getNextYearAndMonth() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, +1);
        Date month = calendar.getTime();
        String yearAndMonth = format.format(month);
        return yearAndMonth;
    }

    /**
     * 获取下个月的年月
     *
     * @return
     */
    public static Long minuteToMillisecond(Long minute) {
        Long millisecond = minute * 60 * 1000;
        return millisecond;
    }

    /**
     * 根据开始时间和结束时间计算中间的日期和天数精确到两位
     *
     * @return
     */
    public static List<String> timeConvertDays(String startTime, String endTime) {
        List<String> dayList = new ArrayList<String>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sdf.parse(startTime));
            for (long d = calendar.getTimeInMillis(); d <= sdf.parse(endTime).getTime(); d = getConvertDays(calendar)) {
                dayList.add(sdf.format(d));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dayList;
    }

    private static long getConvertDays(Calendar calendar) {
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
        return calendar.getTimeInMillis();
    }

    /**
     * 根据传入的考勤时间段计算出当天的需要的工作时长
     *
     * @param attendTime
     * @return
     */
    public static Double getWorkTime(String attendTime) {

        // 转化为数组
        String[] attendTimeArray = attendTime.split(",");
        // 数组转化为集合
        List<String> attendList = Arrays.asList(attendTimeArray);
        Double hours = 0d;
        // 一天一次上下班打卡不休息
        if (attendList.size() == 1) {
            // 开始时间减去 结束时间即可
            String startFirstTime = attendList.get(0).substring(0, 5).concat(":59");
            String endFirstTime = attendList.get(0).substring(6, 11).concat(":00");
            hours = getHour(startFirstTime, endFirstTime);
        }

        if (attendList.size() == 2) {
            // 一天两次上下班 或者是一天一次上下班加上休息时间进行计算
            // 第一次上下班的时间的小时数  加上第二次上下班的小时数
            String startFirstTime = attendList.get(0).substring(0, 5).concat(":59");
            String endFirstTime = attendList.get(0).substring(6, 11).concat(":00");
            String startSecondTime = attendList.get(1).substring(0, 5).concat(":59");
            String endSecondTime = attendList.get(1).substring(6, 11).concat(":00");
            Double hourFirst = getHour(startFirstTime, endFirstTime);
            Double hourSecond = getHour(startSecondTime, endSecondTime);
            hours = hourFirst + hourSecond;
        }

        if (attendList.size() == 3) {
            // 一天三次上下班 时间统计
            // 第一次上下班的小时数 加上 最后两次上下班的小时数
            String startFirstTime = attendList.get(0).substring(0, 5).concat(":59");
            String endFirstTime = attendList.get(0).substring(6, 11).concat(":00");
            String startSecondTime = attendList.get(1).substring(0, 5).concat(":59");
            String endSecondTime = attendList.get(1).substring(6, 11).concat(":00");
            String startThirdTime = attendList.get(2).substring(0, 5).concat(":59");
            String endThirdTime = attendList.get(2).substring(6, 11).concat(":00");
            Double hourFirst = getHour(startFirstTime, endFirstTime);
            Double hourSecond = getHour(startSecondTime, endSecondTime);
            Double hourThird = getHour(startThirdTime, endThirdTime);
            hours = hourFirst + hourSecond + hourThird;
        }
        return hours;
    }

    /**
     * 根据传入的考勤时间段 获取第一次上班和最后一次下班考勤打卡的时间
     *
     * @param attendTime
     * @return
     */
    public static List<String> getStartEndCardTime(String attendTime) {

        List<String> cardTimeList = new ArrayList<String>();

        // 转化为数组
        String[] attendTimeArray = attendTime.split(",");
        // 数组转化为集合
        List<String> attendList = Arrays.asList(attendTimeArray);
        // 一天一次上下班打卡不休息
        if (attendList.size() == 1) {
            String startCardTime = attendList.get(0).substring(0, 5).concat(":00");
            String endEndTime = attendList.get(0).substring(6, 11).concat(":59");
            cardTimeList.add(startCardTime);
            cardTimeList.add(endEndTime);
        }

        if (attendList.size() == 2) {
            String startCardTime = attendList.get(0).substring(0, 5).concat(":00");
            String endEndTime = attendList.get(1).substring(6, 11).concat(":59");
            cardTimeList.add(startCardTime);
            cardTimeList.add(endEndTime);
        }

        if (attendList.size() == 3) {
            String startCardTime = attendList.get(0).substring(0, 5).concat(":00");
            String endEndTime = attendList.get(2).substring(6, 11).concat(":59");
            cardTimeList.add(startCardTime);
            cardTimeList.add(endEndTime);
        }
        return cardTimeList;
    }

    public static boolean isToday(final Date date) {
        long millis = date.getTime();
        long wee = getWeeOfToday();
        return millis >= wee && millis < wee + 86400000;
    }

    private static long getWeeOfToday() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    // 获取两个时间点的秒数差
    public static Long getMillisAToB(Long startTime, Long endTime) {
        Long finallyTime = (endTime - startTime)/1000;
        return finallyTime;
    }

    // 获取两段时间的时间差转化为分钟
    public static Long getMillisAToBFromStr(String startTime, String endTime) {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long minutes = 0L;
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = simpleFormat.parse(endTime);
            d2 = simpleFormat.parse(startTime);
            long diff = d1.getTime() - d2.getTime();//这样得到的差值是毫秒级别
            long days = diff / (1000 * 60 * 60 * 24);
            long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
            minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
        } catch (ParseException e) {
        }

        return minutes;
    }
}
