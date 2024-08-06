package anudip.com;

public class BankExc {
    private String accountNumber;
    private double balance;

    public static void main(String[] args) {
        BankExc account = new BankExc("12345", 1000.0);
        try {
            account.deposit(-500.0);
            System.out.println("Deposit successful. New balance: " + account.getBalance());
        } catch (NegativeDepositException e) {
            System.out.println(e.getMessage());
        }
        try {
            account.withdraw(26500.0);
            System.out.println("Withdrawal successful. New balance: " + account.getBalance());
        } catch (InsufficientFundsException | NegativeDepositException e) {
            System.out.println(e.getMessage());
        }
        
    }
    public BankExc(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) throws NegativeDepositException {
        if (amount < 0) {
            throw new NegativeDepositException("Deposit amount cannot be negative");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException, NegativeDepositException {
        if (amount < 0) {
            throw new NegativeDepositException("Withdrawal amount cannot be negative");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds in account");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
    
    
}

class NegativeDepositException extends RuntimeException {
    public NegativeDepositException(String message) {
        super(message);
    }
} 

class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class InvalidAccountException extends RuntimeException {
    public InvalidAccountException(String message) {
        super(message);
    }
}
