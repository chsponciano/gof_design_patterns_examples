package creativePattern;

abstract class Vehicle {
    private String model;
    private String type;

    public Vehicle(String model, String type) {
        this.model = model;
        this.type = type;
    }

    protected String getModel() {
        return this.model;
    }

    protected String getType() {
        return this.type;
    }
}

class Ferrari extends Vehicle {
    private String name;

    public Ferrari(String model) {
        super(model, "Sportive");
        this.name = "creativePattern.Ferrari";
    }

    @Override
    public String toString() {
        return "Car: " + this.name + " - " +  this.getModel() + " - " + this.getType();
    }
}

class Jeep extends Vehicle {
    private String name;

    public Jeep(String model) {
        super(model, "Utility");
        this.name = "creativePattern.Jeep";
    }

    @Override
    public String toString() {
        return "Car: " + this.name + " - " +  this.getModel() + " - " + this.getType();
    }
}

interface AutomakerBuilder {
    void mount(char type, String model);
    Vehicle getVehicle();
}

class AutomakerVehicleBuilder implements AutomakerBuilder {
    private Vehicle vehicle;

    @Override
    public void mount(char type, String model) {
        switch (type) {
            case 'F':
                this.vehicle = new Ferrari(model);
                break;
            case 'J':
                this.vehicle = new Jeep(model);
                break;

        }
    }

    @Override
    public Vehicle getVehicle() {
        return this.vehicle;
    }
}

class Automaker {
    private AutomakerBuilder automakerBuilder = new AutomakerVehicleBuilder();

    public Vehicle mount(char type, String model) {
        automakerBuilder.mount(type, model);
        return automakerBuilder.getVehicle();
    }
}

public class Builder {
    public static void main(String[] args) {
        new Builder().execute();
    }

    public void execute() {
        Automaker automaker = new Automaker();
        Vehicle car1 = automaker.mount('F', "Testerossa");
        Vehicle car2 = automaker.mount('J', "Renegade");
        System.out.println(car1);
        System.out.println(car2);
    }
}
