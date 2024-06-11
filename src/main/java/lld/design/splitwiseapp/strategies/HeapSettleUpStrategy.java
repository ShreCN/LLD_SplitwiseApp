package lld.design.splitwiseapp.strategies;

import lld.design.splitwiseapp.models.Expense;
import lld.design.splitwiseapp.models.User;
import lld.design.splitwiseapp.models.UserExpense;
import lld.design.splitwiseapp.utils.Transaction;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Component
public class HeapSettleUpStrategy implements SettleUpStrategy{
    public List<Transaction> settleUp(List<Expense> expenses){
        HashMap<User, Double> expensesMap = new HashMap<>();
        for (Expense expense : expenses) {
            for (UserExpense userExpense : expense.getUserExpenseList()) {
                if (expensesMap.containsKey(userExpense.getUser())) {
                    expensesMap.put(userExpense.getUser(), expensesMap.get(userExpense.getUser()) + userExpense.getAmount());
                } else {
                    expensesMap.put(userExpense.getUser(), userExpense.getAmount());
                }
            }
        }

        List<Transaction> transactions = new ArrayList<>();
        for(User user : expensesMap.keySet()) {
            System.out.println(user.getName() + " " + expensesMap.get(user));
        }
        List<User> userList = new ArrayList<>(expensesMap.keySet());
        int size = userList.size();
        for(int i = 0; i < size - 1; i ++) {
            Transaction transaction = new Transaction();
            if(expensesMap.get(userList.get(i)) < 0) {
                transaction.setUserFrom(userList.get(i));
                transaction.setAmount(Math.abs(expensesMap.get(userList.get(i))));
                transaction.setUserTo(userList.get(i+1));
                transactions.add(transaction);
//                expensesMap.remove(userList.get(i));
                expensesMap.put(userList.get(i + 1), expensesMap.get(userList.get(i + 1)) + expensesMap.get(userList.get(i)));
            } else if(expensesMap.get(userList.get(i)) > 0) {
                transaction.setUserFrom(userList.get(i + 1));
                transaction.setAmount(Math.abs(expensesMap.get(userList.get(i))));
                transaction.setUserTo(userList.get(i));
                transactions.add(transaction);
//                expensesMap.remove(userList.get(i));
                expensesMap.put(userList.get(i + 1), expensesMap.get(userList.get(i + 1)) + expensesMap.get(userList.get(i)));
            }
        }
        return transactions;
    }
}
