/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentgradingsystem;

import java.io.Serializable;

/**
 *
 * @author Cipher
 */
public class Course implements Serializable {
    
    private int crs_id;
    private  int dept_id;
    private String crs_code;
    private String crs_name;
    
    public Course (int crs_id, int dept_id, String crs_code, String crs_name){
        this.crs_id = crs_id;
        this.dept_id = dept_id;
        this.crs_code = crs_code;
        this.crs_name = crs_name;
    }
    
}
