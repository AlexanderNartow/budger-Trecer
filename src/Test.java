
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class FinancialManagerTest {

  private FinancialManager financialManager;
  private Scanner scanner;

  @BeforeEach
  public void setup() {
    financialManager = new FinancialManager();
    scanner = new Scanner(System.in);
  }

  @Test
  public void testAddIncome() {
    double expectedIncome = 100.0;
    List<Double> expectedIncomeList = Arrays.asList(expectedIncome);

    financialManager.addIncome("Зарплата", scanner);

    Assertions.assertEquals(expectedIncomeList, financialManager.getIncomeList());
  }

  @Test
  public void testAddExpense() {
    double expectedExpense = 50.0;
    List<Double> expectedExpenseList = Arrays.asList(expectedExpense);

    financialManager.addExpense("Продукты", scanner);

    Assertions.assertEquals(expectedExpenseList, financialManager.getExpenseList());
  }

  @Test
  public void testCalculateTotal() {
    List<Double> incomeList = Arrays.asList(233.0, 444.0, 123.0);
    List<Double> expenseList = Arrays.asList(75.0, 75.0);

    financialManager.setIncomeList(incomeList);
    financialManager.setExpenseList(expenseList);

    double expectedTotal = 475.0;
    double actualTotal = financialManager.calculateTotal();

    Assertions.assertEquals(expectedTotal, actualTotal);
  }
}
