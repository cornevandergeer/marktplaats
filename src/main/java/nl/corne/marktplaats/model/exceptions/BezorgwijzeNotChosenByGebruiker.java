package nl.corne.marktplaats.model.exceptions;

public class BezorgwijzeNotChosenByGebruiker extends Exception {
    public BezorgwijzeNotChosenByGebruiker(String errorMessage){
        super(errorMessage);
    }
}
