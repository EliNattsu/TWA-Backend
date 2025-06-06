package cz.catparadiseprojekt.catparadisehotel.exception;

public class ReservationConflictException extends RuntimeException {
    public ReservationConflictException(String message) {
        super(message);
    }
}