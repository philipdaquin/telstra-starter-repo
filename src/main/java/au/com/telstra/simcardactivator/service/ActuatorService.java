package au.com.telstra.simcardactivator.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import au.com.telstra.simcardactivator.exception.ActuatorResourceException;
import au.com.telstra.simcardactivator.service.dto.ActuatorRequestPayload;
import au.com.telstra.simcardactivator.service.dto.SimCardActivationResponse;

@Service
public class ActuatorService {
    
    private final RestTemplate client;

    private final String ACTUATOR_URI = "http://localhost:8444/actuate";

    public ActuatorService(RestTemplate client) { 
        this.client = client;
    }

    /**
     * {@code POST /actuate }: Activate SIM Card 
     * 
     * @param payload ActuatorRequestPayload 
     * @return SimCardActivationResponse Entity
     * @throws {@code 500 (Internal Server Error)} SIM Card activation couldn't be retrieved
     */
    public SimCardActivationResponse activateSimCard(ActuatorRequestPayload payload) { 
        SimCardActivationResponse response;

        try {
            response = client.postForObject(ACTUATOR_URI, payload, SimCardActivationResponse.class);
            return response;
        } catch (HttpClientErrorException | HttpServerErrorException   e) { 

            throw new ActuatorResourceException("Unable to activate SIM Card at this time.");
        }
    }

}
