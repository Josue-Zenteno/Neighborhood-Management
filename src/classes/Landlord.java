package classes;
public class Landlord extends Neighbour {
    //We create it's parameters
    private int year;
    //We create it's constructor
    public Landlord (String name,String DNI, String flatNumber,int year){
        super(name, DNI, flatNumber);
        this.year = year;
    }
    //We create ONLY the necessary Getters/Setters
    private int getYear(){
        return this.year;
    }   //We put it private because we only use it in this class
    // We create the overridden method PricePay that returns the price to pay for this LandLord
    public double getPricePay(){
        double price;
        if((2019-getYear())> 15){
            price = 500+(500*0.15);
        }else{
            price = 500+(500*0.1);
        }
        return price;
    }
    //Creating the overridden method toString in order to return all the information about this LandLord
    public String toString() {
        return "\nThe name is: " + getName() + "\nThe ID is: " + getDNI() + "\nThe flat number is: " + getFlatNumber()+"\nThe year of bought is: "+getYear()+"\n";
    }
}
