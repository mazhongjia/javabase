package com.mzj.javabase.thread.spinlock.demo2._01_simpledemo;

import com.mzj.javabase.thread.spinlock.demo2.Lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 简单自旋锁（可重入）
 *
 */
public class SpinLock implements Lock {
    /**
     *  use thread itself as  synchronization state
     *  使用Owner Thread作为同步状态，比使用一个简单的boolean flag可以携带更多信息
     */
    private AtomicReference<Thread> owner = new AtomicReference<>();
    /**
     * reentrant count of a thread, no need to be volatile
     */
    private int count = 0;

    @Override
    public void lock() {
        Thread t = Thread.currentThread();
        // if re-enter, increment the count.
        if (t == owner.get()) {
            ++count;
            return;
        }
        //spin
        while (owner.compareAndSet(null, t)) {
        }
    }

    @Override
    public void unlock() {
        Thread t = Thread.currentThread();
        //only the owner could do unlock;
        if (t == owner.get()) {
            if (count > 0) {
                // reentrant count not zero, just decrease the counter.
                --count;
            } else {
                // compareAndSet is not need here, already checked
                owner.set(null);
            }
        }
    }
}