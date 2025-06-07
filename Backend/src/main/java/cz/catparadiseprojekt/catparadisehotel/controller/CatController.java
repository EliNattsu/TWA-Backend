package cz.catparadiseprojekt.catparadisehotel.controller;

import cz.catparadiseprojekt.catparadisehotel.model.Cat;
import cz.catparadiseprojekt.catparadisehotel.model.CatOwner;
import cz.catparadiseprojekt.catparadisehotel.service.CatOwnerService;
import cz.catparadiseprojekt.catparadisehotel.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cats")
public class CatController {
    private final CatService catService;
    private final CatOwnerService catOwnerService;

    @Autowired
    public CatController(CatService catService, CatOwnerService catOwnerService) {
        this.catService = catService;
        this.catOwnerService = catOwnerService;
    }

    // CRUD endpointy
    @PostMapping
    public Cat createCat(@RequestBody Cat cat) {
        return catService.saveCat(cat);
    }

    @GetMapping
    public List<Cat> getAllCats() {
        return catService.getAllCats();
    }

    @GetMapping("/{id}")
    public Optional<Cat> getCatById(@PathVariable Long id) {
        return catService.getCatById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCat(@PathVariable Long id) {
        catService.deleteCat(id);
    }

    // Vlastní endpoint: výpis koček podle majitele
    @GetMapping("/by-owner/{ownerId}")
    public List<Cat> getCatsByOwner(@PathVariable Long ownerId) {
        CatOwner owner = catOwnerService.getCatOwnerById(ownerId)
                .orElseThrow(() -> new IllegalArgumentException("Majitel s ID " + ownerId + " neexistuje."));
        return catService.getCatsByOwner(owner);
    }
}