package cz.catparadiseprojekt.catparadisehotel.service;

import cz.catparadiseprojekt.catparadisehotel.exception.ReservationNotFoundException;
import cz.catparadiseprojekt.catparadisehotel.exception.ReservationConflictException;
import cz.catparadiseprojekt.catparadisehotel.model.*;
import cz.catparadiseprojekt.catparadisehotel.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final CatService catService;
    private final RoomService roomService;

    @Autowired
    public ReservationService(
            ReservationRepository reservationRepository,
            CatService catService,
            RoomService roomService
    ) {
        this.reservationRepository = reservationRepository;
        this.catService = catService;
        this.roomService = roomService;
    }

    // CRUD operace
    public Reservation saveReservation(Reservation reservation) {
        validateReservation(reservation);
        reservation.setReferenceNumber("RES-" + UUID.randomUUID().toString().substring(0, 8));
        reservation.setStatus(ReservationStatus.PENDING);
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    public List<Reservation> getReservationsByStatus(ReservationStatus status) {
        return reservationRepository.findByStatus(status);
    }


    // Vrací rezervaci nebo vyhodí výjimku a zaloguje ji
    public Reservation getReservation(Long id) {
        try {
            return reservationRepository.findById(id)
                    .orElseThrow(() -> new ReservationNotFoundException(id));
        } catch (ReservationNotFoundException ex) {
            System.err.println("Chyba: Rezervace nenalezena: " + id);
            ex.printStackTrace();
            throw ex;
        }
    }

    // Aktualizace stavu rezervace
    public Reservation updateReservationStatus(Long id, ReservationStatus newStatus) {
        Reservation reservation = getReservation(id);
        reservation.setStatus(newStatus);
        return reservationRepository.save(reservation);
    }

    // Kontrola dostupnosti pokoje
    public boolean isRoomAvailable(Room room, LocalDate startDate, LocalDate endDate) {
        List<Reservation> overlappingReservations = reservationRepository.findOverlappingReservations(
                room, startDate, endDate
        );
        return overlappingReservations.isEmpty();
    }

    // Validace rezervace
    private void validateReservation(Reservation reservation) {
        if (reservation.getStartDate().isAfter(reservation.getEndDate())) {
            throw new IllegalArgumentException("Datum začátku musí být před koncem.");
        }

        if (!isRoomAvailable(reservation.getRoom(), reservation.getStartDate(), reservation.getEndDate())) {
            throw new ReservationConflictException("Pokoj není dostupný v daném termínu.");
        }

        // Ověření existence kočky a pokoje
        if (!catService.getCatById(reservation.getCat().getId()).isPresent()) {
            throw new IllegalArgumentException("Kočka neexistuje.");
        }
        if (!roomService.getRoomById(reservation.getRoom().getId()).isPresent()) {
            throw new IllegalArgumentException("Pokoj neexistuje.");
        }
    }
}