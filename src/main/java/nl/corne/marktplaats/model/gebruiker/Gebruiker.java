package nl.corne.marktplaats.model.gebruiker;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table( name = "Gebruiker")
public class Gebruiker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userID;
    @Column(unique = true) @Email
    private String username;
    private String wachtwoord;
    @Enumerated(EnumType.STRING) @Builder.Default
    private GebruikerRol rol = GebruikerRol.HANDELAAR;
    private String voornaam;
    private String achternaam;
    private String woonplaats;
    private String favorieteProgrammeertaal;
    @ElementCollection @Builder.Default @CollectionTable(name = "Gebruiker Bezorgwijzes") @Enumerated(EnumType.STRING) //@OneToMany(cascade = CascadeType.PERSIST) @ToString.Exclude
    private Set<Bezorgwijze> bezorgwijzes = new HashSet<>();
//    private List<Advertentie> myFavorieteAdvertenties = new ArrayList<>();
    private boolean isIngelogd = false;

}
