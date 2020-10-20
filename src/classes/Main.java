package classes;
import exceptions.NoMoreRequestException;
import exceptions.NoNeighbourFound;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //Creating a boolean variable "Exit" in order to stop the loop and finish the program if the user wants it
        boolean Exit = true;
        //Creating The objects that are going to be used
        FileReader F1 = new FileReader();
        Neighbourhood N1 = new Neighbourhood(3);    //This should be a fixed value? && lift == planta?
        MaintenanceCompany M1 = new MaintenanceCompany("M1","IntelliJ",120.0);  //Is this given by the user?
        //We read the txt file
        F1.readTxT("neighbours.txt",N1);
        //Creating a switch
       int n;
        do {
            try{n=printMenu();}catch(InputMismatchException e){n=0;}
            switch (n) {
                default:
                    System.out.println("Introduce the correct value");
                    break;
                case 1:
                    try {
                        System.out.println(N1.ShowAllInfo());
                    }catch(InputMismatchException e){
                        System.out.println("Introduce the correct value");
                    }
                    break;
                case 2:
                    try {
                        N1.selectNeighbour(askForDNI()).makeRequest(askForUrgency(),askForDescription());
                    }catch (NoMoreRequestException e) {
                        System.out.println("You've reached the limit of exceptions allowed");
                    }catch (NullPointerException e){
                        System.out.println("There are no Neighbours in your file");
                    }catch (InputMismatchException e){
                        System.out.println("Introduce the correct type of value");
                    }catch(NoNeighbourFound e){
                        System.out.println("We couldn't find the Neighbour");
                    }
                    break;
                case 3:
                    try {
                        System.out.println(N1.readRequests(askForDNI()));
                    }catch(NullPointerException e){
                        System.out.println("There are no Neighbours in your file");
                    }catch (InputMismatchException e){
                        System.out.println("Introduce the correct type of value");
                    }catch (NoNeighbourFound e){
                        System.out.println("We couldn't find the neighbour");
                    }
                    break;
                case 4:
                    try {
                        System.out.println(N1.readHighRequests(askForDNI()));
                    }catch(NullPointerException e){
                        System.out.println("There are no Neighbours in your file");
                    }catch (InputMismatchException e){
                        System.out.println("Introduce the correct type of value");
                    }catch (NoNeighbourFound e){
                        System.out.println("We couldn't find the Neighbour");
                    }
                    break;
                case 5:
                    try {
                        System.out.println("The total annual taxes to pay is: " + N1.totalTaxesToPay()+ " €");
                    }catch(NullPointerException e){
                        System.out.println("There are no Neighbours in your file");
                    }catch(InputMismatchException e){
                        System.out.println("Introduce the correct value");
                    }
                    break;
                case 6:
                    try {
                        System.out.println("The total annual taxes to pay for this neighbour is: " + N1.neighbourTaxesToPay(askForDNI()));
                    }catch(NullPointerException e){
                        System.out.println("There are no Neighbours in your file");
                    }catch (InputMismatchException e){
                        System.out.println("Introduce the correct type of value");
                    }catch (NoNeighbourFound e){
                        System.out.println("We couldn't find the Neighbour");
                    }
                    break;
                case 7:
                    try {
                        System.out.println("The total price to pay to the company is: " + N1.payToCompany(M1));
                    }catch(InputMismatchException e){
                        System.out.println("Introduce the correct value");
                    }
                    break;
                case 8:
                    try {
                        Exit = false;
                        System.out.println("Thank you for use this manager\nHope to see you soon");
                    }catch(InputMismatchException e){
                        System.out.println("Introduce the correct value");
                    }
                    break;
            }
        } while (Exit);
        sc.close();
    }
    private static String askForDNI()throws InputMismatchException{
        System.out.println("Please introduce the DNI:");
        sc.nextLine();
        return sc.nextLine();
    }
    private static int askForUrgency()throws InputMismatchException{
        System.out.println("Please tell me the level of Urgency:");
        return sc.nextInt();
    }
    private static String askForDescription(){
        System.out.println("Please introduce a description of your problem:");
        sc.nextLine();
        return sc.nextLine();
    }
    private static int printMenu()throws InputMismatchException{
        int option;
        System.out.println("---------------------------------------------------");
        System.out.println("\nWelcome to our Neighbourhood manager.\nPlease select one option:\n\n1. Show all the information about neighbours\n2. Make a request\n3. Show a specific Neighbour requests\n4. Show a specific Neighbour high level requests\n5. Show the total annual taxes to pay for the Neighbourhood\n6. Show the taxes to pay for a specific Neighbour\n7. Show total amount to be paid to the company\n8. Exit the manager");
        System.out.println("\n---------------------------------------------------");
        option = sc.nextInt();
        return option;
    }
}
