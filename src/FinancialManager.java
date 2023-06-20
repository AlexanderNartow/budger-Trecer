import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FinancialManager {
    private List<Double> incomeList;
    private List<Double> expenseList;
    Scanner scanner = new Scanner(System.in);
    public FinancialManager(){
        incomeList = new ArrayList<>();
        expenseList = new ArrayList<>();
    }

    public FinancialManager(List<Double> incomeList, List<Double> expenseList, Scanner scanner) {
    }

    public List<Double> getIncomeList() {
        return incomeList;
    }

    public List<Double> getExpenseList() {
        return expenseList;
    }
    public void displayBalance(){
        double totalIncome = calculateTotal(incomeList);
        double totalExpense = calculateTotal(expenseList);
        double balance = totalIncome - totalExpense;
        System.out.println("Текущий баланс: " + balance);
    }
    public void displayExpenses(){
        System.out.println("Текущие расходы: ");
        for (double expense: expenseList){
            System.out.println(expense);
        }
    }
    public void addIncome(String category) {
        System.out.print("Введите сумму дохода: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        incomeList.add(amount);
        System.out.println("Доход в категории '" + category + "' успешно добавлен.");
    }

    public void addExpense(String category, Scanner scanner) {
        System.out.print("Введите сумму расхода: ");
        double amount = this.scanner.nextDouble();
        this.scanner.nextLine();

        expenseList.add(amount);
        System.out.println("Расход в категории '" + category + "' успешно добавлен.");
    }
    private double calculateTotal(List<Double> amounts) {
        double total = 0;
        for (double amount : amounts) {
            total += amount;
        }
        return total;
    }
    public void removeExpensesByDate() {
        // Implement logic to remove expenses by
    }

    public void removeIncomeByDate() {
        // Implement logic to remove income by date
    }

    public void saveFinances() {
        // Implement logic to save finances to a file
    }

    public void editFinances() {
        // Implement logic to edit finances
    }

    public void displayFinancialHistory() {
        // Implement logic to display financial history
    }

    public void setIncomeList(List<Double> incomeList) {
    }

    public void setExpenseList(List<Double> expenseList) {
    }

    public double calculateTotal() {

      return 0;
    }

    public void addIncome(String salary, Scanner scanner) {
    }
}