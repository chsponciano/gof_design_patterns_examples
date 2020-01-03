package creativePattern;

class CheckingAccount {
    private String codeAccount;
    private static CheckingAccount instance;

    private CheckingAccount() {

    }

    public static CheckingAccount getInstance() {
        if (instance == null) {
            instance = new CheckingAccount();
        }
        return instance;
    }

    public void setCodeAccount(String codeAccount) {
        this.codeAccount = codeAccount;
    }

    @Override
    public String toString() {
        return this.codeAccount;
    }
}

public class Singleton {
    public static void main(String[] args) {
        new Singleton().createAccount();
    }

    public void createAccount() {
        CheckingAccount ca1 = CheckingAccount.getInstance();
        ca1.setCodeAccount("123-45");
        System.out.println(ca1 + " - " + ca1.hashCode());

        CheckingAccount ca2 = CheckingAccount.getInstance();
        ca2.setCodeAccount("323-35");
        System.out.println(ca2 + " - " + ca2.hashCode());
    }
}
