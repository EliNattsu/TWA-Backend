package util;

public class ValidationUtils {

    // Kontrola, že řetězec není prázdný nebo jen z mezer
    public static boolean isNotBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }

    // Validace hesla: min. 8 znaků, aspoň 1 velké písmeno, aspoň 1 číslice, speciální znak není potřeba
    public static boolean isPasswordSecure(String password) {
        return password != null &&
                password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[0-9].*");
    }

    // Validace e-mailu (základní kontrola)
    public static boolean isValidEmail(String email) {
        return email != null &&
                email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    // Validace telefonního čísla (český formát, 9 číslic)
    public static boolean isValidPhoneNumber(String phone) {
        return phone != null &&
                phone.matches("^\\d{9}$|^(\\d{3} ?){3}$");
    }
}