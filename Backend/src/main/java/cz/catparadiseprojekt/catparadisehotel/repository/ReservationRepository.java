package cz.catparadiseprojekt.catparadisehotel.repository;

import cz.catparadiseprojekt.catparadisehotel.model.Reservation;
import cz.catparadiseprojekt.catparadisehotel.model.ReservationStatus;
import cz.catparadiseprojekt.catparadisehotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    // Najdi rezervace pro daný pokoj, které se překrývají s daným rozsahem dat
    @Query("SELECT r FROM Reservation r " +
            "WHERE r.room = :room " +
            "AND ((r.startDate <= :endDate AND r.endDate >= :startDate) " +
            "OR (r.startDate >= :startDate AND r.endDate <= :endDate)) " +
            "AND r.status <> 'CANCELLED'")
    List<Reservation> findOverlappingReservations(
            @Param("room") Room room,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
    List<Reservation> findByStatus(ReservationStatus status);
}