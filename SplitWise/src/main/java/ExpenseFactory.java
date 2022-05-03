import Model.Expense;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseFactory {

    public static Expense equalExpense(Integer crId, Double amount, List<Integer> drIds) {

        Map<Integer,Double> splits = new HashMap<>();
        Double splitedAmount = amount/(drIds.size()+1);

        for(Integer drId : drIds) {
            splits.put(drId,splitedAmount);
        }
        return Expense.builder()
                .amount(amount)
                .paidBy(crId)
                .splits(splits)
                .build();
    }
}
