package appcrud;
import java.util.Scanner;

public class Administrativo extends Persona{
    
     private String departamento;

    public Administrativo(String departamento, String nombre, String apellido, String edad) {
        super(nombre, apellido, edad);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
     
  public static String[]  solicitaDatos( int indexFree){
        Scanner opcion = new Scanner (System.in);
        System.out.println("Nombre:");  
        String nombre  = opcion.nextLine();
        System.out.println("Apellido:");
        String apellido  = opcion.nextLine();
        System.out.println("Edad:");
        String edad  =  (opcion.nextLine());
        System.out.println("Depto admin:");
        String depto  = opcion.nextLine();
        
        String[] retorna = new String[4];
        retorna[0] = depto;
        retorna[1] = nombre;
        retorna[2] = apellido;
        retorna[3] = edad;

        return retorna;
      
  }    
  
  
 
       public String retornarDatos () {
        return " Perfil: Administrativo  => "
                + " Nombre: " + nombre 
                + "; Apellido: " + apellido 
                + "; Edad: " + edad +
                "; Depto: "+ departamento;
    }
 
  
  
}