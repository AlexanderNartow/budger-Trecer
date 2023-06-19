import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("\n--- Управление финансами ---");
      System.out.println("0. Текущее состояние баланса");
      System.out.println("1. Текущие расходы");
      System.out.println("2. Добавить доход по категории");
      System.out.println("3. Добавить расход по категории");
      System.out.println("4. Удалить расходы по дате ");
      System.out.println("5. Удалить доходы по дате ");
      System.out.println("6. Сохранить финансы ");
      System.out.println("7. Редактировать ");
      System.out.println("8. Показать историю финансов всех ");
      System.out.println("9. Выйти");

      System.out.print("Введите номер действия: ");
      String choice = scanner.nextLine();
      switch (choice){

      }

    }
  }
}