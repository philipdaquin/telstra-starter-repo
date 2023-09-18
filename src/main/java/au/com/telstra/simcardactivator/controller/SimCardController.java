package au.com.telstra.simcardactivator.controller;

import java.net.URISyntaxException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping(path = "/api/v1")
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
    @PostMapping(path = "/activate")
    public ResponseEntity<SimCardActivationResponse> activateSimCard(@RequestBody SimCard simCard) throws URISyntaxException { 
        
        if (simCard.isActive()) 
            throw new SimCardResourceException("SIM Card for" + simCard.getCustomerEmail() + "is already activated!");
        
        return ResponseEntity.ok(service.callSimCardActuatorService(simCard));
    }

    /**
     * {@code GET /{simCardId}}: Get the id of simcard transaction
     * 
     * @param simCardId
     * @return the {@link ResponseEntity} with status {@code 200} with the body simcard transaction
     */
    @GetMapping(path = "/query?simCardId={simCardId}")
    public ResponseEntity<SimCard> getSimCard(@PathVariable final Long simCardId) { 
        SimCard simcard = service.getOne(simCardId).orElseThrow(() -> new SimCardResourceException("Unable to find SimCard entity!"));

        return ResponseEntity.ok().body(simcard);
    }

}
