/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nv.javaproject.mtb.admin.models;

/**
 *
 * @author user
 */
public class MovieCategory {
    private int id;
    private String name;
    private String description;
//    create constuctor 4 propertiess
    //defult constructor
    public MovieCategory() {
    }
    //paramiterized constructors

    public MovieCategory(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public MovieCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }
//insert getters n setters 2 access properties
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
//    method 2 check the class 

    @Override
    public String toString() {
        return "MovieCategory{" + "id=" + id + ", name=" + name + ", description=" + description + '}';
    }
    
}
