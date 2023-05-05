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

    private String gebruikersNaam;
    private String wachtwoord;
    private boolean isIngelogd = false;
    private Rol rol = Rol.HANDELAAR;
    private boolean afhalen = false;
    private boolean bezorgen = false;
    private boolean depot = false;


    public Gebruiker(String gebruikersNaam, String wachtwoord) {
        this.gebruikersNaam = gebruikersNaam;
        this.wachtwoord = wachtwoord;
    }


}
