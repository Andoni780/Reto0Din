/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author andoni
 */
public class User {

    private String dni;
    private String nombre;
    private String apellido;
    private String gmail;

    public User(String nombre, String apellido, String email, String dni) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.gmail = email;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return gmail;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.gmail = email;
    }

}
