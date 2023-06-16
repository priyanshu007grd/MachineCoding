import Model.Expense;
import Service.SplitWiseService;

import java.util.Arrays;

public class SplitWiseMain {

    static SplitWiseService splitWiseService;
    public static void main(String[] args) {

        splitWiseService = new SplitWiseService();
        addUser();


        Expense expense = ExpenseFactory.equalExpense(1,300.0, Arrays.asList(2,3));
        splitWiseService.addExpenses(expense);

        showReport();

    }

    public static void addUser() {

        splitWiseService.addUser("RAM"); // id = 1
        splitWiseService.addUser("Shyam"); // id = 2
        splitWiseService.addUser("Ghanshyam"); // id = 3
        splitWiseService.addUser("Ghanshyam2");
    }
    public static void showReport() {
        System.out.println();
        System.out.println("Showing report for userid: 1");
        splitWiseService.showReport(1);

        System.out.println();
        System.out.println("Showing report for userid: 2");
        splitWiseService.showReport(2);

        System.out.println();
        System.out.println("Showing report for userid: 3");
        splitWiseService.showReport(3);

        System.out.println();
        System.out.println("Showing report for userid: 4");
        splitWiseService.showReport(4);
    }
}
