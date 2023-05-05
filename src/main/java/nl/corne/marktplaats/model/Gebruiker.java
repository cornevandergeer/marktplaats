package nl.corne.marktplaats.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Rol rol = Rol.HANDELAAR;
    private boolean afhalen = false;
    private boolean bezorgen = false;
    private boolean depot = false;


    public Gebruiker(String email, String wachtwoord, String voornaam, String achternaam, String favorieteProgrammeertaal) {
        this.email = email;
        this.wachtwoord = wachtwoord;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.favorieteProgrammeertaal = favorieteProgrammeertaal;
    }


}
