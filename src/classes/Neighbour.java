package classes;
import exceptions.NoMoreRequestException;
public abstract class Neighbour {
    //We create it's parameters
    private String name;
    private String DNI;
    private String flatNumber;
    private Request [] requestArray = new Request [10];
    //We create it's constructor
    public Neighbour (String name,String DNI, String flatNumber){
        this.name=name;
        this.DNI=DNI;
        this.flatNumber=flatNumber;
    }
    //We create ONLY the necessary Getters/Setters
    public Request [] getArrayRequest (){
        return requestArray;
    }
    public String getName(){
        return name;
    }
    public String getDNI(){
        return DNI;
    }
    public String getFlatNumber(){
        return flatNumber;
    }
    //We create this method in order to fill our Requests Array with given parameters

    public void makeRequest(int urgency,String description) throws NoMoreRequestException {
        boolean stop=false;
        for (int i = 0; i < getArrayRequest().length && !stop ; i++) {
            if (getArrayRequest()[i] == null) {
                getArrayRequest()[i] = new Request(urgency, description);
                stop =true;
            }else if(i==(getArrayRequest().length)-1){  //If it reaches 9 it will throw the exception created by us "NoMoreRequestException"
                                            //It will only reach 9 if all the previous request had been made
                throw new NoMoreRequestException();
            }
        }
    }
    abstract public String toString();
    abstract public double getPricePay();
}
