package Service;

import Model.Expense;
import Model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import storage.ExpenseStorage;
import storage.UserAccountStorage;
import storage.UserStorage;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class SplitWiseService {

    private UserStorage<Integer,User> userM;
    private UserAccountStorage<Integer, Map<Integer,Double>> userAccountM;
    private ExpenseStorage<Integer,Expense> expenseM;


    public SplitWiseService() {
        this.userM = new UserStorage<>(0);

        this.userAccountM = new UserAccountStorage<>();


        this.expenseM = new ExpenseStorage<>(0);
    }

    public void addExpenses(Expense expense) {

        Integer crId = expense.getPaidBy();
        Integer expenseId = this.expenseM.getId()+1;
        this.expenseM.add(expenseId,expense);

        for (Map.Entry<Integer, Double> split : expense.getSplits().entrySet()) {

            Integer drId = split.getKey();
            Double drValue = split.getValue();


            Map<Integer,Double> crM;
            try {
                crM = this.userAccountM.get(crId);
            } catch (RuntimeException rte) {
                crM = new HashMap<>();
            }
            crM.put(drId,crM.getOrDefault(drId,0.0)+ drValue);
            this.userAccountM.upsert(crId,crM);

            Map<Integer,Double> drM;
            try {
                drM = this.userAccountM.get(crId);
            } catch (RuntimeException rte) {
                drM = new HashMap<>();
            }
            drM.put(crId,drM.getOrDefault(crId,0.0)-drValue);
            this.userAccountM.upsert(drId,drM);
        }
    }

    public void addUser(String name) {

        Integer userId = userM.getId()+1;
        User user = User.builder().userId(userId).name(name).build();
        userM.add(userId,user);
    }

    public void showReport(Integer userId) {

        try {
            System.out.println(this.userAccountM.get(userId).toString());
        } catch (Exception e) {
            System.out.println(new HashMap<>());
        }
    }

}
