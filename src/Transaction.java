public class Transaction {
    private double kwota;
    private kontoBankowe konto1;
    private kontoBankowe konto2;

    public Transaction(double kwota, kontoBankowe konto1, kontoBankowe konto2) {
        this.kwota = kwota;
        this.konto1 = konto1;
        this.konto2 = konto2;
    }

    public double getKwota() {
        return kwota;
    }

    public kontoBankowe getKonto1() {
        return konto1;
    }

    public kontoBankowe getKonto2() {
        return konto2;
    }
}