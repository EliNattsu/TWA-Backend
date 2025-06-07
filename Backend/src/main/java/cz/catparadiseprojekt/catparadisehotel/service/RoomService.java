package cz.catparadiseprojekt.catparadisehotel.service;

import cz.catparadiseprojekt.catparadisehotel.model.Room;
import cz.catparadiseprojekt.catparadisehotel.model.RoomType;
import cz.catparadiseprojekt.catparadisehotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    // Uložení pokoje s kontrolou unikátního čísla
    public Room saveRoom(Room room) {
        if (roomRepository.existsByRoomNumber(room.getRoomNumber())) {
            throw new IllegalArgumentException("Pokoj s číslem " + room.getRoomNumber() + " již existuje.");
        }
        return roomRepository.save(room);
    }

    // Výpis všech pokojů
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    // Výpis pokojů podle typu
    public List<Room> getRoomsByType(RoomType roomType) {
        return roomRepository.findByRoomType(roomType);
    }

    // Výpis pokoje podle ID
    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    // Aktualizace pokoje
    public Room updateRoom(Long id, Room updatedRoom) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pokoj s ID " + id + " neexistuje."));

        room.setRoomNumber(updatedRoom.getRoomNumber());
        room.setCapacity(updatedRoom.getCapacity());
        room.setPricePerNight(updatedRoom.getPricePerNight());
        room.setDescription(updatedRoom.getDescription());
        room.setRoomType(updatedRoom.getRoomType());
        return roomRepository.save(room);
    }
}