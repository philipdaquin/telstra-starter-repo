package stepDefinitions.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import au.com.telstra.simcardactivator.domains.SimCard;
import au.com.telstra.simcardactivator.repository.SimCardRepository;
import au.com.telstra.simcardactivator.service.ActuatorService;
import au.com.telstra.simcardactivator.service.SimCardService;

@ExtendWith(MockitoExtension.class)
public class SimCardServiceUnitTest {
    
    @Mock
    private SimCardRepository repository;

    @Mock
    private ActuatorService actuator;

    private SimCardService service;

    @BeforeEach
    void setup() { 
        service = new SimCardService(repository, actuator);
    }

    @Test
    public void shouldCallSimCardActuator_GivenSimCard_ReturnsSimCardActionResponseWhenSuccess() { 
        // Given
        // String iccd = "XXXXX";
        
        // SimCard simCard = mock(SimCard.class);
        // SimCardActivationResponse expectedResponse = new SimCardActivationResponse(true);
        // ActuatorRequestPayload payload = new ActuatorRequestPayload(iccd);
        
        // // Mock the dependencies    
        // when(actuator.activateSimCard(eq(payload))).thenReturn(expectedResponse);
        // // when(service.callSimCardActuatorService(simCard)).thenReturn(expectedResponse);
        // // When
        // SimCardActivationResponse response = service.callSimCardActuatorService(simCard);

        // // Then
        // assertEquals(expectedResponse, response);
        // assertTrue(response.getActive());
    }

}
