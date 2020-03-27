package bankaccount;

public class BankAccount {
        private Client client;
        private double balance;
        private String pinCode;

        public BankAccount(Client client, String pinCode) {
            this.client = client;
            this.pinCode = pinCode;
            this.balance = 2000;

        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }
        public void deposit(double amount){
            if(amount < 0){
                throw new IllegalArgumentException();
            }
            this.balance += amount;
        }
        public void withdraw(double amount){
            if(this.balance < amount){
                throw new IllegalArgumentException("Insufficient balance");
            }
            this.balance -= amount;

        }

        @Override
        public String toString(){
            return String.format("Account of %s, balance %.2f",this.client.getName(),this.balance);
        }
}
