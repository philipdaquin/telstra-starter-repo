package au.com.telstra.simcardactivator.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "simcard")
public class SimCard implements Serializable {

    @Id
    private String iccid;
    private String customerEmail;
    private Boolean activated;

    public SimCard() {}
    public SimCard(String iccid, String customerEmail) { 
        this.iccid = iccid;
        this.customerEmail = customerEmail;
    }

    
    public String getICCD() {
        return iccid;
    }
    public void setICCD(String iccid) {
        this.iccid = iccid;
    }
    public String getCustomerEmail() {
        return customerEmail;
    }
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
    public Boolean isActivated() {
        return activated;
    }
    public void setActivated(Boolean activated) {
        this.activated = activated;
    } 

}
