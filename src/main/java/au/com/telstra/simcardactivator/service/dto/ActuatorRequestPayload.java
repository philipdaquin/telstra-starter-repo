package au.com.telstra.simcardactivator.service.dto;

import java.io.Serializable;

public class ActuatorRequestPayload implements Serializable {

    private String iccid;

    public ActuatorRequestPayload(String iccd) { 
        this.iccid = iccd;
    }
}
