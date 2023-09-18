package stepDefinitions.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import au.com.telstra.simcardactivator.SimCardActivator;
import au.com.telstra.simcardactivator.domains.SimCard;
import au.com.telstra.simcardactivator.repository.SimCardRepository;
import au.com.telstra.simcardactivator.service.SimCardService;

// @DataJpaTest
// @RunWith(SpringRunner.class)
// @EnableAutoConfiguration
// @ContextConfiguration( initializers = SimCardRepositoryUnitTest.Intialiser.class, classes = { 
//     SimCardRepository.class,
// })
public class SimCardRepositoryUnitTest {

    @Autowired
    private SimCardRepository repository;


    // @Test
    // public void shouldInsertAndQueryReturnsEntity() { 
    //     // SimCard newCard = new SimCard("XXXXXXX", "XXXXX@XXXXX.com");
    //     // SimCard savedItem = repository.save(newCard);


    //     // assertNotNull(savedItem);

    //     // Optional<SimCard> response = repository.findById(savedItem.getICCD());
        
    //     // assertTrue(response.isPresent());
    //     // assertEquals(response.get().getICCD(), savedItem.getICCD());
    //     // assertEquals(response.get().getCustomerEmail(), savedItem.getCustomerEmail());
    // }

    // public static class Intialiser implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    //     @Override
    //     public void initialize(ConfigurableApplicationContext applicationContext) {
    //         String h2Url = String.format("jdbc:h2:mem:testdb");

    //         TestPropertyValues values = TestPropertyValues.of(
    //             "spring.datasource.url:" + h2Url,
    //             "spring.datasource.driverClassName: org.h2.Driver",
    //             "spring.datasource.username: sa",
    //             "spring.datasource.password: password",
    //             "spring.jpa.database-platform: org.hibernate.dialect.H2Dialect"
    //         );
            
    //         values.applyTo(applicationContext);
    //     } 

    // }

}
