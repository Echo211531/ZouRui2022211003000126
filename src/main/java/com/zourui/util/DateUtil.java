package com.zourui.util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static java.sql.Date convertUtilToSql(Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    public static Date convertSQLToUtil(java.sql.Date uDate) {
        java.util.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    public static Date convertStringToUtil(String sDate) {
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("yyyy-mm-dd").parse(sDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1;

    }

    public static String convertUtiltoString(Date  uDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String strDate = dateFormat.format(uDate);
        return strDate;
    }
//    @SuppressWarnings("deprecation")
//    public static void main(String a[]){
//        System.out.println(DateUtil.convertUtilToSql(new Date()));
//        System.out.println(DateUtil.convertSQLToUtil(new java.sql.Date(1999, 9, 9)));
//
//        System.out.println(DateUtil.convertStringToUtil("1999-09-09"));
//
//        System.out.println(DateUtil.convertUtiltoString(new Date()));
//    }
}
