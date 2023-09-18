package au.com.telstra.simcardactivator.service.dto;

public class SimCardActivationResponse {
    private Boolean success;

    public Boolean getActive() { 
        return success;
    }
    public SimCardActivationResponse(Boolean activate) { 
        this.success = activate;
    }
}
