/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nv.javaproject.mtb.admin.model;

/**
 *
 * @author user
 */
public class Person {
    private String name;
    private String gender;
    private String dob;
    
//    constructors
    //defult 
    public Person() {
    }

    public Person(String name, String gender, String dob) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
    }
//    getters n setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
      
}
