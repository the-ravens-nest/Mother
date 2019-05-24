package com.gmail.iledrome.user.pin;

public class Pin {

    private int pin;
    private boolean authenticated;

    public Pin(int pin) {
        this.pin = pin;
        this.authenticated = false;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public boolean authenticate(int pin) {
        if (pin == this.pin) {
            this.authenticated = true;
            return this.authenticated;
        } else {
            return this.authenticated;
        }
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
}
