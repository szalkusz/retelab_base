package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
	}

	private void ValidateLimit(int targetSpeedLimit) {
		if ((targetSpeedLimit < 0 || targetSpeedLimit > 500) || (targetSpeedLimit < (controller.getReferenceSpeed() * 0.5))) {
			user.setAlarmState(true);
		}
		else {
			user.setAlarmState(false);
		}
	}

	@Override
	public int getSpeedLimit() {
		return speedLimit;
	}

	@Override
	public void overrideSpeedLimit(int speedLimit) {
		ValidateLimit(speedLimit);
		this.speedLimit = speedLimit;
		controller.setSpeedLimit(speedLimit);
	}

}
