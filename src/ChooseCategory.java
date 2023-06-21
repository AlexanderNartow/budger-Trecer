import java.util.Scanner;

public class ChooseCategory {

  static String chooseCategory() {
    System.out.println("Выберите категорию:");
    System.out.println("1. Зарплата");
    System.out.println("2. Досуг");
    System.out.println("3. Спорт");
    System.out.println("4. Здоровье");
    System.out.println("5. Продукты");

    Scanner scanner = new Scanner(System.in);

    try {
      int choice = scanner.nextInt();
      scanner.nextLine(); // Считываем лишний символ перевода строки

      switch (choice) {
        case 1:
          return "Зарплата";
        case 2:
          return "Досуг";
        case 3:
          return "Спорт";
        case 4:
          return "Здоровье";
        case 5:
          return "Продукты";
        default:
          System.out.println("Некорректный выбор категории.");
          return "Некорректный выбор категории.";
      }
    } catch (Exception e) {
      System.out.println("Ошибка при вводе категории: " + e.getMessage());
      return null;
    }
  }
}