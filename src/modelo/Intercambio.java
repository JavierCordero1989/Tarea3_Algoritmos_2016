package modelo;

/**
 *
 * @author Javi Cordero
 */
public class Intercambio 
{
    public Intercambio()
    {
    }/*Fin del constructor.*/
    
    public static void intercambiar(int[] arreglo, int i, int j)
    {
        int aux = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = aux;
    }/*Fin del metodo intercambiar*/
    
    public static void ordenarIntercambio(int[] arreglo)
    {
        for(int i=0; i<arreglo.length-1; i++)
        {
            //Situa minimo de arreglo[i+1]...arreglo[n-1] en arreglo[i]
            for(int j=(i+1); j<arreglo.length; j++)
            {
                if(arreglo[i] > arreglo[j])
                {
                    intercambiar(arreglo, i, j);
                }
            }
        }
    }/*Fin de la clase ordenarIntercambio*/
    
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
}/*Fin de la clase Intercambio*/
