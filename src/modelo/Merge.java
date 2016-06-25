/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 * 
 * @author Javi Cordero
 */
public class Merge
{
     /**
     * Algoritmo recursivo que permite ordenar el vector por medio del
     * MergeSort.
     *
     */
    private int arregloTemporal[];
    private int tamanio;
    private int arreglo[];
     
    public void MergeSort(int a[]) 
    {
        this.arreglo = a;
        this.tamanio = a.length;
        this.arregloTemporal = new int[tamanio];
        doMergeSort(0, tamanio - 1);
    }//Fin del metodo MergeSort.
   
    private void doMergeSort(int indiceMenor, int indiceMayor) 
    {
        if (indiceMenor < indiceMayor) 
        {
            int medio = indiceMenor + (indiceMayor - indiceMenor) / 2;
            // Below step sorts the left side of the array
            doMergeSort(indiceMenor, medio);
            // Below step sorts the right side of the array
            doMergeSort(medio + 1, indiceMayor);
            // Now merge both sides
            mergeParts(indiceMenor, medio, indiceMayor);
        }
    }//Fin del metodo doMergeSort
   
    /**
     * Método que se encarga de ir separando el vector en sub vectores más
     * pequeños hasta llegar a un estado donde todos los elementos estén
     * separados.
     *
     */
    private void mergeParts(int indiceMenor, int medio, int indiceMayor) 
    {

        for (int i = indiceMenor; i <= indiceMayor; i++) 
        {
            arregloTemporal[i] = arreglo[i];
        }
        
        int i = indiceMenor;
        int j = medio + 1;
        int k = indiceMenor;
        
        while (i <= medio && j <= indiceMayor) 
        {
            if (arregloTemporal[i] <= arregloTemporal[j]) 
            {
                arreglo[k] = arregloTemporal[i];
                i++;
            } 
            else
            {
                arreglo[k] = arregloTemporal[j];
                j++;
            }
            k++;
        }
        
        while (i <= medio) 
        {
            arreglo[k] = arregloTemporal[i];
            k++;
            i++;
        }
    }//Fin del metodo mergeParts
    
    public static void imprimir(int arr[])
    {
        for(int v : arr)
        {
            System.out.println(v);
        }
    }
//    public static void main(String args[])
//    {
//        int arr[] = {5,7,9,12,45,30,4,11,90,0};
//        Merge merge = new Merge();
//        
//        System.out.println("Arreglo desordenado:\n");
//        Merge.imprimir(arr);
//        
//        System.out.println("Arreglo ordenado:\n");
//        merge.MergeSort(arr);
//        Merge.imprimir(arr);
//    }
}//Fin de la clase Merge