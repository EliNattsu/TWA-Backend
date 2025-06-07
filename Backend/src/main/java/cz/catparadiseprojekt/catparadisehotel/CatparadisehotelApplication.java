package cz.catparadiseprojekt.catparadisehotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import cz.catparadiseprojekt.catparadisehotel.model.User;
import cz.catparadiseprojekt.catparadisehotel.security.UserRole;
import cz.catparadiseprojekt.catparadisehotel.util.DateUtils;
import java.time.LocalDate;

@SpringBootApplication
public class CatparadisehotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatparadisehotelApplication.class, args);

		User admin = new User(1L, "admin@email.cz", "tajneheslo", UserRole.ADMIN);
		User recepce = new User(2L, "recepce@email.cz", "recepceheslo", UserRole.RECEPCNI);
		User pecovatel = new User(3L, "pecovatel@email.cz", "pecovatelheslo", UserRole.PECOVATEL);
		User user = new User(4L, "user@email.cz", "userheslo", UserRole.HOST);

		if (admin.getRole() == UserRole.ADMIN) {
			System.out.println("Uživatel je admin.");
		}
		if (recepce.getRole() == UserRole.RECEPCNI) {
			System.out.println("Uživatel je recepční.");
		}
		if (pecovatel.getRole() == UserRole.PECOVATEL) {
			System.out.println("Uživatel je pečovatel.");
		}
		if (user.getRole() == UserRole.HOST) {
			System.out.println("Uživatel je host.");
		}

		LocalDate dnes = LocalDate.now();
		LocalDate vBudoucnu = LocalDate.of(2025, 12, 31);
		LocalDate vMinulosti = LocalDate.of(2024, 1, 1);

		// Výpočet dnů mezi dvěma daty
		long dny = DateUtils.daysBetween(dnes, vBudoucnu);
		System.out.println("Počet dnů od dnes do 31.12.2025: " + dny);

		// Kontrola, zda je datum v budoucnosti
		System.out.println("31.12.2025 je v budoucnosti? " + DateUtils.isFutureDate(vBudoucnu));
		System.out.println("1.1.2024 je v budoucnosti? " + DateUtils.isFutureDate(vMinulosti));
	}
}

