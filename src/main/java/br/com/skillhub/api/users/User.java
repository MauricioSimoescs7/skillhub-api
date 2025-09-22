package br.com.skillhub.api.users;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    private String phone;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType userType;

    private boolean isActive = true;

    private Instant createdAt = Instant.now();

    private Instant updatedAt = Instant.now();
}

// Crie também o Enum UserType.java no mesmo pacote
public enum UserType {
    candidate,
    company,
    admin
}
,