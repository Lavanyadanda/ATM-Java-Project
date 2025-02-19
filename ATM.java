package leetcode_sums;
import java.util.*;

// Business class
public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter PIN:");
        int x = sc.nextInt();

        ATMFun atm = new ATMFun();
        int storedPin = atm.getPin();
        int option;

        if (storedPin == x) {
            do {
                System.out.println("\n===== ATM Menu =====");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Balance");
                System.out.println("4. PIN Change");
                System.out.println("5. Transaction History");
                System.out.println("6. Exit");
                System.out.print("Enter your option: ");
                option = sc.nextInt();

                switch (option) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        int depositAmount = sc.nextInt();
                        atm.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        int withdrawAmount = sc.nextInt();
                        atm.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.println("Current balance: ₹" + atm.getBalance());
                        break;
                    case 4:
                        System.out.print("Enter new PIN: ");
                        int newPin = sc.nextInt();
                        atm.setPin(newPin);
                        System.out.println("PIN updated successfully.");
                        break;
                    case 5:
                        atm.showTransactionHistory();
                        break;
                    case 6:
                        System.out.println("Exiting... Thank you for using our ATM.");
                        break;
                    default:
                        System.out.println("Invalid option! Please try again.");
                }
            } while (option != 6);
        } else {
            System.out.println("Incorrect PIN! Try again.");
        }
        sc.close();
    }
}

// Logic class
class ATMFun {
    private float balance = 1000f;
    private int pin = 1234;
    private List<String> transactionHistory = new ArrayList<>();

    void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("❌ Insufficient balance.");
        } else if (balance - amount >= 500) {
            balance -= amount;
            transactionHistory.add("Withdrawn: ₹" + amount);
            System.out.println("✅ Withdrawal successful.");
        } else {
            System.out.println("❌ Minimum balance of ₹500 must be maintained.");
        }
    }

    void deposit(int amount) {
        if (amount % 10 == 0) {
            balance += amount;
            transactionHistory.add("Deposited: ₹" + amount);
            System.out.println("✅ Money deposited successfully.");
        } else {
            System.out.println("❌ Amount must be a multiple of ₹10.");
        }
    }

    void setPin(int newPin) {
        pin = newPin;
    }

    int getPin() {
        return pin;
    }

    float getBalance() {
        return balance;
    }

    void showTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("\n📜 Transaction History:");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }
}
