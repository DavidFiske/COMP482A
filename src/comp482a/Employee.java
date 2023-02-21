/**
 *             Assignment3, COMP482
 * Class:      Client.java
 * Purpose:    Employee variables for ABC Therapy client management software.
 *
 * @author:    David Fiske
 * Date:       July 1, 2019
 * Version     1.0
 */
package comp482a;

import java.io.*;

/**
 * The Employee class implements serializable, which is important for sending the 
 * array data between the program and the data files.
 * 
 * Based on: 
 * 
 * Jurrius, J. [Johan Jurrius] (2017, September 18). 
 * Java GUI in Netbeans [Video file]. 
 * Retrieved June 19, 2019, from https://www.youtube.com/watch?v=GZ9MT2myBf8
 */
public class Employee implements Serializable {
    private String firstName;
    private String lastName;
    private String roleText;
    private int roleIndex;
    private String statusText;
    private int statusIndex;
    private String primaryPhone;
    private String secondaryPhone;
    private String streetAddress;
    private String city;
    private String postalCode;
    private String email;
    private String username;
    private String password;
    private String notes;

    // Constructor for Employee
    public Employee(String firstName, String lastName, String roleText, int roleIndex, String statusText, int statusIndex, String primaryPhone, String secondaryPhone, String streetAddress, String city, String postalCode, String email, String username, String password, String notes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.roleText = roleText;
        this.roleIndex = roleIndex;
        this.statusText = statusText;
        this.statusIndex = statusIndex;
        this.primaryPhone = primaryPhone;
        this.secondaryPhone = secondaryPhone;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postalCode = postalCode;
        this.email = email;
        this.username = username;
        this.password = password;
        this.notes = notes;
    }

    // Getter for firstName
    public String getFirstName() {
        return firstName;
    }

    //Setter for firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter for lastName
    public String getLastName() {
        return lastName;
    }

    //Setter for lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter for roleText
    public String getRoleText() {
        return roleText;
    }

    //Setter for roleText
    public void setRoleText(String roleText) {
        this.roleText = roleText;
    }

    // Getter for roleIndex
    public int getRoleIndex() {
        return roleIndex;
    }

    //Setter for roleIndex
    public void setRoleIndex(int roleIndex) {
        this.roleIndex = roleIndex;
    }

    // Getter for statusText
    public String getStatusText() {
        return statusText;
    }

    //Setter for statusText
    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    // Getter for statusIndex
    public int getStatusIndex() {
        return statusIndex;
    }

    //Setter for statusIndex
    public void setStatusIndex(int statusIndex) {
        this.statusIndex = statusIndex;
    }

    // Getter for primaryPhone
    public String getPrimaryPhone() {
        return primaryPhone;
    }

    //Setter for primaryPhone
    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    // Getter for secondaryPhone
    public String getSecondaryPhone() {
        return secondaryPhone;
    }

    //Setter for secondaryPhone
    public void setSecondaryPhone(String secondaryPhone) {
        this.secondaryPhone = secondaryPhone;
    }

    // Getter for streetAddress
    public String getStreetAddress() {
        return streetAddress;
    }

    //Setter for streetAddress
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    // Getter for city
    public String getCity() {
        return city;
    }

    //Setter for city
    public void setCity(String city) {
        this.city = city;
    }

    // Getter for postalCode
    public String getPostalCode() {
        return postalCode;
    }

    //Setter for postalCode
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    //Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    //Setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    //Setter for password
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter for notes
    public String getNotes() {
        return notes;
    }

    //Setter for notes
    public void setNotes(String notes) {
        this.notes = notes;
    }  
}


