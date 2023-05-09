package nl.corne.marktplaats.model.advertentie;

public enum Hoofdcategorie {
    DIENSTEN("Diensten"),
    GOEDEREN("Goederen");

    private final String description;

    Hoofdcategorie(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
