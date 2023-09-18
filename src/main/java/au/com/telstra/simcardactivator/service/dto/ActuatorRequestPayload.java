package au.com.telstra.simcardactivator.service.dto;

import java.io.Serializable;

public class ActuatorRequestPayload implements Serializable {

    private String iccid;
    private String customerEmail;

    public ActuatorRequestPayload(String iccd) { 
        this.iccid = iccd;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
    
}
