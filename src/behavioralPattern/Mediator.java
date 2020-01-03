package behavioralPattern;

class ChatRoom {
    public static void show(User user, String msg) {
        System.out.println(user + ": " + msg);
    }
}

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void send(String msg) {
        ChatRoom.show(this, msg);
    }
}

public class Mediator {
    public static void main(String[] args) {
        new Mediator().execute();
    }

    public void execute() {
        User fernando = new User("Fernando");
        User anselmo = new User("Anselmo");
        fernando.send("Olá");
        anselmo.send("Oie");
    }
}
