package test;

/**
 * @Author: lizi
 * @Date: 2021/3/18 上午9:53
 * 单例模式
 */
public class Single {
    //构造方法
   private Single(){}
    //创建私有内部类
   private static class SHolder{
       private static final Single SINGLE = new Single();
   }

   private static Single getInstance(){
       return SHolder.SINGLE;
   }
}
