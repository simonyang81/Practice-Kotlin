package sm.practice.java;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class JavaLocalDate {

    public void test() {

        var datetime = LocalDateTime.now();
        System.out.println("datetime: " + datetime);
        System.out.println(datetime.getYear() + "-" + datetime.getMonthValue() + "-" + datetime.getDayOfMonth());
        System.out.println(datetime.getHour() + ":" + datetime.getMinute() + ":" + datetime.getSecond());

        System.out.println("date: " + datetime.toLocalDate());
        System.out.println("time: " + datetime.toLocalTime());

        var now = LocalDate.of(2020, 7, 8);
        System.out.println(now.with(TemporalAdjusters.dayOfWeekInMonth(0, DayOfWeek.MONDAY)));

        // 当月第一天
        System.out.println(now.with(TemporalAdjusters.firstDayOfMonth()));
        // 当月最后一天
        System.out.println(now.with(TemporalAdjusters.lastDayOfMonth()));
        // 下个月第一天
        System.out.println(now.with(TemporalAdjusters.firstDayOfNextMonth()));

    }

}
