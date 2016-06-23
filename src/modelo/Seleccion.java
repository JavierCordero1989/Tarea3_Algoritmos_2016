package modelo;

import hilos.Hilo_Ejecucion;
import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author Javi Cordero
 */
public class Seleccion 
{
    private Hilo_Ejecucion hilo;
    
    public Seleccion(Hilo_Ejecucion hilo)
    {
        this.hilo = hilo;
    }/*Fin del constructor.*/
    
    public void intercambiar(int[] arreglo, JLabel[] arregloEtiquetas, int i, int j)
    {
        dormir();
        cambiarARojo(arregloEtiquetas[i], arregloEtiquetas[j]);
        
        dormir();
        
        int aux = arreglo[i];
        String text = arregloEtiquetas[i].getText();
        
        arreglo[i] = arreglo[j];
        arregloEtiquetas[i].setText(arregloEtiquetas[j].getText());
        
        arreglo[j] = aux;
        arregloEtiquetas[j].setText(text);
        
        dormir();
        cambiarANormal(arregloEtiquetas[i], arregloEtiquetas[j]);
    }/*Fin del metodo intercambiar*/
    
    public void ordenarSeleccion(int[] arreglo, JLabel[] arregloEtiquetas)
    {
        int indiceMenor;
        int n_tamanio = arreglo.length;
        
        for(int i=0; i<n_tamanio-1; i++)
        {
            //Comienzo de la exploracion en indice i
            indiceMenor = i;
            
            //j explora la sublista arreglo[i+1]...arreglo[n_tamanio-1]
            for(int j=(i+1); j<n_tamanio; j++)
            {
                if(arreglo[j] < arreglo[indiceMenor])
                {
                    indiceMenor = j;
                }
            }
            
            //Situa el elemento mas pequeno en arreglo[i]
            if(i != indiceMenor)
            {
                intercambiar(arreglo, arregloEtiquetas, i, indiceMenor);
            }
        }
    }/*Fin del metodo ordenarSeleccion*/
    
    public void dormir()
    {
        try
        {
            Hilo_Ejecucion.sleep(2000);
        }
        catch(Exception exception)
        {
            System.out.println("Error en la clase Seleccion con el hilo.\nExcepcion: " + exception);
        }
    }//Fin del metodo dormir.
    
    public void cambiarARojo(JLabel etiqueta1, JLabel etiqueta2)
    {
        etiqueta1.setBackground(Color.red);
        etiqueta2.setBackground(Color.red);
        etiqueta1.setForeground(Color.white);
        etiqueta2.setForeground(Color.white);
    }
    public void cambiarANormal(JLabel etiqueta1, JLabel etiqueta2)
    {
        etiqueta1.setBackground(new Color(214,217,223));
        etiqueta2.setBackground(new Color(214,217,223));
        etiqueta1.setForeground(Color.black);
        etiqueta2.setForeground(Color.black);
    }
    public static void imprimir(int[] arreglo)
    {
        int tamanio = arreglo.length; //Tamanio del arreglo
        
        for(int contador=0; contador<tamanio; contador++)
        {
            mostrarMensaje("Valor en [" + contador + "] es: " + arreglo[contador]);
        }
    }/*Fin del metodo imprimir*/
    
    public static void mostrarMensaje(String mensaje)
    {
        System.out.println(mensaje);
    }/*Fin del metodo mostrarMensaje*/
}/*Fin de la clase Seleccion*/
