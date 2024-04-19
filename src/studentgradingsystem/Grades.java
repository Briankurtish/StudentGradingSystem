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
public class Grades implements Serializable{
    private int grd_id;
    private int std_id;
    private int crs_id;
    private float grd_mt;
    private float grd_hw; 
    private float grd_final;
    private String grd_Igrade;

    public Grades(int grd_id, int std_id, int crs_id, float grd_mt, float grd_hw, float grd_final, String grd_Igrade) {
        this.grd_id = grd_id;
        this.std_id = std_id;
        this.crs_id = crs_id;
        this.grd_mt = grd_mt;
        this.grd_hw = grd_hw;
        this.grd_final = grd_final;
        this.grd_Igrade = grd_Igrade;
    }
    
    

}
