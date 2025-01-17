package au.com.telstra.simcardactivator.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import au.com.telstra.simcardactivator.domains.SimCard;
import java.util.List;



@SuppressWarnings("unused")
@Repository
public interface SimCardRepository extends JpaRepository<SimCard, Long> {
    
    Optional<SimCard> findByICCD(String iCCD);
}
