package exceptions;

public class NoMoreRequestException extends Exception {
    public NoMoreRequestException(){}
    public NoMoreRequestException(String a){
        super(a);
    }
}
