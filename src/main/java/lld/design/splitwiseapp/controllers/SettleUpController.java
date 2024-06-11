package lld.design.splitwiseapp.controllers;

import lld.design.splitwiseapp.dtos.SettleUpRequestDto;
import lld.design.splitwiseapp.dtos.SettleUpResponseDto;
import lld.design.splitwiseapp.services.SettleUpService;
import lld.design.splitwiseapp.utils.Transaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SettleUpController {

    private SettleUpService settleUpService;
    public SettleUpController(SettleUpService settleUpService){
        this.settleUpService = settleUpService;
    }

    @GetMapping("/settleUp")
    public @ResponseBody SettleUpResponseDto settleUp(@RequestBody SettleUpRequestDto settleUpRequestDto){
        List<Transaction> transactions =
                settleUpService.settleUpGroup(settleUpRequestDto);
        return new SettleUpResponseDto(transactions);
    }

}
