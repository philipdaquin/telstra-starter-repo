package au.com.telstra.simcardactivator.service;

import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        
        // Send a post request to SimCardActuator
        SimCardActivationResponse actuatorResponse = actuator.activateSimCard(payload);

        // Save to database
        repository.save(simCard);

        return actuatorResponse;
    }

    /**
     * Get one SimCard by Id
     * 
     * @param id of SimCard transaction
     * @return the entity 
     */
    @Transactional(readOnly = true)
    public Optional<SimCard> getOne(final Long id) { 
        return repository.findById(id);
    }


}
