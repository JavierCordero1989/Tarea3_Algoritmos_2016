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
import javax.swing.JLabel;

/**
 *
 * @author Javi Cordero
 */
public class Seleccion 
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
    public Seleccion(Hilo_Ejecucion hilo)
    {
        this.hilo = hilo;
    }/*Fin del constructor.*/
    
    /**
     * Hace el intercambio de las posiciones 'i' y 'j' en los arreglos 
     * enviados como parametros.
     * @param arreglo
     * @param arregloEtiquetas
     * @param i
     * @param j 
     */
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
    
    /**
     * Recibe como parametros los arreglos a los que se va a ordenar de menor a
     * mayor, mediante el algoritmo de seleccion.
     * @param arreglo
     * @param arregloEtiquetas 
     */
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
}/*Fin de la clase Seleccion*/
