
package Controllers;

import java.util.concurrent.ThreadLocalRandom;


public class Algoritmo {

    private int maximos[][], asignacion[][];
    private int recursos[], disponibles[];
    private int necesarios[][];
    private int numRutas;
    private int numOrdenes;
    
    public Algoritmo(int maximos[][], int asignacion[][], int recursos[],int rutas, int ordenes) {
        
        this.maximos = maximos;
        this.asignacion = asignacion;
        this.recursos = recursos;
        this.disponibles = recursos;    //La matriz disponibles inicia siendo igual a la de disponibles
        this.numRutas = rutas;
        this.numOrdenes= ordenes;
        this.necesarios=maximos;
        
        
        //Llenar matriz asignacion con numeros aleatorios
        this.asignacion = llenarAsignacion(this.asignacion, this.maximos, this.disponibles);
        
        //Actualizar la matriz de recursos disponibles
        this.disponibles = actualizarDisponibles(this.asignacion, this.recursos); 
        this.necesarios(this.asignacion,this.maximos);

    }
    
    //Funcion que rellena la matriz asignacion con valores aleatorios. Los valores aleatorios no superaran la cantidad de recursos existentes
    
    private int[][] llenarAsignacion(int asignacion[][], int maximos[][], int disponibles[])
    {
        
        //Variables para llenar la matriz asignacion
        int max, disp, random;
        int asignados[][] = asignacion;
        
        for(int j = 0; j < asignacion[0].length; j++){
            
            disp = disponibles[j]; //Extraer la cantidad de tipo de recurso disponible
            
            for(int i = 0; i < asignacion.length; i++){
                
                if(disp > 0){ //Si la cantidad de tipo recurso disponibles es 0, asignar 0
                    
                    //Extraer valor maximo de tipo de recurso que requiere el proceso
                    max = maximos[i][j];
                    
                    //Si el proceso requiere mas recursos de los disponibles, limitar los recursos asignables a los disponibles
                        if(max > disp)
                        {
                            max = disp;
                        }
                    
                    //Asignar una cantidad aleatoria del tipo de recurso, entre 0 y la cantidad maxima posible
                    random = ThreadLocalRandom.current().nextInt(0, max + 1);
                    asignados[i][j] = random;
                    
                    //Actualizar la cantidad de tipo de recurso disponible
                    disp = disp - random;
                } 
                else 
                {
                    asignados[i][j] = disp;
                }
            }
        }
        
       
        return asignados;
    }
    
    //Función que calcula la matriz de valores necesarios que se requieren
   
    private int[][] necesarios(int asignacion[][], int maximos[][]) 
    {
        int necesarios[][]=maximos;
        
        for (int i = 0; i < this.numOrdenes; i++) {
            
            for (int j = 0; j < this.numRutas; j++)
            {
                necesarios[i][j] = maximos[i][j] - asignacion[i][j];
            }
        }

        return necesarios;
    }

    
    
   //Funcion que actualiza los valores del vector de tipo de recursos disponibles
    private int[] actualizarDisponibles(int asignacion[][], int recursos[]){
       
        int update[] = recursos; //Vector auxiliar a ser actualizado
        
        //Proceso de actualizacion de vector
        for(int j = 0; j < update.length; j++){
            for(int i = 0; i < asignacion.length; i++){
                //Restar el valor almacenado en cada proceso para cada tipo de
                //recurso respectivo
                update[j] = recursos[j] - asignacion[i][j];
            }
        }
        
        return update;
    }
   
   //Verificar si los recursos pueden ser asignados.
   private boolean recursosAsignacion(int i) {
       
 
        for (int j = 0; j < numRutas; j++) 
        {
            if (disponibles[j] < necesarios[i][j]) 
            {
                return false;
            }
        }

        return true;
    } 
    
    public void esSeguro(int numRutas, int numOrdenes) {

        
        
        //Actualizar matriz de necesarios
        //this.necesarios = necesarios(this.asignacion,this.maximos);
        
        for (int i=0;i<numOrdenes;i++)
        {
            for (int j=0;j<numRutas;j++)
            {
               
                System.out.println(asignacion[i][j]);
            }
        }
        /*
        boolean seguro[] = new boolean[numRutas]; //Arreglo para indicar el orden de ejecución del estado seguro
        int temp = 0;

        while (temp < numOrdenes) 
        {  
            boolean asignado = false;
            
            for (int i = 0; i < numOrdenes; i++) 
            { 
                if (!seguro[i] && recursosAsignacion(i)) {
                    
                    for (int k = 0; k < numRutas; k++) {

                        this.disponibles[k] = this.disponibles[k] - necesarios[i][k] + maximos[i][k];
                    }
                    
                    System.out.println("Proceso asignado : " + i);
                    asignado = seguro[i] = true;
                    temp++;
                }
            }
            if (!asignado) {
                break;  //si no esta asignado
            }
        }
        
        
        if (temp == numOrdenes) //si todos los procesos estan asignados
        {
            System.out.println("\nAsignado de forma segura");
            
        } else {
            System.out.println("Todos los procesos se pueden asignar de forma segura");
        }*/
    }

    public int[][] getAsignacion() {
        return asignacion;
    }

    public int[] getDisponibles() {
        return disponibles;
    }

    public int[][] getNecesarios() {
        return necesarios;
    }
    
   
    
}
       
    




