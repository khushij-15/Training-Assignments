/**
 * Concepts covered:
 * 1. Exception hirarchy
 * 2. try catch
 * 3. finally
 * 4. throw
 * 5. throws
 * 6. custom exceptions
 */

// Custom exception class
class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    public BankAccount( double balance ) {
        this.balance = balance;
    }

    public void withdraw (double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance. Available balance: " + balance);
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Remaining balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }
}

public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        try {
            account.withdraw(500); // This should succeed
            account.withdraw(1500);
        } catch (InsufficientBalanceException e) {
            System.out.println("Caught exception: " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt completed.");
        }
    }
}

/**
 * Output:
 * Withdrawal successful. Remaining balance: 500.0
 * Caught exception: Insufficient balance. Available balance: 500.0
 * Transaction attempt completed.
 */