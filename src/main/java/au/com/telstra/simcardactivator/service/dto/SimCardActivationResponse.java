package au.com.telstra.simcardactivator.service.dto;

import java.io.Serializable;

public class SimCardActivationResponse implements Serializable {
    private Boolean success;

    public Boolean getActive() { 
        return success;
    }
    public SimCardActivationResponse(Boolean activate) { 
        this.success = activate;
    }
}
