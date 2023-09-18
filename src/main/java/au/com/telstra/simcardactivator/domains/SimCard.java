package au.com.telstra.simcardactivator.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name = "simcard")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SimCard implements Serializable {

    private static final long serialVersionUID = 1L; 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Column(name = "iccid", nullable = false)
    private String iccid;
    
    @NotNull
    @Email
    @Column(name = "customer_email", nullable = false)
    private String customerEmail;
    
    @Column(name = "activated")
    private Boolean active;


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
    public Boolean isActive() {
        return active;
    }
    public void setActive(Boolean activated) {
        this.active = activated;
    } 

}
