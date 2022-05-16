package com.kuang.syn;


//案例一： 不安全的买票
//线程不安全，有人拿到负数
public class UnsafeBuyTicket {

  public static void main(String[] args) {
    BuyTicket buyTicket = new BuyTicket();

    new Thread(buyTicket,"小明").start();
    new Thread(buyTicket,"小花").start();
    new Thread(buyTicket,"黄牛").start();

  }
}

class BuyTicket implements Runnable{
  //定义一个票数
  private int ticketNums = 10;
  boolean flag = true;   //外部停止方式

  @Override
  public void run() {
    //买票
    while (flag){
      buy();
    }
  }

  //synchronized  同步方法，锁的是this 就是BuyTicket.class
  private synchronized void buy(){
    //判断是否有票
    if(ticketNums <= 0){
      flag = false;
      return;
    }

    //模拟延迟
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    //买到票
    System.out.println(Thread.currentThread().getName()+"拿到第"+ticketNums--+"票");
  }

}
