package com.mzj.javabase.thread.spinlock.demo1;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLock {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {
        //获取当前线程对象
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "\t come in ####");
        //当owner持有线程不为空时，循环等待
        while (!atomicReference.compareAndSet(null, thread)) {
            //当owner持有线程为空时，将owner持有线程设为当前线程，退出循环
        }
    }

    public void myUnLock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        //执行完成后，将owner持有线程重新置为空，相当于释放锁
        System.out.println(Thread.currentThread().getName() + "\t invoke myUnLock()");
    }
}
