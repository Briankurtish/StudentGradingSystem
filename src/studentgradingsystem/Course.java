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
    
    public Course (int crs_id, int dept_id, String crs_code, String crs_name){
        this.crs_id = crs_id;
        this.dept_id = dept_id;
        this.crs_code = crs_code;
        this.crs_name = crs_name;
    }

    public int getCrs_id() {
        return crs_id;
    }

    public void setCrs_id(int crs_id) {
        this.crs_id = crs_id;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getCrs_code() {
        return crs_code;
    }

    public void setCrs_code(String crs_code) {
        this.crs_code = crs_code;
    }

    public String getCrs_name() {
        return crs_name;
    }

    public void setCrs_name(String crs_name) {
        this.crs_name = crs_name;
    }
    private String crs_name;
    
    

}
