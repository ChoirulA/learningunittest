package com.infosys.learning;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtilsTest {
    Date date;
    String resultFormat;

    @Before
    public void init(){
        date = Date.from(LocalDate.of(2019, 01, 22).atStartOfDay(ZoneId.systemDefault()).toInstant());
        resultFormat = new DateUtils().dateTimeToFormat(date, "yyyyMMMdd");
        System.out.println(resultFormat);
    }

    @Test
    public void dateTimeFormat_shouldSuccess(){
        Assert.assertEquals("2019Jan22", resultFormat);
    }

    @Test
    public void dateTimeFormat_shouldNotSuccess(){
        Assert.assertEquals("2018Jan22", resultFormat);
    }
}
