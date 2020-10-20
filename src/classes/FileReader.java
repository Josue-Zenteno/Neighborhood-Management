package classes;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    //We create a method in order to read the file, it's a common file reader
    public void readTxT(String pathname, Neighbourhood neighbourhood) {
        //We create the objects File,Scanner and Neighbour
        File f = new File(pathname);
        Scanner sc;
        Neighbour n;
        int counter=0;
        //Now we use a While loop in order to read ALL the file
        try{
            sc = new Scanner(f);
            while(sc.hasNext()){
                //We create some variables that will be the parameters for the Neighbour's constructor
                char rol = sc.next().charAt(0);
                String name = sc.next();
                String DNI = sc.next();
                String flatNumber = sc.next();
                //With this if we know if the neighbours are Tenants or LandLords
                if (rol == 'l'){
                    int year = sc.nextInt();
                    n = new Landlord (name,DNI,flatNumber,year);
                }else{
                    String rentalString=sc.next();
                    double rental = Double.parseDouble(rentalString);
                    n = new Tenant (name,DNI,flatNumber,rental);
                }
                //Now we add the created neighbour to the neighbours array that has a fixed length
                neighbourhood.addNeighbour(n,counter);
                counter++;
            }
            //With our Try and Catch we are controlling the FileNotFoundException
        } catch (FileNotFoundException e){
            System.out.println("Don't move the file from the project's folder");
        }
    }
}


