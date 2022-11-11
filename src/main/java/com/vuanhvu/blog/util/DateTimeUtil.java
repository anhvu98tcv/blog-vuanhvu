package com.vuanhvu.blog.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {

    public static final String DDMMYYYY = "dd/MM/yyyy";

    public static Date convertStringToDate(String dateStr, String dateFormat) throws Exception {
        if (Common.isNullOrEmpty(dateFormat)) {
            return new SimpleDateFormat(DDMMYYYY).parse(dateStr);
        }
        return new SimpleDateFormat(dateFormat).parse(dateStr);
    }

}
