/**
 * Tarea #3: algoritmos de ordenamiento.
 * Integrantes: Llasuara Peraza, Alexandra Elizondo y Javier Cordero.
 * Profesor: Juan Carlos Arias.
 * Curso: Algoritmos y estructuras de datos.
 * Universidad de Costa Rica - Sede el Pacifico Arnoldo Ferreto Segura.
 * I semestre, 2016.
 */
package modelo;

import hilos.Hilo_Ejecucion;
import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author Javi Cordero
 */
public class Quicksort 
{
    private Hilo_Ejecucion hilo;
    private Color colorOriginal;
    private int pasada = 0;
    
    public Quicksort(Hilo_Ejecucion hilo)
    {
        this.hilo = hilo;
        colorOriginal = hilo.ventana.colorOriginal();
    }/*Fin del constructor.*/
    
    public void quick(JButton[] botones, int[] vector, int primero, int ultimo)
    {
        hilo.ventana.reiniciarTodo();
        int i, j, central, pivote;
        central = (primero + ultimo)/2;
        
        pivote = vector[central];
        
        dormir_x_segundos(1000);
        hilo.ventana.mostrarPivote("Pivote: " + pivote + ", pasada: " + (pasada));
        botones[central].setBackground(Color.black);
        
        System.out.println("Pivote: " + pivote);
        
        dormir_x_segundos(1000);
        i = primero;
        j = ultimo;
//        hilo.ventana.hacerInvisibles(i, j);
        
        dormir_x_segundos(1000);
        do
        {
            botones[i].setBackground(Color.green);
            botones[j].setBackground(Color.green);
            hilo.ventana.hacerVisibles(i, j);
        
            dormir_x_segundos(1000);
            
            while(vector[i] < pivote)
            {
                botones[i].setBackground(colorOriginal);
                hilo.ventana.hacerInvisibles(i, j);
                i++;
                botones[i].setBackground(Color.green);
                hilo.ventana.hacerVisibles(i, j);
                dormir_x_segundos(1000);
            }
            dormir_x_segundos(1000);
            
            while(vector[j] > pivote)
            {
                botones[j].setBackground(colorOriginal);
                hilo.ventana.hacerInvisibles(i, j);
                j--;
                botones[j].setBackground(Color.green);
                hilo.ventana.hacerVisibles(i, j);
                dormir_x_segundos(1000);
            }
            
            if(i<=j)
            {
                if(i==j)
                {
                    dormir_x_segundos(1000);
                    botones[i].setBackground(colorOriginal);
                    botones[j].setBackground(colorOriginal);
                }
                else
                {
                    dormir_x_segundos(1000);
                    botones[i].setBackground(Color.red);
                    botones[j].setBackground(Color.red);
                }
                
                dormir_x_segundos(1000);
                int aux = vector[i];
                vector[i] = vector[j];
                botones[i].setText(botones[j].getText());
                vector[j] = aux;
                botones[j].setText(""+aux);
                
                dormir_x_segundos(1000);
                botones[i].setBackground(colorOriginal);
                botones[j].setBackground(colorOriginal);
                
                dormir_x_segundos(1000);
                hilo.ventana.hacerInvisibles(i, j);
                i++;
                j--;
                botones[i].setBackground(Color.green);
                botones[j].setBackground(Color.green);
                hilo.ventana.hacerVisibles(i, j);
            }
        }while(i <= j);
        
        System.out.println("Termino la pasada: " + pasada++);
        botones[central].setBackground(colorOriginal);
        
        if(primero < j)
        {
            quick(botones, vector, primero, j);
        }
        if(i < ultimo)
        {
            quick(botones, vector, i, ultimo);
        }
        hilo.ventana.reiniciarTodo();
    }
    
    public void dormir_x_segundos(long milis)
    {
        try 
        {
            Hilo_Ejecucion.sleep(milis);
        } 
        catch (InterruptedException e) 
        {
            System.out.println("Error: " + e);
        }
    }
}/*Fin de la clase Quicksort*/
