package nl.corne.marktplaats.controller;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import nl.corne.marktplaats.model.advertentie.Advertentie;
import nl.corne.marktplaats.model.advertentie.AdvertentieDAO;
import nl.corne.marktplaats.model.advertentie.Hoofdcategorie;
import nl.corne.marktplaats.model.advertentie.StatusAdvertentie;
import nl.corne.marktplaats.model.bod.Bod;
import nl.corne.marktplaats.model.bod.BodDAO;
import nl.corne.marktplaats.model.gebruiker.Bezorgwijze;
import nl.corne.marktplaats.model.gebruiker.Gebruiker;
import nl.corne.marktplaats.model.reactie.Reactie;
import nl.corne.marktplaats.model.reactie.ReactieDAO;
import nl.corne.marktplaats.view.AdvertentieGekozenMenuView;
import nl.corne.marktplaats.view.AdvertentieInputView;
import nl.corne.marktplaats.view.AdvertentieInfoMenuView;

import java.math.BigDecimal;


@Singleton
public class AdvertentieController {

    @Inject
    private AdvertentieInputView advertentieInputView;
    @Inject
    private AdvertentieDAO advertentieDAO;
    @Inject
    private AdvertentieInfoMenuView advertentieInfoMenuView;
    @Inject
    private AdvertentieGekozenMenuView advertentieGekozenMenuView;
    @Inject
    private ReactieDAO reactieDAO;
    @Inject
    private BodDAO bodDAO;

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
    public void zieAlleAdvertenties(Gebruiker gebruiker){
        advertentieInfoMenuView.laatAlleAdvertentiesZien();
        advertentieInfoMenuView.laatKeuzeMenuZien();
        advertentieInfoMenuView.vraagNummerUitKeuzeMenu();

        switch (advertentieInfoMenuView.getAntwoord()) {
            case "1": // Zie geselecteerde advertentie
                int advertentieNummer = advertentieInfoMenuView.vraagAdvertentieNummer();
                zieGekozenAdvertentie(gebruiker, advertentieDAO.get(advertentieNummer));
                break;
            case "2": // Sorteer de advertenties
                System.out.println(
                        "Een mooi gesorteerde lijst van advertenties."
                );
                break;
            case "3": // Terug naar hoofdmenu
                System.out.println(
                        "Terug naar hoofdmenu."
                );


        }
    }

    public void zieGekozenAdvertentie(Gebruiker gebruiker, Advertentie advertentie){
        advertentie.printAdvertentie();
        advertentieGekozenMenuView.laatAlleReactiesZienVanAdvertentie(advertentie);
        advertentieGekozenMenuView.laatKeuzeMenuZien();
        advertentieGekozenMenuView.vraagNummerUitKeuzeMenu();

        switch (advertentieGekozenMenuView.getAntwoord()) {
            case "1" -> { // Plaats reactie op advertentie
                String tekst = advertentieGekozenMenuView.vraagTekst();
                Reactie reactie = Reactie.builder().
                        gebruiker(gebruiker).
                        advertentie(advertentie).
                        tekst(tekst).
                        build();
                reactieDAO.update(reactie);
                zieGekozenAdvertentie(gebruiker, advertentie);
            }
            case "2" -> { // Plaats bod op advertentie
                BigDecimal bodbedrag = advertentieGekozenMenuView.vraagBod(advertentie);
                Bod bod = Bod.builder().
                        gebruiker(gebruiker).
                        advertentie(advertentie).
                        bedrag(bodbedrag).
                        build();
                bodDAO.update(bod);
                zieGekozenAdvertentie(gebruiker, advertentie);
            }
            case "3" -> // Terug naar vorige menu
                    System.out.println("Terug naar vorige menu.");
        }
    }

}
