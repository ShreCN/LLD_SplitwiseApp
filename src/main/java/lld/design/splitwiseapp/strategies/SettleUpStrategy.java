package lld.design.splitwiseapp.strategies;

import lld.design.splitwiseapp.models.Expense;
import lld.design.splitwiseapp.utils.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface SettleUpStrategy {
    public List<Transaction> settleUp(List<Expense> expenses);
}
