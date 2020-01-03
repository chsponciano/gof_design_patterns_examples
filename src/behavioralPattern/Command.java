package behavioralPattern;

import java.util.Scanner;

class TV {
    private boolean on = false;
    private byte volume = 0;

    public void onOff() {
        System.out.println("TV " + ((this.on = !this.on) ? "Ligada." : "Desligada."));
    }

    public void upVolume() {
        if (this.on) {
            if (this.volume < 10) {
                this.volume++;
            }
            System.out.println("Volume: " + this.volume);
        } else {
            System.out.println("Turn on the TV");
        }
    }

    public void downVolume() {
        if (this.on) {
            if (this.volume > 0) {
                this.volume--;
            }
            System.out.println("Volume: " + this.volume);
        } else {
            System.out.println("Turn on the TV");
        }
    }
}

interface Action {
    void execute();
}

class TVOnOffCommand implements Action {
    private TV tv;

    public TVOnOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        this.tv.onOff();
    }
}

class TVUpVolumeCommand implements Action {
    private TV tv;

    public TVUpVolumeCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        this.tv.upVolume();
    }
}

class TVDownVolumeCommand implements Action {
    private TV tv;

    public TVDownVolumeCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        this.tv.downVolume();
    }
}

class RemoteControl {
    private Action btnOnOff, btnUpVolume, btnDownVolume;

    public RemoteControl(TV tv) {
        this.btnOnOff = new TVOnOffCommand(tv);
        this.btnUpVolume = new TVUpVolumeCommand(tv);
        this.btnDownVolume = new TVDownVolumeCommand(tv);
    }

    public void pushOnOff() {
        this.btnOnOff.execute();
    }

    public void pushUpVolume() {
        this.btnUpVolume.execute();
    }

    public void pushDownVolume() {
        this.btnDownVolume.execute();
    }

}

public class Command {
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Command().execute();
    }

    public void execute() {
        byte option = 0;
        RemoteControl rm = new RemoteControl(new TV());

        do {
            System.out.println("Select a command:");
            System.out.println("0 - Go out");
            System.out.println("1 - On/Off");
            System.out.println("2 - Up Volume");
            System.out.println("3 - Down Volume");
            option = scanner.nextByte();
            System.out.println();

            switch (option) {
                case 1:
                    rm.pushOnOff();
                    break;
                case 2:
                    rm.pushUpVolume();
                    break;
                case 3:
                    rm.pushDownVolume();
                    break;
            }

        } while (option != 0);
    }
}
