package com.smalaca.systemtests.dto;

public class BankClientDto {
    private final String pesel;
    private final String amount;

    public BankClientDto(String pesel, String amount) {
        this.pesel = pesel;
        this.amount = amount;
    }

    public String getPesel() {
        return pesel;
    }

    public String getAmount() {
        return amount;
    }
}
