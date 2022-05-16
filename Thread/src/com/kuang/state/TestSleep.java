package com.kuang.state;

//模拟网络延迟 放大问题的发生性
public class TestSleep implements Runnable {

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
    TestSleep ticket = new TestSleep();

    new Thread(ticket,"小红").start();
    new Thread(ticket,"小明").start();
    new Thread(ticket,"小黄牛").start();
  }
}
