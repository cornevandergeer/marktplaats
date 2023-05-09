package nl.corne.marktplaats.model.exceptions;

public class UsernameTooSmallException extends Throwable {
    public UsernameTooSmallException(String errorMessage){
        super(errorMessage);
    }
}
