public class Main {
    public static void main(String[] args) {
        try {
            Admin admin = new Admin("imie", "nazwisko");

            Employee employee1 = admin.addEmployee("imie1", "nazwisko1");
            Employee employee2 = admin.addEmployee("imie2", "nazwisko2");

            Client client1 = employee1.addClient("imie3", "nazwisko3");
            Client client2 = employee1.addClient("imie4", "nazwisko4");
            Client client3 = employee2.addClient("imie5", "nazwisko5");
            Client client4 = employee2.addClient("imie6", "nazwisko6");

            employee1.depositToAccount(client1.getAccount(), 1000);
            employee1.depositToAccount(client2.getAccount(), 2000);
            employee2.depositToAccount(client3.getAccount(), 3000);
            employee2.depositToAccount(client4.getAccount(), 4000);

            client1.performTransfer(100, client2.getAccount());
            client2.performTransfer(200, client3.getAccount());
            client3.performTransfer(300, client4.getAccount());
            client4.performTransfer(400, client1.getAccount());
            client1.performTransfer(150, client3.getAccount());
            client2.performTransfer(250, client4.getAccount());
            client3.performTransfer(350, client1.getAccount());
            client4.performTransfer(450, client2.getAccount());
            client1.performTransfer(200, client4.getAccount());
            client2.performTransfer(300, client3.getAccount());

            Client[] clients = {client1, client2, client3, client4};

            for (Client client : clients) {
                System.out.println("Users.Client ID: " + client.getClientId() + ", Balance: " + client.getAccount().checkBalance());
                for (Transaction t : client.getAccount().getTransactions()) {
                    System.out.println("Amount: " + t.getKwota() + ", From: " +
                            (t.getKonto1() != null ? t.getKonto1().hashCode() : "N/A") +
                            ", To: " + t.getKonto2().hashCode());
                }
            }

        } catch (AccountOperationException e) {
            e.printStackTrace();
        }
    }
}
