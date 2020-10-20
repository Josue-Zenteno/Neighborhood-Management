package classes;

import exceptions.NoNeighbourFound;

public class Neighbourhood {
    //We create it's parameters
    private int numberLifts;
    private Neighbour [] array = new Neighbour [11];
    //We create it's constructor
    public Neighbourhood(int numberLifts){
        this.numberLifts=numberLifts;
    }
    //We create ONLY the necessary Getters/Setters
    private int getNumberLifts(){
        return numberLifts;
    }
    public Neighbour [] getArray(){
        return array;
    }

    //We create the method ShowAllInfo that allow us to read the toString methods of the neighbours and then print them in the console
    public String ShowAllInfo(){
        //We initialize the String all with "" because we are not allowed to let i with a null value
        String all="";
        for(int i=0;i<getArray().length;i++){
            if(getArray()[i] == null){
                all += "";
            }else{
                all += getArray()[i].toString();
            }
        }
        if(all.equals("")){
            all="There are no neighbours in your file";
        }
        return all;
    }
    //We create the method totalTaxesToPay that calculates the amount that has to be paid for the Neighbourhood
    public double totalTaxesToPay(){
        double total=0;
        for(int i=0; i<getArray().length; i++){
            total += getArray()[i].getPricePay();
        }
        return total;
    }
    //We create the method totalTaxesToPay that calculates the amount that has to be paid for a given Neighbour
    public double neighbourTaxesToPay (String DNI)throws NoNeighbourFound{
        return getArray()[lookForNeighbour(DNI)].getPricePay();
    }
    //We create the method totalTaxesToPay that calculates the amount that has to be paid to the company
    public double payToCompany(MaintenanceCompany M1){
        return  12*(M1.getCost())*getNumberLifts();
    }
    //We create the method that has to read the Requests array and via toString's information print that in the console
    public String readRequests(String DNI)throws NoNeighbourFound{
        String info="";
        int counter=0;
        for(int i=0;i<getArray()[lookForNeighbour(DNI)].getArrayRequest().length;i++){
            if(getArray()[lookForNeighbour(DNI)].getArrayRequest()[i] == null){
                info += "";
            }else {
                info += getArray()[lookForNeighbour(DNI)].getArrayRequest()[i].toString();
                counter++;
            }
        }
        info += "\nthe number of requests is: "+counter;
        return info;
    }
    //We create a very similar method but this one only prints the High level urgency Request's info.
    public String readHighRequests(String DNI)throws NoNeighbourFound{
        String info="";
        int counter=0;
        for(int i=0;i<getArray()[lookForNeighbour(DNI)].getArrayRequest().length;i++){
            if(getArray()[lookForNeighbour(DNI)].getArrayRequest()[i] == null){
                info += "";
            }else if (getArray()[lookForNeighbour(DNI)].getArrayRequest()[i].getUrgency() == 2){
                info += getArray()[lookForNeighbour(DNI)].getArrayRequest()[i].toString();
                counter++;
            }
        }
        info += "\nthe number of high urgency requests is: "+counter;
        return info;
    }
    //We create this method in order to fill our Neighbours Array using the File Reader class
    public void addNeighbour(Neighbour neighbour,int position){
        getArray()[position]=neighbour;
    }
    public Neighbour selectNeighbour(String DNI)throws NoNeighbourFound{
        return getArray()[lookForNeighbour(DNI)];
    }
    private int lookForNeighbour(String DNI)throws NoNeighbourFound{
        int counter=0;
        for(int i=0; i<getArray().length;i++){
            if((getArray()[i].getDNI()).equals(DNI)){
                counter = i;
            }
        }
        if (counter == 0){
            throw new NoNeighbourFound();
        }
        return counter;
    }
}