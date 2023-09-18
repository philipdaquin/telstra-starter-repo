package stepDefinitions.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import au.com.telstra.simcardactivator.service.ActuatorService;
import au.com.telstra.simcardactivator.service.dto.ActuatorRequestPayload;
import au.com.telstra.simcardactivator.service.dto.SimCardActivationResponse;

@ExtendWith(MockitoExtension.class)
public class ActuatorServiceUnitTest {

    private ActuatorService service;

    @Mock
    private RestTemplate client;

    private String iccd = "XXXXXXX";

    private final String ACTUATOR_URI = "http://localhost:8444/actuate";

    @BeforeEach
    void init() { 
        service = new ActuatorService(client);
    }

    @Test
    public void shouldActivateSimCardReturnsActivationResponse() { 
        ActuatorRequestPayload payload = new ActuatorRequestPayload(iccd);

        SimCardActivationResponse response = new SimCardActivationResponse(true);
        when(client.postForObject(ACTUATOR_URI, 
            payload, 
            SimCardActivationResponse.class
        )).thenReturn(response);        
        
        when(service.activateSimCard(payload)).thenReturn(response);
        SimCardActivationResponse returns = service.activateSimCard(payload);

        verify(client).postForObject(anyString(), eq(payload),eq(SimCardActivationResponse.class));
        assertEquals(response, returns);
    }

}
