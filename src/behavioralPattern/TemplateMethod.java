package behavioralPattern;

abstract class Item {
    public final boolean remove(int quantity)  {
        if (!this.validateQuantity(quantity)) {
            System.out.println("Prevent removal");
            return false;
        }

        if (this.getStock() >= quantity) {
            this.decStock(quantity);
            System.out.println("Items removed");
            return true;
        }

        System.out.println("Prevent removal");
        return false;
    }

    protected abstract boolean validateQuantity(int quantity);
    protected abstract int getStock();
    protected abstract void decStock(int quantity);
}

class GeneralItem extends Item {
    private String name;
    private int quantity;
    private int matrixQuantity;

    public GeneralItem(String name, int quantity, int matrixQuantity) {
        this.name = name;
        this.quantity = quantity;
        this.matrixQuantity = matrixQuantity;
    }

    @Override
    public String toString() {
        return this.name + " - Na loja: " + this.quantity + " - Na matriz: " + this.matrixQuantity;
    }

    @Override
    protected boolean validateQuantity(int quantity) {
        return this.quantity  >= 0;
    }

    @Override
    protected int getStock() {
        return this.quantity + this.matrixQuantity;
    }

    @Override
    protected void decStock(int quantity) {
        if (quantity > this.quantity) {
            quantity -= this.quantity;
            this.quantity = 0;
            this.matrixQuantity -= quantity;
        } else {
            this.quantity -= quantity;
        }
    }
}

class RareItem extends Item {
    private String name;
    private int maximumWithdrawals;
    private int quantity;

    public RareItem(String name, int maximumWithdrawals, int quantity) {
        this.name = name;
        this.maximumWithdrawals = maximumWithdrawals;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return this.name + " - Na loja: " + this.quantity
                + " - (Max. Retirada: : " + this.maximumWithdrawals + ")";
    }

    @Override
    protected boolean validateQuantity(int quantity) {
        return this.quantity  >= 0 && this.quantity <= Math.min(this.quantity, this.maximumWithdrawals);
    }

    @Override
    protected int getStock() {
        return this.quantity;
    }

    @Override
    protected void decStock(int quantity) {
        this.quantity -= quantity;
    }
}

public class TemplateMethod {
    public static void main(String[] args) {
        new TemplateMethod().execute();
    }

    public void execute() {
        System.out.println("Exemplo de item geral");
        Item general = new GeneralItem("Sal", 20, 10);
        System.out.println(general);
        System.out.println("Obter 6 Unidades: ");
        general.remove(6);
        System.out.println(general);
        System.out.println("Obter 17 Unidades: ");
        general.remove(17);
        System.out.println(general);

        System.out.println("Exemplo de item raro");
        Item rare = new RareItem("Plutonio", 5, 20);
        System.out.println(rare);
        System.out.println("Obter 6 Unidades: ");
        rare.remove(6);
        System.out.println(rare);
        System.out.println("Obter 3 Unidades: ");
        rare.remove(3);
        System.out.println(rare);
    }
}
