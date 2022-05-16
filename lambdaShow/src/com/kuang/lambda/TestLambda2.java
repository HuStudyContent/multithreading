package com.kuang.lambda;

public class TestLambda2 {
//2.
//  static class Love implements ILove{
//    @Override
//    public void love(int a) {
//      System.out.println("i love you ->"+a);
//    }
//  }

  public static void main(String[] args) {

    //3.
//    class Love implements ILove{
//      @Override
//      public void love(int a) {
//        System.out.println("i love you ->"+a);
//      }
//    }


    //4.
//    ILove love = new ILove(){
//      @Override
//      public void love(int a) {
//        System.out.println("i love you ->"+a);
//      }
//    };

    //5.
    ILove love = (int a) -> {
      System.out.println("i love you->"+a);
    };

    //简化1.0 去掉参数类型
    ILove love1 = (a) -> {
      System.out.println("i love you->"+a);
    };

    //简化2.0 去掉括号
    ILove love2 = a -> {
      System.out.println("i love you->"+a);
    };

    //简化3.0 去掉花括号
    ILove love3 = a -> System.out.println("i love you->"+a);

//    ILove love = new Love();
    love.love(3);
    love1.love(23);
    love2.love(26);
    love3.love(30);

    /**总结:
     * {}简略的条件是只能有一行代码,多行{}就不能简略了
     * 前提是接口为函数式接口(只能有一个方法)
     * 多个参数也可以去掉参数类型,要去掉就都去掉,必须加上()
     */
  }

}


//接口
interface ILove{
  void love(int a);

}

//1.实现类
//class Love implements ILove{
//  @Override
//  public void love(int a) {
//    System.out.println("i love you ->"+a);
//  }
//}