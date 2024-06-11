package lld.design.splitwiseapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Expense extends BaseModel {
    private String description;

    @ManyToOne
    private User createdBy;
    private double amount;

    @OneToMany(mappedBy = "expense")
    private List<UserExpense> userExpenseList;

    @Enumerated
    private ExpenseType expenseType;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

}
