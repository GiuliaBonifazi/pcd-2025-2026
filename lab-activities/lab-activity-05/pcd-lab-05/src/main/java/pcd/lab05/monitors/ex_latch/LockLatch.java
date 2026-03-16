package pcd.lab05.monitors.ex_latch;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockLatch implements Latch {
    private final int nAgents;
    private int nHits = 0;
    private final Lock lock;
    private final Condition finishedCountDown;

    LockLatch(int nAgents) {
        this.nAgents = nAgents;
        this.nHits = 0;
        this.lock = new ReentrantLock();
        this.finishedCountDown = lock.newCondition();
    }

    @Override
    public void countDown() {
        try {
            lock.lock();
            nHits = nHits + 1;
            if (nHits == nAgents) finishedCountDown.signal();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void await() throws InterruptedException {
        finishedCountDown.await();
    }
}
