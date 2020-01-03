package structuralPattern;

import java.util.ArrayList;
import java.util.List;

abstract class MenuComponent {
    private String link;
    private String description;

    public MenuComponent(String link, String description) {
        this.description = description;
        this.link = link;
    }

    @Override
    public String toString() {
        if (this.link != null) {
            return "\t" + this.description + " - " + this.link;
        }

        return this.description;
    }

    public abstract void print();
}

class MenuItem extends MenuComponent {
    public MenuItem(String description, String link) {
        super(link, description);
    }

    @Override
    public void print() {
        System.out.println(super.toString());
    }
}

class Menu extends MenuComponent {
    private List<MenuComponent> components;

    public Menu(String description) {
        super(null, description);
        components = new ArrayList<>();
    }

    public void add(MenuComponent component) {
        components.add(component);
    }

    @Override
    public void print() {
        System.out.println(" >> " + super.toString());
        for (MenuComponent c : this.components) {
            c.print();
        }
    }
}

public class Composite {
    public static void main(String[] args) {
        new Composite().setUpMenu();
    }

    public void setUpMenu() {
        Menu partI = new Menu("Part I");
        partI.add(new MenuItem("Item I", "Event I"));
        partI.add(new MenuItem("Item II", "Event II"));

        Menu partII = new Menu("Part II");
        partII.add(new MenuItem("Item I", "Event III"));
        partII.add(new MenuItem("Item II", "Event IV"));
        partII.add(new MenuItem("Item II", "Event V"));

        Menu main = new Menu("Main");
        main.add(partI);
        main.add(partII);
        main.print();
    }
}
