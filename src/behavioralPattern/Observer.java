package behavioralPattern;

import java.util.ArrayList;
import java.util.List;

abstract class ObserverNumber {
    protected Number number;
    public abstract void warn();
}

class Number {
    private List<ObserverNumber> observers = new ArrayList<>();

    private int value;

    @Override
    public int hashCode() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        for(ObserverNumber obs : this.observers) {
            obs.warn();
        }
    }

    public void add(ObserverNumber obs) {
        this.observers.add(obs);
    }
}

class HexObserver extends ObserverNumber {
    public HexObserver(Number number) {
        this.number = number;
        this.number.add(this);
    }

    public void warn() {
        System.out.println(this.number.hashCode() + " in hexadecimal: "
                + Integer.toHexString(this.number.hashCode()));
    }
}

class OctalObserver extends ObserverNumber {
    public OctalObserver(Number number) {
        this.number = number;
        this.number.add(this);
    }

    public void warn() {
        System.out.println(this.number.hashCode() + " in Octal: "
                + Integer.toOctalString(this.number.hashCode()));
    }
}

public class Observer {
    public static void main(String[] args) {
        new Observer().execute();
    }

    public void execute() {
        Number number = new Number();
        new HexObserver(number);
        new OctalObserver(number);
        number.setValue(15);
        number.setValue(30);
        number.setValue(45);
        number.setValue(12);
    }
}
