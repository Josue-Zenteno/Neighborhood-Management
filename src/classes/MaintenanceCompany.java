package classes;
public class MaintenanceCompany {
    //We create it's parameters
    private String name;
    private String address;
    private double cost;
    //We create it's constructor
    public MaintenanceCompany(String name,String address,double cost) {
        this.name = name;
        this.address = address;
        this.cost = cost;
    }
    //We create ONLY the necessary Getter/Setters
    public double getCost(){
        return cost;
    }
}
