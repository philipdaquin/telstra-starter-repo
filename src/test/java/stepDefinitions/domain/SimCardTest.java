package stepDefinitions.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import au.com.telstra.simcardactivator.domains.SimCard;

public class SimCardTest {
    
    private String ICCD = "XXXXXXX";
    private String customerEmail =  "test@user.com";

    private String ICCD_A = "YYYYYYY";
    private String customerEmail_A =  "testA@user.com";
    



    @Test
    void equalsVerifier() { 
        SimCard newCard = new SimCard(ICCD, customerEmail);
        
        SimCard newCard_A = new SimCard(ICCD_A, customerEmail_A);

        assertNotNull(newCard);
        assertNotNull(newCard);

        newCard.setCustomerEmail(customerEmail_A);
        assertEquals(newCard.getCustomerEmail(), newCard_A.getCustomerEmail());
        assertNotEquals(newCard.getICCD(), newCard_A.getICCD());

    }

}
