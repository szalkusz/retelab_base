package hu.bme.mit.train.interfaces;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
public interface TrainTachograph {
    void recordValues(String time, int joystickPosition, int referenceSpeed);
    Table getValues();
}