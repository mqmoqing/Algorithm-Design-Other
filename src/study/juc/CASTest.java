package study.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mq
 * @create 2023-02-17 22:06
 */
public class CASTest {
//    static Integer num =0;
    static AtomicInteger num = new AtomicInteger(0);
    /**
     * 用三个线程来打印0-1000
     * 1.使用 synchronized 互斥锁（悲观锁）保持线程同步
     * 2.无锁保持线程同步，使用AtomicInteger,Atomic底层使用了CAS方法
     *      public final int getAndAddInt(Object var1, long var2, int var4) {
     *              int var5;
     *              do {
     *                  var5 = this.getIntVolatile(var1, var2);
     *              } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4));
     *
     *              return var5;
     *          }
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0 ;i <= 3 ;i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
//                    synchronized (CASTest.class){//互斥锁（悲观锁）保持线程同步，不加的话
//                        while (num<1000){
//                            System.out.println("thread name:"+Thread.currentThread().getName()+":"+num++);
//                        }
//                    }
                    while (num.get()<1000){
                            System.out.println("thread name:"+Thread.currentThread().getName()+":"+num.incrementAndGet());
                        }
                }
            });
            thread.start();
        }
    }
}
