/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nv.javaproject.mtb.admin.model;

/**
 *
 * @author user
 */
public class Admin extends Person{
    private int id;
//    private String name;
    private String email;
    private String password;
    private String tel_no;
    private String role;
    
//constructor without parameters
    public Admin() {
    }
//constructor including id
    public Admin(int id, String email, String password, String tel_no, String role, String name, String gender, String dob) {
        super(name, gender, dob);
        this.id = id;
        this.email = email;
        this.password = password;
        this.tel_no = tel_no;
        this.role = role;
    }
//constructor exxcluding id
    public Admin(String email, String password, String tel_no, String role) {
        this.email = email;
        this.password = password;
        this.tel_no = tel_no;
        this.role = role;
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
}
