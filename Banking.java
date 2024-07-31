package Bank;
class User {
    private String name;
    private int accountNumber;

    public User(String name, int accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }
}

class Bankacc {
    private int accountNumber;
    private double balance;
    private User customer;

    public Bankacc(int accountNumber, User user1) {
        this.accountNumber = accountNumber;
        this.customer = user1;
        this.balance = 0.0;
    }

	public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdraw: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public User getCustomer() {
        return customer;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}

public class Banking {
    public static void main(String[] args) {
        User user1 = new User("Altamash ", 12345);
        Bankacc account1 = new Bankacc(12345, user1);
        account1.deposit(1000);
        account1.withdraw(500);
        System.out.println("Account balance: " + account1.getBalance());
        System.out.println("Customer Name: " + account1.getCustomer().getName());
        System.out.println("Customer Account Number: " + account1.getCustomer().getAccountNumber());
    }
}
