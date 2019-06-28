package com.smalaca.systemtests.stories;

import com.smalaca.credit.CreditNotGrantedBikInvalidScenario;
import com.smalaca.systemtests.JBehaveConfiguration;
import com.smalaca.systemtests.dto.BankClientDto;
import com.smalaca.systemtests.dto.CreditResponse;
import com.smalaca.systemtests.dto.CreditStatus;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.assertj.core.api.Assertions.assertThat;

public class TakeCreditWhenBikInvalidStories extends JBehaveConfiguration {
    private BankClientDto bankClientDto;
    private CreditResponse creditResponse;

    @Given("bank client with account in our bank")
    public void userWithoutBikAndWithAccount() {
        bankClientDto = new BankClientDto(
                CreditNotGrantedBikInvalidScenario.PESEL, CreditNotGrantedBikInvalidScenario.AMOUNT);
    }

    @When("wants to get credit")
    public void wantsToGetCredit() {
        creditResponse = getRestClient().takeCredit(bankClientDto);
    }

    @Then("credit granted")
    public void creditGranted() {
        CreditStatus creditStatus = getRestClient().checkCreditStatus(creditResponse);

        assertThat(creditStatus.getStatus()).isEqualTo(CreditNotGrantedBikInvalidScenario.CREDIT_STATUS);
    }
}
