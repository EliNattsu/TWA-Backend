package cz.catparadiseprojekt.catparadisehotel.service;

import cz.catparadiseprojekt.catparadisehotel.model.Cat;
import cz.catparadiseprojekt.catparadisehotel.model.CatOwner;
import cz.catparadiseprojekt.catparadisehotel.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CatService {
    private final CatRepository catRepository;
    private final CatOwnerService catOwnerService;

    @Autowired
    public CatService(CatRepository catRepository, CatOwnerService catOwnerService) {
        this.catRepository = catRepository;
        this.catOwnerService = catOwnerService;
    }

    public Cat saveCat(Cat cat) {
        if (cat.getOwner() == null || !catOwnerService.existsById(cat.getOwner().getId())) {
            throw new IllegalArgumentException("Majitel musí existovat.");
        }
        return catRepository.save(cat);
    }

    public List<Cat> getAllCats() {
        return catRepository.findAll();
    }

    public Optional<Cat> getCatById(Long id) {
        return catRepository.findById(id);
    }

    public void deleteCat(Long id) {
        catRepository.deleteById(id);
    }

    // výpis koček podle majitele
    public List<Cat> getCatsByOwner(CatOwner owner) {
        return catRepository.findByOwner(owner);
    }
}