package nl.corne.marktplaats.model.advertentie;

import nl.corne.marktplaats.model.exceptions.AuthorizationLevelTooLow;
import nl.corne.marktplaats.model.exceptions.BezorgwijzeNotChosenByGebruiker;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.corne.marktplaats.model.gebruiker.Bezorgwijze;
import nl.corne.marktplaats.model.gebruiker.Gebruiker;
import nl.corne.marktplaats.model.gebruiker.GebruikerRol;

import java.math.BigDecimal;

@Slf4j
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table( name = "Advertentie")
@NamedQuery(name = "Advertentie.findAll", query = "SELECT a FROM Advertentie a")
public class Advertentie {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long advID;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Gebruiker mygebruiker;
    @Enumerated(EnumType.STRING)
    private Hoofdcategorie hoofdcategorie;
    private String titel;
    private BigDecimal prijs;
    @Lob
    private String omschrijving;
    @Enumerated(EnumType.STRING)
    private Bezorgwijze bezorgwijze;
    private StatusAdvertentie status = StatusAdvertentie.BESCHIKBAAR;

    public Advertentie(int advID, Gebruiker mygebruiker, Hoofdcategorie hoofdcategorie, String titel, BigDecimal prijs, Bezorgwijze bezorgwijze, String omschrijving) {
        this.advID = advID;
        this.mygebruiker = mygebruiker;
        this.hoofdcategorie = hoofdcategorie;
        this.titel = titel;
        this.prijs = prijs;
        try {
            setBezorgwijze(mygebruiker, bezorgwijze);
        } catch (BezorgwijzeNotChosenByGebruiker e) {
            System.out.println(e.getMessage());
        }
        this.bezorgwijze = bezorgwijze;
        this.omschrijving = omschrijving;
    }

    public boolean checkAuthorisatieAdvertentieByGebruiker(Gebruiker gebruiker){
        if (gebruiker == this.mygebruiker){
            return true;
        }
        return gebruiker.getRol().getAuthorizationLevel() > GebruikerRol.HANDELAAR.getAuthorizationLevel();
    }

    public void setBezorgwijze(Gebruiker mygebruiker, Bezorgwijze bezorgwijze) throws BezorgwijzeNotChosenByGebruiker{
        if (mygebruiker.getBezorgwijzes().contains(bezorgwijze)){
            this.bezorgwijze = bezorgwijze;
        } else {
            System.out.println("De " + bezorgwijze + " staat niet geactiveerd bij deze gebruiker.");
        }
    }
    public void setStatus(StatusAdvertentie status, Gebruiker gebruiker) throws AuthorizationLevelTooLow {
        if (this.checkAuthorisatieAdvertentieByGebruiker(gebruiker)){
            this.status = status;
        } else {
            System.out.println("Autorisatie level is te laag om status van advertentie aan te passen.");
        }
    }
}
