package nl.corne.marktplaats.controller;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import nl.corne.marktplaats.model.advertentie.Advertentie;
import nl.corne.marktplaats.model.advertentie.AdvertentieDAO;
import nl.corne.marktplaats.model.advertentie.Hoofdcategorie;
import nl.corne.marktplaats.view.AdvertentieInputView;

import java.math.BigDecimal;


@Singleton
public class AdvertentieController {

    @Inject
    private AdvertentieInputView advertentieInputView;
    @Inject
    private AdvertentieDAO advertentieDAO;

    public void maakAdvertentie() {
        String hoofdcategorie = advertentieInputView.vraagHoofdcategorie();
        String titel = advertentieInputView.vraagTitel();
        BigDecimal prijs =  advertentieInputView.vraagPrijs();
        String omschrijving = advertentieInputView.vraagOmschrijving();
        Advertentie advertentie = Advertentie.builder().hoofdcategorie(Hoofdcategorie.valueOf(hoofdcategorie.toUpperCase())).titel(titel).prijs(prijs).omschrijving(omschrijving).build();
        advertentieDAO.insert(advertentie);

    }

}
