package classes;
public class Request {
    //We create it's parameters
    private int urgency;
    private String description;
    //We create it's constructor
    public Request (int urgency, String description){
        this.urgency = urgency;
        this.description = description;
    }
    //We create ONLY the necessary Getters/Setters
    public int getUrgency(){
        return this.urgency;
    }
    public String getDescription(){
        return this.description;
    }
    //We create the toString method that returns all the information about a request
    public String toString(){
        return "\nThe urgency level is: "+getUrgency()+"\nThe description of the problem is: "+getDescription();
    }
}

