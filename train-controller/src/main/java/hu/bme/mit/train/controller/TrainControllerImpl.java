package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;
import java.util.Timer;
import java.util.TimerTask;

public class TrainControllerImpl implements TrainController {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;

	public TrainControllerImpl() {
		updateReferenceSpeed();
	}

	@Override
	public void followSpeed() {
		if (referenceSpeed < 0) {
			referenceSpeed = 0;
		} else {
		    if(referenceSpeed+step > 0) {
                referenceSpeed += step;
            } else {
		        referenceSpeed = 0;
            }
		}

		enforceSpeedLimit();
	}

	@Override
	public int getReferenceSpeed() {
		return referenceSpeed;
	}

	@Override
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		enforceSpeedLimit();
		
	}

	private void enforceSpeedLimit() {
		if (referenceSpeed > speedLimit) {
			referenceSpeed = speedLimit;
		}
	}

	@Override
	public void setJoystickPosition(int joystickPosition) {
		this.step = joystickPosition;		
	}

	public void emergencyBreak() {
		this.speedLimit = 0;
		enforceSpeedLimit();
	}

	private class Helper extends TimerTask {
		public void run() {
			followSpeed();
		}
	}

    private void updateReferenceSpeed() {
        Timer timer = new Timer();
        TimerTask task = new Helper();
        timer.schedule(task, 200, 1000);
    }
}
