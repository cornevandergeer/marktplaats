package nl.corne.marktplaats.model.exceptions;

public class AuthorizationLevelTooLow extends Exception {
    public AuthorizationLevelTooLow(String errorMessage){
        super(errorMessage);
    }
}
