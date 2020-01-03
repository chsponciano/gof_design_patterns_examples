package structuralPattern;

interface ToBeSupreme {
    public String reply(String question);
}

class SupremeBeingReal implements ToBeSupreme {

    @Override
    public String reply(String question) {
        return "Because 42 is the answer to everything";
    }
}

class Intermediate implements ToBeSupreme {
    private SupremeBeingReal real;

    public Intermediate() {
        this.real = new SupremeBeingReal();
    }

    @Override
    public String reply(String question) {
        return this.real.reply(question);
    }
}

public class Proxy {
    public static void main(String[] args) {
        new Proxy().execute();
    }

    public void execute() {
        ToBeSupreme supreme = new Intermediate();
        System.out.println(supreme.reply("test?"));
    }
}
