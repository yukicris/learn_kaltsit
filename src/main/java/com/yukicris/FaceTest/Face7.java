package com.yukicris.FaceTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Face7 {

    public static void main(String[] args) {
        getWeekend("2022-9-19","2022-9-30");
    }

    public static void getWeekend(String startDay,String endDay){
        //获取日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date sd = (Date) sdf.parse(startDay);
            Date ed = (Date) sdf.parse(endDay);
            Calendar c = Calendar.getInstance();
            c.setTime(sd);
            Calendar c1 = Calendar.getInstance();
            c1.setTime(ed);

            //星期天是0,星期一是1,他这个接口是按照返回参数来判断调用哪个接口,传入c.DAY_OF_WEEK=7,就是表明他要调用这个
            //判断日期是星期几的接口
            System.out.printf(""+(c.get(c.DAY_OF_WEEK)-1));
            System.out.printf(""+(c1.get(c1.DAY_OF_WEEK)-1));
            //这个过时了,会有个-
            // sd.getDay();

            //然后再来遍历日期,看其中工作日有那些天
            int result = 0;
            Calendar c2 = Calendar.getInstance();
            while(sd.compareTo(ed)<=0){
                c2.setTime(sd);
                System.out.printf(""+(c2.get(c2.DAY_OF_WEEK)-1));
                if((c2.get(c2.DAY_OF_WEEK)-1)!=6 &&(c2.get(c2.DAY_OF_WEEK)-1)!=0 ){
                    result++;
                }
                sd.setDate(sd.getDate()+1);
            }
            System.out.printf("工作日有"+result+"天");
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
