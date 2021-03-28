package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class AlarmTests {
    private Alarm alarm;
    private Sensor sensor;

    @Test
    public void checkShouldTurnOnAlarmIfPsiIsLowerThanTheLowPressureThreshold(){
        sensor = new Sensor();

        sensor = Mockito.mock(Sensor.class);

        when(sensor.popNextPressurePsiValue()).thenReturn(16.0);

        alarm = new Alarm(sensor);

        alarm.check();

        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void checkShouldTurnOnAlarmIfPsiIsHigherThanTheHighPressureThreshold(){
        sensor = new Sensor();

        sensor = Mockito.mock(Sensor.class);

        when(sensor.popNextPressurePsiValue()).thenReturn(22.0);

        alarm = new Alarm(sensor);

        alarm.check();

        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void checkShouldTurnOffAlarmIfPsiIsLowerThanTheHighPressureThresholdAndHigherThanTheLowPressure(){
        sensor = new Sensor();

        sensor = Mockito.mock(Sensor.class);

        when(sensor.popNextPressurePsiValue()).thenReturn(20.0);

        alarm = new Alarm(sensor);

        alarm.check();

        Assert.assertFalse(alarm.getAlarmOn());
    }

}
