package creativePattern;

import java.util.Scanner;

abstract class Pet {
    private String name;

    public Pet(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

abstract class Dog extends Pet {
    public Dog(String name) {
        super(name);
    }
}

abstract class Cat extends Pet {
    public Cat(String name) {
        super(name);
    }
}

class Shitzu extends Dog {
    public Shitzu() {
        super("creativePattern.Shitzu");
    }
}

class Pastor extends Dog {
    public Pastor() {
        super("creativePattern.Pastor");
    }
}

class Persa extends Cat {
    public Persa() {
        super("creativePattern.Persa");
    }
}

class RagDoll extends Cat {
    public RagDoll() {
        super("creativePattern.RagDoll");
    }
}

interface Model {
    Dog getDog();
    Cat getCat();
}

class FactoryCompany implements Model {
    @Override
    public Cat getCat() {
        return new Persa();
    }

    @Override
    public Dog getDog() {
        return new Shitzu();
    }
}

class FactoryGuard implements Model {
    @Override
    public Cat getCat() {
        return new RagDoll();
    }

    @Override
    public Dog getDog() {
        return new Pastor();
    }
}

public class AbstractFactory {
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new AbstractFactory().execute();
    }

    public void execute() {
        System.out.println("Select 1-company or 2-guard");
        byte opc = scanner.nextByte();
        Model model = null;

        switch (opc) {
            case 1:
                model = new FactoryCompany();
                break;
            case 2:
                model = new FactoryGuard();
                break;
        }

        System.out.println("creativePattern.Dog: " + model.getDog());
        System.out.println("creativePattern.Cat: " + model.getCat());
    }
}
