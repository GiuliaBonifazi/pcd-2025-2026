package pcd.lab04.ex01_synchwithsem;

import java.util.concurrent.Semaphore;

/**
 * Unsynchronized version
 * 
 * @TODO make it sync 
 * @author aricci
 *
 */
public class TestPingPong {
	public static void main(String[] args) {
        // Semafori evento sempre inizializzati a zero (aka sempre release prima di event)
        Semaphore pingDoneEvent = new Semaphore(0);
        Semaphore pongDoneEvent = new Semaphore(0);

		new Pinger(pongDoneEvent, pingDoneEvent).start();
		new Ponger(pongDoneEvent, pingDoneEvent).start();

        // Così parte ping
        pongDoneEvent.release();
	}

}
