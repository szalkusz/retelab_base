package hu.bme.mit.train.tachograph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import hu.bme.mit.train.interfaces.TrainTachograph;
import hu.bme.mit.train.tachograph.TrainTachographImpl;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TrainTachographTest {

    @Before
    public void before() {
        // TODO Add initializations
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        // TODO Delete this and add test cases based on the issues
    }

    private String getTime() {
        LocalDateTime currentLocalDateTime = LocalDateTime.now();
 
        // Create DateTimeFormatter instance with specified format
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
 
        // Format LocalDateTime to String
        String formattedDateTime = currentLocalDateTime.format(dateTimeFormatter);
        return formattedDateTime;
    }

    @Test 
    public void TestTachograph() {
        TrainTachograph data = new TrainTachographImpl();
        String time = getTime();
        data.recordValues(time, 1, 2);
        Assert.assertEquals(2, data.getValues().get(time, 1));
    }
}
