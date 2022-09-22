
package appcrud;
import java.util.Scanner;


public class Profesor extends Persona {
    
    private String colegiado;
   

    public Profesor(String  colegiado, String nombre, String apellido, String edad) {
        super(nombre, apellido, edad);
        this.colegiado = colegiado;
    }

    public String getcolegiado() {
        return colegiado;
    }

    public void setcolegiado(String colegiado) {
        this.colegiado = colegiado;
    }
    
     
  public static String[]  solicitaDatos( int indexFree){
        Scanner opcion = new Scanner (System.in);
        System.out.println("Nombre:");  
        String nombre  = opcion.nextLine();
        System.out.println("Apellido:");
        String apellido  = opcion.nextLine();
        System.out.println("Edad:");
        String edad  =  opcion.nextLine();
        System.out.println("No. colegiado:");
        String colegiado  = opcion.nextLine();

        
        String[] retorna = new String[4];
        retorna[0] = colegiado;
        retorna[1] = nombre;
        retorna[2] = apellido;
        retorna[3] = edad;

        return retorna;

    
    
    
      
  }       
    
    public String retornarDatos () {
        return " Perfil: Catedratico     => "
                + " Nombre: " + nombre + ";"
                + " Apellido: " + apellido 
                + "; Edad: " + edad +
                "; Colegiado: "+ colegiado;
    }
    
    
}

