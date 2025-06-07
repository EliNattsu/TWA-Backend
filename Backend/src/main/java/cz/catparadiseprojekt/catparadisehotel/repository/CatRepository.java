package cz.catparadiseprojekt.catparadisehotel.repository;

import cz.catparadiseprojekt.catparadisehotel.model.Cat;
import cz.catparadiseprojekt.catparadisehotel.model.CatOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CatRepository extends JpaRepository<Cat, Long> {
    // Vlastní metoda pro vyhledání koček podle majitele
    List<Cat> findByOwner(CatOwner owner);
}