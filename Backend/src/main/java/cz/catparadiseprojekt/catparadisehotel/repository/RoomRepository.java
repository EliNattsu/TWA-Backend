package cz.catparadiseprojekt.catparadisehotel.repository;

import cz.catparadiseprojekt.catparadisehotel.model.Room;
import cz.catparadiseprojekt.catparadisehotel.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    // Vlastní metoda pro vyhledání pokojů podle typu
    List<Room> findByRoomType(RoomType roomType);

    // Vlastní metoda pro kontrolu existence pokoje podle čísla
    boolean existsByRoomNumber(String roomNumber);
}