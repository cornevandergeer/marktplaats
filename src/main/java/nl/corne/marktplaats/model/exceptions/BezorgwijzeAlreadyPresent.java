package nl.corne.marktplaats.model.exceptions;

public class BezorgwijzeAlreadyPresent extends RuntimeException {
    public BezorgwijzeAlreadyPresent(String errorMessage){
        super(errorMessage);
    }
}
