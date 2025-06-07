package cz.catparadiseprojekt.catparadisehotel.service;

import cz.catparadiseprojekt.catparadisehotel.model.CatOwner;
import cz.catparadiseprojekt.catparadisehotel.repository.CatOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatOwnerService {

    private final CatOwnerRepository catOwnerRepository;

    @Autowired
    public CatOwnerService(CatOwnerRepository catOwnerRepository) {
        this.catOwnerRepository = catOwnerRepository;
    }

    public boolean existsById(Long ownerId) {
        return catOwnerRepository.existsById(ownerId);
    }

    // Uložení nového majitele
    public CatOwner saveCatOwner(CatOwner catOwner) {
        return catOwnerRepository.save(catOwner);
    }

    // Výpis všech majitelů
    public List<CatOwner> getAllCatOwners() {
        return catOwnerRepository.findAll();
    }

    // Najdi podle ID
    public Optional<CatOwner> getCatOwnerById(Long id) {
        return catOwnerRepository.findById(id);
    }

    // Smazání podle ID
    public void deleteCatOwner(Long id) {
        catOwnerRepository.deleteById(id);
    }
}