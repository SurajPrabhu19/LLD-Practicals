package com.scaler.splitwise.dtos;

import java.util.List;

import com.scaler.splitwise.services.settleup.Transaction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SettleUpGroupResponseDto {
    private List<Transaction> transactions;
}
