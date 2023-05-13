package nl.corne.marktplaats.model.bod;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.corne.marktplaats.model.advertentie.Advertentie;
import nl.corne.marktplaats.model.gebruiker.Gebruiker;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table( name = "Bod")
@NamedQuery( name = "Bod.findBodAdvertentie", query = "SELECT b FROM Bod b WHERE b.advertentie = :advertentie")
public class Bod {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bodID;
    @ManyToOne
    private Gebruiker gebruiker;
    @OneToOne
    private Advertentie advertentie;
    @Builder.Default
    private Date timeStamp = new Date();
    private BigDecimal bedrag;
    private boolean geaccepteerdBod;

    public String formattedTimestamp()  {
        Timestamp ts = new Timestamp(timeStamp.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(ts);
    }

}
