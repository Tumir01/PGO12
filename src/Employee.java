public class Employee extends User {
    private static int employeeIdCounter = 0;
    private int employeeId;

    public Employee(String firstName, String lastName) {
        super(firstName, lastName);
        this.employeeId = ++employeeIdCounter;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public Client addClient(String imie, String nazwisko) {
        return new Client(imie, nazwisko);
    }

    public kontoBankowe otworzycKonto() {
        return new kontoBankowe();
    }

    public void depositToAccount(kontoBankowe konto, double kwota) throws AccountOperationException {
        konto.deposit(kwota);
    }
}
