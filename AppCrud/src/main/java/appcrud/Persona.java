
package appcrud;
import java.util.Scanner;


public class Persona {
    
   //Atributos
    protected String nombre;
    protected String apellido;
    protected String    edad;

    //constructor
    public Persona(String nombre, String apellido, String edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
       
    }

        //get & set
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }


    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEdad() {
        return edad;
    }

    
    public String retornarDatos () {
        return "nombre: " + nombre + "\napellido: " + apellido + "\nedad: " + edad;
    }
    
   
     public String  solicitaDatos( ){
         
     return "0";
     }
           
}


