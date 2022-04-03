package com.se;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mockito;

public class ControllerTest {
   
    @Test
    public void newControllerStateIsOff() {
        Controller controller = new Controller();
        assertFalse(controller.getState());
    }
    @Test
    public void turnOnChangesTheStateToOn() {
        Controller controller = new Controller();
        controller.turnOn();
        assertTrue(controller.getState());
    }
    @Test
    public void turnOffChangesTheStateToOff() {
        Controller controller = new Controller();
        controller.turnOn();
        controller.turnOff();
        assertFalse(controller.getState());
    }
    @Test
    public void controlTurnsOffWhenSensorTemperatureHigh() {

        Controller controller = new Controller();
        Sensor mockSensor= Mockito.mock(Sensor.class);
        Mockito.when(mockSensor.getTemperature()).thenReturn(111);


        controller.turnOn();
        controller.control();

        assertFalse(controller.getState());
    }
    @Test
    public void controlTurnsOnWhenSensorTemperatureLow() {

        Controller controller = new Controller();
        Sensor mockSensor= Mockito.mock(Sensor.class);
        Mockito.when(mockSensor.getTemperature()).thenReturn(70);
        controller.setSensor(mockSensor);

        controller.control();
        
        assertTrue(controller.getState());
    }
    
    
}
