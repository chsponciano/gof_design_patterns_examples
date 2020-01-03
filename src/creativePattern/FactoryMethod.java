package creativePattern;

abstract class VehicleNationals {
    private String model;

    public VehicleNationals(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

class Opala extends VehicleNationals {
    public Opala() {
        super("Opala");
    }
}

class Vectra extends VehicleNationals {
    public Vectra() {
        super("Vectra");
    }
}

abstract class GMCreator {
    public abstract Opala factoryOpala();
    public abstract Vectra factoryVectra();
}

class GMConcreteCreator extends GMCreator {
    @Override
    public Opala factoryOpala() {
        return new Opala();
    }

    @Override
    public Vectra factoryVectra() {
        return new Vectra();
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        new FactoryMethod().build();
    }

    public void build() {
        GMConcreteCreator gm = new GMConcreteCreator();
        System.out.println(gm.factoryOpala());
        System.out.println(gm.factoryVectra());
    }
}
