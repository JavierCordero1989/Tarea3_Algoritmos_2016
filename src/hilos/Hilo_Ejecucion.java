/**
 * Tarea #3: algoritmos de ordenamiento.
 * Integrantes: Llasuara Peraza, Alexandra Elizondo y Javier Cordero.
 * Profesor: Juan Carlos Arias.
 * Curso: Algoritmos y estructuras de datos.
 * Universidad de Costa Rica - Sede el Pacifico Arnoldo Ferreto Segura.
 * I semestre, 2016.
 */

package hilos;

import javax.swing.JButton;
import javax.swing.JLabel;
import modelo.Burbuja;
import modelo.Intercambio;
import modelo.Quicksort;
import modelo.Seleccion;
import modelo.Shell;
import vistas.FRM_Burbuja;
import vistas.FRM_Intercambio;
import vistas.FRM_Seleccion;
import vistas.FRM_Shell;
import vistas.FRM_VentanaQuicksort;

/**
 *
 * @author Javi Cordero
 */
public class Hilo_Ejecucion extends Thread
{
    /*Variables que son iguales para todos los algoritmos*/
    private boolean ejecuta;
    private int[] arregloDatos;
    private JLabel[] arregloEtiquetas;
    
    /*VARIABLES PARA EL ALGORITMO DE SHELL*/
    private FRM_Shell ventana_shell = null;
    private Shell shell;
    
    /*VARIABLES PARA EL ALGORITMO DE SELECCION*/
    private FRM_Seleccion ventana_Seleccion = null;
    private Seleccion seleccion;
    
    /*VARIABLES PARA EL ALGORITMO DE BURBUJA*/
    private FRM_Burbuja ventana_burbuja = null;
    private Burbuja burbuja;
    
    /*VARIABLES PARA EL ALGORITMO DE INTERCAMBIO*/
    private FRM_Intercambio ventana_Intercambio = null;
    private Intercambio intercambio;
    
    /*VARIABLES PARA EL ALGORITMO DE QUICKSORT*/
    private JButton[] botones;
    private int tamanio;
    public FRM_VentanaQuicksort ventana = null;
    private Quicksort quicksort1;
    
    /**
     * Constructor utilizado para ejecutar los tiempos del algoritmo Shell para 
     * ordenar.
     * @param ventana_shell es la interfaz que ejecuta los cambios graficos.
     * @param arregloDatos datos con los valores enteros ingresados por el usuario.
     * @param arregloEtiquetas etiquetas que cambian cuando el algoritmo lo requiere.
     */
    public Hilo_Ejecucion(FRM_Shell ventana_shell, int[] arregloDatos, JLabel[] arregloEtiquetas)
    {
        this.ventana_shell = ventana_shell;
        
        ejecuta = true;
        
        this.arregloDatos = arregloDatos;
        this.arregloEtiquetas = arregloEtiquetas;
        
        shell = new Shell(this);
    }//Fin del constructor.
    
    /**
     * Constructor utilizado para ejecutar los tiempos del algoritmo de Seleccion
     * para ordenar.
     * @param ventana_Seleccion es la interfaz que ejecuta los cambios graficos.
     * @param arregloDatos datos con los valores enteros ingresados por el usuario.
     * @param arregloEtiquetas etiquetas que cambian cuando el algoritmo lo requiere.
     */
    public Hilo_Ejecucion(FRM_Seleccion ventana_Seleccion, int[] arregloDatos, JLabel[] arregloEtiquetas)
    {
        this.ventana_Seleccion = ventana_Seleccion;
        
        ejecuta = true;
        
        this.arregloDatos = arregloDatos;
        this.arregloEtiquetas = arregloEtiquetas;
        
        seleccion = new Seleccion(this);
    }//Fin del cosntructor.
    
    /**
     * Constructor utilizado para ejecutar los tiempos del algoritmo de Burbuja
     * para ordenar.
     * @param ventana_burbuja es la interfaz que ejecuta los cambios graficos.
     * @param arregloDatos datos con los valores enteros ingresados por el usuario.
     * @param arregloEtiquetas etiquetas que cambian cuando el algoritmo lo requiere.
     */
    public Hilo_Ejecucion(FRM_Burbuja ventana_burbuja, int[] arregloDatos, JLabel[] arregloEtiquetas)
    {
        this.ventana_burbuja = ventana_burbuja;
        
        ejecuta = true;
        
        this.arregloDatos = arregloDatos;
        this.arregloEtiquetas = arregloEtiquetas;
        
        burbuja = new Burbuja(this);
    }//Fin del constructor.
    
    /**
     * Constructor utilizado para ejecutar los tiempos del algoritmo de Intercambio
     * para ordenar.
     * @param ventana_Intercambio es la interfaz que ejecuta los cambios graficos.
     * @param arregloDatos datos con los valores enteros ingresados por el usuario.
     * @param arregloEtiquetas etiquetas que cambian cuando el algoritmo lo requiere.
     */
    public Hilo_Ejecucion(FRM_Intercambio ventana_Intercambio, int[] arregloDatos, JLabel[] arregloEtiquetas)
    {
        this.ventana_Intercambio = ventana_Intercambio;
        
        ejecuta = true;
        
        this.arregloDatos = arregloDatos;
        this.arregloEtiquetas = arregloEtiquetas;
        
        intercambio = new Intercambio(this);
    }//Fin del cosntructor.
    
    /**
     * Constructor utilizado para ejecutar los tiempos del algoritmo Quicksort
     * para ordenar.
     * @param ventana es la interfaz que ejecuta los cambios graficos.
     * @param botones botones que cambian cuando el algoritmo lo requiere.
     * @param datos datos con los valores enteros ingresados por el usuario.
     */
    public Hilo_Ejecucion(FRM_VentanaQuicksort ventana, JButton[] botones, int[] datos)
    {
        this.botones = botones;
        this.arregloDatos = datos;
        tamanio = datos.length;
        
        ejecuta = true;
        this.ventana = ventana;
        
        quicksort1 = new Quicksort(this);
    }
    
    public void run()
    {
        /**
         * Ejecuta la sentencia solo si se ha iniciado la interfaz para el 
         * ordenamiento de Quicksort.
         */
        if(ventana != null)
        {
            while(ejecuta)
            {
                try
                {
                    for(int i=0; i<tamanio; i++)
                    {
                        sleep(100);
                        botones[i].setText("" + arregloDatos[i]);
                    }
                    
                    quicksort1.quick(botones, arregloDatos, 0, arregloDatos.length-1);
                    ejecuta = false; //Termina el ciclo y detiene el hilo.
                }
                catch(Exception exception)
                {
                    System.out.println("Error en el hilo de Quicksort.\nExcepcion: " + exception);
                }
            }
        }
        /**
         * Ejecuta la sentencia solo si se ha iniciado la interfaz para el 
         * ordenamiento de Intercambio.
         */
        else if(ventana_Intercambio != null)
        {
            while(ejecuta)
            {
                try
                {
                    sleep(1000);
                    intercambio.ordenarIntercambio(arregloDatos, arregloEtiquetas);
                    ejecuta = false; //Termina el ciclo y detiene el hilo.
                }
                catch(Exception exception)
                {
                    System.out.println("Error en el hilo de Intercambio.\nExcepcion: " + exception);
                }
            }
            ventana_Intercambio.mostrarMensaje();
        }
        /**
         * Ejecuta la sentencia solo si se ha iniciado la interfaz para el 
         * ordenamiento de Burbuja.
         */
        else if(ventana_burbuja != null)
        {
            while(ejecuta)
            {
                try
                {
                    sleep(1000);
                    burbuja.ordenarBurbuja(arregloDatos, arregloEtiquetas);
                    ejecuta = false; //Termina el ciclo y detiene el hilo.
                }
                catch(Exception exception)
                {
                    System.out.println("Error en el hilo de Burbuja.\nExcepcion: " + exception);
                }
            }
            ventana_burbuja.mostrarMensaje("El algoritmo de Burbuja ha concluido");
        }
        /**
         * Ejecuta la sentencia solo si se inicio la interfaz para el ordenamiento
         * de Seleccion.
         */
        else if(ventana_Seleccion != null)
        {
            while(ejecuta)
            {
                try
                {
                    sleep(1000);
                    seleccion.ordenarSeleccion(arregloDatos, arregloEtiquetas);
                    ejecuta = false; //Detiene el ciclo
                }
                catch(Exception exception)
                {
                    System.out.println("Error en el hilo de Seleccion.\nExcepcion: " + exception);
                }
            }
            ventana_Seleccion.mostrarMensaje();
        }
        /**
         * Se ejecuta la sentencia solo si se inicio la interfaz para el 
         * ordenamiento de Shell.
         */
        else if(ventana_shell != null)
        {
            while(ejecuta)
            {
                try
                {
                    sleep(1000);
                    shell.ordenarShell(arregloDatos, arregloEtiquetas);
                    ejecuta = false;//Termina el ciclo.
                }
                catch(Exception exception)
                {
                    System.out.println("Error en el hilo del Shell.\nExcepcion: " + exception);
                }
            }
            ventana_shell.mostrarMensaje();
        }
    }
    
    /**
     * Metodo que muestra cuantas pasadas ha hecho un algoritmo. Inicialmente
     * se hizo para el algoritmo de Burbuja. Puede ser usado en algun otro
     * algoritmo a futuro.
     * 
     * @param pasada 
     */
    public void mostrarPasadas(int pasada)
    {
        ventana_burbuja.mostrarMensaje("Pasada: " + (pasada+1));
    }
    
    public void mostrarPasadasIntercambio(int pasada)
    {
        ventana_Intercambio.mostrarMensaje("Pasada: " + (pasada+1));
    }
}//Fin de la clase Hilo_Ejecucion.
