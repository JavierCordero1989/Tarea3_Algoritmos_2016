package modelo;

import hilos.Hilo_Ejecucion;
import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author Javi Cordero
 */
public class Quicksort 
{
    private Hilo_Ejecucion hilo;
    
    public Quicksort(Hilo_Ejecucion hilo)
    {
        this.hilo = hilo;
    }/*Fin del constructor.*/
    
    public void ordenarQuicksort(JLabel[] etiquetas, int[] vector, int izq, int der)
    {
        int pivote = vector[izq]; //Tomamos el primer elemento como pivote.
        String pivoteText = etiquetas[izq].getText();
        
        dormir();
        marcarPivote(etiquetas[izq]);
        
        int i = izq; //i realiza la busqueda de izquierda a derecha.
        int d = der; //d realiza la busqueda de derecha a izquierda.
        int aux;
        String text;
        
        while(i < d) //Mietras no se crucen las busquedas.
        {
            while(vector[d] > pivote) //Busca elemento menor que pivote. 
            {
                d--;
            }
            while(vector[i] <= pivote && i < d) //Busca elemento mayor que pivote.
            {
                i++;
            }
            
            if(i < d)
            {
                dormir();
                cambiarARojo(etiquetas[i], etiquetas[d]);
                
                dormir();
                aux = vector[i];
                text = etiquetas[i].getText();
                
                vector[i] = vector[d];
                etiquetas[i].setText(etiquetas[d].getText());
                
                vector[d] = aux;
                etiquetas[d].setText(text);
                
                dormir();
                cambiarANormal(etiquetas[d], etiquetas[i]);
            }
        }
        
        dormir();
        vector[izq] = vector[d]; //Se coloca el pivote en su lugar de forma que tendremos
        etiquetas[izq].setText(etiquetas[d].getText());
        
        vector[d] = pivote; // los menores a su izquierda y los mayores a su derecha.
        etiquetas[d].setText(pivoteText);
        
//        dormir();
//        desmarcarPivote(etiquetas[izq]);
        
        if(izq < d-1)
        {
            ordenarQuicksort(etiquetas, vector, izq, d-1);
        }
        if(d+1 < der)
        {
            ordenarQuicksort(etiquetas, vector, d+1, der);
        }
    }/*Fin del metodo quicksort*/
    
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
    
    public void marcarPivote(JLabel etiqueta)
    {
        etiqueta.setBackground(Color.black);
        etiqueta.setForeground(Color.white);
    }//Fin del metodo marcarPivote.
    
    public void desmarcarPivote(JLabel etiqueta)
    {
        etiqueta.setBackground(new Color(214,217,223));
        etiqueta.setForeground(Color.black);
    }
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
}/*Fin de la clase Quicksort*/
