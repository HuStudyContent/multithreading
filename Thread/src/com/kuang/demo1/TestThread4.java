package com.kuang.demo1;

//多个线程同时操作同一个对象  买护着票案例

//发现问题： 多个线程操作同一个资源 的情况下，线程不安全，数据混乱
public class TestThread4 implements Runnable {

  //总的票数
  private int ticketNums = 10;

  @Override
  public void run() {
    while(true){

      if(ticketNums <= 0){
        break;
      }
      //模拟延迟
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.println(Thread.currentThread().getName() + "--------->拿到了第"+ ticketNums-- +"--张票");
    }
  }


  public static void main(String[] args) {
    TestThread4 ticket = new TestThread4();

    new Thread(ticket,"小红").start();
    new Thread(ticket,"小明").start();
    new Thread(ticket,"小黄牛").start();
  }
}
