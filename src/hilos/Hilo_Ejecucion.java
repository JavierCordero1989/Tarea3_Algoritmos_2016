package hilos;

import static java.lang.Thread.sleep;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modelo.Seleccion;
import modelo.Shell;
import vistas.FRM_Seleccion;
import vistas.FRM_Shell;

/**
 *
 * @author Javi Cordero
 */
public class Hilo_Ejecucion extends Thread
{
    /*VARIABLES PARA EL ALGORITMO DE SHELL*/
    private FRM_Shell ventana_shell = null;
    private boolean ejecuta;
    private int[] arregloDatos;
    private JLabel[] arregloEtiquetas;
    private Shell shell;
    
    /*VARIABLES PARA EL ALGORITMO DE SELECCION*/
    private FRM_Seleccion ventana_Seleccion;
    private Seleccion seleccion;
    
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
        seleccion = new Seleccion(this);//Hay que enviarle el this.
    }//Fin del cosntructor.
    
    public void run()
    {
        if(ventana_Seleccion != null)
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
}//Fin de la clase Hilo_Ejecucion.
