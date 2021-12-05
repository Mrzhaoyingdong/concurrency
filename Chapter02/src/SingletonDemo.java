/**
 *  @Description: 静态内部类实习单例
 *  @author: zhao_yd
 *  @Date: 2021/12/5 9:32 下午
 *
 */

public class SingletonDemo {

    private SingletonDemo(){

    }

    private static class SingletonDemoHandler{
        private static SingletonDemo instance = new SingletonDemo();
    }

    public SingletonDemo getInstance(){
        return  SingletonDemoHandler.instance;
    }
}
