package pcd.lab05.monitors.ex_barrier;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockBarrier implements Barrier {
    private final int nParticipants;
    private int nHits;
    private Lock lock;
    private Condition allArrived;

    public LockBarrier(int nParticipants) {
        this.nParticipants = nParticipants;
        this.nHits = 0;
        this.lock = new ReentrantLock();
        this.allArrived = this.lock.newCondition();
    }

    @Override
    public void hitAndWaitAll() throws InterruptedException {
        try {
            lock.lock();
            nHits = nHits + 1;
            if (nHits < nParticipants) {
                while (nHits < nParticipants) {
                    allArrived.await();
                }
            } else {
                allArrived.signalAll();
            }
        }  finally {
            lock.unlock();
        }
    }
}
