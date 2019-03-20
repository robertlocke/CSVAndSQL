package com.github.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static final String format = "yyyy-MM-dd HH:mm:ss.FF";

    public static Date format(String date) {
        if (date == null) throw new IllegalArgumentException("date cannot be null");
        try {
            return new SimpleDateFormat(format).parse(date);
        }
        catch (ParseException e) {
            return null;
        }
    }

    public static String format(Date date) {
        if (date == null) throw new IllegalArgumentException("date cannot be null");
        return new SimpleDateFormat(format).format(date);
    }

}
