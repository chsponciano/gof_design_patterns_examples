package behavioralPattern;

import java.util.ArrayList;
import java.util.List;

class ActivityMemento {
    private float cost;

    public ActivityMemento(float cost) {
        this.cost = cost;
    }

    public float getState() {
        return this.cost;
    }
}

class Activity {
    private String company;
    private float cost;
    private List<ActivityMemento> memory = new ArrayList<>();

    public Activity(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return this.company + " - " + this.cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
        this.memory.add(new ActivityMemento(cost));
    }

    public void undo() {
        if (this.memory.size() > 1) {
            this.memory.remove(this.memory.size() - 1);
            this.cost = this.memory.get(this.memory.size() - 1).getState();
        }
    }
}

public class Memento {
    public static void main(String[] args) {
        new Memento().execute();
    }

    public void execute() {
        Activity p = new Activity("Patterns Inc.");
        p.setCost(3.0f);
        System.out.println(p);
        p.setCost(8.0f);
        System.out.println(p);
        p.setCost(25.0f);
        System.out.println(p);
        p.undo();
        System.out.println(p);
        p.undo();
        System.out.println(p);
        p.undo();
        System.out.println(p);
    }
}
