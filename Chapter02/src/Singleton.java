/**
 *  @Description: 双重锁机制实现单例
 *  @author: zhao_yd
 *  @Date: 2021/12/5 9:19 下午
 *
 */


/**
 *
 * 未被编译器优化的操作：
 *
 * 指令1：分配一款内存M
 * 指令2：在内存M上初始化Singleton对象
 * 指令3：将M的地址赋值给instance变量
 *
 * 编译器优化后的操作指令：
 *
 * 指令1：分配一块内存S
 * 指令2：将M的地址赋值给instance变量
 * 指令3：在内存M上初始化Singleton对象
 *
 * 有可能最终线程获取的instance是没有初始化的，此时去使用instance可能会产生一些意想不到的错误。
 */
public class Singleton {

    private static Singleton instance;

    public Singleton getInstance(){

        if(instance == null){
            synchronized (Singleton.class){
                instance = new Singleton();
            }
        }
        return instance;
    }

}
