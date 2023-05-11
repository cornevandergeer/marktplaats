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
import java.util.Date;

@Slf4j
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table( name = "Bod")
public class Bod {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bodID;
    @ManyToOne
    private Gebruiker gebruiker;
    @OneToOne
    private Advertentie advertentie;
    private BigDecimal bedrag;
    private boolean geaccepteerdBod;

}
