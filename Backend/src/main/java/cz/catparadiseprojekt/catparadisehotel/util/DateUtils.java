package cz.catparadiseprojekt.catparadisehotel.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateUtils {
    public static String formatDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    // Výpočet počtu dnů mezi dvěma daty
    public static long daysBetween(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Data nesmí být null");
        }
        return ChronoUnit.DAYS.between(startDate, endDate);
    }

    // Kontrola, zda je datum v budoucnosti (po dnešku)
    public static boolean isFutureDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Datum nesmí být null");
        }
        return date.isAfter(LocalDate.now());
    }
}