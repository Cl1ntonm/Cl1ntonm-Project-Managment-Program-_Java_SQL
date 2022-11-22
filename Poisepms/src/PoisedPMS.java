
/**
 * Task 8 Compulsory Task
 *
 * Task Purpose - modify previous level 2 capstone project to work with MySql
 *
 * Program Description - Program performs the following functions for Project management
 *                       .Adds new Projects withe details - to a file  to be recalled later
 *                       .View all ongoing Projects at once
 *                       .View condensed list of ongoing Projects
 *                       .View List if of Projects passed it due date
 *                       .Search for and view a particular project
 *                       .Update any selected ongoing Project detail
 *                       .Delete any ongoing Project
 *                       .Finalize a project by adding completion date and moving it to a new file
 *                       .View condensed list of Completed Projects
 *                       .View an in Detail list of Completed Projects
 *
 * IMPORTANT NOTICE - For program to work as intended Safe update mode in MySQL will need to be Turned off
 *
 *
 * Class Breakdown - Person class , holds Person Objects
 *                 - Project class , holds Project Objects
 *                 - PoisedUtilities , holds reusable methods for the program
 *                 - DB , holds all methods that connect to the database
 *
 * @author ClintonM
 */

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Main class that executes the menu options
 */
public class PoisedPMS {

    public static void main(String[] args) throws SQLException {

        //creating instance of class that contains all connections to the database
        DB context = new DB();
        context.connect();

        //declare base variables
        boolean closeProgram = false;
        ArrayList<Project> ongoingProjects = new ArrayList<Project>();
        ArrayList<Project> completedProjects = new ArrayList<Project>();
        ArrayList<Project> lateProjects = new ArrayList<Project>();
        ArrayList<Integer> ongoingProjectIDs = new ArrayList<>();

        //while loop for menu
        while (!closeProgram){
            Scanner scannerMenu = new Scanner(System.in).useDelimiter("\\n");
            Scanner scanner = new Scanner(System.in);

            // calling method to display the options available for the user
            PoisedUtilities.menuOption();
            try {
                switch (scannerMenu.nextInt()) {
                    case 1:
                        // calling method that inputs project and person data and returns them in object from
                        ArrayList projectObjectList = PoisedUtilities.projectObjectList();

                        // extract from array list and insert Project detail to project table
                        Project projectDetails = (Project) projectObjectList.get(5);
                        int projectNumber = context.projectSqlInsert(projectDetails);

                        // extract from each person role type from array list and
                        // insert person detail to person table
                        Person customer = (Person) projectObjectList.get(0);
                        context.personSqlInsert(customer,projectNumber,1);

                        Person architect = (Person) projectObjectList.get(1);
                        context.personSqlInsert(architect,projectNumber,2);

                        Person contractor = (Person) projectObjectList.get(2);
                        context.personSqlInsert(contractor,projectNumber,3);

                        Person engineer = (Person) projectObjectList.get(3);
                        context.personSqlInsert(engineer,projectNumber,4);

                        Person manager = (Person) projectObjectList.get(4);
                        context.personSqlInsert(manager,projectNumber,5);
                        break;

                    case 2:
                        //View Ongoing Projects - Full Details

                        // calling method that saves all ongoing projects to an array list
                        ongoingProjects = context.getOngoingProjects();
                        System.out.println("ONGOING PROJECT DETAILS:");

                        //iterate through array list and display to screen
                        if (ongoingProjects.size() != 0){
                            for (Project temp : ongoingProjects) {
                                System.out.println(temp.displayDetails());
                            }
                        } else {
                            System.out.println("empty");
                        }
                        break;
                    case 3:
                        //View Ongoing Projects - Name and Number

                        // calling method that saves all ongoing projects to an array list
                        ongoingProjects = context.getOngoingProjects();
                        System.out.println("ONGOING PROJECT SUMMARY:");

                        //iterate through array list and display to screen(partial information )
                        if (ongoingProjects.size() != 0){
                            for (Project temp : ongoingProjects) {
                                System.out.println(temp.displaySummary());
                            }
                        } else {
                            System.out.println("empty");
                        }
                        break;
                    case 4:
                        //View Ongoing Projects Passed Due Date

                        // calling method that saves all overdue projects to an array list
                        lateProjects = context.getLateProjects();
                        System.out.println("LATE PROJECT SUMMARY:");

                        //iterate through array list and display to screen(partial information )
                        if (lateProjects.size() != 0){
                            for (Project temp : lateProjects) {
                                System.out.println(temp.displaySummary());
                            }
                        } else {
                            System.out.println("empty");
                        }
                        break;
                    case 5:
                        //Search for Ongoing Project

                        // calling method that saves all ongoing projects to an array list
                        ongoingProjects = context.getOngoingProjects();
                        System.out.println("ONGOING PROJECT SUMMARY:");

                        //iterate through array list and display to screen(partial information )
                        if (ongoingProjects.size() != 0){
                            for (Project temp : ongoingProjects) {
                                System.out.println(temp.displaySummary());
                            }
                        } else {
                            System.out.println("empty");
                        }

                        //request user to select project number from view
                        System.out.println("\nEnter the Project Number to view details");
                        int projectNumberSearch = scanner.nextInt();

                        //checking if user selected from only the available summery list
                        ongoingProjectIDs = context.getOngoingProjectIDs();
                        if (ongoingProjectIDs.contains(projectNumberSearch)) {

                            // calling method to retrieve and display selected method from database
                            Project searchProject = context.getProject(projectNumberSearch);
                            System.out.println(searchProject.displayDetails());
                        }
                        break;
                    case 6:
                        /**
                         * IMPORTANT NOTICE - For program to work as intended Safe update mode in MySQL will need to be Turned off
                         */
                        //Update Ongoing Project Details

                        // calling method that saves all ongoing projects to an array list
                        ongoingProjects = context.getOngoingProjects();
                        System.out.println("ONGOING PROJECT SUMMARY:");

                        //iterate through array list and display to screen(partial information )
                        if (ongoingProjects.size() != 0){
                            for (Project temp : ongoingProjects) {
                                System.out.println(temp.displaySummary());
                            }
                        } else {
                            System.out.println("empty");
                        }
                        //request user to select project number to edit
                        System.out.println("\nEnter the Project Number to Edit Details");
                        int projectNumberUpdate = scanner.nextInt();

                        //checking if user selected from only the available summery list
                        ongoingProjectIDs = context.getOngoingProjectIDs();
                        if (ongoingProjectIDs.contains(projectNumberUpdate)) {

                            // calling method that inputs project and person data and returns them in object from
                            ArrayList projectObjectListUpdate = PoisedUtilities.projectObjectList();

                            // extract from array list and insert updated Project detail to project table
                            Project projectDetailsUpdate = (Project) projectObjectListUpdate.get(5);
                            context.projectSqlUpdate(projectDetailsUpdate, projectNumberUpdate);

                            // extract from each person role type from array list and
                            // insert Update person detail to person table
                            customer = (Person) projectObjectListUpdate.get(0);
                            context.personSqlUpdate(customer, projectNumberUpdate, 1);

                            architect = (Person) projectObjectListUpdate.get(1);
                            context.personSqlUpdate(architect, projectNumberUpdate, 2);

                            contractor = (Person) projectObjectListUpdate.get(2);
                            context.personSqlUpdate(contractor, projectNumberUpdate, 3);

                            engineer = (Person) projectObjectListUpdate.get(3);
                            context.personSqlUpdate(engineer, projectNumberUpdate, 4);

                            manager = (Person) projectObjectListUpdate.get(4);
                            context.personSqlUpdate(manager, projectNumberUpdate, 5);
                            break;
                        }else {
                            //display appropriate message for incorrect user selection
                            System.out.println("You have not chosen from the above available list ,Please try again");
                        }
                        break;
                    case 7:
                        //Delete a Project

                        // calling method that saves all ongoing projects to an array list
                        ongoingProjects = context.getOngoingProjects();
                        System.out.println("ONGOING PROJECT SUMMARY:");

                        //iterate through array list and display to screen(partial information )
                        if (ongoingProjects.size() != 0){
                            for (Project temp : ongoingProjects) {
                                System.out.println(temp.displaySummary());
                            }
                        } else {
                            System.out.println("empty");
                        }

                        //request user to select project number to Delete
                        System.out.println("\nEnter the Project Number to Delete");
                        int projectNumberToDelete = scanner.nextInt();

                        //checking if user selected from only the available summery list
                        ongoingProjectIDs = context.getOngoingProjectIDs();
                        if (ongoingProjectIDs.contains(projectNumberToDelete)) {
                        context.deleteProject(projectNumberToDelete);
                            System.out.println("Project is now Deleted");
                        }else {
                            //display appropriate message for incorrect user selection
                            System.out.println("You have not chosen from the above available list ,Please try again");
                        }
                        break;

                    case 8:
                        //Finalize - Display Invoice

                        // calling method that saves all ongoing projects to an array list
                        ongoingProjects = context.getOngoingProjects();
                        System.out.println("ONGOING PROJECT SUMMARY:");

                        //iterate through array list and display to screen(partial information )
                        if (ongoingProjects.size() != 0){
                            for (Project temp : ongoingProjects) {
                                System.out.println(temp.displaySummary());
                            }
                        } else {
                            System.out.println("empty");
                        }
                        //request user to select project number to Finalize
                        System.out.println("\nEnter the Project Number to to Finalize");
                        int projectToFinalize = scanner.nextInt();

                        //checking if user selected from only the available summery list
                        ongoingProjectIDs = context.getOngoingProjectIDs();
                        if (ongoingProjectIDs.contains(projectToFinalize)) {

                            //accept users input , completed date and update new info to the database
                            System.out.println("Please Enter completed date");
                            LocalDate completedDate = PoisedUtilities.assignDate();
                            context.finalizeProject(projectToFinalize,completedDate);

                            //calling method that retrieves the user selected projects and extracts amounts
                            Project finalizedProject = context.getProject(projectToFinalize);
                            double cost = finalizedProject.getProjectCostAmount();
                            double paid = finalizedProject.getProjectPaidAmount();

                            //checks amount owing and displays Client invoice information
                            double amountDue = 0;
                            if (cost > paid){amountDue = cost - paid;}
                            System.out.println("Client Invoice");
                            System.out.println("Customer Info:");
                            System.out.println(finalizedProject.getProjectCustomer());
                            System.out.println("Amount Due : "+amountDue);

                        }else {
                            //display appropriate message for incorrect user selection
                            System.out.println("You have not chosen from the above available list ,Please try again");
                        }
                        break;

                    case 9:
                        //View Completed Projects - Number & Names only

                        // calling method that saves all ongoing projects to an array list
                        completedProjects = context.getCompletedProjects();
                        System.out.println("COMPLETED PROJECT SUMMARY:");

                        //iterate through array list and display to screen(partial information )
                        if (completedProjects.size() != 0){
                            for (Project temp : completedProjects) {
                                System.out.println(temp.displaySummary());
                            }
                        } else {
                            System.out.println("empty");
                        }
                        break;

                    case 10:
                        //View Completed Projects with details

                        // calling method that saves all ongoing projects to an array list
                        completedProjects = context.getCompletedProjects();
                        System.out.println("COMPLETED PROJECT DETAILS:");

                        //iterate through array list and display to screen
                        if (completedProjects.size() != 0){
                            for (Project temp : completedProjects) {
                                System.out.println(temp.displayDetails());
                            }
                        } else {
                            System.out.println("empty");
                        }
                        break;
                    case 0:
                        //This option exits the program
                        scannerMenu.close();
                        System.exit(0);
                        System.out.println("Program is closed");
                    default:
                        // Should a user enter an incorrect option, the following message is displayed
                        // allowing user to make a correct chose
                        System.out.println("This is not a valid option \nPlease choose another ");
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid entry , Please try again ");
            }
        }
    }
}