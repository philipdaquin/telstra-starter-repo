package au.com.telstra.simcardactivator.controller;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import au.com.telstra.simcardactivator.domains.SimCard;
import au.com.telstra.simcardactivator.exception.SimCardResourceException;
import au.com.telstra.simcardactivator.repository.SimCardRepository;
import au.com.telstra.simcardactivator.service.SimCardService;
import au.com.telstra.simcardactivator.service.dto.SimCardActivationResponse;

@RestController
@RequestMapping("/api/v1/simcard")
public class SimCardController {
    
    private final SimCardService service;
    private final SimCardRepository repository;

    public SimCardController(SimCardService service, SimCardRepository repository) { 
        this.service = service; 
        this.repository = repository;
    }

    /**
     * {@code POST /activate}: Activate the SIM Card from Customer
     * 
     * @param simCard entity
     * @return SimCardActivationResponse 
     * @throws RunTimeException {@code 500 (Internal Server Error)} if the user can't be activated 
     * 
     */
    @PostMapping(path = "/activate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SimCardActivationResponse> activateSimCard(@RequestBody @Valid SimCard simCard) { 
        if (simCard.isActivated()) 
            throw new SimCardResourceException("SIM Card for" + simCard.getCustomerEmail() + "is already activated!");
        
        return ResponseEntity.ok(service.callSimCardActuatorService(simCard));
    }

}
