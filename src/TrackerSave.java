import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TrackerSave {

  private static final String FILE_PATH = "tracker.csv";
  private static final String CSV_SEPARATOR = ",";

  public static void saveFinancialHistory(List<Double> incomeList, List<Double> expenseList) {
    try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
      writer.println("Доходы");
      for (double income : incomeList) {
        writer.println("Income" + CSV_SEPARATOR + income);
      }
      writer.println("Расходы");
      for (double expense : expenseList) {
        writer.println("Expense" + CSV_SEPARATOR + expense);
      }
      System.out.println("История успешно сохранена в файле " + FILE_PATH);
    } catch (IOException e) {
      System.out.println("Ошибка при сохранении истории.");
      e.printStackTrace();
    }
  }

  public static List<Double> readFinancialDataByType(String type) {
    List<Double> data = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
      String line;
      boolean shouldRead = false;

      while ((line = reader.readLine()) != null) {
        if (line.equals(type)) {
          shouldRead = true;
        } else if (line.contains(CSV_SEPARATOR)) {
          if (shouldRead) {
            String[] parts = line.split(CSV_SEPARATOR);
            if (parts.length == 2 && parts[0].equals("Income") || parts[0].equals("Expense")) {
              try {
                double amount = Double.parseDouble(parts[1]);
                data.add(amount);
              } catch (NumberFormatException e) {
                System.out.println("Ошибка при чтении данных.");
                e.printStackTrace();
              }
            }
          }
        } else {
          shouldRead = false;
        }
      }
    } catch (IOException e) {
      System.out.println("Ошибка при чтении файла " + FILE_PATH);
      e.printStackTrace();
    }
    return data;
  }
}