package structuralPattern;

interface Corn {
    void match();
    void setFatherCorn(Corn fatherPea);
}

abstract class CornDecorator implements Corn {
    private Corn fatherCorn = null;

    public CornDecorator(Corn fatherCorn) {
        this.setFatherCorn(fatherCorn);
    }

    @Override
    public void setFatherCorn(Corn fatherCorn) {
        this.fatherCorn = fatherCorn;
    }

    public void match() {
        if (this.fatherCorn != null) {
            this.fatherCorn.match();
            System.out.print(" X ");
        } else {
            System.out.println();
        }
    }
}

class YellowCorn extends CornDecorator {
    public YellowCorn() {
        super(null);
    }

    public YellowCorn(Corn fatherCorn) {
        super(fatherCorn);
    }

    @Override
    public void match() {
        super.match();
        this.showColor();
    }

    private void showColor() {
        System.out.print("Yellow Corn");
    }
}

class RedCorn extends CornDecorator {
    public RedCorn() {
        super(null);
    }

    public RedCorn(Corn fatherCorn) {
        super(fatherCorn);
    }

    @Override
    public void match() {
        super.match();
        this.showColor();
    }

    private void showColor() {
        System.out.print("Red Corn");
    }
}

class GreenCorn extends CornDecorator {
    public GreenCorn() {
        super(null);
    }

    public GreenCorn(Corn fatherCorn) {
        super(fatherCorn);
    }

    @Override
    public void match() {
        super.match();
        this.showColor();
    }

    private void showColor() {
        System.out.print("Green Corn");
    }
}

class CornFlyweight {
    private Corn[] pool = {
            new GreenCorn(),
            new RedCorn(),
            new YellowCorn()
    };

    public void show(Corn fatherCorn) {
        for (int i = 0; i < this.pool.length; i++) {
            fatherCorn.setFatherCorn(this.pool[i]);
            fatherCorn.match();
        }
    }
}

public class Flyweight {
    public static void main(String[] args) {
        new Flyweight().match();
    }

    public void match() {
        CornFlyweight cfw = new CornFlyweight();
        cfw.show(new GreenCorn());
        cfw.show(new RedCorn());
        cfw.show(new YellowCorn());
    }
}
