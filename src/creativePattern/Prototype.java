package creativePattern;

class Sheep implements Cloneable {
    private String name;

    public Sheep(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public Object clone() {
        Object object = null;

        try {
            object = super.clone();

        } catch (CloneNotSupportedException e) {
            System.err.println(e.getMessage());

        } finally {
            return object;

        }
    }
}

interface IPrototype {
    public Sheep duplicate(Sheep sheep);
}

class PrototypeImpl implements IPrototype {
    @Override
    public Sheep duplicate(Sheep sheep) {
        return (Sheep) sheep.clone();
    }
}

public class Prototype {
    public static void main(String[] args) {
        new Prototype().execute();
    }

    public void execute() {
        Sheep original = new Sheep("Dolly");
        Sheep clone = new PrototypeImpl().duplicate(original);
    }
}
