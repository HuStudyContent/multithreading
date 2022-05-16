package com.kuang.demo1;


//创建方式一： 继承Thread类，重写run()方法，调用start开启线程
//总结：注意，线程开启不一定是立即执行，有cpu决定
public class TestThread1 extends Thread {

  @Override
  public void run() {
    //run方法线程体
    for(int i = 0; i < 20;i++){
      System.out.println("我在看代码----"+i);
    }
  }

  public static void main(String[] args) {
    //main 主线程

    //创建一个线程对象
    TestThread1 testThread1 = new TestThread1();

    //调用START()方法开启线程
    testThread1.start();


    for(int i = 0; i < 20;i++){
      System.out.println("我在学习多线程----"+i);
    }
  }

}
