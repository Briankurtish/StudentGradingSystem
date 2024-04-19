
package studentgradingsystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Cem Yagli
 */
public class StudentGradingSystem {
  public static List students, grades, departments, courses, attendance;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        students = new ArrayList();
        grades = new ArrayList();
        departments = new ArrayList();
        courses = new ArrayList();
        attendance = new ArrayList();

        test_students();
        test_Course();
        test_Department();
        test_Grades();
        
        System.out.printf("\n");
    }
    
    public static void test_Course(){
        
        try{
            System.out.printf("\n Tests for Class Course\n\n");
            System.out.printf("\n Add Course()\n\n");
            add_course(1, 1, "ITEC314", "Multi Platform Programming");           
            add_course(2, 1, "ITEC413", "Information Systems Security");
            add_course(3, 2, "ECON101", "Introduction to Economics");
            add_course(4, 3, "BUSS103", "Fundamentals of Business Administration");
            
            System.out.printf("\n List Course()\n\n");
            list_courses();
            System.out.printf("\n Edit Course()\n\n");
            edit_course(4, 3, "BUSS104", "Fundamentals of Accounting");
            System.out.printf("\n List Course()\n\n");
            list_courses();
            backup_courses();
            
            System.out.printf("\nDelete_Course(4)\n\n");
            delete_course(4);
            
            System.out.printf("\n List Course()\n\n");
            list_courses();
            
            restore_courses();
            System.out.printf("\n List Course()\n\n");
            list_courses();
        }
        catch(IOException | ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Error");
        }
        
    }
    
    public static void test_students() {
        try {
        System.out.printf("\n Tests for Class Student\n\n");
        System.out.printf("\n Add_student()\n\n");
        add_student(1, "116229", "Ali Huseyin", "Faisal", "Male", "Turkey", "19/06/1993");
        add_student(2, "186731", "Ayse", "Kemaller", "Female", "Cyprus", "28/09/1998");
        add_student(3, "168337", "Muhammad", "Fahrad", "Male", "Iran", "30/05/1996");
        add_student(4, "189222", "Fatima", "Reshad", "Female", "Syria", "22/07/1998");
        add_student(5, "199221", "Bahar", "Tunc", "Female", "Cyprus", "27/08/2019");
        System.out.printf("\n List_student()\n\n");
        list_students();
        System.out.printf("\n Edit_student()\n\n");
        edit_student(2, "186731", "Ayse", "Kemaller", "Female", "Turkey", "28/09/1998");
        System.out.printf("\n List_student()\n\n");
        list_students();
        backup_student();
        
        System.out.printf("\n Delete_student(4)\n\n");
        delete_student(4);
        
        System.out.printf("\n List_student()\n\n");
        list_students();
        
        retrieve_student();
        System.out.printf("\n List_student()\n\n");
        list_students();
        }
        catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error");
                }
    }
    
    
    public static void test_Department(){
        
        try{
            System.out.printf("\n Tests for Class Department\n\n");
            System.out.printf("\n Add Department()\n\n");
            add_department(1, "Information Technology");           
            add_department(2,"Economics");
            add_department(3, "Business");
            
            
            System.out.printf("\n List All Departments()\n\n");
            list_all_departments();
            System.out.printf("\n Edit Department()\n\n");
            edit_department(3, "Accountancy");
            System.out.printf("\n List All Departments()\n\n");
            list_all_departments();
            backup_departments();
            
            System.out.printf("\nDelete_departments(3)\n\n");
            delete_department(3);
            
            System.out.printf("\n List All Departments()\n\n");
            list_all_departments();
            
            restore_departments();
            System.out.printf("\n List All Departments()\n\n");
            list_all_departments();
        }
        catch(IOException | ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Error");
        }
        
    }
    
    public static void test_Grades(){
        
        try{
            System.out.printf("\n\n Tests for Class Grades\n\n");
            System.out.printf("\n Add Grade()\n\n");
            add_grade(1,1,1,90f,88f,96f,"A");           
            add_grade(2,2,1,80f,85f,82f,"B+"); 
            add_grade(3,3,2,75f,80f,77f,"B-"); 
            add_grade(4,4,2,69f,75f,66f,"C+"); 
            add_grade(5,5,1,88f,80f,82f,"A-"); 
            
            
            System.out.printf("\n List All Grades()\n\n");
            list_all_grades();
            System.out.printf("\n Edit Grade()\n\n");
            edit_grade(4,4,2,70f,75f,80f,"B-");
            System.out.printf("\n List All Grades()\n\n");
            list_all_grades();
            backup_grades();
            
            System.out.printf("\nDelete_Grades(4)\n\n");
            delete_grade(4);
            
            System.out.printf("\n List All Grades()\n\n");
            list_all_grades();
            
            restore_grades();
            System.out.printf("\n List All Grades()\n\n");
            list_all_grades();
        }
        catch(IOException | ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Error");
        }
        
    }
    
    
    
    public static void retrieve_student() throws IOException, ClassNotFoundException
    {
     File infile  = new File("students.dat");
     FileInputStream infilestream = new FileInputStream(infile);
     ObjectInputStream inObjectStream = new ObjectInputStream(infilestream);
     students = (ArrayList)inObjectStream.readObject();
     
     inObjectStream.close();
     
    }
    public static void backup_student() throws IOException
    {
     File outfile  = new File("students.dat");
     FileOutputStream outfilestream = new FileOutputStream(outfile);
     ObjectOutputStream outObjectStream = new ObjectOutputStream(outfilestream);
     
     outObjectStream.writeObject(students);
     outObjectStream.close();
     
    }
    
    public static void add_student(int std_id, String std_no, String std_name, String std_surname,
            String gender, String nationality, String birthday) {
            Student st =new Student(std_id, std_no, std_name, std_surname,
                                    gender, nationality, birthday);
            students.add(st);
    }
    
      public static void edit_student(int std_id, String std_no, String std_name, 
                               String std_surname, String gender, 
                               String nationality, String birthday) {
      Student st=null;
      Boolean found=false;
      Iterator <Student> itr = students.iterator();
      while (itr.hasNext()) {
          st = itr.next(); 
          if(std_id==st.getStd_id()) {
              found=true;
              break;
          }
      }
      if (found) {
          st.setStd_no(std_no);
          st.setStd_name(std_name);
          st.setStd_surname(std_surname);
          st.setNationality(nationality);
          st.setGender(gender);
          st.setBirthday(birthday);
      }
      }

public static void delete_student(int std_id) {
      Student st=null;
      Boolean found=false;
      Iterator <Student> itr = students.iterator();
      while (itr.hasNext()) {
          st = itr.next(); 
          if(std_id==(st.getStd_id())) {
              found=true;
              break;
          }
      }
      if (found) students.remove(st);
      }
    
    public static void draw_line(int num) {
        String ln="";
        for (int i=0; i<num; i++) ln+="=";
        System.out.printf("\n"+ln);
    }
    
    public static void list_students() {
      Student st;
      Iterator <Student> itr = students.iterator();
      System.out.printf("\n%2s %10s %15s %15s %10s %12s %12s",
              "Id", "Student No","Std. Name", "Std. Surname", 
              "Gender","Nationality", "Birthday");
        draw_line(79);
        
      while (itr.hasNext()) {
          st = itr.next(); 
          System.out.printf("\n%2d %10s %15s %15s %10s %12s %12s", 
              st.getStd_id(), st.getStd_no(), 
              st.getStd_name(), st.getStd_surname(),
              st.getGender(), st.getNationality(), st.getBirthday());
      }
      draw_line(79);
        
    }
    
    
    public static void restore_courses() throws IOException, ClassNotFoundException{
        File inFile = new File("courses.dat");
        FileInputStream infileStream = new FileInputStream(inFile);
        ObjectInputStream inObjectstream = new ObjectInputStream(infileStream);
        courses = (ArrayList)inObjectstream.readObject();
        
        inObjectstream.close();
    }
    
    public static void backup_courses() throws IOException {
        File outFile = new File("courses.dat");
        FileOutputStream outfileStream = new FileOutputStream(outFile);
        ObjectOutputStream outObjectStream = new ObjectOutputStream(outfileStream);
        
        outObjectStream.writeObject(courses);
        outObjectStream.close();
    }
    
    public static void add_course(int id, int dept_id, String crs_code, String crs_name){
        Course crs = new Course(id, dept_id, crs_code, crs_name);
        
        courses.add(crs);
    }
    
    public static void edit_course(int id, int dept_id, String crs_code, String crs_name){
        
        Course crs = null;
        Boolean found = false;
        Iterator <Course> itr = courses.iterator();
        
        while(itr.hasNext()) {
            crs = itr.next();
            if(id == crs.getCrs_id()) {
                found = true;
                break;
            }
        }
        
        if(found) {
            crs.setCrs_code(crs_code);
            crs.setCrs_id(id);
            crs.setDept_id(dept_id);
            crs.setCrs_name(crs_name);
        }
    }
    
    public static void delete_course(int id){
        Course crs = null;
        Boolean found = false;
        Iterator <Course> itr = courses.iterator();
        
        while(itr.hasNext()){
            crs = itr.next();
            if(id == crs.getCrs_id()){
                found = true;
                break;
            }
        }
        
        if(found) courses.remove(crs);
    }
    
    public static void list_courses() {
        Course crs;
        Iterator <Course> itr = courses.iterator();
        System.out.printf("\n%2s %10s %15s %20s", "Id", "Dept_ID", "Crs_Code", "Crs_Name");
        draw_line(79);
        
        while(itr.hasNext()){
            crs = itr.next();
            System.out.printf("\n%2s %10s %14s %35s", crs.getCrs_id(), crs.getDept_id(), crs.getCrs_code(), crs.getCrs_name());
        }
        draw_line(79);
    }
    
    
    
    public static void restore_departments() throws IOException, ClassNotFoundException{
        File inFile = new File("departments.dat");
        FileInputStream infileStream = new FileInputStream(inFile);
        ObjectInputStream inObjectstream = new ObjectInputStream(infileStream);
        departments = (ArrayList)inObjectstream.readObject();
        
        inObjectstream.close();
    }
    
    public static void backup_departments() throws IOException {
        File outFile = new File("departments.dat");
        FileOutputStream outfileStream = new FileOutputStream(outFile);
        ObjectOutputStream outObjectStream = new ObjectOutputStream(outfileStream);
        
        outObjectStream.writeObject(departments);
        outObjectStream.close();
    }
    
    
    public static void add_department(int id, String dept_name){
        Department dept = new Department(id, dept_name);
        
        departments.add(dept);
    }
    
    
    public static void edit_department(int id, String dept_name){
        
        Department dept = null;
        Boolean found = false;
        Iterator <Department> itr = departments.iterator();
        
        while(itr.hasNext()) {
            dept = itr.next();
            if(id == dept.getDept_id()) {
                found = true;
                break;
            }
        }
        
        if(found) {
            dept.setDept_id(id);
            dept.setDept_name(dept_name);
            
        }
    }
    
    
    public static void delete_department(int id){
        Department dept = null;
        Boolean found = false;
        Iterator <Department> itr = departments.iterator();
        
        while(itr.hasNext()){
            dept = itr.next();
            if(id == dept.getDept_id()){
                found = true;
                break;
            }
        }
        
        if(found) departments.remove(dept);
    }
    
    public static void list_all_departments() {
        Department dept;
        Iterator <Department> itr = departments.iterator();
        System.out.printf("\n%2s %10s", "Id", "Dept_Name");
        draw_line(30);
        
        while(itr.hasNext()){
            dept = itr.next();
            System.out.printf("\n%2s %10s", dept.getDept_id(), dept.getDept_name());
        }
        draw_line(30);
    }
    
    
    public static void restore_grades() throws IOException, ClassNotFoundException{
        File inFile = new File("Grades.dat");
        FileInputStream infileStream = new FileInputStream(inFile);
        ObjectInputStream inObjectstream = new ObjectInputStream(infileStream);
        grades = (ArrayList)inObjectstream.readObject();
        
        inObjectstream.close();
    }
    
    
    public static void backup_grades() throws IOException {
        File outFile = new File("Grades.dat");
        FileOutputStream outfileStream = new FileOutputStream(outFile);
        ObjectOutputStream outObjectStream = new ObjectOutputStream(outfileStream);
        
        outObjectStream.writeObject(grades);
        outObjectStream.close();
    }
    
    public static void add_grade(int id, int std_id, int crs_id,  float grd_mt, float grd_hw, float grd_final, String grd_Igrade){
        Grades grd = new Grades(id, std_id, crs_id, grd_mt, grd_hw, grd_final, grd_Igrade);
        
        grades.add(grd);
    }
    
    public static void edit_grade(int id, int std_id, int crs_id,  float grd_mt, float grd_hw, float grd_final, String grd_Igrade){
        
        Grades grd = null;
        Boolean found = false;
        Iterator <Grades> itr = grades.iterator();
        
        while(itr.hasNext()) {
            grd = itr.next();
            if(id == grd.getGrd_id()) {
                found = true;
                break;
            }
        }
        
        if(found) {
            grd.setGrd_id(id);
            grd.setStd_id(std_id);
            grd.setCrs_id(crs_id);
            grd.setGrd_mt(grd_mt);
            grd.setGrd_hw(grd_hw);
            grd.setGrd_final(grd_final);
            grd.setGrd_Igrade(grd_Igrade);
        }
    }
    
    public static void delete_grade(int id){
        Grades grd = null;
        Boolean found = false;
        Iterator <Grades> itr = grades.iterator();
        
        while(itr.hasNext()){
            grd = itr.next();
            if(id == grd.getGrd_id()){
                found = true;
                break;
            }
        }
        
        if(found) grades.remove(grd);
    }
    
    
    public static void list_all_grades() {
        Grades grd;
        Iterator <Grades> itr = grades.iterator();
        System.out.printf("\n%2s %5s %5s %10s %10s %10s %15s ", "Id", "Std_ID", "Crs_ID", "Grd_MT", "Grd_HW", "Grd_FIN", "Grd_IGrade");
        draw_line(79);
        
        while(itr.hasNext()){
            grd = itr.next();
            System.out.printf("\n%2s %5s %5s %10s %10s %10s %12s", grd.getGrd_id(), grd.getStd_id(), grd.getCrs_id(), grd.getGrd_mt(), grd.getGrd_hw(), grd.getGrd_final(), grd.getGrd_Igrade());
        }
        draw_line(79);
    }
    
    
    
    public static void restore_attendances() throws IOException, ClassNotFoundException{
        File inFile = new File("Attendances.dat");
        FileInputStream infileStream = new FileInputStream(inFile);
        ObjectInputStream inObjectstream = new ObjectInputStream(infileStream);
        attendance = (ArrayList)inObjectstream.readObject();
        
        inObjectstream.close();
    }
    
    public static void backup_attendances() throws IOException {
        File outFile = new File("Attendances.dat");
        FileOutputStream outfileStream = new FileOutputStream(outFile);
        ObjectOutputStream outObjectStream = new ObjectOutputStream(outfileStream);
        
        outObjectStream.writeObject(attendance);
        outObjectStream.close();
    }
    
    
    public static void add_attendance(int id, int std_id, int crs_id, Date att_date){
        Attendance att = new Attendance(id, std_id, crs_id, att_date);
        
        attendance.add(att);
    }
    
    
    public static void edit_attendance(int id, int std_id, int crs_id, Date att_date){
        
        Attendance att = null;
        Boolean found = false;
        Iterator <Attendance> itr = attendance.iterator();
        
        while(itr.hasNext()) {
            att = itr.next();
            if(id == att.getAtt_id()) {
                found = true;
                break;
            }
        }
        
        if(found) {
            att.setAtt_id(id);
            att.setStd_id(std_id);
            att.setCrs_id(crs_id);
            att.setAtt_date(att_date);
        }
    }
    
    
    public static void delete_attendance(int id){
        Attendance att = null;
        Boolean found = false;
        Iterator <Attendance> itr = attendance.iterator();
        
        while(itr.hasNext()){
            att = itr.next();
            if(id == att.getAtt_id()){
                found = true;
                break;
            }
        }
        
        if(found) attendance.remove(att);
    }
    
    
    
    public static void list_all_attendances() {
        Attendance att;
        Iterator <Attendance> itr = attendance.iterator();
        System.out.printf("\n%2s %10s %15s %20s", "Id", "Std_ID", "Crs_ID", "Att_Date");
        draw_line(79);
        
        while(itr.hasNext()){
            att = itr.next();
            System.out.printf("\n%2s %10s %14s %35s", att.getAtt_id(), att.getStd_id(), att.getCrs_id(), att.getAtt_date());
        }
        draw_line(79);
    }
    
    
}
