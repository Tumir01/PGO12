public class Client extends User {
    private static int clientIdCounter = 0;
    private int clientId;
    private kontoBankowe account;

    public Client(String imie, String nazwisko) {
        super(imie, nazwisko);
        this.clientId = ++clientIdCounter;
        this.account = new kontoBankowe();
    }

    public int getClientId() {
        return clientId;
    }

    public kontoBankowe getAccount() {
        return account;
    }

    public void performDeposit(double kwota) throws AccountOperationException {
        account.deposit(kwota);
    }

    public void performTransfer(double amount, kontoBankowe targetAccount) throws AccountOperationException {
        account.transfer(amount, targetAccount);
    }
}
