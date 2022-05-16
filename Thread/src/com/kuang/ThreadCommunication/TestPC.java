package com.kuang.ThreadCommunication;

//测试： 生产者消费者模型，->利用缓存区解决： 管程发

// 生产者，消费者，产品，缓冲区
public class TestPC {
  public static void main(String[] args) {
    SynContainer synContainer = new SynContainer();

    new Producer(synContainer).start();
    new Consumer(synContainer).start();

  }
}

//生产者
class Producer extends Thread{
  SynContainer container;

  public Producer(SynContainer container){
    this.container = container;
  }

  //生产
  @Override
  public void run() {
    for (int i = 1; i <= 100; i++) {
      container.push(new Chicken(i));
//      System.out.println("生产了第"+i+"只鸡");
    }
  }
}

//消费者
class Consumer extends Thread{
  SynContainer container;

  public Consumer(SynContainer container){
    this.container = container;
  }

  //消费
  @Override
  public void run() {
    for (int i = 1; i <= 100; i++) {
      container.pop();
//      System.out.println("消费了-->"+container.pop().id+"只鸡");
    }
  }
}

//产品
class Chicken{
  int id; //产品编号

  public Chicken(int id){
    this.id = id;
  }

}

//缓冲区
class SynContainer{

  //需要一个容器大小
  Chicken[] chickens = new Chicken[10];
  //容器计数器
  int count = 0;

  //生产者放入产品
  public synchronized void push(Chicken chicken){
    //如果容器满了，就需要等待消费者消费
    /*如果是if的话，假如消费者1消费了最后一个，这时index变成0此时释放锁被消费者2拿到而不是生产者拿到，
    这时消费者的wait是在if里所以它就直接去消费index-1下标越界，如果是while就会再去判断一下index得值是不是变成0了*/
    while(count == chickens.length){
      try {
        this.wait();  //满了，生产者就要等待，先不生产
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    //如果没有满，我们就需要丢入产品
    chickens[count] = chicken;   //数组下标赋值，把我们的鸡的编号放进去
    count++;

    System.out.println("生产了第"+chicken.id+"只鸡"+"--->容器容量为："+count);
    //可以通知消费者消费了
    this.notifyAll();   //通知所有等待线程
  }

  //消费者消费产品
  public synchronized Chicken pop(){
    //判断是否能消费
    while (count <= 0){
      try {
        this.wait();   //没有东西，就等待生产者生产
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    //如果可以消费
    count--;
    Chicken chicken = chickens[count];  //这里是指把容器该位置的鸡的编号返回

    System.out.println("容器容量为:"+count+"--->消费者消费了第"+chicken.id+"只鸡");

    //吃完了，通知消费者生产
    this.notifyAll();
    return chicken;
  }


}