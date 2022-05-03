import Model.Expense;
import Model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class SplitWise {

    private Integer userId;
    private Map<Integer, User> userM;  // <userId,User>

    private Integer userAccountId;
    private Map<Integer, Map<Integer,Double>> userAccountM;  // <userId, <userId,amount>>

    private Integer expenseId;
    private Map<Integer, Expense> expenseM; // <expenseId,Expense>


    public SplitWise() {
        userId = 0;
        this.userM = new HashMap<>();

        userAccountId = 0;
        this.userAccountM = new HashMap<>();

        expenseId = 0;
        this.expenseM = new HashMap<>();
    }

    public void addExpenses(Expense expense) {

        Integer crId = expense.getPaidBy();
        this.expenseM.put(expense.getExpenseId(),expense);

        for (Map.Entry<Integer, Double> split : expense.getSplits().entrySet()) {

            Integer drId = split.getKey();
            Double drValue = split.getValue();

            Map<Integer,Double> crM = this.userAccountM.getOrDefault(crId,new HashMap<>());
            crM.put(drId,crM.getOrDefault(drId,0.0)+ drValue);
            this.userAccountM.put(crId,crM);

            Map<Integer,Double> drM = this.userAccountM.getOrDefault(drId,new HashMap<>());
            drM.put(crId,drM.getOrDefault(crId,0.0)-drValue);
            this.userAccountM.put(drId,drM);


        }
    }

    public void addUser(String name) {

        userId++;
        User user = User.builder().userId(userId).name(name).build();
        userM.put(userId,user);
    }

    public void showReport(Integer userId) {
        System.out.println(this.userAccountM.getOrDefault(userId,new HashMap<>()).toString());
    }

}
