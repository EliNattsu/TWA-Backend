package cz.catparadiseprojekt.catparadisehotel.service;

import cz.catparadiseprojekt.catparadisehotel.exception.ReservationNotFoundException;
import cz.catparadiseprojekt.catparadisehotel.model.Reservation;

public class ReservationService {

    public Reservation getReservation(Long id) {
        try {
            // Simulace chyby
            throw new ReservationNotFoundException(id);
        } catch (ReservationNotFoundException ex) {
            // Zalogování chyby na standardní chybový výstup
            System.err.println("Chyba: Rezervace nenalezena: " + id);
            ex.printStackTrace(); // Vypíše celý stack trace chyby
            throw ex; // nebo můžeš vrátit nějakou hodnotu
        }
    }
}