package com.smalaca.systemtests.rest;

import com.smalaca.systemtests.dto.BankClientDto;
import com.smalaca.systemtests.dto.CreditResponse;
import com.smalaca.systemtests.dto.CreditStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

public class RestClient {
    private final RestTemplate restTemplate;
    private final String frontEndHostName;

    public RestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        frontEndHostName = "http://localhost:8001";
    }

    public CreditResponse takeCredit(BankClientDto bankClientDto) {
        String url = frontEndHostName + "/credit/";
        ResponseEntity<CreditResponse> responseEntity = restTemplate.postForEntity(
                url, bankClientDto, CreditResponse.class);
        return responseEntity.getBody();
    }

    public CreditStatus checkCreditStatus(CreditResponse creditResponse) {
        String url = frontEndHostName + "/credit/" + creditResponse.getId();
        return restTemplate.getForObject(url, CreditStatus.class);
    }
}