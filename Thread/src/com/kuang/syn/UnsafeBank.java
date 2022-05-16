package com.kuang.syn;


//不安全取钱
//两个人去银行取钱，账户
public class UnsafeBank {

  public static void main(String[] args) {
    //1.创建一个账户
    Account account = new Account(1000, "结婚基金");

    //2.创建两个人分别取钱
    Drawing you = new Drawing(account, 50, "你自己");
    Drawing wife = new Drawing(account, 100, "妻子");

    //3.启动线程
    you.start();
    wife.start();

  }
}


//账户
class Account{
  int money;  //余额
  String name;//卡名

  public Account(int money, String name) {
    this.money = money;
    this.name = name;
  }
}


//银行:模拟取款
class Drawing extends Thread{

  Account account;  //账户
  int drawingMoney;   //取了多少钱
  int nowMoney;   //现在手里多少钱

  public Drawing(Account account,int drawingMoney,String name){
    super(name);  //继承父类的属性
    this.account = account;
    this.drawingMoney = drawingMoney;
  }

  //取钱
  @Override
  public void run() {

    //锁的对象就是变化的量，增，删，改
    synchronized (account){
      //判断有没有钱
      if(account.money - drawingMoney < 0){ //账户的钱不够取的
        System.out.println(Thread.currentThread().getName()+"钱不够，取不了");
        return;
      }

      //模拟一个延迟，这样两个人都是看到余额是100
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      //卡内余额 = 余额 - 你取的钱
      account.money = account.money - drawingMoney;
      //你手里的钱
      nowMoney = nowMoney + drawingMoney;

      System.out.println(account.name+"余额为："+account.money);
      // Thread.currentThread().getName() = this.getName()   Drawing继承了Thread类，便有了Thread里面的属性,即name属性
      System.out.println(this.getName()+"手里的钱有"+nowMoney);
      }
    }

}
