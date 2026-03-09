package pcd.lab04.ex01_synchwithsem;

import java.util.concurrent.Semaphore;

public class Pinger extends ActiveComponent {
    private final Semaphore mutex;

	public Pinger(Semaphore mutex) {
        this.mutex = mutex;
	}	
	
	public void run() {
		while (true) {
            try {
                mutex.acquire();
                println("ping");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                mutex.release();
            }
		}
	}
}