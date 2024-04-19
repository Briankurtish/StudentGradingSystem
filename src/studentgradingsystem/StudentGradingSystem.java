
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
        
        System.out.printf("\n");
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
        System.out.printf("\n%2s %5s %5s %15s", "Id", "Dept_ID", "Course_Code", "Course_Name");
        draw_line(79);
        
        while(itr.hasNext()){
            crs = itr.next();
            System.out.printf("\n%2s %5s %5s %15s", crs.getCrs_id(), crs.getDept_id(), crs.getCrs_code(), crs.getCrs_name());
        }
        draw_line(79);
    }
    
    
    
}
