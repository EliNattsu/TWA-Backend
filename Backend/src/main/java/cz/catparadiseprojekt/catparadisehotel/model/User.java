package cz.catparadiseprojekt.catparadisehotel.model;

import cz.catparadiseprojekt.catparadisehotel.security.UserRole;

public class User {
    private Long id;
    private String email;
    private String password;
    private UserRole role;

    // Konstruktor
    public User(Long id, String email, String password, UserRole role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Gettery a settery
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public UserRole getRole() { return role; }
    public void setRole(UserRole role) { this.role = role; }
}
