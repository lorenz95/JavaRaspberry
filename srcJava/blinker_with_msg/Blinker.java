package pse.blinker_with_msg;

import java.io.IOException;

import pse.common.*;
import pse.devices.*;

public class Blinker extends BasicEventLoopController {
	
	private Light led;
	private ObservableTimer timer;
	
	private enum State {ON, OFF, IDLE};
	private State currentState;

	public Blinker(Light led){
		this.led = led;
		this.timer = new ObservableTimer();		
		timer.addObserver(this);
		currentState = State.IDLE;
	}
	
	protected void processEvent(Event ev){
		switch (currentState){
		case IDLE:
			try {
				if (ev instanceof StartMsg){
					led.switchOn();
					timer.start(500);
					currentState = State.ON;
				}
			} catch (IOException ex){
				ex.printStackTrace();
			}
			break;
		case ON:
			try {
				if (ev instanceof Tick){
					led.switchOff();
					currentState = State.OFF;
				} else if (ev instanceof StopMsg){
					led.switchOff();
					currentState = State.IDLE;
					timer.stop();					
				}
			} catch (IOException ex){
				ex.printStackTrace();
			}
			break;
		case OFF:
			try {
				if (ev instanceof Tick){
					led.switchOn();
					currentState = State.ON;
				} else if (ev instanceof StopMsg){
					currentState = State.IDLE;
					timer.stop();
				}
			} catch (IOException ex){
				ex.printStackTrace();
			}
			break;
		}
	}
}
