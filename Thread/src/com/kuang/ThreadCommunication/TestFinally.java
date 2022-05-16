package com.kuang.ThreadCommunication;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//多线程总结: 回顾线程的创建
public class TestFinally {
  public static void main(String[] args) {
    new MyThread1().start();

    new Thread(new MyThread2()).start();

    MyThread3 myThread3 = new MyThread3();
    ExecutorService service = Executors.newFixedThreadPool(1);
    service.submit(myThread3);

    service.shutdown();

  }
}

//1.继承Thread类
class MyThread1 extends Thread{
  @Override
  public void run() {
    System.out.println("MyThread1");
  }
}

//2，实现Runnable接口
class MyThread2 implements Runnable{
  @Override
  public void run() {
    System.out.println("MyThread2");
  }
}

//3.实现Callable接口
class MyThread3 implements Callable<Integer>{
  @Override
  public Integer call() throws Exception {
    System.out.println("MyThread3");
    return null;
  }
}

