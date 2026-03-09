package pcd.lab04.ex01_synchwithsem;

import java.util.concurrent.Semaphore;

public class Ponger extends ActiveComponent {
    private final Semaphore mutex;
	
	public Ponger(Semaphore mutex) {
        this.mutex = mutex;
	}	
	
	public void run() {
        while (true) {
            try {
                mutex.acquire();
                println("pong");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                mutex.release();
            }
        }
	}
}