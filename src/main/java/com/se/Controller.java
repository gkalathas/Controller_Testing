package com.se;
public class Controller {
    private final int MAX_VALUE =100;
    private Sensor sensor;

    private boolean state;
    public void setSensor(Sensor sensor){

    }

    public boolean getState() {
        return state;
    }

    public void turnOn() {
        state = true;
    }

    public void turnOff() {
        state = false;
    }

    public void control() {
        if(Sensor.getTemperature()> MAX_VALUE){
             turnOff();
        }
        else{
            turnOn();
        }

    }
    
}
