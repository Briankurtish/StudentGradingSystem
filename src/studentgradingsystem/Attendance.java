/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentgradingsystem;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Cipher
 */
public class Attendance implements Serializable{
    private int att_id;
    private int std_id;
    private int crs_id;
    private Date att_date;

    public Attendance(int att_id, int std_id, int crs_id, Date att_date) {
        this.att_id = att_id;
        this.std_id = std_id;
        this.crs_id = crs_id;
        this.att_date = att_date;
    }
    
    
}
