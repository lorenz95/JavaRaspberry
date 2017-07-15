package pse.devices;

import pse.common.Event;

public class MotionNoMoreDetected implements Event {
	private ObservableMotionDetectorSensor source;
	
	public MotionNoMoreDetected(ObservableMotionDetectorSensor source){
		this.source = source;
	}
	
	public ObservableMotionDetectorSensor getSource(){
		return source;
	}
}
