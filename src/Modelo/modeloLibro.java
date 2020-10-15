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
public class modeloLibro {
    private int id;
    private String genero;
    private int fecha;
    private String nombre;
    private int paginas;
    private String contenido;
    private String autor;

    public modeloLibro(int id, String genero, int fecha, String nombre, int paginas,String contenido, String autor) {
        this.id = id;
        this.genero = genero;
        this.fecha = fecha;
        this.nombre = nombre;
        this.paginas = paginas;
        this.contenido = contenido;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    
    
    
}
