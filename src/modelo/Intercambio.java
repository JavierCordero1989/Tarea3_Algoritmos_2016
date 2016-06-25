package modelo;

import hilos.Hilo_Ejecucion;
import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author Javi Cordero
 */
public class Intercambio 
{
    private Hilo_Ejecucion hilo;
    
    public Intercambio(Hilo_Ejecucion hilo)
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
    
    public void ordenarIntercambio(int[] arreglo, JLabel[] arregloEtiquetas)
    {
        for(int i=0; i<arreglo.length-1; i++)
        {
            //Situa minimo de arreglo[i+1]...arreglo[n-1] en arreglo[i]
            for(int j=(i+1); j<arreglo.length; j++)
            {
                if(arreglo[i] > arreglo[j])
                {
                    intercambiar(arreglo, arregloEtiquetas, i, j);
                }
            }
        }
    }/*Fin de la clase ordenarIntercambio*/
    
    /**
     * Duerme el hilo por el tiempo especificado dentro del metodo sleep de
     * la clase Hilo_Ejecucion. Para este caso son 2 segundos.
     */
    public void dormir()
    {
        try
        {
            Hilo_Ejecucion.sleep(1000);
        }
        catch(Exception exception)
        {
            System.out.println("Error en la clase Seleccion con el hilo.\nExcepcion: " + exception);
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
}/*Fin de la clase Intercambio*/
