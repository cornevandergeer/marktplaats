package nl.corne.marktplaats.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Bezorgwijze {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private boolean afhalen = false;
    private boolean bezorgen = false;
    private boolean depot = false;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "bezorgwijzes")
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Gebruiker> gebruikers = new ArrayList<>();
}
