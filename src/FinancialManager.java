import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FinancialManager {

  private List<String> incomeCategories; // Список категорий доходов
  private List<String> expenseCategories; // Список категорий расходов
  private List<Double> incomeList; // Список доходов
  private List<Double> expenseList; // Список расходов
  Scanner scanner = new Scanner(
      System.in); // Инициализация сканнера для считывания пользовательского ввода

  public FinancialManager() {
    incomeCategories = new ArrayList<>(); // Инициализация списка категорий доходов
    expenseCategories = new ArrayList<>(); // Инициализация списка категорий расходов
    incomeList = TrackerSave.readFinancialDataByType("Доходы", incomeCategories);
    expenseList = TrackerSave.readFinancialDataByType("Расходы", expenseCategories);
  }

  public List<Double> getIncomeList() {
    return incomeList; // Возвращает список доходов
  }

  public List<Double> getExpenseList() {
    return expenseList; // Возвращает список расходов
  }

  public void displayBalance() {
    double totalIncome = calculateTotal(incomeList); // Рассчитывает сумму всех доходов
    double totalExpense = calculateTotal(expenseList); // Рассчитывает сумму всех расходов
    double balance =
        totalIncome - totalExpense; // Рассчитывает баланс (разницу между доходами и расходами)
    System.out.println("Текущий баланс: " + balance); // Выводит текущий баланс
  }

  public void displayExpenses() {
    System.out.println("Текущие расходы: ");
    for (double expense : expenseList) {
      System.out.println(expense); // Выводит текущие расходы
    }
  }

  /**
   * @param category категория дохода
   * @param scanner  объект Scanner для чтения пользовательского ввода
   */
  public void addIncome(String category, Scanner scanner) {
    double amount;
    String inputCategory = null; // Используем переданную категорию как значение по умолчанию

    while (true) {
      System.out.print("Введите сумму дохода: ");
      try {
        amount = scanner.nextDouble();
        scanner.nextLine();
        break; // Выходим из цикла, если ввод корректен
      } catch (InputMismatchException e) {
        System.out.println("Ошибка! Введите числовое значение.");
        scanner.nextLine(); // Считываем лишний символ перевода строки
      }
    }

    while (inputCategory == null || inputCategory.isEmpty()) {
      System.out.print("Введите категорию дохода: ");
      inputCategory = scanner.nextLine();
      if (inputCategory.isEmpty()) {
        System.out.println("Ошибка! Категория не может быть пустой.");
      }
    }

    incomeList.add(amount); // Добавляет сумму дохода в список доходов
    System.out.println("Доход в категории '" + inputCategory + "' успешно добавлен.");
    incomeCategories.add(inputCategory); // Добавляет категорию дохода в список категорий доходов
  }

  public List<String> getIncomeCategories() {
    return incomeCategories; // Возвращает список категорий доходов
  }

  public List<String> getExpenseCategories() {
    return expenseCategories; // Возвращает список категорий расходов
  }

  public void setIncomeCategories(List<String> incomeCategories) {
    this.incomeCategories = incomeCategories; // Устанавливает список категорий доходов
  }

  public void setExpenseCategories(List<String> expenseCategories) {
    this.expenseCategories = expenseCategories; // Устанавливает список категорий расходов
  }

  public void addExpense(String category, Scanner scanner) {
    double amount;
    String inputCategory = null; // Используем null в качестве значения по умолчанию

    while (true) {
      System.out.print("Введите сумму расхода: ");
      try {
        amount = scanner.nextDouble();
        scanner.nextLine();
        break; // Выходим из цикла, если ввод корректен
      } catch (InputMismatchException e) {
        System.out.println("Ошибка! Введите числовое значение.");
        scanner.nextLine(); // Считываем лишний символ перевода строки
      }
    }

    while (inputCategory == null || inputCategory.isEmpty()) {
      System.out.print("Введите категорию расхода: ");
      inputCategory = scanner.nextLine();
      if (inputCategory.isEmpty()) {
        System.out.println("Ошибка! Категория не может быть пустой.");
      }
    }

    expenseList.add(amount); // Добавляет сумму расхода в список расходов
    System.out.println("Расход в категории '" + inputCategory + "' успешно добавлен.");
    expenseCategories.add(inputCategory); // Добавляет категорию расхода в список категорий расходов
  }

  private double calculateTotal(List<Double> amounts) {
    double total = 0;
    for (double amount : amounts) {
      total += amount;
    }
    return total;
  }

  public void saveFinances() {
    TrackerSave.saveFinancialHistory(incomeCategories, incomeList, expenseCategories, expenseList);
    System.out.println("Финансовые данные успешно сохранены.");
  }

  public void editFinances() {
    System.out.println("Выберите, что вы хотите отредактировать:");
    System.out.println("1. Редактировать доходы");
    System.out.println("2. Редактировать расходы");
    System.out.println("3. Удалить доход");
    System.out.println("4. Удалить расход");

    int choice = scanner.nextInt();
    scanner.nextLine(); // Считываем лишний символ перевода строки

    switch (choice) {
      case 1:
        editIncome();
        break;
      case 2:
        editExpense();
        break;
      case 3:
        deleteIncome();
        break;
      case 4:
        deleteExpense();
        break;
      default:
        System.out.println("Некорректный выбор.");
        break;
    }
  }

  private void deleteIncome() {
    System.out.println("Выберите номер дохода, который вы хотите удалить:");
    for (int i = 0; i < incomeList.size(); i++) {
      System.out.println(
          (i + 1) + ". Категория: " + incomeCategories.get(i) + ", Сумма: " + incomeList.get(i));
    }

    int index = scanner.nextInt();
    scanner.nextLine(); // Считываем лишний символ перевода строки

    deleteIncomeByNumber(index);
  }

  private void deleteExpense() {
    System.out.println("Выберите номер расхода, который вы хотите удалить:");
    for (int i = 0; i < expenseList.size(); i++) {
      System.out.println(
          (i + 1) + ". Категория: " + expenseCategories.get(i) + ", Сумма: " + expenseList.get(i));
    }

    int index = scanner.nextInt();
    scanner.nextLine(); // Считываем лишний символ перевода строки

    deleteExpenseByNumber(index);
  }

  public void deleteExpenseByNumber(int number) {
    if (number >= 1 && number <= expenseList.size()) {
      expenseList.remove(number - 1);
      expenseCategories.remove(number - 1);
      System.out.println("Расход успешно удален.");
    } else {
      System.out.println("Некорректный номер расхода.");
    }
  }

  public void deleteIncomeByNumber(int number) {
    if (number >= 1 && number <= incomeList.size()) {
      incomeList.remove(number - 1);
      incomeCategories.remove(number - 1);
      System.out.println("Доход успешно удален.");
    } else {
      System.out.println("Некорректный номер дохода.");
    }
  }

  private void editIncome() {
    System.out.println("Выберите номер дохода, который вы хотите отредактировать:");
    for (int i = 0; i < incomeList.size(); i++) {
      System.out.println(
          (i + 1) + ". Категория: " + incomeCategories.get(i) + ", Сумма: " + incomeList.get(i));
    }

    int index = scanner.nextInt();
    scanner.nextLine(); // Считываем лишний символ перевода строки

    if (index < 1 || index > incomeList.size()) {
      System.out.println("Некорректный номер дохода.");
      return;
    }

    System.out.print("Введите новую категорию дохода: ");
    String newIncomeCategory = scanner.nextLine();

    System.out.print("Введите новое значение дохода: ");
    double newIncome = scanner.nextDouble();
    scanner.nextLine();

    incomeList.set(index - 1, newIncome);
    incomeCategories.set(index - 1, newIncomeCategory);

    System.out.println("Доход успешно отредактирован.");
  }

  private void editExpense() {
    System.out.println("Выберите номер расхода, который вы хотите отредактировать:");
    for (int i = 0; i < expenseList.size(); i++) {
      System.out.println(
          (i + 1) + ". Категория: " + expenseCategories.get(i) + ", Сумма: " + expenseList.get(i));
    }

    int index = scanner.nextInt();
    scanner.nextLine(); // Считываем лишний символ перевода строки

    if (index < 1 || index > expenseList.size()) {
      System.out.println("Некорректный номер расхода.");
      return;
    }

    System.out.print("Введите новую категорию расхода: ");
    String newExpenseCategory = scanner.nextLine();

    System.out.print("Введите новое значение расхода: ");
    double newExpense = scanner.nextDouble();
    scanner.nextLine();

    expenseList.set(index - 1, newExpense);
    expenseCategories.set(index - 1, newExpenseCategory);

    System.out.println("Расход успешно отредактирован.");
  }


  public void setIncomeList(List<Double> incomeList) {
    this.incomeList = incomeList;
  }

  public void setExpenseList(List<Double> expenseList) {
    this.expenseList = expenseList;
  }


  public double calculateTotal() {
    return 0;
  }

  public void displayFinancialHistory() {
    System.out.println("История финансов:");
    System.out.println("Доходы:");
    for (int i = 0; i < incomeList.size(); i++) {
      System.out.println(
          (i + 1) + ": " + incomeCategories.get(i) + ": Сумма: " + incomeList.get(i));
    }

    System.out.println("Расходы:");
    for (int i = 0; i < expenseList.size(); i++) {
      System.out.println(
          (i + 1) + ": " + expenseCategories.get(i) + ": Сумма: " + expenseList.get(i));
    }
  }

  public void saveFinancialHistory() {
    TrackerSave.saveFinancialHistory(incomeCategories, incomeList, expenseCategories, expenseList);
    System.out.println("Финансовые данные успешно сохранены.");
  }

}