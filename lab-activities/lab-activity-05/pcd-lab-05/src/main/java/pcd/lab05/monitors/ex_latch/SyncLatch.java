package pcd.lab05.monitors.ex_latch;

/*
 * Latch - to be implemented
 */
public class SyncLatch implements Latch {
	private final int nAgents;
	private int nCalled;

	public SyncLatch(int nAgents) {
		this.nAgents = nAgents;
	}
	
	@Override
	public synchronized void await() throws InterruptedException {
		while (nCalled < nAgents) {
			wait();
		}
		notify();
	}

	@Override
	public synchronized void countDown() {
		nCalled =  nCalled + 1;
		notify();
	}

	
}
