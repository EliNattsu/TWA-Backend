package cz.catparadiseprojekt.catparadisehotel.controller;

import cz.catparadiseprojekt.catparadisehotel.model.CatOwner;
import cz.catparadiseprojekt.catparadisehotel.service.CatOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/catowners")
public class CatOwnerController {

    private final CatOwnerService catOwnerService;

    @Autowired
    public CatOwnerController(CatOwnerService catOwnerService) {
        this.catOwnerService = catOwnerService;
    }

    // Přidání nového majitele (POST /api/catowners)
    @PostMapping
    public CatOwner createCatOwner(@RequestBody CatOwner catOwner) {
        return catOwnerService.saveCatOwner(catOwner);
    }

    // Výpis všech majitelů (GET /api/catowners)
    @GetMapping
    public List<CatOwner> getAllCatOwners() {
        return catOwnerService.getAllCatOwners();
    }

    // Najdi majitele podle ID (GET /api/catowners/{id})
    @GetMapping("/{id}")
    public Optional<CatOwner> getCatOwnerById(@PathVariable Long id) {
        return catOwnerService.getCatOwnerById(id);
    }

    // Smazání majitele podle ID (DELETE /api/catowners/{id})
    @DeleteMapping("/{id}")
    public void deleteCatOwner(@PathVariable Long id) {
        catOwnerService.deleteCatOwner(id);
    }
}