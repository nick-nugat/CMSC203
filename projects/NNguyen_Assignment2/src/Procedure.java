/*
 * Class: CMSC203
 * Instructor: Professor Monshi
 * Description: Procedure.java is a blueprint of a procedure with attributes of a procedure
 * Due: 2023-09-27
 * Platform/compiler: javac
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Nicholas Nguyen
*/

public class Procedure {

    //instance variables
    private String name, date, practitioner;
    int charges;

    /**
     * Constructs a Procedure object with default attribute values.
     */
    public Procedure(){
        this.name = "IV";
        this.date = "2023-09-11";
        this.practitioner = "Dr. Berry";
        this.charges = 800;
    } 
    
    /**
     * Constructs a Procedure object with specified name and date, using default values for other attributes.
     *
     * @param name The name of the procedure.
     * @param date The date of the procedure.
     */
    public Procedure(String name, String date){
        this.name = name;
        this.date = date;
        this.practitioner = "Dr. Berry";
        this.charges = 200;
    } 
    
    /**
     * Constructs a Procedure object with specified attributes.
     *
     * @param name The name of the procedure.
     * @param date The date of the procedure.
     * @param practitioner The practitioner performing the procedure.
     * @param charges The charges for the procedure.
     */
    public Procedure(String name, String date, String practitioner, int charges){
        this.name = name;
        this.date = date;
        this.practitioner = practitioner;
        this.charges = charges;
    }
    

    //accessors
    public String getPractitioner() { return practitioner; }
    public int getCharges() { return charges; }
    public String getDate() { return date; }
    public String getName() { return name; }

    //mutators
    public void setPractitioner(String practitioner) { this.practitioner = practitioner; }
    public void setCharges(int charges) { this.charges = charges; }
    public void setDate(String date) { this.date = date; }
    public void setName(String name) { this.name = name; }

    /**
     * Returns a string representation of the Procedure object, including name, date, practitioner, and charges.
     *
     * @return String representation of the Procedure object.
     */
    @Override
    public String toString(){
        return "\tProcedure: " + getName() + 
               "\n\tProcedure Date: " + getDate() + 
               "\n\tPractitioner: " + getPractitioner() + 
               "\n\tCharge: " + getCharges() + "\n";
    }
    
}
