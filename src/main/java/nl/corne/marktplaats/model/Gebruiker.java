package nl.corne.marktplaats.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor @AllArgsConstructor @Data @Builder
@Entity
@Table(name = "Gebruikers")
public class Gebruiker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;
    private String wachtwoord;
    private String voornaam;
    private String achternaam;
    private String favorieteProgrammeertaal;
    private boolean isIngelogd = false;
    @Enumerated(EnumType.STRING) @Builder.Default
    private Rol rol = Rol.HANDELAAR;

    @ManyToOne
    private Bezorgwijze bezorgwijzes;



    public Gebruiker(String email, String wachtwoord, String voornaam, String achternaam, String favorieteProgrammeertaal) {
        this.email = email;
        this.wachtwoord = wachtwoord;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.favorieteProgrammeertaal = favorieteProgrammeertaal;
    }

    public Gebruiker(String voornaam) {
        this.voornaam = voornaam;
    }


    public void setBezorgwijzes(Bezorgwijze bezorgwijzes) {
        this.bezorgwijzes = bezorgwijzes;
        bezorgwijzes.getGebruikers().add(this);
    }

}
