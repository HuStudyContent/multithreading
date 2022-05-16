package com.kuang.state;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestStop3 {

  //获取当前系统时间
  public static void main(String[] args) {
    Date startTime = new Date(System.currentTimeMillis());   //获取系统当前时间

    while (true){
      try {
        Thread.sleep(1000);  //每次间隔1s
        System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));  //打印当前时间
        startTime = new Date(System.currentTimeMillis());  //更新当前时间
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }
  }

}
