
package Controllers;

import GUI.MainView;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;

public class Algoritmo {

    //Definición de las matrices y vectores a utilizar
    private int maximos[][];
    private int asignacion[][];
    private int necesarios[][];
    private int recursos[];
    private int disponibles[];
    
    public Algoritmo(int maximos[][], int asignacion[][], int recursos[]) 
    {
        
        this.maximos = new int[maximos.length][maximos[0].length];
        this.asignacion = new int [asignacion.length][asignacion[0].length];
        this.necesarios = new int [asignacion.length][asignacion[0].length];
        this.recursos = new int[recursos.length];
        this.disponibles = new int[recursos.length];
        
        //Llenar matriz asignacion con numeros aleatorios
        //Repetir hasta estar en un estado seguro
        
        boolean seguro = false;

        while(!seguro){
       
            for(int i = 0; i < this.necesarios.length; i++){
                for(int j = 0;  j < this.necesarios[0].length; j++){
                    this.maximos[i][j] = maximos[i][j];
                    this.asignacion[i][j] = asignacion[i][j];
                    this.necesarios[i][j] = asignacion[i][j];
                    this.recursos[j] = recursos[j];
                    this.disponibles[j] = recursos[j];
                }
            }
            
            
            //Rellenar con numeros aleatoreos
            this.asignacion = llenarAsignacion(this.asignacion, this.maximos, this.disponibles);
            
            //Actualizar la matriz de recursos disponibles
            this.disponibles = actualizarDisp(this.asignacion, this.recursos);
            
            //Calcular el numero de recursos necesarios por orden
            this.necesarios = calcularNecesarios(this.asignacion, this.maximos);
            
            //Determinar si existe un estado seguro
            seguro = Revisar(this.necesarios, this.disponibles);
        }
        
        for(int i = 0; i < this.asignacion.length; i++){
            for(int j= 0; j < this.asignacion[0].length; j++){
                MainView.text3[i][j].setText(""+this.asignacion[i][j]);
            }
        }
     
        esSeguro();
    }
    
    //Funcion que rellena la matriz asignacion con valores aleatorios. Los valores aleatorios no superaran la cantidad de recursos existentes
    private int[][] llenarAsignacion(int asignacion[][], int maximos[][], int disponibles[])
    {
        
        //Variables para llenar la matriz asignacion
        int max, disp, random;
        int asignados[][] = asignacion;
        int maxarr[][] = maximos;
        int disparr[] = disponibles;
        
        for(int j = 0; j < asignacion[0].length; j++){
            //Extraer la cantidad de tipo de recurso disponible
            disp = disparr[j];
            for(int i = 0; i < asignacion.length; i++){
                
                if(disp > 0){ //Si la cantidad de tipo recurso disponibles es 0, asignar 0
                    
                    //Extraer valor maximo de tipo de recurso que requiere el proceso
                    max = maxarr[i][j];
                    
                    //Si el proceso requiere mas recursos de los disponibles, limitar los recursos asignables a los disponibles
                        if(max > disp)
                        {
                            max = disp;
                        }
                    
                    //Asignar una cantidad aleatoria del tipo de recurso, entre 0 y la cantidad maxima posible
                    random = ThreadLocalRandom.current().nextInt(0, max + 1);
                    asignados[i][j] = random;
                    
                    //System.out.println("as "+asignados[i][j]);
                    
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
    
    //Funcion que actualiza los valores del vector de tipo de recursos disponibles
    private int[] actualizarDisp(int asignacion[][], int disponibles[]){
        
        //Vector auxiliar a ser actualizado
        int update[] = disponibles;
        
        //Proceso de actualizacion de vector
        for(int j = 0; j < update.length; j++){
            for(int i = 0; i < asignacion.length; i++){
                //Restar el valor almacenado en cada proceso para cada tipo de recurso respectivo
                update[j] = recursos[j] - asignacion[i][j];
            }
        }
        
        return update;
    }
    
    //Calculo de recursos necesarios para ejecutar una orden
    private int[][] calcularNecesarios(int asig[][], int maxi[][]){
        int needed[][] = new int[maxi.length][maxi[0].length];
        
        for(int i = 0; i < asig.length; i++){
            for(int j = 0; j < asig[0].length; j++){
                needed[i][j] = maxi[i][j] - asig[i][j];
            }
        }
        
        return needed;
    }
    
    //Revisar si a algun proceso se le pueden asignar sus recursos
    private boolean Revisar(int need[][], int disp[]){
        
        int count = 0;
        
        for(int i = 0; i < need.length; i++){
            for(int j = 0; j < disp.length; j++){
                
                if(disp[j] < need[i][j]){
                    count++;
                }
            }
        }
        
        if(count >= ((need.length/2)+1)){
            return false;
        } else {
            return true;
        }
    }
    
    //Revisar si a un proceso especifico se le pueden asignar sus recursos
    private boolean chequear(int i) {
        
        for (int j = 0; j < necesarios[0].length; j++) {
            if (disponibles[j] < necesarios[i][j]) {
                return false;
            }
        }

        return true;
    }

 //Función que calcula el estado seguro del proceso      
 public void esSeguro() 
{
        boolean done[] = new boolean[maximos.length];
        int temp = 0;
        String msg = "  ";
        
        while (temp < maximos.length) {
            for (int i = 0; i < maximos.length; i++) {
                if (!done[i] && chequear(i)) {  //intentando asignar
                    for (int k = 0; k < maximos[0].length; k++) {
                        System.out.println("antes");
                        System.out.println(Arrays.toString(disponibles));
                        System.out.println(Arrays.deepToString(asignacion).replace("], ", "]\n"));
                        System.out.println(Arrays.deepToString(necesarios).replace("], ", "]\n"));
                        
                        asignacion[i][k] = asignacion[i][k] + necesarios[i][k];
                        disponibles[k] = disponibles[k] - necesarios[i][k];
                        necesarios[i][k] = necesarios[i][k] - necesarios[i][k];
                        
                        System.out.println("Asignacion");
                        System.out.println(Arrays.toString(disponibles));
                        System.out.println(Arrays.deepToString(asignacion).replace("], ", "]\n"));
                        System.out.println(Arrays.deepToString(necesarios).replace("], ", "]\n"));
                        
                        
                        
                    }
                    System.out.println("despues");
                    for(int j = 0; j < maximos[0].length; j++){
                        disponibles[j] = disponibles[j] + maximos[i][j];
                        asignacion[i][j] = asignacion[i][j] - asignacion[i][j];
                        System.out.println(Arrays.toString(disponibles));
                        System.out.println(Arrays.deepToString(asignacion).replace("], ", "]\n"));
                    }
                    System.out.println("Proceso asignado : " + i);
                    msg = msg + "Orden " + (i+1) + "  ";
                    done[i] = true;
                    temp++;
                }         
            }
        }
        
        MainView.orden.setText(msg);
        
        if (temp == maximos.length) //si todos los procesos estan asignados
        {
            System.out.println("\nAsignado de forma segura");
        } else {
            System.out.println("Todos los procesos se pueden asignar de forma segura");
        }
    }


}

