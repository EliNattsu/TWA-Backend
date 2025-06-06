package cz.catparadiseprojekt.catparadisehotel.repository;

import cz.catparadiseprojekt.catparadisehotel.model.CatOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CatOwnerRepository extends JpaRepository<CatOwner, Long> {
    Optional<CatOwner> findByEmail(String email);
}