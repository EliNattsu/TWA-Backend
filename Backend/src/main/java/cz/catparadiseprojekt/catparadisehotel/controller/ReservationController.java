package cz.catparadiseprojekt.catparadisehotel.controller;

import cz.catparadiseprojekt.catparadisehotel.model.Reservation;
import cz.catparadiseprojekt.catparadisehotel.model.ReservationStatus;
import cz.catparadiseprojekt.catparadisehotel.model.Room;
import cz.catparadiseprojekt.catparadisehotel.service.ReservationService;
import cz.catparadiseprojekt.catparadisehotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    private final RoomService roomService;

    @Autowired
    public ReservationController(ReservationService reservationService, RoomService roomService) {
        this.reservationService = reservationService;
        this.roomService = roomService;
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.saveReservation(reservation);
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }

    @GetMapping("/status/{status}")
    public List<Reservation> getReservationsByStatus(@PathVariable ReservationStatus status) {
        return reservationService.getReservationsByStatus(status);
    }

    @PutMapping("/{id}/status")
    public Reservation updateReservationStatus(
            @PathVariable Long id,
            @RequestParam ReservationStatus status
    ) {
        return reservationService.updateReservationStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
    }

    // Endpoint pro kontrolu dostupnosti pokoje
    @GetMapping("/availability")
    public boolean checkRoomAvailability(
            @RequestParam Long roomId,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate
    ) {
        Room room = roomService.getRoomById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("Pokoj neexistuje."));
        return reservationService.isRoomAvailable(room, startDate, endDate);
    }
}