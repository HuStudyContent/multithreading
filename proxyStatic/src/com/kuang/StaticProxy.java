package com.kuang;


//静态代理模式总结
//真实对象和代理对象都要实现同一个接口
//代理对象要代理真实角色

//好处：
//代理对象可以做很多真实对象做不了的事情
//真实对象专注做自己的事情

public class StaticProxy {

  public static void main(String[] args) {

    //真实结婚对象
//    You you = new You();
//
//    WeddingCompany weddingCompany = new WeddingCompany(you);
//    weddingCompany.HappyMarry();

    //线程中的代理
    new Thread(() -> System.out.println("我爱你")).start();

    new WeddingCompany(new You()).HappyMarry();

  }

}

//接口
interface Marry{
  void HappyMarry();
}


//真实角色
class You implements Marry{
  @Override
  public void HappyMarry() {
    System.out.println("胡歌要结婚了，很开心");
  }
}

//婚庆公司， 代理
class WeddingCompany implements Marry{

  //要结婚的真实目标角色
  private Marry target;

  public WeddingCompany(Marry target){
    this.target = target;
  }

  
  @Override
  public void HappyMarry() {
    before();
    this.target.HappyMarry();
    after();
  }

  private void before() {
    System.out.println("结婚前，布置婚礼现场");
  }

  private void after() {
    System.out.println("结婚后，收份子钱");
  }
}
