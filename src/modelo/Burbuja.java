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
    public Burbuja(Hilo_Ejecucion hilo)
    {
        this.hilo = hilo;
    }/*Fin del constructor.*/
    
    /**
     * Recibe como parametros los arreglos a los que se va a ordenar de menor a
     * mayor, mediante el algoritmo de burbuja.
     * @param arreglo
     * @param arregloEtiquetas 
     */
    public void ordenarBurbuja(int arreglo[], JLabel[] arregloEtiquetas)
    {
        int interruptor = 1;
        int tamanio = arreglo.length;
        
        for(int pasada=0; (pasada<tamanio-1 && interruptor!=0); pasada++)
        {
            dormir(500);
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
    
    /**
     * Duerme el hilo por el tiempo especificado dentro del metodo sleep de
     * la clase Hilo_Ejecucion. Para este caso son 2 segundos.
     */
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
    
    public void dormir(long tiempo)
    {
        try
        {
            Hilo_Ejecucion.sleep(tiempo);
        }
        catch(Exception exception)
        {
            System.out.println("Error en la clase Burbuja con el hilo.\nExcepcion: " + exception);
        }
    }//Fin del metodo dormir.
    
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
}/*Fin de la clase Burbuja*/
