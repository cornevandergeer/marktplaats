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

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    @Builder.Default
    private Date timeStamp = new Date();
    @Size(max = 255, message = "Uw tekst is te lang.")
    private String tekst;


    public String formattedTimestamp()  {
        Timestamp ts = new Timestamp(timeStamp.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(ts);
    }

    public String printReacties() {
        return "" +
                "|__________________________________________________________________\n" +
                "| Gebruikersnaam:     " + this.getGebruiker().getUsername() + "\n" +
                "| Datum:              " + this.formattedTimestamp() + "\n" +
                "| Reactie:            " + this.getTekst() + "\n" +
                "|___________________________________________________________________\n";
    }
}
