package nl.corne.marktplaats.controller;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import nl.corne.marktplaats.model.advertentie.Advertentie;
import nl.corne.marktplaats.model.advertentie.AdvertentieDAO;
import nl.corne.marktplaats.model.advertentie.Hoofdcategorie;
import nl.corne.marktplaats.model.advertentie.StatusAdvertentie;
import nl.corne.marktplaats.model.gebruiker.Bezorgwijze;
import nl.corne.marktplaats.model.gebruiker.Gebruiker;
import nl.corne.marktplaats.view.AdvertentieInputView;

import java.math.BigDecimal;


@Singleton
public class AdvertentieController {

    @Inject
    private AdvertentieInputView advertentieInputView;
    @Inject
    private AdvertentieDAO advertentieDAO;

    public void maakAdvertentie(Gebruiker gebruiker) {
        String hoofdcategorie = advertentieInputView.vraagHoofdcategorie();
        String bezorgwijze = "";
        if (hoofdcategorie.equals("product")) {
            bezorgwijze = advertentieInputView.vraagBezorgwijze(gebruiker);
        }
        String titel = advertentieInputView.vraagTitel();
        BigDecimal prijs =  advertentieInputView.vraagPrijs();
        String omschrijving = advertentieInputView.vraagOmschrijving();
        Advertentie advertentie = Advertentie.builder().hoofdcategorie(Hoofdcategorie.valueOf(hoofdcategorie.toUpperCase())).titel(titel).prijs(prijs).omschrijving(omschrijving).status(StatusAdvertentie.BESCHIKBAAR).mygebruiker(gebruiker).bezorgwijze(Bezorgwijze.valueOf(bezorgwijze)).build();
        advertentieDAO.update(advertentie);
    }
}
