package lld.design.splitwiseapp.services;

import lld.design.splitwiseapp.dtos.SettleUpRequestDto;
import lld.design.splitwiseapp.exceptions.BadRequestExcepiton;
import lld.design.splitwiseapp.models.Expense;
import lld.design.splitwiseapp.models.Group;
import lld.design.splitwiseapp.repositories.ExpenseRepository;
import lld.design.splitwiseapp.repositories.GroupRepository;
import lld.design.splitwiseapp.strategies.SettleUpStrategy;
import lld.design.splitwiseapp.utils.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SettleUpService {
    private GroupRepository groupRepository;
    private ExpenseRepository expenseRepository;
    private SettleUpStrategy settleUpStrategy;
    public SettleUpService(GroupRepository groupRepository,
                           ExpenseRepository expenseRepository,
                           SettleUpStrategy settleUpStrategy){
        this.groupRepository = groupRepository;
        this.expenseRepository = expenseRepository;
        this.settleUpStrategy = settleUpStrategy;
    }
    public List<Transaction> settleUpGroup(SettleUpRequestDto settleUpRequestDto) {
        // validate the group
        Optional<Group> group =
                groupRepository.findById(settleUpRequestDto.getGroupId());
        if(group.get().getId() != settleUpRequestDto.getGroupId()){
            throw new BadRequestExcepiton("Invalid Group Id");
        }

        // get all expenses for group
        List<Expense> groupExpenses =
                expenseRepository.findAllById(settleUpRequestDto.getGroupId());

        // 3. Iterate through all the expenses to find out who owes what
        // 4. Find the transactions to be done
        List<Transaction> transactions = settleUpStrategy.settleUp(groupExpenses);
        // 5. return transactions
        return transactions;


    }
}
