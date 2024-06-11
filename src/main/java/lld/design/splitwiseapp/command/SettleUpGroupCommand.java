package lld.design.splitwiseapp.command;

import lld.design.splitwiseapp.controllers.SettleUpController;
import lld.design.splitwiseapp.dtos.SettleUpRequestDto;
import lld.design.splitwiseapp.dtos.SettleUpResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SettleUpGroupCommand implements Command{

    private SettleUpController settleUpController;
    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));
        System.out.println(words);
        if(words.size() == 2 && words.get(0).equals("SettleUpGroup")){
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));
        Long groupId =  Long.valueOf(words.get(1));

        SettleUpRequestDto request = new SettleUpRequestDto();
        request.setGroupId(groupId);

        SettleUpResponseDto response =  settleUpController.settleUp(request);
        System.out.println(response.getTransactions());
    }
}
