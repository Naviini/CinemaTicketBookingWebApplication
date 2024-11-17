/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nv.javaproject.mtb.user.models;

import nv.javaproject.mtb.admin.models.Person;

public class User extends Person{
    private int id;
//    private String name;
    private String email;
    private String password;
    private String tel_no;
//defult method
    public User() {}
    
//    public User(String name, String gender, String dob, String tel_no) {
//        super (name, gender, dob, tel_no); 
//    }
//method
    public User(int id, String email, String password, String tel_no, String name, String gender, String dob) {
        super(name, gender, dob);
        this.id = id;
        this.email = email;
        this.password = password;
        this.tel_no = tel_no;
    }

    public User(String email, String password, String tel_no, String name, String gender, String dob) {
        super(name, gender, dob);
        this.email = email;
        this.password = password;
        this.tel_no = tel_no;
    }
//getters n setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel_no() {
        return tel_no;
    }

    public void setTel_no(String tel_no) {
        this.tel_no = tel_no;
    }
//toString method
//    @Override
//    public String toString() {
//        return "User{" + "id=" + id + ", email=" + email + ", password=" + password + ", tel_no=" + tel_no + '}';
//    }
//    
}
