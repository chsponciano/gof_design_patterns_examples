package structuralPattern;

enum Category {
    PROMOTIONAL,
    RELEASE,
    NORMAL
}

class CD {
    private float cost;

    public CD(Category category) {
        switch (category) {
            case PROMOTIONAL:
                this.cost = 9.99f;
            case NORMAL:
                this.cost = 19.99f;
            case RELEASE:
                this.cost = 29.99f;
        }
    }

    public float getCost() {
        return this.cost;
    }
}

class Client {
    private short buy;
    private short rent;

    public void addBuy() {
        this.buy++;
    }

    public void addRent() {
        this.rent++;
    }

    @Override
    public String toString() {
        return "[Client] buys: " + this.buy + " - rents: " + this.rent;
    }
}

class RecordCompany {
    private float passAlong = 0.0f;

    public void setPassAlong(float passAlong) {
        this.passAlong += passAlong;
    }

    @Override
    public String toString() {
        return "[Record Company] Pass along: " + this.passAlong;
    }
}

class RNFacade{
    private Client client;
    private RecordCompany recordCompany;

    public RNFacade() {
        this.client = new Client();
        this.recordCompany = new RecordCompany();
    }

    public void buy(Category c) {
        CD cd = new CD(c);
        this.client.addBuy();
        this.recordCompany.setPassAlong(cd.getCost() * 0.5f);
        this.print();
    }

    public void rent(Category c) {
        CD cd = new CD(c);
        this.client.addRent();
        this.recordCompany.setPassAlong(cd.getCost() * 0.05f);
        this.print();
    }

    void print() {
        System.out.println(this.client);
        System.out.println(this.recordCompany);
    }
}

public class Facade {
    public static void main(String[] args) {
        new Facade().work();
    }

    public void work() {
        RNFacade rnFacade = new RNFacade();
        rnFacade.buy(Category.NORMAL);
        rnFacade.rent(Category.NORMAL);
    }
}
