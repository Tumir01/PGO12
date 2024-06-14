import java.util.ArrayList;
import java.util.List;

public class kontoBankowe implements AccountOperations {
    private double balance;
    private List<Transaction> transactions;

    public kontoBankowe() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    @Override
    public void transfer(double kwota, kontoBankowe celoweKonto) throws AccountOperationException {
        if (kwota <= 0 || kwota > balance) {
            throw new AccountOperationException("Niepoprawna kwota!");
        }
        this.balance -= kwota;
        celoweKonto.deposit(kwota);
        Transaction transaction = new Transaction(kwota, this, celoweKonto);
        this.transactions.add(transaction);
        celoweKonto.addTransaction(transaction);
    }

    @Override
    public void deposit(double kwota) throws AccountOperationException {
        if (kwota <= 0) {
            throw new AccountOperationException("Niepoprawna kwota!");
        }
        this.balance += kwota;
        Transaction transaction = new Transaction(kwota, null, this);
        this.transactions.add(transaction);
    }

    private void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}