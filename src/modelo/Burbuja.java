package modelo;

/**
 *
 * @author Javi Cordero
 */
public class Burbuja 
{
    public Burbuja()
    {
    }/*Fin del constructor.*/
    
    public static void ordenarBurbuja(int arreglo[])
    {
        int interruptor = 1;
        int tamanio = arreglo.length;
        
        for(int pasada=0; (pasada<tamanio-1 && interruptor!=0); pasada++)
        {
            /*bucle externo controla la cantidad de pasadas. */
            interruptor = 0;
            
            for(int j=0; j < (tamanio-pasada-1); j++)
            {
                if(arreglo[j] > arreglo[j+1])
                {
                    /*elementos desordenados, es necesario intercambiar*/
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = aux;
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
    
}/*Fin de la clase Burbuja*/
