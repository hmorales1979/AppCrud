package appcrud;

import java.util.Scanner;

    // constante que van a estar disponibles para todas las clases
    interface globalVar{    
          static Persona arrayPersonas[] = new Persona[100]; 

    }    
   
public class AppCrud  implements globalVar{        

    // metodo para simular clear de pantalla insertando lineas en blanco
    static void limpiar( )
    {
     for (int i=0; i < 100; i++)
     {
      System.out.println();
     }
    }     
    
    //metodo para analizar si el imput de usuario es cadena o es numerico
     static boolean  analizaCadena (String str ) {

        boolean isNumeric = true;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                isNumeric = false;
            }
        }
        return (isNumeric);
    }
     
    //metodo para invocar el menu principal 
    static void menu  (){
        System.out.println();
        System.out.println();
        System.out.println("*********************************");
        System.out.println("1) Ingresar registros            ");
        System.out.println("2) Actualizar registro           ");
        System.out.println("3) Buscar registros              ");
        System.out.println("4) Borrar registros              ");
        System.out.println("5) Imprimir registros            ");
        System.out.println("6) Salir                         ");
        System.out.println("*********************************");
        System.out.println();
        System.out.print("Ingrese opcion: ");

    }
    
    // metodo para realizar el llenado del arreglo
    static void llenadoArray ( ) {
        Scanner opcion = new Scanner (System.in);
        int indexFree=0;     
        String opcionUser;
        String[] captaDatos = new String[4];  
  
                  do  {                                              
                      //for para identificar el siguiente "espacio" libre del arreglo principal  
                      // al identificar se lleva el indice disponible en la variable indexFree
                      for ( int i =0 ; i < arrayPersonas.length; i++){
             
                           if  (arrayPersonas[i] ==null){
                 
                               indexFree=i;
                                 break;
                            }
                        }
                      
                        //impresion del sub-menu para insertar registros 
                        System.out.println();
                        System.out.println();
                        System.out.println("*********************************");
                        System.out.println("1) Registrar personal Administrativo");
                        System.out.println("2) Registrar Catedraticos");
                        System.out.println("3) Registrar Alumnos");
                        System.out.println("4) Salir");
                        System.out.println("*********************************");
                        System.out.println();
                        System.out.print("Ingrese opcion: ");
                        opcionUser = opcion.next();
                        System.out.println();
                        System.out.println();
                        
                         // dependiendo el tipo de registro, utilizo la funcion "solicitaDatos
                         // de cada tipo Profesor, Alumno o Administrativo y el registro ingresado
                         // lo guardo en el arreglo principal "arrayPersonas"
                         switch(opcionUser) {
                            case "1":                                                   
                                captaDatos=Administrativo.solicitaDatos(indexFree);                      
                                arrayPersonas[indexFree]= new Administrativo(captaDatos[0], captaDatos[1], captaDatos[2], captaDatos[3]);  
                                break;    
                            case "2":  
                                captaDatos=Profesor.solicitaDatos(indexFree);                      
                                arrayPersonas[indexFree]= new Profesor(captaDatos[0], captaDatos[1], captaDatos[2], captaDatos[3]);          
                                break;    
                            case "3":                             
                                captaDatos=Alumno.solicitaDatos(indexFree);                      
                                arrayPersonas[indexFree]= new Alumno(captaDatos[0], captaDatos[1], captaDatos[2], captaDatos[3]);          
                                break;
                            case "4":  
                                break;
                            default:
                                System.out.println(" ");  
                                System.out.println("OPCION INVALIDA!");
                                System.out.println(" ");         
                         }                    
                          
                  }   while (  !"4".equals(opcionUser) );
        
                  
        
        
    }
    //metodo para buscar personas, se ingresa un nombre y un apellido
    //y el metodo va comparando con cada registro del arreglo "arrayPersonas",
    //los registros que son coincidentes los va imprimiendo en pantalla
    static void buscarArray (String nombre, String apellido) {
    
        System.out.println("******PERSONAS ENCONTRADAS POR COINCIDENCIA ******"); 
        System.out.println( " ");        
        for ( int i =0 ; i < arrayPersonas.length; i++){
            if(arrayPersonas[i] != null) {            
                String nombre_convert   = arrayPersonas[i].nombre.toLowerCase();
                String apellido_convert = arrayPersonas[i].apellido.toLowerCase();
                String name_convert     = nombre.toLowerCase();
                String lastName_convert = apellido.toLowerCase();

                if (nombre_convert.contains(name_convert)) {
                    if(apellido_convert.contains(lastName_convert)){
                        ///lista[i]=new ArrayPersona(i,nombre_convert, apellido_convert);
                        System.out.println( "Registro encontrado: " + arrayPersonas[i].nombre + " "+arrayPersonas[i].apellido+" Indice: "+ i);
                    }
                }            
      
            }
        }

    }
    
    //metodo para actualizar registros, se necesita que el usuario ingrese el ID del indice
    //del registro que quiere actualizar, el update es una sobrescritura sobre el indice ingresado
    static void actualizar(){
        Scanner opcion = new Scanner (System.in);
        String opcionUser;
        int indexFree=0;
        String indice;
        String[] captaDatos = new String[1];  
        System.out.println("PARA BUSQUEDA DE REGISTRO UTILICE OPCION #3 MENU");
        System.out.println("INGRESE EL #ID (indice) DEL REGISTRO:");
        indice  = opcion.next();
        
        boolean analiza= analizaCadena(indice);
        System.out.println( );
        if ( analiza==false ){
            System.out.println("Opcion ingresada no es un indice valido numerico, retorna a menu.");
        } else {
            
            if(arrayPersonas[ Integer.parseInt(indice) ] != null) {
                Persona persona  = arrayPersonas[Integer.parseInt(indice)];                           
                System.out.println( persona.retornarDatos());
                System.out.println("============================");
                System.out.println("Seleccione el perfil:"); 
                System.out.println("1) Admin 2)Catedratico 3) Alumno");  
                opcionUser = opcion.next();  
                switch(opcionUser) {
                case "1":                                                   
                    captaDatos=Administrativo.solicitaDatos(indexFree);                      
                    arrayPersonas[Integer.parseInt(indice)]= new Administrativo(captaDatos[0], captaDatos[1], captaDatos[2], captaDatos[3]);  
                    break;    
                case "2":  
                    captaDatos=Profesor.solicitaDatos(indexFree);                      
                    arrayPersonas[Integer.parseInt(indice)]= new Profesor(captaDatos[0], captaDatos[1], captaDatos[2], captaDatos[3]);          
                    break;    
                case "3":                             
                    captaDatos=Alumno.solicitaDatos(indexFree);                      
                    arrayPersonas[Integer.parseInt(indice)]= new Alumno(captaDatos[0], captaDatos[1], captaDatos[2], captaDatos[3]);          
                    break;
                case "4":  
                    break;
                default:
                    System.out.println(" ");  
                    System.out.println("OPCION INVALIDA!");
                    System.out.println(" ");  
                }
             } else {
                 
                System.out.println( "El numero de indice ingresado no existe en el arreglo.");     
                }
            
                              
        }
    
    }
    
    //metodo para borrar registro recibe parametro el id del indice
    static void borrar() {
        Scanner opcion = new Scanner (System.in);   
        System.out.println("BUSQUE EL REGISTRO OPCION #3");
        System.out.println("INGRESE EL #ID (indice) DEL REGISTRO O X/x PARA REGRESAR AL MENU:");
        String indice  = opcion.next();
        
        boolean analiza= analizaCadena(indice);
        System.out.println( );
        if ( analiza==false ){
            System.out.println("Opcion ingresada no es un indice valido numerico, retorna a menu.");
        
        } else {
            int cont=0;
            Persona arrayPivot[] = new Persona[100]; 
            for ( int i =0 ; i < arrayPersonas.length; i++){

                if(arrayPersonas[i] != null) {  

                         if(i != Integer.parseInt(indice)) {

                             for ( int m =0 ; m < arrayPivot.length; m++){
                                 if(arrayPivot[m] == null) {                                      
                                    arrayPivot[m]=arrayPersonas[i];

                                    m=arrayPivot.length+1;
                                  } 

                              }
                            }
                            cont=1;
                  } else {
                    if (cont==0){
                        System.out.println("El arreglo no tiene elementos"); 
                        cont=1;
                    }
                }

             }

            for ( int p =0 ; p < arrayPivot.length; p++){
                arrayPersonas[p]=arrayPivot[p];                                        
            }
        }

    
    
    
}
    
    
    
    //METODO MAIN PRINCIPAL
    public static void main(String[] args) {
        String opcionUser;
        String indice;
        Scanner opcion = new Scanner (System.in);
        
        
        
        do{
            menu();
            opcionUser = opcion.next();
            limpiar();
               
                switch(opcionUser) {
                
                 case "1": //INGRESAR REGISTROS
                        llenadoArray( ); 
                        break;

                 case "2":// ACTUALIZAR REGISTROS 
                        actualizar(); 
                         break;                                                                
                                   
                 case "3":// BUSCAR REGISTROS 
                        System.out.println("Ingrese un nombre: ");
                        String nombre  = opcion.next();
                        System.out.println("Ingrese un apellido: ");
                        String apellido  = opcion.next();
                        buscarArray(nombre, apellido);

                        break;
                case "4": //BORRAR REGISTROS 
                        borrar();
                        break;
                case "5": //IMPRESION DE REGISTROS 
                        int cont=0;
                        System.out.println("                          REGISTROS ALMACENADOS                                     ");
                        System.out.println("===============================================================================================");  
                        for (Persona persona  : arrayPersonas){
                          if(persona != null){
                            System.out.println(cont+ ") "+   persona.retornarDatos());
                            System.out.println("");
                            cont=cont+1;
                          } else {
                              if (cont==0){
                                System.out.println("Arreglo sin elementos"); 
                                cont=1;
                              }
                          }
                        }        
                        System.out.println("===============================================================================================");  
                           
                         break;
                case "6"://SALIDA DEL MENU
                         break;
                default: //CUALQUIER VALOR NO VALIDO DEL MENU
                        System.out.println(" ");  
                        System.out.println("OPCION INVALIDA!");
                        System.out.println(" ");  
              } 
        
           }
        while (  !"6".equals(opcionUser) );
        
                
        }
    
    
}
