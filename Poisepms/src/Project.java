import java.time.LocalDate;

/**
 * Class for creating Project objects
 */

public class Project {
    // Assigning class Attributes of various essential construction (project) characteristic
    protected Integer projectNumber;
    private String projectName;
    private String projectType;
    private String projectAddress;
    private final String projectErfNumber;
    private double projectCostAmount;
    private double projectPaidAmount;
    private LocalDate projectDeadline;
    private LocalDate projectCompletedDate;
    private String projectFinalized;

    // assigning (Person) object for use
    private Person projectCustomer;
    private Person projectArchitect;
    private Person projectContractor;
    private Person projectEngineer;
    private Person projectManager;


    // Constructor method , to pass through variables needed to flesh out and create the class object
    public Project(Integer projectNumber, String projectName, String projectType, String projectAddress,
                   String projectErfNumber, double projectCostAmount, double projectPaidAmount,
                   LocalDate projectDeadlineDate, String projectFinalized, LocalDate projectCompletedDate, Person projectCustomer,
                   Person projectArchitect, Person projectContractor, Person projectEngineer, Person projectManager){
        this.projectNumber = projectNumber;
        this.projectName = projectName;
        this.projectType = projectType;
        this.projectAddress = projectAddress;
        this.projectErfNumber = projectErfNumber;
        this.projectCostAmount = projectCostAmount;
        this.projectPaidAmount = projectPaidAmount;
        this.projectDeadline = projectDeadlineDate;
        this.projectCompletedDate = projectCompletedDate;
        this.projectFinalized = projectFinalized;
        this.projectCustomer = projectCustomer;
        this.projectArchitect = projectArchitect;
        this.projectContractor = projectContractor;
        this.projectEngineer = projectEngineer;
        this.projectManager = projectManager;
    }

    // Providing Getter methods for each encapsulated Attribute
    public String getProjectName(){
        return projectName;
    }
    public String getProjectType(){
        return projectType;
    }
    public String getProjectAddress(){
        return projectAddress;
    }
    public String getProjectErfNumber(){
        return projectErfNumber;
    }
    public double getProjectCostAmount(){
        return projectCostAmount;
    }
    public double getProjectPaidAmount(){
        return projectPaidAmount;
    }
    public LocalDate getProjectDeadline(){
        return projectDeadline;
    }
    public LocalDate getProjectCompletedDate() {
        return projectCompletedDate;
    }
    public String getProjectFinalized() {
        return projectFinalized;
    }
    public Person getProjectCustomer() {
        return projectCustomer;
    }

    //Methods
    /**
     *Displays Information on screen
     * @return Displays to screen the stored Project object values (Full Details)
     */
    public String displayDetails(){

        return "FULL PROJECT DETAILS:"
                + "\n___________________________________________________________"
                + "\nProject Number :" + projectNumber
                + "\nProject Name :" + projectName
                + "\nProject Type :" + projectType
                + "\nProject Address :" + projectAddress
                + "\nProject ERF Number :" + projectErfNumber
                + "\nProject Cost :" + projectCostAmount
                + "\nProject Paid Amount :" + projectPaidAmount
                + "\nProject Deadline: " + projectDeadline
                + "\nProject Finalized :" + projectFinalized
                + "\n"
                + "\nCustomer Details: " + projectCustomer.toString() + "\n"
                + "\nArchitect Details: " + projectArchitect.toString() + "\n"
                + "\nContractor Details: " + projectContractor.toString() + "\n"
                + "\nStructural Engineer Details: " + projectEngineer.toString() + "\n"
                + "\nProject Manager Details: " + projectManager.toString() + "\n"
                + "\n___________________________________________________________";
    }

    /**
     * Displays Information on screen
     * @return Displays to screen the stored Project object values (Summary Details)
     */
    public String displaySummary(){
        return "___________________________________________________________"
                + "\nProject Number :" + projectNumber
                + "\nProject Name :" + projectName;
    }
}
