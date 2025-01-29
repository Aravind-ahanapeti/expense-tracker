import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    private String category;
    private double amount;
    private String description;

    public Expense(String category, double amount, String description) {
        this.category = category;
        this.amount = amount;
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}

public class ExpenseTracker {
    private ArrayList<Expense> expenses;
    private Scanner scanner;

    public ExpenseTracker() {
        expenses = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    public void run() {
        while (true) {
            System.out.println("1. Add expense");
            System.out.println("2. View expenses");
            System.out.println("3. Delete expense");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    deleteExpense();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    private void addExpense() {
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        Expense expense = new Expense(category, amount, description);
        expenses.add(expense);
        System.out.println("Expense added successfully!");
    }

    private void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to display.");
        } else {
            System.out.println("Expenses:");
            for (int i = 0; i < expenses.size(); i++) {
                Expense expense = expenses.get(i);
                System.out.println((i + 1) + ". Category: " + expense.getCategory() +
                        ", Amount: " + expense.getAmount() +
                        ", Description: " + expense.getDescription());
            }
        }
    }

    private void deleteExpense() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to delete.");
        } else {
            System.out.print("Enter the number of the expense to delete: ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine(); // Consume newline left-over

            if (index >= 0 && index < expenses.size()) {
                expenses.remove(index);
                System.out.println("Expense deleted successfully!");
            } else {
                System.out.println("Invalid index. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        tracker.run();
    }
}