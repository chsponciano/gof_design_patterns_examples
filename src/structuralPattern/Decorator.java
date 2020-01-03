package structuralPattern;

interface Pea {
    void match();
    void setFatherPea(Pea fatherPea);
}

abstract class PeaDecorator implements Pea {
    private Pea fatherPea = null;

    public PeaDecorator(Pea fatherPea) {
        this.setFatherPea(fatherPea);
    }

    @Override
    public void setFatherPea(Pea fatherPea) {
        this.fatherPea = fatherPea;
    }

    public void match() {
        if (this.fatherPea != null) {
            this.fatherPea.match();
            System.out.print(" X ");
        } else {
            System.out.println();
        }
    }
}

class YellowPea extends PeaDecorator {
    public YellowPea() {
        super(null);
    }

    public YellowPea(Pea fatherPea) {
        super(fatherPea);
    }

    @Override
    public void match() {
        super.match();
        this.showColor();
    }

    private void showColor() {
        System.out.print("Yellow Pea");
    }
}

class RedPea extends PeaDecorator {
    public RedPea() {
        super(null);
    }

    public RedPea(Pea fatherPea) {
        super(fatherPea);
    }

    @Override
    public void match() {
        super.match();
        this.showColor();
    }

    private void showColor() {
        System.out.print("Red Pea");
    }
}

class GreenPea extends PeaDecorator {
    public GreenPea() {
        super(null);
    }

    public GreenPea(Pea fatherPea) {
        super(fatherPea);
    }

    @Override
    public void match() {
        super.match();
        this.showColor();
    }

    private void showColor() {
        System.out.print("Green Pea");
    }
}

public class Decorator {
    public static void main(String[] args) {
        new Decorator().match();
    }

    public void match() {
        new GreenPea(new RedPea(new YellowPea())).match();
        new YellowPea(new GreenPea()).match();
        new YellowPea().match();
    }
}
