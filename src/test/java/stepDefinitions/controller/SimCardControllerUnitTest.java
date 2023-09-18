package stepDefinitions.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import au.com.telstra.simcardactivator.controller.SimCardController;
import au.com.telstra.simcardactivator.domains.SimCard;
import au.com.telstra.simcardactivator.repository.SimCardRepository;
import au.com.telstra.simcardactivator.service.SimCardService;
import au.com.telstra.simcardactivator.service.dto.SimCardActivationResponse;

@ExtendWith(MockitoExtension.class)
public class SimCardControllerUnitTest {
    
    @Mock
    private SimCardService service;
    @Mock
    private SimCardRepository repository;

    private SimCardController controller;

    public void setup() { 
        controller = new SimCardController(service, repository);
    }

    @Test
    public void shouldActivateSimCardGivenSimCardReturnsResponse() {

        SimCard newSimCard = new SimCard("sdasdasd", "asdasdas@adsdas");
        
        newSimCard.setActivated(false);

        SimCardActivationResponse expectedResponse = new SimCardActivationResponse(true);

        when(service.callSimCardActuatorService(newSimCard)).thenReturn(expectedResponse);
        

        ResponseEntity<SimCardActivationResponse> response = controller.activateSimCard(newSimCard);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(newSimCard, response.getBody());

    }

}
