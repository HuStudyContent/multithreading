package com.kuang.state;


//测试守护线程
//案例： 上帝守护你
public class TestDaemon {

  public static void main(String[] args) {
    God god = new God();
    You you = new You();

    Thread thread = new Thread(god);
    thread.setDaemon(true);     //默认是false，表示是用户线程，正常的线程都是用户线程，改成true代表是守护线程

    thread.start();  //线程启动


    Thread thread1 = new Thread(you);
    thread1.start();  //你启动

  }
}

//上帝
class God implements Runnable{
  @Override
  public void run() {
    while (true){
      System.out.println("上帝一生保护你");
    }
  }
}


//你
class You implements Runnable{
  @Override
  public void run() {
    for(int i = 0;i< 3650;i++){
      System.out.println("你一生都快乐的活着");
    }
    System.out.println("******goodbye world**********");
  }
}


