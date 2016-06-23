package hilos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modelo.Shell;

public class Hilo_Shell extends Thread
{
    private boolean ejecuta;
    private int[] arregloDatos;
    private JLabel[] arregloEtiquetas;
    private Shell shell;
    
    public Hilo_Shell(int[] arregloDatos, JLabel[] arregloEtiquetas)
    {
        ejecuta = true;
        this.arregloDatos = arregloDatos;
        this.arregloEtiquetas = arregloEtiquetas;
        //shell = new Shell(this);
    }//Fin del constructor.
    
    public void run()
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
        JOptionPane.showMessageDialog(null, "Ha concluido el algoritmo Shell");
    }//Fin del metodo run.
}//Fin de la clase Hilo_Shell.
