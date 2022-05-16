package com.kuang.state;


//观察测试线程的状态
public class TestState {

  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(() -> {
      //这个循环等于让线程等待了5s
      for(int i = 0;i < 5;i++){
        try {
          Thread.sleep(1000);  //没执行一次休息1s
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.println("***********");
    });

    //观察状态
    Thread.State state = thread.getState();
    System.out.println(state);   //NEW  新生的状态

    //观察启动后
    thread.start();
    state = thread.getState();  //重新获取状态
    System.out.println(state);   //Run  正在运行的状态

    while (state != Thread.State.TERMINATED){ //只要线程不终止，就一直输出他当前的状态
      Thread.sleep(100);
      state = thread.getState();    //更新线程状态，不然while循环一直出不去
      System.out.println(state);
    }

    //死亡之后的线程不能再重新启动，启动后会报异常
//    thread.start();
  }
}
