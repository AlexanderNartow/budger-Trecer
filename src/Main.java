import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    FinancialManager financialManager = new FinancialManager();

    while (true) {
      System.out.println("\n--- Управление финансами ---");
      System.out.println("1.=> Баланс");
      System.out.println("2.=> Добавить доход по категории");
      System.out.println("3.=> Добавить расход по категории");
      System.out.println("4.=> Сохранить финансы");
      System.out.println("5.=> Редактировать");
      System.out.println("6.=> Показать историю финансов всех");
      System.out.println("7.=> Выйти");

      System.out.print("Введите номер действия => ");
      String choice = scanner.nextLine();

      switch (choice) {


        case "1":
          financialManager.displayBalance(); // Вывод текущих расходов
          break;
        case "2":
          financialManager.addIncome(ChooseCategory.chooseCategory(), scanner); // Добавление дохода с выбором категории
          break;
        case "3":
          financialManager.addExpense(ChooseCategory.chooseCategory(), scanner); // Добавление расхода с выбором категории
          break;
        case "4":
          financialManager.saveFinancialHistory(); // Сохранение финансов
          break;
        case "5":
          financialManager.editFinances(); // Редактирование финансов
          break;
        case "6":
          financialManager.displayFinancialHistory(); // Вывод истории финансов
          break;
        case "7":
          System.out.println("Программа завершена.");
          System.exit(0); // Завершение программы
          break;
        default:
          System.out.println("Некорректный ввод. Пожалуйста, выберите действие из предложенных.");
          break;
      }
    }
  }
}


