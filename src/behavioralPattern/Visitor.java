package behavioralPattern;

interface VisitorPart {
    public void visit(CPU cpu);
    public void visit(Peripheral peripheral);
}

class ShowVisitor implements VisitorPart {

    @Override
    public void visit(CPU cpu) {
        System.out.println("Computador...");
    }

    @Override
    public void visit(Peripheral peripheral) {
        System.out.println("Periferico " + peripheral);
    }
}

interface PartComp {
    public void add(VisitorPart visitorPart);
}

class Peripheral implements PartComp {
    private String name;

    public Peripheral(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public void add(VisitorPart visitorPart) {
        visitorPart.visit(this);
    }
}

class CPU implements PartComp {
    private PartComp[] parts;

    public CPU() {
        this.parts = new PartComp[]{
                new Peripheral("Mouse"),
                new Peripheral("Teclado"),
                new Peripheral("Monitor")
        };
    }

    @Override
    public void add(VisitorPart visitorPart) {
        visitorPart.visit(this);
        for (int i = 0; i < parts.length; i++) {
            parts[i].add(visitorPart);
        }
    }
}

public class Visitor {
    public static void main(String[] args) {
        PartComp computador = new CPU();
        computador.add(new ShowVisitor());
    }
}
