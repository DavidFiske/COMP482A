/**
 *             Assignment3, COMP482
 * Class:      Settings.java
 * Purpose:    Settings variables for ABC Therapy client management software.
 *
 * @author:    David Fiske
 * Date:       July 1, 2019
 * Version     1.0
 */
package comp482a;

import java.io.*;

/**
 * The Settings class implements serializable, which is important for sending the 
 * array data between the program and the data files.
 * 
 * Based on: 
 * 
 * Jurrius, J. [Johan Jurrius] (2017, September 18). 
 * Java GUI in Netbeans [Video file]. 
 * Retrieved June 19, 2019, from https://www.youtube.com/watch?v=GZ9MT2myBf8
 */
public class Settings implements Serializable {
    private String databaseClients;
    private String databaseStaff;

    // Constructor for Settings
    public Settings(String databaseClients, String databaseStaff) {
        this.databaseClients = databaseClients;
        this.databaseStaff = databaseStaff;
    }

    // Getter for databaseClients
    public String getDatabaseClients() {
        return databaseClients;
    }

    // Setter for databaseClients
    public void setDatabaseClients(String databaseClients) {
        this.databaseClients = databaseClients;
    }

    // Getter for databaseStaff
    public String getDatabaseStaff() {
        return databaseStaff;
    }

    // Setter for databaseStaff
    public void setDatabaseStaff(String databaseStaff) {
        this.databaseStaff = databaseStaff;
    }
}
