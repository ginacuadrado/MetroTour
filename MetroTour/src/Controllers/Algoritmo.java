/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author samue
 */
public class Algoritmo {

    private int maximos[][], asignacion[][];
    private int recursos[], disponibles[];
    
    public Algoritmo(int maximos[][], int asignacion[][], int recursos[]) {
        
        this.maximos = maximos;
        this.asignacion = asignacion;
        this.recursos = recursos;
        this.disponibles = recursos;
        
        //Llenar matriz asignacion con numeros aleatorios
        this.asignacion = llenarAsignacion(this.asignacion, this.maximos, this.disponibles);
        
        //Actualizar la matriz de recursos disponibles
        this.disponibles = actualizarDisp(this.asignacion, this.disponibles);
    }
    
    //Funcion que rellena la matriz asignacion con valores aleatoreos
    //Los valores aleatorios no superaran la cantidad de recursos existentes
    private int[][] llenarAsignacion(int asignacion[][], int maximos[][], int disponibles[]){
        
        //Variables para llenar la matriz asignacion
        int max, disp, random;
        int asignados[][] = asignacion;
        
        for(int j = 0; j < asignacion[0].length; j++){
            //Extraer la cantidad de tipo de recurso disponible
            disp = disponibles[j];
            
            for(int i = 0; i < asignacion.length; i++){
                //Si la cantidad de tipo recurso disponibles es 0, asignar 0
                if(disp > 0){
                    
                    //Extraer valor maximo de tipo de recurso que requiere el proceso
                    max = maximos[i][j];
                    
                    //Si el proceso requiere mas recursos de los disponibles, limitar los
                    //recursos asignables a los disponibles
                    if(max > disp){
                        max = disp;
                    }
                    
                    //Asignar una cantidad aleatoria del tipo de recurso, entre 0 y la
                    //cantidad maxima posible
                    random = ThreadLocalRandom.current().nextInt(0, max + 1);
                    asignados[i][j] = random;
                    
                    //Actualizar la cantidad de tipo de recurso disponible
                    disp = disp - random;
                } else {
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
                //Restar el valor almacenado en cada proceso para cada tipo de
                //recurso respectivo
                update[j] = update[j] - asignacion[i][j];
            }
        }
        
        return update;
    }
}
