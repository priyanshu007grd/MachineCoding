package Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Expense {

    private Integer expenseId;
    private double amount;
    private Integer paidBy; // userId;
    private Map<Integer,Double> splits;
    //private ExpenseMetadata metadata;
}
