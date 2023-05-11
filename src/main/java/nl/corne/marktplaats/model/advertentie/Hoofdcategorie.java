package nl.corne.marktplaats.model.advertentie;

public enum Hoofdcategorie {
    DIENST("dienst"),
    PRODUCT("product");

    private final String description;

    Hoofdcategorie(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
