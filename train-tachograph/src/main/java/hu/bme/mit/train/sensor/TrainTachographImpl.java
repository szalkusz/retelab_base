package hu.bme.mit.train.tachograph;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import hu.bme.mit.train.interfaces.TrainTachograph;

public class TrainTachographImpl implements TrainTachograph {


	public TrainTachographImpl() {
	}

	// Time, joystickPosition, referenceSpeed
	private Table<String, Integer, Integer> data = HashBasedTable.create();

	@Override
	public void recordValues(String time, int joystickPosition, int referenceSpeed) {
		data.put(time, joystickPosition, referenceSpeed);
	}

	@Override
	public Table getValues() {
		return data;
	}

}
