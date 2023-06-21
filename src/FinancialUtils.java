import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FinancialUtils {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    /**
     *
     * @param expenseList список расходов
     * @param category категория, которую необходимо сопоставить и удалить
     */
    public static void removeExpensesByCategory(List<Double> expenseList, String category) {
        Iterator<Double> iterator = expenseList.iterator();
        while (iterator.hasNext()) {
            double expense = iterator.next();
            // Assuming the expenseList contains the category information as a string representation of the expense
            if (Double.toString(expense).equals(category)) {
                iterator.remove();
            }
        }
    }

    /**
     *
     * @param incomeList список доходов
     * @param category категория для сопоставления и удаления
     */
    public static void removeIncomeByCategory(List<Double> incomeList, String category) {
        Iterator<Double> iterator = incomeList.iterator();
        while (iterator.hasNext()) {
            double income = iterator.next();
            // Assuming the incomeList contains the category information as a string representation of the income
            if (Double.toString(income).equals(category)) {
                iterator.remove();
            }
        }
    }

    /**
     *
     * @param expenseList список расходов
     * @param expenseDates перечень дат, соответствующих расходам
     * @param scanner Scanner объект для чтения пользовательского ввода
     */

    public static void removeExpensesByDate(List<Double> expenseList, List<LocalDate> expenseDates, Scanner scanner) {
        System.out.print("Введите дату для удаления расходов (в формате дд.мм.гггг): ");
        String dateString = scanner.nextLine();

        LocalDate dateToRemove = LocalDate.parse(dateString, DATE_FORMATTER);

        Iterator<Double> expenseIterator = expenseList.iterator();
        Iterator<LocalDate> dateIterator = expenseDates.iterator();
        while (expenseIterator.hasNext() && dateIterator.hasNext()) {
            double expense = expenseIterator.next();
            LocalDate expenseDate = dateIterator.next();

            if (expenseDate.equals(dateToRemove)) {
                expenseIterator.remove();
                dateIterator.remove();
            }
        }
    }

    /**
     *
     * @param incomeList список расходов
     * @param incomeDates перечень дат, соответствующих расходам
     * @param scanner объект Scanner для чтения пользовательского ввода
     */
    public static void removeIncomeByDate(List<Double> incomeList, List<LocalDate> incomeDates, Scanner scanner) {
        System.out.print("Введите дату для удаления доходов (в формате дд.мм.гггг): ");
        String dateString = scanner.nextLine();

        LocalDate dateToRemove = LocalDate.parse(dateString, DATE_FORMATTER);

        Iterator<Double> incomeIterator = incomeList.iterator();
        Iterator<LocalDate> dateIterator = incomeDates.iterator();
        while (incomeIterator.hasNext() && dateIterator.hasNext()) {
            double income = incomeIterator.next();
            LocalDate incomeDate = dateIterator.next();

            if (incomeDate.equals(dateToRemove)) {
                incomeIterator.remove();
                dateIterator.remove();
            }
        }
    }
}