import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrackerSave {

  private static final String FILE_PATH = "res/trackers.csv";
  private static final String CSV_SEPARATOR = ",";

  /**
   * @param incomeCategories
   * @param incomeList
   * @param expenseCategories
   * @param expenseList
   */
  public static void saveFinancialHistory(List<String> incomeCategories, List<Double> incomeList,
                                          List<String> expenseCategories, List<Double> expenseList) {
    try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
      writer.println("Доходы");
      for (int i = 0; i < incomeList.size(); i++) {
        writer.println(incomeCategories.get(i) + CSV_SEPARATOR + incomeList.get(i));
      }
      writer.println("Расходы");
      for (int i = 0; i < expenseList.size(); i++) {
        writer.println(expenseCategories.get(i) + CSV_SEPARATOR + expenseList.get(i));
      }
      System.out.println("История успешно сохранена в файле " + FILE_PATH);
    } catch (IOException e) {
      System.out.println("Ошибка при сохранении истории.");
      e.printStackTrace();
    }
  }

  /**
   *
   * @param type
   * @return
   */
  public static List<Double> readFinancialDataByType(String type, List<String> categories) {
    List<Double> data = new ArrayList<>();
    Map<String, Double> categorySums = new HashMap<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
      String line;
      boolean shouldRead = false;

      while ((line = reader.readLine()) != null) {
        if (line.equals(type)) {
          shouldRead = true;
        } else if (line.contains(CSV_SEPARATOR)) {
          if (shouldRead) {
            String[] parts = line.split(CSV_SEPARATOR);
            if (parts.length == 2) {
              try {
                double amount = Double.parseDouble(parts[1]);
                data.add(amount);

                // Update category sums
                String category = parts[0];
                categories.add(category);
                if (categorySums.containsKey(category)) {
                  double sum = categorySums.get(category);
                  categorySums.put(category, sum + amount);
                } else {
                  categorySums.put(category, amount);
                }
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

    // Print category sums
    for (Map.Entry<String, Double> entry : categorySums.entrySet()) {
      System.out.println("Категория: " + entry.getKey() + ", Сумма: " + entry.getValue());
    }

    return data;
}}