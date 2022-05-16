package com.kuang.lock;


import java.util.concurrent.locks.ReentrantLock;

//测试lock锁
public class TestLock {

  public static void main(String[] args) {
    TestLock2 testLock2 = new TestLock2();

    new Thread(testLock2).start();
    new Thread(testLock2).start();
    new Thread(testLock2).start();
    new Thread(testLock2).start();

  }
}

class TestLock2 implements Runnable{

  int ticketNums = 10;

  //定义lock锁
  private final ReentrantLock lock = new ReentrantLock();

  @Override
  public void run() {
    while (true){

      try{
        lock.lock();//对资源加上锁
        if(ticketNums > 0){
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.println("还有"+ticketNums-- + "张票");
        } else {
          break;
        }
      }finally {
        lock.unlock();
      }
    }
  }
}
