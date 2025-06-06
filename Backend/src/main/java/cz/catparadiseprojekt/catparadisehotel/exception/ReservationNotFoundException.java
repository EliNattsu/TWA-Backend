package cz.catparadiseprojekt.catparadisehotel.exception;

public class ReservationNotFoundException extends RuntimeException {
    public ReservationNotFoundException(Long id) {
        super("Rezervace s ID " + id + " nebyla nalezena.");
    }
}
