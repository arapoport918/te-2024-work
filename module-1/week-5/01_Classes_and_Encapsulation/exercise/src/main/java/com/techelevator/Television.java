package com.techelevator;

public class Television {

    //Instance Variables
    private boolean isOn = false;
    private int currentChannel = 3;
    private int currentVolume = 2;

    //Getters
    public boolean isOn() {
        return this.isOn;
    }

    public int getCurrentChannel() {
        return this.currentChannel;
    }

    public int getCurrentVolume() {
        return this.currentVolume;
    }

    //Methods
    public void turnOff() {
        isOn = false;
    }
    public void turnOn() {
        isOn = true;
    }
    public void changeChannel(int newChannel) {
        if (isOn) {
            currentChannel = newChannel;
        }
    }
    public void channelUp() {
        if (isOn) {
            this.currentChannel++;
        }

        if (currentChannel > 18) {
            currentChannel = 3;
        }
    }
    public void channelDown() {
        if (isOn) {
            this.currentChannel--;
        }

        if (currentChannel < 3) {
            currentChannel = 18;
        }
    }
    public void raiseVolume() {
        if(isOn) {
            currentVolume++;
        }
    }
    public void lowerVolume(){
        if(isOn) {
            currentVolume--;
        }

        if (currentVolume <= 0) {
            currentVolume = 0;
        }
    }
}
