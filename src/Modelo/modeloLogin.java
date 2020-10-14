/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author ALEXIS VIDES
 */
public class modeloLogin {
    private String Nombre;
    private String Pass;
    private int Rango;
    private int Id;

    public modeloLogin(int Id, String usuario, String pass, int rol) {
        this.Id = Id;
        this.Nombre = usuario;
        this.Pass = pass;
        this.Rango = rol;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public int getRango() {
        return Rango;
    }

    public void setRango(int Rango) {
        this.Rango = Rango;
    }
}
