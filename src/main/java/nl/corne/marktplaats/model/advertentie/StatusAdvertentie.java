package nl.corne.marktplaats.model.advertentie;

public enum StatusAdvertentie {
    BESCHIKBAAR("Beschikbaar", 0),
    MAGAZIJN("Magazijn", 1),
    ONDERWEG("Onderweg", 2),
    AFGEHANDELD("Afgehandeld", 3);

    private final String description;
    private final int afhandelingstatus;

    StatusAdvertentie(String description, int afhandelingstatus){
        this.description = description;
        this.afhandelingstatus = afhandelingstatus;
    }

    public String getDescription() {
        return description;
    }

    public int getAfhandelingstatus(){
        return afhandelingstatus;
    }
}
