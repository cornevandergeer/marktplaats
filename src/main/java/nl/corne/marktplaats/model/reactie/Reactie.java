package nl.corne.marktplaats.model.reactie;

import jakarta.persistence.*;
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
public class Reactie {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reactieID;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Gebruiker gebruiker;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Advertentie advertentie;
    private Date timeStamp;
    private String reactie;
}
