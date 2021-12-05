public class Demo01 {

    /** jstack使用 使用top查看程序的pid 执行 jstack pid 查看死锁信息*/

    public static void main(String[] args) {
        SynAddRunalbe.Obj1 obj1 = new SynAddRunalbe.Obj1();
        SynAddRunalbe.Obj2 obj2 = new SynAddRunalbe.Obj2();

        SynAddRunalbe synAddRunalbe = new SynAddRunalbe(obj1,obj2,10,11,true);
        SynAddRunalbe synAddRunalbe1 = new SynAddRunalbe(obj1,obj2,10,11,false);

        Thread thread = new Thread(synAddRunalbe);
        thread.setName("thread");
        thread.start();

        Thread thread1 = new Thread(synAddRunalbe1);
        thread1.setName("thread1");
        thread1.start();
    }
}
