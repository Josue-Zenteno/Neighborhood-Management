package classes;
public class Tenant extends Neighbour {
    //We create it's parameters
    private double monthRental;
    //We create it's constructor
    public Tenant (String name,String DNI, String flatNumber,double rental){
        super (name,DNI,flatNumber);
        this.monthRental = rental;
    }
    //We create ONLY the necessary Getters/Setters
    private double getMonthRental(){
        return this.monthRental;
    } //We put it private because we only use it in this class
    // We create the overridden method PricePay that returns the price to pay for this Tenant
    public double getPricePay(){
        double price;
        if (getMonthRental() > 400){
            price = 300+(0.1*300);
        } else{
            price = 300+(0.05*300);
        }
        return price;
    }
    //Creating the overridden method toString in order to return all the information about this Tenant
    public String toString() {
        return "\nThe name is: " + getName() + "\nThe ID is: " + getDNI() + "\nThe flat number is: " + getFlatNumber() +"\nThe month rental is: "+getMonthRental()+"\n";
    }

}
