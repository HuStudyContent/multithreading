package com.kuang.lock;


//死锁：多个线程相互抱着对方需要的资源，然后形成僵持
//解决：一个锁只能锁一个对象
public class DeadLock {
  public static void main(String[] args) {
    Makeup makeup = new Makeup(0,"灰姑娘");
    Makeup makeup1 = new Makeup(1, "白雪公主");

    makeup.start();
    makeup1.start();
  }
}

//口红
class Lipstick{

}

//镜子
class Mirror{

}


class Makeup extends Thread{

  //需要的资源只有一份，用static来保证只有一份
  static Lipstick lipstick = new Lipstick();
  static Mirror mirror = new Mirror();

  int choice;   //选择
  String girlName;  //使用化妆品的人

  Makeup(int choice,String girlName){
    this.choice = choice;
    this.girlName = girlName;
  }

  @Override
  public void run() {
    //化妆
    try {
      makeup();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  //化妆，相互持有对方的锁，就是需要拿到对方的资源
  private void makeup() throws InterruptedException {
    if(choice ==0){
      synchronized (lipstick){  //获得口红的锁
        System.out.println(this.girlName+"获得了口红的锁");
        Thread.sleep(1000);
//        synchronized (mirror){ //一秒后，想要获得镜子
//          System.out.println(this.girlName+"获得镜子的锁");
//        }
      }
      //避免死锁
      synchronized (mirror){ //一秒后，想要获得镜子
        System.out.println(this.girlName+"获得镜子的锁");
      }
    }else{
      synchronized (mirror){  //获得镜子的锁
        System.out.println(this.girlName+"获得了镜子的锁");
        Thread.sleep(2000);
//        synchronized (lipstick){ //2秒后，想要获得口红
//          System.out.println(this.girlName+"获得口红的锁");
//        }
      }
      //避免死锁
      synchronized (lipstick){ //2秒后，想要获得口红
        System.out.println(this.girlName+"获得口红的锁");
      }
    }
  }

}

