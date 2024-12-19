package study.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtils {

    /**
     * 获取两个日期之间的所有日期列表（包括起始和结束日期）
     *
     * @param startDate 起始日期
     * @param endDate   结束日期
     * @return 日期列表
     * @throws IllegalArgumentException 如果起始日期在结束日期之后
     */
    public static List<Date> getAllDatesBetween(Date startDate, Date endDate) {
        List<Date> dateList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);

        Date currentDate;
        do {
            // 创建一个新的Date对象，以避免修改calendar.getTime()返回的原始Date对象
            currentDate = (Date) calendar.getTime().clone();
            dateList.add(currentDate);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        } while (!currentDate.after(endDate));

        return dateList;
    }

    public static void main(String[] args) {
        String a = "593046447";
//        Long a = 593046447;
        System.out.println(String.format("%010s", a));
    }
}
