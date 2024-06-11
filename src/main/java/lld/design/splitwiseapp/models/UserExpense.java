package lld.design.splitwiseapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserExpense extends BaseModel{
    @ManyToOne
    @JoinColumn(name = "expense_id")
    private Expense expense;
    @ManyToOne
    private User user;
    private double amount;
    @Enumerated
    private UserExpenseType userExpenseType;
}
