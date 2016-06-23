package modelo;

import hilos.Hilo_Ejecucion;
import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author Javi Cordero
 */
public class Burbuja 
{
    private Hilo_Ejecucion hilo;
    
    public Burbuja(Hilo_Ejecucion hilo)
    {
        this.hilo = hilo;
    }/*Fin del constructor.*/
    
    public void ordenarBurbuja(int arreglo[], JLabel[] arregloEtiquetas)
    {
        int interruptor = 1;
        int tamanio = arreglo.length;
        
        for(int pasada=0; (pasada<tamanio-1 && interruptor!=0); pasada++)
        {
            hilo.mostrarPasadas(pasada);
            /*bucle externo controla la cantidad de pasadas. */
            interruptor = 0;
            
            for(int j=0; j < (tamanio-pasada-1); j++)
            {
                if(arreglo[j] > arreglo[j+1])
                {
                    dormir();
                    
                    cambiarARojo(arregloEtiquetas[j], arregloEtiquetas[j+1]);
                    
                    dormir();
                    /*elementos desordenados, es necesario intercambiar*/
                    int aux = arreglo[j];
                    String text = arregloEtiquetas[j].getText();
                    
                    arreglo[j] = arreglo[j+1];
                    arregloEtiquetas[j].setText(arregloEtiquetas[j+1].getText());
                    
                    arreglo[j+1] = aux;
                    arregloEtiquetas[j+1].setText(text);
                    
                    dormir();
                    cambiarANormal(arregloEtiquetas[j], arregloEtiquetas[j+1]);
                    
                    interruptor = 1;
                }
            }
        }
    }/*Fin del metodo ordenarBurbuja*/
    
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
    
    public void dormir()
    {
        try
        {
            Hilo_Ejecucion.sleep(2000);
        }
        catch(Exception exception)
        {
            System.out.println("Error en la clase Burbuja con el hilo.\nExcepcion: " + exception);
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
}/*Fin de la clase Burbuja*/
