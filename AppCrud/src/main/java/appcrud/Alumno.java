
package appcrud;
import java.util.Scanner;


public class Alumno extends Persona {
    
     private String carnet;

    public Alumno(String carnet, String nombre, String apellido, String edad) {
        super(nombre, apellido, edad);
        this.carnet = carnet;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }
    
    public static String[]  solicitaDatos( int indexFree){
        Scanner opcion = new Scanner (System.in);
        System.out.println("Nombre:");  
        String nombre  = opcion.nextLine();
        System.out.println("Apellido:");
        String apellido  = opcion.nextLine();
        System.out.println("Edad:");
        String edad  = opcion.nextLine();
        System.out.println("No. carnet :");
        String carnet=opcion.nextLine();

        
        String[] retorna = new String[4];
        retorna[0] = carnet;
        retorna[1] = nombre;
        retorna[2] = apellido;
        retorna[3] = edad;

        return retorna;  
     
    }
    
       public String retornarDatos () {
        return " Perfil: Alumno          => "
                + " Nombre: " + nombre + ";"
                + " Apellido: " + apellido 
                + "; Edad: " + edad +
                "; Carnet: "+ carnet;
    }
    
    
}
    

