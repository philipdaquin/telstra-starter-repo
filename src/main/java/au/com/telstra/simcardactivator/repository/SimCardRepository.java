package au.com.telstra.simcardactivator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import au.com.telstra.simcardactivator.domains.SimCard;


@SuppressWarnings("unused")
@Repository
public interface SimCardRepository extends JpaRepository<SimCard, Long> {
    
}
