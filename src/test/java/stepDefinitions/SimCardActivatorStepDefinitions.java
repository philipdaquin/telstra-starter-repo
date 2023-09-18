package stepDefinitions;

import au.com.telstra.simcardactivator.SimCardActivator;
import au.com.telstra.simcardactivator.domains.SimCard;
import au.com.telstra.simcardactivator.service.dto.ActuatorRequestPayload;
import au.com.telstra.simcardactivator.service.dto.SimCardActivationResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.spring.CucumberContextConfiguration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

@RunWith(Cucumber.class)
@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = SimCardActivator.class, loader = SpringBootContextLoader.class)
public class SimCardActivatorStepDefinitions {
    @Autowired
    private TestRestTemplate restTemplate;

    private SimCard simcard;


    private String workingSimCard = "1255789453849037777";
    private String customerA = "customerA@x.com";
    
    private String brokenSimCard = "8944500102198304826";
    private String customerB = "customerB@x.com";

    private final String ACTUATOR_URI = "http://localhost:8080/api/v1/activate";

    private final String GET_URI = "http://localhost:8080/api/v1/query?simCardId={id}";



    @Given("a new sim card")
    public void workingSimCard() { 
        simcard = new SimCard(workingSimCard, customerA);
    }
    @When("a request to activate the sim card is posted")
    public void submitActivationRequest() { 
        restTemplate.postForObject(ACTUATOR_URI, new ActuatorRequestPayload(workingSimCard), SimCardActivationResponse.class);
    }
    @Then("the sim card is activated and its recorded to the database")
    public void activateSimCard() {
        simcard = restTemplate.getForEntity(String.format(GET_URI, 1), SimCard.class).getBody();
        assertTrue(simcard.isActive());
    }



    @Given("a broken sim card")
    public void brokenSimCard() { 
        simcard = new SimCard(brokenSimCard, customerB);
    }
      @Then("the sim card is activated and its recorded to the database")
    public void activateBrokenSimCard() {
        simcard = restTemplate.getForEntity(String.format(GET_URI, 2), SimCard.class).getBody();
        assertFalse(simcard.isActive());
    }

    

}