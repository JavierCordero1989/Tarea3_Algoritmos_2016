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
    
    public void intercambiar(int[] arreglo, int i, int j)
    {
        int aux = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = aux;
    }/*Fin del metodo intercambiar*/
    
    public void ordenarIntercambio(int[] arreglo)
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
}/*Fin de la clase Intercambio*/
