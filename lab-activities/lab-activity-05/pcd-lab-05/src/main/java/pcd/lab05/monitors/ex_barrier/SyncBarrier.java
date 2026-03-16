package pcd.lab05.monitors.ex_barrier;

/*
 * Barrier - to be implemented
 */
public class SyncBarrier implements Barrier {
	private final int nParticipants;
	private int nHits = 0;
	
	public SyncBarrier(int nParticipants) {
		this.nParticipants = nParticipants;
	}
	
	@Override
	public synchronized void hitAndWaitAll() throws InterruptedException {
		nHits = nHits + 1;
		while (nHits < nParticipants) {
			wait();
		}
		notify();
		/* Alternativa:
		if (nHits < nParticipants) {
			while (nHits < nParticipants) {
				wait()
			}
		} else {
			notifyAll()
		}
		 */
	}

	
}
