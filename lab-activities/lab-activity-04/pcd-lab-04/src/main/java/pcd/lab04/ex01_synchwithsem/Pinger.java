package pcd.lab04.ex01_synchwithsem;

import java.util.concurrent.Semaphore;

public class Pinger extends ActiveComponent {
    private final Semaphore pongDoneEvent;
    private final Semaphore pingDoneEvent;

	public Pinger(
        Semaphore pongDoneEvent,
        Semaphore pingDoneEvent
    ) {
        this.pongDoneEvent = pongDoneEvent;
        this.pingDoneEvent = pingDoneEvent;
	}	
	
	public void run() {
		while (true) {
            try {
                pongDoneEvent.acquire();
                println("ping");
                pingDoneEvent.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
	}
}