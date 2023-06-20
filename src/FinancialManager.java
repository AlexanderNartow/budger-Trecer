import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FinancialManager {

  private List<Double> incomeList;
  private List<Double> expenseList;
  Scanner scanner = new Scanner(System.in);

  public FinancialManager() {
    incomeList = new ArrayList<>();
    expenseList = new ArrayList<>();
  }

  public List<Double> getIncomeList() {
    return incomeList;
  }

  public List<Double> getExpenseList() {
    return expenseList;
  }

  public void displayBalance() {
    double totalIncome = calculateTotal(incomeList);
    double totalExpense = calculateTotal(expenseList);
    double balance = totalIncome - totalExpense;
    System.out.println("Текущий баланс: " + balance);
  }

  public void displayExpenses() {
    System.out.println("Текущие расходы: ");
    for (double expense : expenseList) {
      System.out.println(expense);
    }
  }

  public void addIncome(String category, Scanner scanner) {
    System.out.print("Введите сумму дохода: ");
    double amount = this.scanner.nextDouble();
    this.scanner.nextLine();

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
    System.out.println("Выберите, что вы хотите отредактировать:");
    System.out.println("1. Редактировать доходы");
    System.out.println("2. Редактировать расходы");

    int choice = scanner.nextInt();
    scanner.nextLine(); // Считываем лишний символ перевода строки

    switch (choice) {
      case 1:
        editIncome();
        break;
      case 2:
        editExpense();
        break;
      default:
        System.out.println("Некорректный выбор.");
        break;
    }
  }

  private void editIncome() {
    System.out.println("Выберите номер дохода, который вы хотите отредактировать:");
    for (int i = 0; i < incomeList.size(); i++) {
      System.out.println((i + 1) + ". " + incomeList.get(i));
    }

    int index = scanner.nextInt();
    scanner.nextLine(); // Считываем лишний символ перевода строки

    if (index < 1 || index > incomeList.size()) {
      System.out.println("Некорректный номер дохода.");
      return;
    }

    System.out.print("Введите новое значение дохода: ");
    double newIncome = scanner.nextDouble();
    scanner.nextLine(); // Считываем лишний символ перевода строки

    incomeList.set(index - 1, newIncome);
    System.out.println("Доход успешно отредактирован.");
  }

  private void editExpense() {
    System.out.println("Выберите номер расхода, который вы хотите отредактировать:");
    for (int i = 0; i < expenseList.size(); i++) {
      System.out.println((i + 1) + ". " + expenseList.get(i));
    }

    int index = scanner.nextInt();
    scanner.nextLine(); // Считываем лишний символ перевода строки

    if (index < 1 || index > expenseList.size()) {
      System.out.println("Некорректный номер расхода.");
      return;
    }

    System.out.print("Введите новое значение расхода: ");
    double newExpense = scanner.nextDouble();
    scanner.nextLine(); // Считываем лишний символ перевода строки

    expenseList.set(index - 1, newExpense);
    System.out.println("Расход успешно отредактирован.");
  }

  public void setIncomeList(List<Double> incomeList) {
  }

  public void setExpenseList(List<Double> expenseList) {
  }

  public double calculateTotal() {
    return 0;
  }

  public void displayFinancialHistory() {
    System.out.println("История финансов:");
    System.out.println("Доходы:");
    for (int i = 0; i < incomeList.size(); i++) {
      System.out.println("Доход #" + (i + 1) + ": " + incomeList.get(i));
    }

    System.out.println("Расходы:");
    for (int i = 0; i < expenseList.size(); i++) {
      System.out.println("Расход #" + (i + 1) + ": " + expenseList.get(i));
    }

  }

  public void saveFinancialHistory() {
    TrackerSave.saveFinancialHistory(incomeList, expenseList);
  }
}
