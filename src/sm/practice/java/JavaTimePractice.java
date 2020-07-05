package sm.practice.java;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class JavaTimePractice {

    public void test() {

        System.out.println("Date: " + LocalDate.now());
        System.out.println("Time: " + LocalTime.now());
        System.out.println("Datetime: " + LocalDateTime.now());

        System.out.println(Instant.ofEpochMilli(0));
        System.out.println(Instant.ofEpochMilli(1000));
        System.out.println("Instant.now(): " + Instant.now());

    }

}
