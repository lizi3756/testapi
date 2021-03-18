package com.lizi.utils;

import org.apache.poi.ss.usermodel.DateUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: lizi
 * @Date: 2020/10/26 7:34 下午
 */

/*
 * 入参：Date   Mon Oct 26 19:39:23 CST 2020
 * 返回：String   2020-10-26 19:39:23
 */
public class DateTool {
    public static String dataToString(Date date){
        //Date date= new Date();
        //Date date=new Date(1272958479586l);//参数为long类型
        //long time = date.getTime();//返回long类型
        SimpleDateFormat sFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = sFormat.format(date);
        return format;//返回的格式为：2020-10-26 19:39:23
    }
    /*
    * 入参：String   2020-10-26 19:39:23
    * 返回：Date   Mon Oct 26 19:39:23 CST 2020
    */
    public static Date stringToData(String data) throws ParseException {
        SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = sFormat.parse(data);
        return parse;

    }
    /*
    * Date转成 Calendar
    */
    public static Calendar dateToCalendar(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
    /*
     * Date转成 Calendar
     */
    public static Date calendarToDate(){
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        return date;
    }

    public static void main(String[] args) throws ParseException {
       // System.out.println(stringToData("2020-10-26 19:39:23"));
       /* Calendar c = Calendar.getInstance();
        int year =c.get(Calendar.YEAR);
        int month =c.get(Calendar.MONTH)+1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        c.setTime(new Date());
        //c.set(new Date());
        int year1 =c.get(Calendar.YEAR);
        int month1 =c.get(Calendar.MONTH)+1;
        int day1 = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(year1+"/"+month1+"/"+day1);*/
        Date date = DateUtil.parseYYYYMMDDDate("2020/10/26");
        //System.out.println(dataToString(date));
        System.out.println(System.currentTimeMillis());
    }
}
