package pcd.lab04.ex01_synchwithsem;

import java.util.concurrent.Semaphore;

public class Ponger extends ActiveComponent {
    private final Semaphore pingDoneEvent;
    private final Semaphore pongDoneEvent;
	
	public Ponger(
        Semaphore pongDoneEvent,
        Semaphore pingDoneEvent
    ) {
        this.pingDoneEvent = pingDoneEvent;
        this.pongDoneEvent = pongDoneEvent;
	}	
	
	public void run() {
        while (true) {
            try {
                pingDoneEvent.acquire();
                println("pong");
                pongDoneEvent.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}
}