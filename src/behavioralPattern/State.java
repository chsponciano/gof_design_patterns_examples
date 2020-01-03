package behavioralPattern;

class Stock {
    private String company;
    private float cust;
    private Variation variation;

    public Stock(String company) {
        this.company = company;
        this.variation = new Variation();
    }

    @Override
    public String toString() {
        return this.company + " - " + this.cust;
    }

    public void setCust(float cust) {
        if (variation.isExchange(cust)){
            this.cust = cust;
        } else {
            System.out.println("Improper value exchange");
        }
    }
}

interface StateStock {
    byte getLevel();
    boolean isValue(float value);
}

class BearishAction implements StateStock {

    @Override
    public byte getLevel() {
        return (byte) 1;
    }

    @Override
    public boolean isValue(float value) {
        return value < 4;
    }
}

class AverageAction implements StateStock {

    @Override
    public byte getLevel() {
        return (byte) 2;
    }

    @Override
    public boolean isValue(float value) {
        return value >= 4 && value <= 20;
    }
}

class BullishAction implements StateStock {

    @Override
    public byte getLevel() {
        return (byte) 3;
    }

    @Override
    public boolean isValue(float value) {
        return value > 20;
    }
}

class Variation {
    private StateStock current;

    public Variation() {
        this.current = new BearishAction();
    }

    public boolean isExchange(float value) {
        if (this.current.isValue(value)) {
           return true;
        }

        StateStock newState = this.changeCurrent(value);
        if(newState.getLevel() == this.current.getLevel() + 1 ||
                newState.getLevel() == this.current.getLevel() - 1) {
            this.current = newState;
            return true;
        }

        return false;
    }

    private StateStock changeCurrent(float value) {
        if (new BullishAction().isValue(value)) {
            return new BullishAction();
        }

        if (new BearishAction().isValue(value)) {
            return new BearishAction();
        }

        if (new AverageAction().isValue(value)) {
            return new AverageAction();
        }

        return null;
    }
}

public class State {
    public static void main(String[] args) {
        new State().execute();
    }

    public void execute() {
        Stock p = new Stock("Patterns INC.");
        p.setCust(1.0f);
        System.out.println(p);
        p.setCust(8.0f);
        System.out.println(p);
        p.setCust(25.0f);
        System.out.println(p);
        p.setCust(1.0f);
        System.out.println(p);

    }
}
