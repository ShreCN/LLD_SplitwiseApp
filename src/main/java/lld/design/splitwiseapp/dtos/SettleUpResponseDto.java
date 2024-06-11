package lld.design.splitwiseapp.dtos;

import lld.design.splitwiseapp.models.Expense;
import lld.design.splitwiseapp.utils.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpResponseDto {
    private List<Transaction> transactions;
    public SettleUpResponseDto(List<Transaction> transactions){
        this.transactions = transactions;
    }
}