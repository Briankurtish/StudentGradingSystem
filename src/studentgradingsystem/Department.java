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
public class Department implements Serializable{
    
    private int dept_id;
    private String dept_name;

    public Department(int dept_id, String dept_name) {
        this.dept_id = dept_id;
        this.dept_name = dept_name;
    }
    
    
    
}
