package nl.corne.marktplaats.model.reactie;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.corne.marktplaats.model.advertentie.Advertentie;
import nl.corne.marktplaats.model.gebruiker.Gebruiker;

import java.util.Date;

@Slf4j
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table( name = "Reactie")
@NamedQuery(name = "Reactie.findAll", query = "SELECT r FROM Reactie r Where r.advertentie = :advID")
public class Reactie {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reactieID;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Gebruiker gebruiker;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Advertentie advertentie;
//    @Builder.Default
//    private Date timeStamp = new Date();
    @Size(max = 255, message = "Uw tekst is te lang.")
    private String tekst;

    public String printReacties() {
        return "" +
                "|___________________________________________________\n" +
                "| Gebruiker:      " + this.getGebruiker() + "\n" +
                "| Reactie:       €" + this.getTekst() + "\n" +
                "____________________________________________________\n";
    }
}
