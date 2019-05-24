package com.gmail.iledrome.user.pin;

import com.gmail.iledrome.utilities.ConfigurationFile;

public class PinManager {

    private boolean pinExists;
    private Pin pin;
    private ConfigurationFile configurationFile;

    public PinManager(ConfigurationFile configurationFile) {
        this.pinExists = false;
        this.configurationFile = configurationFile;
    }

    public Pin getPin() {
        return pin;
    }

    public void setPin(Pin pin) {
        this.pin = pin;
    }

    public boolean doesPinExist() {
        return this.pinExists;
    }

    public void load() {

        if (this.configurationFile.getConfiguration().contains("pin")) {
            this.pinExists = true;
        }

        this.pin = new Pin(this.configurationFile.getConfiguration().getInt("pin"));
    }

    public void save() {
        this.configurationFile.getConfiguration().set("pin", pin.getPin());
    }

}
