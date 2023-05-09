package nl.corne.marktplaats.model.advertentie;

import belastingdienst.marktplaats.exceptions.AuthorizationLevelTooLow;
import belastingdienst.marktplaats.exceptions.BezorgwijzeNotChosenByGebruiker;
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
public class Advertentie {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int advID;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Gebruiker mygebruiker;
    private Hoofdcategorie hoofdcategorie;
    private String naamAdvertentie;
    private BigDecimal prijs;
    private Bezorgwijze bezorgwijze;
    private String omschrijvingAdvertentie;
    private StatusAdvertentie status = StatusAdvertentie.BESCHIKBAAR;

    public Advertentie(int advID, Gebruiker mygebruiker, Hoofdcategorie hoofdcategorie, String naamAdvertentie, BigDecimal prijs, Bezorgwijze bezorgwijze, String omschrijvingAdvertentie) {
        this.advID = advID;
        this.mygebruiker = mygebruiker;
        this.hoofdcategorie = hoofdcategorie;
        this.naamAdvertentie = naamAdvertentie;
        this.prijs = prijs;
        try {
            setBezorgwijze(mygebruiker, bezorgwijze);
        } catch (BezorgwijzeNotChosenByGebruiker e) {
            System.out.println(e.getMessage());
        }
        this.bezorgwijze = bezorgwijze;
        this.omschrijvingAdvertentie = omschrijvingAdvertentie;
    }

    public boolean changeAdvertentieByGebruiker(Gebruiker gebruiker){
        if (gebruiker == this.mygebruiker){
            return true;
        }
        return gebruiker.getRol().getAuthorizationLevel() > GebruikerRol.HANDELAAR.getAuthorizationLevel();
    }

    public int getAdvID() {
        return advID;
    }

    public Gebruiker getMygebruiker() {
        return mygebruiker;
    }

    public Hoofdcategorie getHoofdcategorie() {
        return hoofdcategorie;
    }

    public void setHoofdcategorie(Hoofdcategorie hoofdcategorie) {
        this.hoofdcategorie = hoofdcategorie;
    }

    public String getNaamAdvertentie() {
        return naamAdvertentie;
    }

    public void setNaamAdvertentie(String naamAdvertentie) {
        this.naamAdvertentie = naamAdvertentie;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public void setPrijs(BigDecimal prijs) {
        this.prijs = prijs;
    }

    public String getOmschrijvingAdvertentie() {
        return omschrijvingAdvertentie;
    }

    public void setOmschrijvingAdvertentie(String omschrijvingAdvertentie) {
        this.omschrijvingAdvertentie = omschrijvingAdvertentie;
    }

    public Bezorgwijze getBezorgwijze() {
        return bezorgwijze;
    }

    public void setBezorgwijze(Gebruiker mygebruiker, Bezorgwijze bezorgwijze) throws BezorgwijzeNotChosenByGebruiker{
        if (mygebruiker.getBezorgwijzes().contains(bezorgwijze)){
            this.bezorgwijze = bezorgwijze;
        } else {
            System.out.println("De " + bezorgwijze + " staat niet geactiveerd bij deze gebruiker.");
        }
    }

    public StatusAdvertentie getStatus() {
        return status;
    }

    public void setStatus(StatusAdvertentie status, Gebruiker gebruiker) throws AuthorizationLevelTooLow {
        if (this.changeAdvertentieByGebruiker(gebruiker)){
            this.status = status;
        } else {
            System.out.println("Autorisatie level is te laag om status van advertentie aan te passen.");
        }
    }
}
