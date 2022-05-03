import Model.Expense;

import java.util.Arrays;

public class SplitWiseMain {

    static SplitWise splitWise;
    public static void main(String[] args) {

        splitWise = new SplitWise();
        addUser();


        Expense expense = ExpenseFactory.equalExpense(1,300.0, Arrays.asList(2,3));
        splitWise.addExpenses(expense);

        showReport();

    }

    public static void addUser() {

        splitWise.addUser("RAM"); // id = 1
        splitWise.addUser("Shyam"); // id = 2
        splitWise.addUser("Ghanshyam"); // id = 3
    }
    public static void showReport() {
        splitWise.showReport(1);
        splitWise.showReport(2);
        splitWise.showReport(3);
    }
}
