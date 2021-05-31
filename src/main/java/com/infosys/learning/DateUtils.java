package com.infosys.learning;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public String dateTimeToFormat(Date date, String format){
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }
}
