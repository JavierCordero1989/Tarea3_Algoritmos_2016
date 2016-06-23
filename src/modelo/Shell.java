package modelo;

import hilos.Hilo_Ejecucion;
import hilos.Hilo_Shell;
import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author Javi Cordero
 */
public class Shell 
{    
    //private Hilo_Shell hilo;
    private Hilo_Ejecucion hilo;
    
    public Shell(Hilo_Ejecucion hilo)
    {
        this.hilo = hilo;
    }
    
//    public Shell(Hilo_Shell hilo)
//    {
//        this.hilo = hilo;
//    }/*Fin del constructor.*/
    
    public void ordenarShell(int arreglo[], JLabel[] arregloEtiquetas)
    {
        int tamanio = arreglo.length;
        int intervalo =  tamanio / 2;
        int j, k;
        
        while(intervalo > 0)
        {
            for(int i=intervalo; i<tamanio; i++)
            {
                j = (i - intervalo);
                
                while(j >= 0)
                {
                    k = (j + intervalo);
                    
                    if(arreglo[j] <= arreglo[k])
                    {
                        j = -1; //Asi termina el bucle, par ordenado
                    }
                    else
                    {
                        dormir();
                        cambiarARojo(arregloEtiquetas[j], arregloEtiquetas[k]);
                        
                        dormir();
                        int temp = arreglo[j];
                        String text = arregloEtiquetas[j].getText();
                        
                        arreglo[j] = arreglo[k];
                        arregloEtiquetas[j].setText(arregloEtiquetas[k].getText());
                        
                        arreglo[k] = temp;
                        arregloEtiquetas[k].setText(text);
                        
                        dormir();
                        cambiarANormal(arregloEtiquetas[j], arregloEtiquetas[k]);
                        j -= intervalo;
                    }
                }
            }
            intervalo = intervalo/2;
        }
    }/*Fin del metodo ordenarShell*/
    
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
    public void dormir()
    {
        try 
        {
            Hilo_Shell.sleep(2000);//Duerme durante 2 segundos.
        }
        catch (InterruptedException ex)
        {
            System.out.println("Error en la clase Shell con el hilo.\nExcepcion: " + ex);
        }
    }
}/*Fin de la clase Shell*/
