package nl.corne.marktplaats.model.gebruiker;

public enum GebruikerRol {

    HANDELAAR("Handelaar", 0),
    MAGAZIJNMEDEWERKER("Magazijnmedewerker", 1),
    BEHEERDER("Beheerder", 2);

    private final String description;
    private final int authorizationLevel;

    GebruikerRol(String description, int authorizationLevel){
        this.description = description;
        this.authorizationLevel = authorizationLevel;
    }

    public String getRolDescription(){
        return description;
    }

    public int getAuthorizationLevel() {
        return authorizationLevel;
    }

    @Override
    public String toString(){
        return this.getRolDescription();
    }
}
