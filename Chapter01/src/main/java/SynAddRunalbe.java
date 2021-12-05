/**
 *  @Description: 死锁例子
 *  @author: zhao_yd
 *  @Date: 2021/12/5 7:42 下午
 *
 */

public class SynAddRunalbe implements Runnable{

    Obj1 obj1;
    Obj2 obj2;
    int  a,b;
    boolean flag;

    public SynAddRunalbe(Obj1 obj1, Obj2 obj2, int a, int b, boolean flag) {
        this.obj1 = obj1;
        this.obj2 = obj2;
        this.a = a;
        this.b = b;
        this.flag = flag;
    }

    public void run() {
        try {
            if(flag){
                synchronized (obj1){
                    Thread.sleep(100);
                    synchronized (obj2){
                        System.out.println(a+b);
                    }
                }
            }else {
                synchronized (obj2){
                    Thread.sleep(100);
                    synchronized (obj1){
                        System.out.println(a+b);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static class Obj1{

    }

    public static class Obj2{

    }
}
