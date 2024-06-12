import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

// Class representing the ATM machine with Swing GUI
public class ATM extends JFrame {
    public ATM(BankAccount account) {
        setTitle("ATM");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JButton checkBalanceButton = new JButton("Check Balance");
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton exitButton = new JButton("Exit");

        JLabel balanceLabel = new JLabel("Balance: $" + account.getBalance());

        checkBalanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Your current balance is: $" + account.getBalance(), "Balance", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String depositAmountString = JOptionPane.showInputDialog("Enter deposit amount:");
                try {
                    double depositAmount = Double.parseDouble(depositAmountString);
                    if (depositAmount > 0) {
                        account.deposit(depositAmount);
                        balanceLabel.setText("Balance: $" + account.getBalance());
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid amount. Deposit failed.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String withdrawAmountString = JOptionPane.showInputDialog("Enter withdrawal amount:");
                try {
                    double withdrawAmount = Double.parseDouble(withdrawAmountString);
                    if (withdrawAmount > 0) {
                        if (account.withdraw(withdrawAmount)) {
                            balanceLabel.setText("Balance: $" + account.getBalance());
                        } else {
                            JOptionPane.showMessageDialog(null, "Insufficient funds. Withdrawal failed.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid amount. Withdrawal failed.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        panel.add(checkBalanceButton);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(exitButton);

        add(panel, BorderLayout.CENTER);
        add(balanceLabel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Initial balance of $1000
        new ATM(userAccount);
    }
}
