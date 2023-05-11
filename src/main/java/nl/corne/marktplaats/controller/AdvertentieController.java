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
        String bezorgwijze = null;
        if (hoofdcategorie.equals("product")) {
            if (gebruiker.getBezorgwijzes().size() == 0) {
                System.out.println("stel eerst je bezorgwijzes bij je profiel in.");
                return;
            }
            bezorgwijze = advertentieInputView.vraagBezorgwijze(gebruiker);
        }
        String titel = advertentieInputView.vraagTitel();
        BigDecimal prijs =  advertentieInputView.vraagPrijs();
        String omschrijving = advertentieInputView.vraagOmschrijving();
        Advertentie advertentie = Advertentie.builder().
                hoofdcategorie(Hoofdcategorie.valueOf(hoofdcategorie.toUpperCase())).
                titel(titel).
                prijs(prijs).
                omschrijving(omschrijving).
                status(StatusAdvertentie.BESCHIKBAAR).
                mygebruiker(gebruiker).
                bezorgwijze(bezorgwijze == null ? null : Bezorgwijze.valueOf(bezorgwijze)).
                build();
        advertentieDAO.update(advertentie);
    }
}
