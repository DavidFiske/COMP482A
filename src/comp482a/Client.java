/**
 *             Assignment3, COMP482
 * Class:      Client.java
 * Purpose:    Client variables for ABC Therapy client management software.
 *
 * @author:    David Fiske
 * Date:       July 1, 2019
 * Version     1.0
 */
package comp482a;

import java.io.*;

/**
 * The Client class implements serializable, which is important for sending the 
 * array data between the program and the data files.
 * 
 * Based on: 
 * 
 * Jurrius, J. [Johan Jurrius] (2017, September 18). 
 * Java GUI in Netbeans [Video file]. 
 * Retrieved June 19, 2019, from https://www.youtube.com/watch?v=GZ9MT2myBf8
 */
public class Client implements Serializable {
    private String firstName;
    private String lastName;
    private String dob;
    private String statusText;
    private int statusIndex;
    private String primaryPhone;
    private String secondaryPhone;
    private String streetAddress;
    private String city;
    private String postalCode;
    private String email;
    private String therapistText;
    private int therapistIndex;
    private String nextAppointmentText;
    private int nextAppointmentIndex;
    private String notes;

    // Constructor for Client
    public Client(String firstName, String lastName, String dob, String statusText, int statusIndex, String primaryPhone, String secondaryPhone, String streetAddress, String city, String postalCode, String email, String therapistText, int therapistIndex, String nextAppointmentText, int nextAppointmentIndex, String notes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.statusText = statusText;
        this.statusIndex = statusIndex;
        this.primaryPhone = primaryPhone;
        this.secondaryPhone = secondaryPhone;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postalCode = postalCode;
        this.email = email;
        this.therapistText = therapistText;
        this.therapistIndex = therapistIndex;
        this.nextAppointmentText = nextAppointmentText;
        this.nextAppointmentIndex = nextAppointmentIndex;
        this.notes = notes;
    }

    // Getter for firstName
    public String getFirstName() {
        return firstName;
    }

    // Setter for firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter for lastName
    public String getLastName() {
        return lastName;
    }

    // Setter for lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter for dob
    public String getDob() {
        return dob;
    }

    // Setter for dob
    public void setDob(String dob) {
        this.dob = dob;
    }

    // Getter for statusText
    public String getStatusText() {
        return statusText;
    }

    // Setter for statusText
    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    // Getter for statusIndex
    public int getStatusIndex() {
        return statusIndex;
    }

    // Setter for statusIndex
    public void setStatusIndex(int statusIndex) {
        this.statusIndex = statusIndex;
    }

    // Getter for primaryPhone
    public String getPrimaryPhone() {
        return primaryPhone;
    }

    // Setter for primaryPhone
    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    // Getter for secondaryPhone
    public String getSecondaryPhone() {
        return secondaryPhone;
    }

    // Setter for secondaryPhone
    public void setSecondaryPhone(String secondaryPhone) {
        this.secondaryPhone = secondaryPhone;
    }

    // Getter for streetAddress
    public String getStreetAddress() {
        return streetAddress;
    }

    // Setter for streetAddress
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    // Getter for city
    public String getCity() {
        return city;
    }

    // Setter for city
    public void setCity(String city) {
        this.city = city;
    }

    // Getter for postalCode
    public String getPostalCode() {
        return postalCode;
    }

    // Setter for postalCode
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for therapistText
    public String getTherapistText() {
        return therapistText;
    }

    // Setter for therapistText
    public void setTherapistText(String therapistText) {
        this.therapistText = therapistText;
    }

    // Getter for therapistIndex
    public int getTherapistIndex() {
        return therapistIndex;
    }

    // Setter for therapistIndex
    public void setTherapistIndex(int therapistIndex) {
        this.therapistIndex = therapistIndex;
    }

    // Getter for nextAppointmentText
    public String getNextAppointmentText() {
        return nextAppointmentText;
    }

    // Setter for nextAppointmentText
    public void setNextAppointmentText(String nextAppointmentText) {
        this.nextAppointmentText = nextAppointmentText;
    }

    // Getter for nextAppointmentIndex
    public int getNextAppointmentIndex() {
        return nextAppointmentIndex;
    }

    // Setter for nextAppointmentIndex
    public void setNextAppointmentIndex(int nextAppointmentIndex) {
        this.nextAppointmentIndex = nextAppointmentIndex;
    }

    // Getter for notes
    public String getNotes() {
        return notes;
    }

    // Setter for notes
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
