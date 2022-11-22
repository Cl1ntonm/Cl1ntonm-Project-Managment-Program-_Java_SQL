import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class that holds reusable methods for the program
 */
public class PoisedUtilities {
    /**
     * Method to display the menu options
     */
    public static void menuOption() {
        System.out.println("___________________________________________________________");
        System.out.println("WELCOME TO POISED CONSTRUCTION ");
        System.out.println("Please choose one of the following options");
        System.out.println("By Typing in one of the numbers '1' to '10' ");
        System.out.println("\n1.  Add New Project details");
        System.out.println("2.  View Ongoing Projects - Full Details");
        System.out.println("3.  View Ongoing Projects - Name and Number");
        System.out.println("4.  View Ongoing Projects Passed Due Date");
        System.out.println("5.  Search for Project - Full Details");
        System.out.println("6.  Update Ongoing Project Details");
        System.out.println("7.  Delete a Project ");
        System.out.println("8.  Finalize and Display Invoice ");
        System.out.println("9.  View Completed Projects - Name and Number");
        System.out.println("10. View Completed Projects Full Details");
        System.out.println("0. To exit\n ");
        System.out.println("Enter your menu choice: ");
    }

    /**
     * Method that ensure User enters the amounts in the correct numerical format
     * @return - the user entered amounts but only ing the correct format
     */
    public static double assignAmount(){
        //declare base variables
        boolean amountStop;
        double enteredAmount = 0;
        Scanner amountScanner;
        amountScanner = new Scanner(System.in);
        amountStop = false;

        //loops the code until the correct usable type of data is inputted
        do {
            try{
                System.out.println("Enter the Amount value in Numerical format eg 1000 or 1000.00");
                enteredAmount = Double.parseDouble(amountScanner.nextLine());
                break;
            }catch (Exception  e){
                System.out.println("Invalid entry");
            }
        }while (amountStop == false);
        return enteredAmount;

    }

    /**
     * Method that accepts the deadline/completion date in only the correct format
     * @return - the user entered date but only in the correct format
     */
    public static LocalDate assignDate() {
        //declare base variables
        boolean dateStop;
        LocalDate enteredDate;
        Scanner dateScanner;
        dateScanner = new Scanner(System.in);
        dateStop = false;
        enteredDate = null;

        //loops the code until the correct usable type of data is inputted
        do {
            try {
                System.out.println("Please Enter the date in the following format: eg 2010-12-31");

                enteredDate = LocalDate.parse(dateScanner.nextLine());

                break;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid entry");
            }
        } while (dateStop == false);
        return enteredDate;
    }

    /**
     * Method that accepts user entered information for a project
     * @return an object array list that contains Project and all related Persons for a project
     */
    public static ArrayList projectObjectList(){
        // Create Object list to store object of different classes
        ArrayList<Object>projectObjectList = new ArrayList<>();
        // assigning methods scanner instance
        Scanner scanner = new Scanner(System.in);

        // Accepting user input of Project detail information
        System.out.println("Please enter a Project name ," +
                " \nShould you rather prefer an Auto name Press 'x':");
        String projectName = scanner.nextLine();

        System.out.println("Please Enter The Project Type :");
        String projectType = scanner.nextLine();

        System.out.println("Please Enter the Project Address");
        String projectAddress = scanner.nextLine();

        System.out.println("Please Enter the Project ERF Number ");
        String projectErf = scanner.nextLine();
        double projectAmountCharged = PoisedUtilities.assignAmount();

        System.out.println("Please Enter the amount Paid to date");
        double projectAmountPaid = PoisedUtilities.assignAmount();

        System.out.println("Deadline Date Input");
        LocalDate projectDeadlineDate = PoisedUtilities.assignDate();
        //assigning a date value to ensure  no null value exception errors
        LocalDate projectCompletedDate = projectDeadlineDate;

        //Accept project finalized status
        String projectFinalised = "no";

        //Accepting Customer details
        Person customer = PoisedUtilities.createNewPerson("Customer");

        //Accepting Architect details
        Person architect = PoisedUtilities.createNewPerson("Architect");

        //Accepting Contractor details
        Person contractor = PoisedUtilities.createNewPerson("Contractor");

        //Accepting Engineer details
        Person engineer = PoisedUtilities.createNewPerson("Structural Engineer");

        //Accepting Manager details
        Person manager = PoisedUtilities.createNewPerson("Project Manager");


        // Auto generate project name, as per user request , the type and surname are
        // joined and assigned to from the auto project name
        if (projectName.equals("x")) {
            projectName = projectType + " " + customer.getLastName();
        }

        //creating project object
        Project projectDetails = new Project( null, projectName, projectType, projectAddress,
                projectErf, projectAmountCharged, projectAmountPaid, projectDeadlineDate, projectFinalised,
                projectCompletedDate, customer, architect, contractor, engineer, manager);

        //creating each person object
        projectObjectList.add(customer);
        projectObjectList.add(architect);
        projectObjectList.add(contractor);
        projectObjectList.add(engineer);
        projectObjectList.add(manager);
        projectObjectList.add(projectDetails);
        return projectObjectList;
    }

    /**
     *
     * @param personType a variable that indicates role/relationship to the project
     * @return a Person object with all contact details
     */
    public static Person createNewPerson(String personType)  {

        // accept user input of person class related details
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("\nPlease Enter " + personType + " First Name");
        String firstName = scanner.next();
        System.out.println("Please Enter " + personType + " Last Name");
        String surName = scanner.next();
        System.out.println("Please Enter " + personType + " Telephone Number");
        String telephoneNumber = scanner.next();
        System.out.println("Please Enter " + personType + " Email Address");
        String emailAddress = scanner.next();
        System.out.println("Please Enter " + personType + " Address");
        String address = scanner.next();

        //creating the Person object
        Person newPerson = new Person(firstName, surName, telephoneNumber, emailAddress, address);
        return newPerson;
    }

}
