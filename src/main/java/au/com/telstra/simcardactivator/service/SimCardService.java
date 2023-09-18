package au.com.telstra.simcardactivator.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import au.com.telstra.simcardactivator.domains.SimCard;
import au.com.telstra.simcardactivator.repository.SimCardRepository;
import au.com.telstra.simcardactivator.service.dto.ActuatorRequestPayload;
import au.com.telstra.simcardactivator.service.dto.SimCardActivationResponse;

@Service
@Transactional
public class SimCardService {

    private final Logger logger = LoggerFactory.getLogger(SimCardService.class);
    private final SimCardRepository repository;
    private final ActuatorService actuator;


    public SimCardService(SimCardRepository repository, ActuatorService actuator) { 
        this.repository = repository;
        this.actuator = actuator;
    }

    /**
     * Activates Customer's SIM card
     * 
     * @param simCard SimCard entity
     * @return SimCardActivationResponse
     */
    public SimCardActivationResponse callSimCardActuatorService(SimCard simCard) {
        ActuatorRequestPayload payload = new ActuatorRequestPayload(simCard.getICCD());
        SimCardActivationResponse actuatorResponse = actuator.activateSimCard(payload);

        return actuatorResponse;
    }

}
