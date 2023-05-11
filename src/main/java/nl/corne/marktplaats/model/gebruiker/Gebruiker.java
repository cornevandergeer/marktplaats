package nl.corne.marktplaats.model.gebruiker;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.corne.marktplaats.model.advertentie.Advertentie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table( name = "Gebruiker")
@NamedQuery(name = "Gebruiker.findAll", query = "SELECT a FROM Gebruiker a")
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
    @ElementCollection @Builder.Default @CollectionTable(name = "Gebruiker Bezorgwijzes") @Enumerated(EnumType.STRING) //@ManyToMany(cascade = CascadeType.PERSIST) // @ToString.Exclude
    private Set<Bezorgwijze> bezorgwijzes = new HashSet<>();
    @OneToMany @Builder.Default @CollectionTable(name = "Gebruiker Favoriete Advertenties")
    private Set<Advertentie> myFavorieteAdvertenties = new HashSet<>();
    private boolean isIngelogd = false;

}
