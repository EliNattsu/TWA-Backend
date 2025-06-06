package cz.catparadiseprojekt.catparadisehotel.security;

import cz.catparadiseprojekt.catparadisehotel.model.CatOwner;
import cz.catparadiseprojekt.catparadisehotel.util.ValidationUtils;

public class AuthenticationService {

    // Příklad metody pro registraci uživatele
    public void register(CatOwner catOwner) {
        // Validace uživatelského jména
        if (!ValidationUtils.isNotBlank(catOwner.getName())) {
            throw new IllegalArgumentException("Uživatelské jméno nesmí být prázdné.");
        }

        // Validace e-mailu
        if (!ValidationUtils.isValidEmail(catOwner.getEmail())) {
            throw new IllegalArgumentException("Neplatný e-mail.");
        }

        // Validace hesla
        if (!ValidationUtils.isPasswordSecure(catOwner.getPassword())) {
            throw new IllegalArgumentException("Heslo je příliš slabé.");
        }

        // Validace telefonního čísla
        if (!ValidationUtils.isValidPhoneNumber(catOwner.getPhone())) {
            throw new IllegalArgumentException("Neplatné telefonní číslo.");
        }

    }
}