package com.kuang.demo1;

public class TestThread3 implements Runnable {
  @Override
  public void run() {
    //run方法线程体
    for(int i = 0; i < 20;i++){
      System.out.println("我在看代码----"+i);
    }
  }

  public static void main(String[] args) {
    //创建Runnable接口的实现类对象
    TestThread3 testThread3 = new TestThread3();

    //创建多线程对象，通过线程对象来开启我们的线程，代理
    Thread thread = new Thread(testThread3);

    //调用START()方法开启线程
    thread.start();

    //上面两句代码等同于下面一句
//    new Thread(testThread3).start();


    for(int i = 0; i < 20;i++){
      System.out.println("我在学习多线程----"+i);
    }
  }
}
