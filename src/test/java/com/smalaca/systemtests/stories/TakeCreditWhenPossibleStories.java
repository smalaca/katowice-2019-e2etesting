package com.smalaca.systemtests.stories;

import com.smalaca.CreditGrantedScenario;
import com.smalaca.systemtests.JBehaveConfiguration;
import com.smalaca.systemtests.dto.BankClientDto;
import com.smalaca.systemtests.dto.CreditResponse;
import com.smalaca.systemtests.dto.CreditStatus;
import org.assertj.core.api.Assertions;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Ignore;

import static org.assertj.core.api.Assertions.assertThat;

public class TakeCreditWhenPossibleStories extends JBehaveConfiguration {
    private BankClientDto bankClientDto;
    private CreditResponse creditResponse;

    @When("wants to get credit")
    public void wantsToGetCredit() {
        creditResponse = getRestClient().takeCredit(bankClientDto);
    }

    @Given("bank client with a valid BIK history and account in our bank")
    public void userWithBikAndAccount() {
        bankClientDto = new BankClientDto(
                CreditGrantedScenario.PESEL, CreditGrantedScenario.AMOUNT);
    }

    @Then("credit granted")
    public void creditGranted() {
        CreditStatus creditStatus = getRestClient().checkCreditStatus(creditResponse);

        assertThat(creditStatus.getStatus()).isEqualTo(CreditGrantedScenario.CREDIT_STATUS);
    }
}
