package cz.catparadiseprojekt.catparadisehotel.model;

import jakarta.persistence.*;

@Entity
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private String breed;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private CatOwner owner;

    // gettery, settery, konstruktory
    public Cat() {
    }

    public Cat(String name, Integer age, String breed, CatOwner owner) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.owner = owner;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getBreed() { return breed; }
    public void setBreed(String breed) { this.breed = breed; }

    public CatOwner getOwner() { return owner; }
    public void setOwner(CatOwner owner) { this.owner = owner; }
}