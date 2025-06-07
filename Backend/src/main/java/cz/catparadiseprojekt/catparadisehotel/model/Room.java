package cz.catparadiseprojekt.catparadisehotel.model;

import jakarta.persistence.*;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true) // číslo pokoje musí být unikátní
    private String roomNumber;
    private Integer capacity; // maximální počet koček v pokoji
    private Double pricePerNight;
    private String description;

    @Enumerated(EnumType.STRING) // ukládáme název enumu jako řetězec
    private RoomType roomType;

    // Konstruktory
    public Room() {}

    public Room(String roomNumber, Integer capacity, Double pricePerNight, String description, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.pricePerNight = pricePerNight;
        this.description = description;
        this.roomType = roomType;
    }

    // Gettery a settery
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }

    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }

    public Double getPricePerNight() { return pricePerNight; }
    public void setPricePerNight(Double pricePerNight) { this.pricePerNight = pricePerNight; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public RoomType getRoomType() { return roomType; }
    public void setRoomType(RoomType roomType) { this.roomType = roomType; }
}