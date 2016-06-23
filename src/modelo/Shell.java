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
    /**
     * Instancia del Hilo de ejecucion para controlar el tiempo de cambio de las
     * etiquetas de la interfaz que realiza el cambio grafico.
     */
    private Hilo_Ejecucion hilo;
    
    /**
     * Recibe como parametro el hilo de ejecucion, y lo iguala a una instancia propia
     * dentro de esta clase.
     * @param hilo 
     */
    public Shell(Hilo_Ejecucion hilo)
    {
        this.hilo = hilo;
    }
    
    /**
     * Recibe como parametros los arreglos a los que se va a ordenar de menor a
     * mayor, mediante el algoritmo de shell.
     * @param arreglo
     * @param arregloEtiquetas 
     */
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
                        /*Hace los intercambios respectivos*/
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
    
    /**
     * Recibe dos etiquetas por parametros, a las cuales se les hara un cambio 
     * de color tanto en la letra como en el color de fondo. El texto de la
     * etiqueta cambiaraa blanco mientras que el fondo a rojo.
     * 
     * @param etiqueta1
     * @param etiqueta2 
     */
    public void cambiarARojo(JLabel etiqueta1, JLabel etiqueta2)
    {
        etiqueta1.setBackground(Color.red);
        etiqueta2.setBackground(Color.red);
        etiqueta1.setForeground(Color.white);
        etiqueta2.setForeground(Color.white);
    }//Fin del metodo cambiarARojo.
    
    /**
     * Recibe dos etiquetas y les cambia el color de fondo y el texto. El color
     * de fondo sera el mismo que tienen los paneles y JFrame por defecto, mientras
     * que el color de la letra sera negro. Es decir, las volvera al color original
     * que traen por defecto.
     * 
     * @param etiqueta1
     * @param etiqueta2 
     */
    public void cambiarANormal(JLabel etiqueta1, JLabel etiqueta2)
    {
        etiqueta1.setBackground(new Color(214,217,223));
        etiqueta2.setBackground(new Color(214,217,223));
        etiqueta1.setForeground(Color.black);
        etiqueta2.setForeground(Color.black);
    }//Fin del metodo cambiarANormal.
    
    /**
     * Duerme el hilo por el tiempo especificado dentro del metodo sleep de
     * la clase Hilo_Ejecucion. Para este caso son 2 segundos.
     */
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
    }//Fin del metodo dormir.
}/*Fin de la clase Shell*/
