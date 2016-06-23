package hilos;

import static java.lang.Thread.sleep;
import javax.swing.JLabel;
import modelo.Burbuja;
import modelo.Seleccion;
import modelo.Shell;
import vistas.FRM_Burbuja;
import vistas.FRM_Seleccion;
import vistas.FRM_Shell;

/**
 *
 * @author Javi Cordero
 */
public class Hilo_Ejecucion extends Thread
{
    /*Variables que son iguales para todos*/
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
    
    public Hilo_Ejecucion(FRM_Shell ventana_shell, int[] arregloDatos, JLabel[] arregloEtiquetas)
    {
        this.ventana_shell = ventana_shell;
        ejecuta = true;
        this.arregloDatos = arregloDatos;
        this.arregloEtiquetas = arregloEtiquetas;
        
        shell = new Shell(this);
    }//Fin del constructor.
    
    public Hilo_Ejecucion(FRM_Seleccion ventana_Seleccion, int[] arregloDatos, JLabel[] arregloEtiquetas)
    {
        this.ventana_Seleccion = ventana_Seleccion;
        ejecuta = true;
        this.arregloDatos = arregloDatos;
        this.arregloEtiquetas = arregloEtiquetas;
        
        seleccion = new Seleccion(this);
    }//Fin del cosntructor.
    
    public Hilo_Ejecucion(FRM_Burbuja ventana_burbuja, int[] arregloDatos, JLabel[] arregloEtiquetas)
    {
        this.ventana_burbuja = ventana_burbuja;
        ejecuta = true;
        this.arregloDatos = arregloDatos;
        this.arregloEtiquetas = arregloEtiquetas;
        
        burbuja = new Burbuja(this);
    }//Fin del cosntructor.
    
    public void run()
    {
        if(ventana_burbuja != null)
        {
            while(ejecuta)
            {
                try
                {
                    sleep(1000);
                    burbuja.ordenarBurbuja(arregloDatos, arregloEtiquetas);
                    ejecuta = false;
                }
                catch(Exception exception)
                {
                    System.out.println("Error en el hilo de Burbuja.\nExcepcion: " + exception);
                }
            }
            ventana_burbuja.mostrarMensaje("El algoritmo de Burbuja ha concluido");
        }
        else if(ventana_Seleccion != null)
        {
            while(ejecuta)
            {
                try
                {
                    sleep(1000);
                    //shell.ordenarShell(arregloDatos, arregloEtiquetas);
                    seleccion.ordenarSeleccion(arregloDatos, arregloEtiquetas);
                    ejecuta = false;
                }
                catch(Exception exception)
                {
                    System.out.println("Error en el hilo de Seleccion.\nExcepcion: " + exception);
                }
            }
            ventana_Seleccion.mostrarMensaje();
        }
        else if(ventana_shell != null)
        {
            while(ejecuta)
            {
                try
                {
                    sleep(1000);
                    shell.ordenarShell(arregloDatos, arregloEtiquetas);
                    ejecuta = false;
                }
                catch(Exception exception)
                {
                    System.out.println("Error en el hilo del Shell.\nExcepcion: " + exception);
                }
            }
            ventana_shell.mostrarMensaje();
        }
    }
    
    public void mostrarPasadas(int pasada)
    {
        ventana_burbuja.mostrarMensaje("Pasada: " + (pasada+1));
    }
}//Fin de la clase Hilo_Ejecucion.
