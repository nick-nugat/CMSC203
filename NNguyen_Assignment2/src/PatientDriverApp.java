/*
 * Class: CMSC203
 * Instructor: Professor Monshi
 * Description: PatientDriverApp.java is a class that creates a Patient object and three Procedure objects. It also contains the main
 * method, responsible for the program's execution.
 * Due: 2023-09-27
 * Platform/compiler: javac
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Nicholas Nguyen
*/
public class PatientDriverApp {
    //main method
    public static void main(String[] args){
        //sample patient
        Patient sampPatient = new Patient("Timothy", "K.", "Wang", "123 Sample Street", "Williamsburg", "Virginia","20874", "John Green", "301-532-6273");
        
        //procedures
        Procedure procedure1 = new Procedure();
        Procedure procedure2 = new Procedure("Physical Therapy - work on lower body", "2024-01-05");
        Procedure procedure3 = new Procedure("Psychiatrist - discuss new meds", "2023-10-06", "Dr. Nguyen", 100);

        //displaying info
        System.out.println("Patient Info: ");
        System.out.println(displayPatient(sampPatient));
        System.out.println(displayProcedure(procedure1));
        System.out.println(displayProcedure(procedure2));
        System.out.println(displayProcedure(procedure3));

        System.out.println("Total charges: $" + calculateTotalCharges(procedure1, procedure2, procedure3));

        System.out.println("\nStudent Name: Nicholas Nguyen");
        System.out.println("MC#: M21131583");
        System.out.println("Due Date: 2023-09-25");
    } //end main

    /**
     * Displays the information of a patient.
     *
     * @param pat The Patient object whose information needs to be displayed.
     * @return A string representing the patient information.
     */
    public static String displayPatient(Patient pat) { return pat.toString(); }


    /**
     * Displays the information of a procedure.
     *
     * @param pro The Procedure object whose information needs to be displayed.
     * @return A string representing the procedure information.
     */
    public static String displayProcedure(Procedure pro) { return pro.toString(); }


    /**
     * Calculates the total charges for the given procedures.
     *
     * @param pro1 The first Procedure object.
     * @param pro2 The second Procedure object.
     * @param pro3 The third Procedure object.
     * @return The total charges for the procedures.
     */
    public static int calculateTotalCharges(Procedure pro1, Procedure pro2, Procedure pro3) {
       return pro1.getCharges() + pro2.getCharges() + pro3.getCharges();
   } 
}


