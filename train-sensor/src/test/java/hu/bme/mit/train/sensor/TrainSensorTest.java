package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;

import static org.mockito.Mockito.*;


public class TrainSensorTest {

    TrainController mockTC;
    TrainUser mockTU;
    TrainSensorImpl TS;

    @Before
    public void before() {
        mockTC = mock(TrainController.class);
        mockTU = mock(TrainUser.class);

        TS = new TrainSensorImpl(mockTC, mockTU);
    }

    @Test
    public void TooHighAbsoluteSpeedLimit() {
        // Init
        when(mockTC.getReferenceSpeed()).thenReturn(100);

        // Do
        TS.overrideSpeedLimit(501);

        // Check
        verify(mockTU, times(1)).setAlarmState(true);
    }

    @Test
    public void TooLowAbsoluteSpeedLimit() {
       // Init
       when(mockTC.getReferenceSpeed()).thenReturn(100);

       // Do
       TS.overrideSpeedLimit(-1);

       // Check
       verify(mockTU, times(1)).setAlarmState(true);
    }

    @Test
    public void TooLowRelativeSpeedLimit() {
       // Init
       when(mockTC.getReferenceSpeed()).thenReturn(100);

       // Do
       TS.overrideSpeedLimit(20);

       // Check
       verify(mockTU, times(1)).setAlarmState(true);
    }

    @Test
    public void ProperSpeedLimit() {
       // Init
       when(mockTC.getReferenceSpeed()).thenReturn(100);

       // Do
       TS.overrideSpeedLimit(70);

       // Check
       verify(mockTU, times(1)).setAlarmState(false);
    }

}
