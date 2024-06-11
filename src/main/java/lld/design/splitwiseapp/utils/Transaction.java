package lld.design.splitwiseapp.utils;

import lld.design.splitwiseapp.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    private User userFrom;
    private User userTo;
    private Double amount;

    public String toString(){
        return "Transaction : " + userFrom.getName() + " to " + userTo.getName() + " amount : " + amount;
    }
}
