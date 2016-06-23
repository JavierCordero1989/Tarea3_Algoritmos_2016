package modelo;

/**
 *
 * @author Javi Cordero
 */
public class Quicksort 
{
    public Quicksort()
    {
    }/*Fin del constructor.*/
    
    public void ordenarQuicksort(int[] vector, int izq, int der)
    {
        int pivote = vector[izq]; //Tomamos el primer elemento como pivote.
        int i = izq; //i realiza la busqueda de izquierda a derecha.
        int d = der; //d realiza la busqueda de derecha a izquierda.
        int aux;
        
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
                aux = vector[i];
                vector[i] = vector[d];
                vector[d] = aux;
            }
        }
        vector[izq] = vector[d]; //Se coloca el pivote en su lugar de forma que tendremos
        vector[d] = pivote; // los menores a su izquierda y los mayores a su derecha.
        if(izq < d-1)
        {
            ordenarQuicksort(vector, izq, d-1);
        }
        if(d+1 < der)
        {
            ordenarQuicksort(vector, d+1, der);
        }
    }/*Fin del metodo quicksort*/
}/*Fin de la clase Quicksort*/
