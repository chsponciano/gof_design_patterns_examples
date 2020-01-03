package behavioralPattern;

enum DegreeKinship {
    SPOUSE,
    SON,
    FATHER
}

class Dependent {
    private String name;
    private DegreeKinship degreeKinship;

    public Dependent(String name, DegreeKinship degreeKinship) {
        this.name = name;
        this.degreeKinship = degreeKinship;
    }

    public String getName() {
        return this.name;
    }

    public String getDegreeKinship() {
        switch (this.degreeKinship) {
            case SPOUSE:
                return "Spouse";
            case SON:
                return "Son/Daughter";
            case FATHER:
                return "Father/Mother";
        }

        return null;
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getDegreeKinship();
    }
}

interface IteratorAction{
    public void firts();
    public void next();
    public boolean isDone();
    public Object currentItem();
    public int getIndex();
    public byte getLength();
}

class IteratorImpl<T> implements IteratorAction {
    private T[] items;
    private int index;

    public IteratorImpl(T[] items) {
        this.items = items;
    }

    @Override
    public void firts() {
        this.index = 0;
    }

    @Override
    public void next() {
        this.index++;
    }

    @Override
    public boolean isDone() {
        return this.index == this.items.length;
    }

    @Override
    public Object currentItem() {
        return this.items[this.index];
    }

    @Override
    public int getIndex() {
        return this.index;
    }

    @Override
    public byte getLength() {
        return (byte)this.items.length;
    }
}

class ActionsDependent {
    private Dependent[] dependents;

    public void add(Dependent dependent) {
        if (this.dependents == null) {
            this.dependents = new Dependent[]{ dependent };
        } else {
            IteratorImpl<Dependent> backup = new IteratorImpl<>(this.dependents);
            this.dependents = new Dependent[this.dependents.length + 1];
            for (backup.firts(); !backup.isDone(); backup.next()) {
                this.dependents[backup.getIndex()] = (Dependent)backup.currentItem();
            }
            this.dependents[backup.getLength()] = dependent;
        }
    }

    public void remove(byte position) {
        if (this.dependents.length == 1) {
            this.dependents = null;
        } else {
            IteratorImpl<Dependent> backup = new IteratorImpl<>(this.dependents);
            this.dependents = new Dependent[this.dependents.length - 1];
            byte j = 0;

            for (backup.firts(); !backup.isDone(); backup.next()) {
                if (backup.getIndex() != position) {
                    this.dependents[j++] = (Dependent)backup.currentItem();
                }
            }
        }
    }

    public void show() {
        if (this.dependents != null) {
            System.out.println("Dependents: ");
            IteratorImpl<Dependent> backup = new IteratorImpl<>(this.dependents);
            for (backup.firts(); !backup.isDone(); backup.next()) {
                System.out.println("- " + (Dependent)backup.currentItem());
            }
        }
    }
}

public class Iterator {
}
