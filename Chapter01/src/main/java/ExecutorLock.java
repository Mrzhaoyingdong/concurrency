import java.util.concurrent.*;

/**
 *  @Description: 饿死锁例子
 *  @author: zhao_yd
 *  @Date: 2021/12/5 8:23 下午
 *
 */

public class ExecutorLock {

    /**因为单线程线程池所以只能提交一个线程，另一个线程无法执行导致程序饿死*/
    private static ExecutorService executor = Executors.newSingleThreadExecutor();

    public static class AnotherCallable implements Callable<String>{

        public String call() throws Exception {
            System.out.println("in AnotherCallable");
            return "AnotherCallable exec success";
        }
    }

    public static class MyCallAble implements Callable<String>{

        public String call() throws Exception {
            System.out.println("in MyCallAble");
            Future<String> future = executor.submit(new AnotherCallable());
            return "MyCallAble exec success" + future.get();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<String> future = executor.submit(new MyCallAble());
        System.out.println(future.get());
        System.out.println("over");
        executor.shutdown();
    }

}
