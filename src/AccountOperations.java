public interface AccountOperations {
    double checkBalance();
    void transfer(double kwota, kontoBankowe celoweKonto) throws AccountOperationException;
    void deposit(double kwota) throws AccountOperationException;
}