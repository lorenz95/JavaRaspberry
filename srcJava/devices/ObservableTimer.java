package pse.devices;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import pse.common.Observable;

public class ObservableTimer extends Observable  {

	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	private ScheduledFuture<?> tickHandle;
	private Runnable tickTask;
	
	public ObservableTimer(){		
	    
		tickTask = new Thread() {
			public void run() {
				Tick ev = new Tick(System.currentTimeMillis());
				notifyEvent(ev);
			}
		};
		
		/*
	    tickTask = () -> {
	    	Tick ev = new Tick(System.currentTimeMillis());
	    	notifyEvent(ev);
	    };
		*/
	}
	
	/**
	 * Start generating tick event
	 * 
	 * @param period period in milliseconds
	 */
	public synchronized void start(long period){
		tickHandle = scheduler.scheduleAtFixedRate(tickTask, 0, period, TimeUnit.MILLISECONDS);	    
	}

	/**
	 * Generate a tick event after a number of milliseconds
	 * 
	 * @param delta
	 */
	public synchronized void scheduleTick(long deltat){
		scheduler.schedule(tickTask, deltat, TimeUnit.MILLISECONDS);
	}
	/**
	 * Stop generating tick event
	 * 
	 * @param period period in milliseconds
	 */
	public synchronized void stop(){
		if (tickHandle != null){
			tickHandle.cancel(false);
			tickHandle = null;
		}
	}
	
}
