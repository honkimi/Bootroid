package com.honkimi.bootroid.utils;

import android.content.Context;
import android.text.format.Time;

import com.honkimi.bootroid.R;
import com.honkimi.bootroid.application.ApplicationController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by honkimi on 14/11/28.
 */
public class DateUtil {
    private final static long DAY_MILLS = 24 * 60 * 60 * 1000;

    public static String formatTime(int time) {
        Context context = ApplicationController.getInstance().getApplicationContext();
        return String.format(context.getString(R.string.time_format), time);
    }

    public static String parseAndFormat(String targetDate, int formatResId) {
        String result = targetDate;
        Date date = parseDate(targetDate);
        if (date != null) {
            result = formatDate(date, formatResId);
        }
        return result;
    }

    public static String formatDate(Date date, int formatResId) {
        Context context = ApplicationController.getInstance().getApplicationContext();
        Time time = new Time();
        time.set(date.getTime());
        return time.format(context.getString(formatResId));
    }

    public static Date parseDate(String targetDate) {
        return parseDate(targetDate, R.string.date_parse_in);
    }

    public static Date parseDate(String targetDate, int formatId) {
        Context context = ApplicationController.getInstance().getApplicationContext();
        SimpleDateFormat formatIn = new SimpleDateFormat(context.getString(formatId));
        Date date = null;
        try {
            date = formatIn.parse(targetDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static boolean isSameDay(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("The dates must not be null");
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        return isSameDay(cal1, cal2);
    }

    public static boolean isSameDay(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null) {
            throw new IllegalArgumentException("The dates must not be null");
        }
        return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) &&
                cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
    }

    public static boolean isToday(Date date) {
        return isSameDay(date, Calendar.getInstance().getTime());
    }

    public static boolean isOverToday(Date date) {
        Date today = new Date();
        return !isToday(date) && date.getTime() > today.getTime();
    }

    public static boolean isOverXDays(Date date, int x) {
        return (new Date().getTime() + x * DAY_MILLS) < date.getTime();
    }

    public static Date advance(Date origin, long advanceMill) {
        return new Date(origin.getTime() + advanceMill);
    }
}
