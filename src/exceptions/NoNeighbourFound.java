package exceptions;

public class NoNeighbourFound extends Exception {
    public NoNeighbourFound(){}
    public NoNeighbourFound(String description){
        super(description);
    }
}
