/*
 * Class: CMSC203
 * Instructor: Professor Monshi
 * Description: Patient.java is a blueprint of a patient with attributes for a person
 * Due: 2023-09-27
 * Platform/compiler: javac
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Nicholas Nguyen
*/

public class Patient{
        //instance variables
        private String firstName, middleName, lastName,
                       stateAddress, city, state, zipCode,
                       emergencyContactName, emergencyPhoneNumber;
        
        /**
         * Constructs a Patient object with default attribute values.
         */
        public Patient(){
            this.firstName = "John";
            this.middleName = "Green";
            this.lastName = "Mike";
            this.stateAddress = "152 Sample Street";
            this.city = "MyCity";
            this.state = "MyState";
            this.zipCode = "62164";
            this.emergencyContactName = "Gary";
            this.emergencyPhoneNumber = "521-627-9872";
        }
        
        /**
         * Constructs a Patient object with specified name attributes and default address and emergency contact.
         *
         * @param firstName First name of the patient.
         * @param middleName Middle name of the patient.
         * @param lastName Last name of the patient.
         */
        public Patient(String firstName, String middleName, String lastName){
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
            this.stateAddress = "152 Sample Street";
            this.city = "MyCity";
            this.state = "MyState";
            this.zipCode = "62164";
            this.emergencyContactName = "Gary";
            this.emergencyPhoneNumber = "521-627-9872";
        }

        /**
         * Constructs a Patient object with specified attributes.
         *
         * @param firstName First name of the patient.
         * @param middleName Middle name of the patient.
         * @param lastName Last name of the patient.
         * @param stateAddress State address of the patient.
         * @param city City of the patient.
         * @param state State of the patient.
         * @param zipCode Zip code of the patient.
         * @param emergencyContactName Emergency contact name.
         * @param emergencyPhoneNumber Emergency contact phone number.
         */
        public Patient(String firstName, String middleName, String lastName, String stateAddress, String city, String state, String zipCode, String emergencyContactName, String emergencyPhoneNumber){
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
            this.stateAddress = stateAddress;
            this.city = city;
            this.state = state;
            this.zipCode = zipCode;
            this.emergencyContactName = emergencyContactName;
            this.emergencyPhoneNumber = emergencyPhoneNumber;
        }

        //accessors
        public String getFirstName(){ return firstName; }
        
        public String getMiddleName(){ return middleName; }
        public String getLastName(){ return lastName; }
        public String getStateAddress(){ return stateAddress; }
        public String getCity(){ return city; }
        public String getState(){ return state; }
        public String getZipCode(){ return zipCode; }
        public String getContactName(){ return emergencyContactName; }
        public String getNumber(){ return emergencyPhoneNumber; }

        //mutators
        public void setFirstName(String firstName){ this.firstName = firstName; }
        public void setMiddleName(String middleName){ this.middleName = middleName; }
        public void setLastName(String lastName){ this.lastName = lastName; }
        public void setStateAddress(String stateAddress){ this.stateAddress = stateAddress; }
        public void setCity(String city){ this.city = city; }
        public void setState(String state){ this.state = state; }
        public void setZipCode(String zipCode){ this.zipCode = zipCode; }
        public void setContactName(String emergencyContactName){ this.emergencyContactName = emergencyContactName; }
        public void setNumber(String emergencyPhoneNumber){ this.emergencyPhoneNumber = emergencyPhoneNumber; }

        /**
         * Builds the full name of the patient by combining first name, middle name, and last name.
         *
         * @return The full name of the patient.
         */
        public String buildFullName(){
            return getFirstName() + " " + getMiddleName() + " " + getLastName();
        }


        /**
         * Builds the address of the patient by combining state address, city, state, and zip code.
         *
         * @return The address of the patient.
         */
        public String buildAddress(){
            return getStateAddress() + " " + getCity() + " " + getState() + " " + getZipCode();
        }

        /** 
         * Builds the emergency contact information by combining emergency contact name and phone number.
         *
         * @return The emergency contact information.
         */
        public String buildEmergencyContact(){
            return getContactName() + " " + getNumber();
        }

        /**
         * Returns a string representation of the Patient object, including name, address, and emergency contact.
         *
         * @return String representation of the Patient object.
         */
        @Override
        public String toString(){
            return "  Name: " + buildFullName() + 
                   "\n  Address: " + buildAddress() + 
                   "\n  Emergency Contact: " + buildEmergencyContact() + "\n";
        }
    }

