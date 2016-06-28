/**
 * Tarea #3: algoritmos de ordenamiento.
 * Integrantes: Llasuara Peraza, Alexandra Elizondo y Javier Cordero.
 * Profesor: Juan Carlos Arias.
 * Curso: Algoritmos y estructuras de datos.
 * Universidad de Costa Rica - Sede el Pacifico Arnoldo Ferreto Segura.
 * I semestre, 2016.
 */
package vistas;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Javi Cordero
 */
public class FRM_Principal extends javax.swing.JFrame
{
    /**
     * ArrayList para copiar los datos que se ingresaran.
     */
    private ArrayList<Integer> numeros;
    
    /**
     * Datos que se ingresaran ya sea por el usuario, o de forma automatica por el programa.
     */
    private int[] arregloDatos;
    
    /**
     * Metodo constructor de la clase.
     */
    public FRM_Principal() 
    {
        initComponents();
        
        /**
         * Pregunta al usuario si desea ingresar los datos el uno a uno, o si
         * prefiere que el programa lo haga de forma manual.
         */
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Elija una opcion:\n1 - Caso de prueba interno\n2 - Ingresar manualmente los numeros a ordenar", "", JOptionPane.PLAIN_MESSAGE));
        
        /**
         * Si la opcion es 1, lo hara de forma manual, de lo contrario, le 
         * solicitara los datos al usuario uno a uno hasta completar los diez numeros
         * necesarios para el arreglo.
         */
        if(opcion == 1)
        {
            arregloDatos = new int[]{58, 12, 0, 98, 30, 2, 7, 41, 45, 19};
            numeros = new ArrayList<>();
            
            /**
             * for mejorado para copiar los datos del arreglo en el ArrayList
             * numeros.
             */
            for(int n : arregloDatos)
            {
                numeros.add(n);
            }
        }
        else
        {
            /**
             * Pide los datos al usuario
             */
            insertarDatos();
        }
        
        /**
         * Reinicia el arreglo a los datos insertados originalmente, es decir,
         * los desordena de nuevo.
         */
        reiniciar();
        setLocationRelativeTo(null);
    }//Fin del constructor.
    
    /**
     * Vuelve los datos del arregloDatos a su origen, es decir, de manera desordenada
     * usando el Arraylist.
     */
    public void reiniciarArreglo()
    {
        int tamanio = numeros.size();
        
        for(int i=0; i<tamanio; i++)
        {
            arregloDatos[i] = numeros.get(i);
        }
    }//Fin del metodo reiniciarArreglo.
    
    /**
     * Solicita los datos al usuario uno por uno, hasta completar los diez. Los
     * datos seran los que los algoritmos usaran para ordenar.
     */
    public void insertarDatos()
    {
        /**
         * Inicializa el arreglo y el ArrayList.
         */
        arregloDatos = new int[10];
        numeros = new ArrayList<>();
        
        /**
         * Obtiene el tamano del arreglo de datos, que es de 10 elementos.
         */
        int tamanio = arregloDatos.length;
        
        /**
         * Variable que aumenta conforme el usuario ingrese los datos.
         */
        int inserta = 0;
        
        /**
         * Ciclo que se repetira hasta que todos los datos esten insertados
         * dentro del arreglo.
         */
        while(inserta < tamanio)
        {
            /**
             * Bloque try-catch para procesar si el usuario ingresa una letra en vez de un numero entero,
             * y el programa no falle y pueda seguir su ejecucion normalmente.
             */
            try
            {
                /**
                 * Solicita los datos al usuario, los agrega al ArrayList y aumenta
                 * la variable inserta en 1, pero cabe decir, que si el dato
                 * ingresado por el usuario esta mal, no se agregara al ArrayList
                 * ni se aumentara la variable inserta. Esto para poder volver
                 * a solicitar el dato ya agregarlo correctamente.
                 */
                arregloDatos[inserta] = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato #" + (inserta+1), "", JOptionPane.PLAIN_MESSAGE));
                numeros.add(arregloDatos[inserta]);
                inserta++;
            }
            catch(NumberFormatException exception)
            {
                JOptionPane.showMessageDialog(null, "Ha ingresado un numero incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//Fin del metodo insertarDatos.
    
    /**
     * Limpia el grupo de botones, para que se pueda seleccionar otra opcion, 
     * ademas reinicia el arreglo de datos.
     */
    public void reiniciar()
    {
        grupoBotones.clearSelection();
        reiniciarArreglo();
    }//Fin del metodo reiniciar.
    
    /**
     * Devuelve el arreglo de datos que contiene los numeros enteros ingresados 
     * por el usuario.
     * @return el arreglo de los datos.
     */
    public int[] devolverArreglo()
    {
        return arregloDatos;
    }//Fin del metodo devolverArreglo.
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotones = new javax.swing.ButtonGroup();
        label_Titulo = new javax.swing.JLabel();
        radioBoton_Intercambio = new javax.swing.JRadioButton();
        radioBoton_Seleccion = new javax.swing.JRadioButton();
        radioBoton_Shell = new javax.swing.JRadioButton();
        radioBoton_Merge = new javax.swing.JRadioButton();
        radioBoton_Quicksort = new javax.swing.JRadioButton();
        btn_Ver = new javax.swing.JButton();
        radioBoton_Burbuja = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_Titulo.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        label_Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_Titulo.setText("Elija el algoritmo que desea ver");

        grupoBotones.add(radioBoton_Intercambio);
        radioBoton_Intercambio.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        radioBoton_Intercambio.setText("Intercambio");

        grupoBotones.add(radioBoton_Seleccion);
        radioBoton_Seleccion.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        radioBoton_Seleccion.setText("Seleccion");

        grupoBotones.add(radioBoton_Shell);
        radioBoton_Shell.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        radioBoton_Shell.setText("Shell");

        grupoBotones.add(radioBoton_Merge);
        radioBoton_Merge.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        radioBoton_Merge.setText("Merge");

        grupoBotones.add(radioBoton_Quicksort);
        radioBoton_Quicksort.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        radioBoton_Quicksort.setText("Quicksort");

        btn_Ver.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        btn_Ver.setText("Ver algoritmo");
        btn_Ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VerActionPerformed(evt);
            }
        });

        grupoBotones.add(radioBoton_Burbuja);
        radioBoton_Burbuja.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        radioBoton_Burbuja.setText("Burbuja");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label_Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioBoton_Burbuja)
                            .addComponent(radioBoton_Seleccion)
                            .addComponent(radioBoton_Intercambio)
                            .addComponent(radioBoton_Shell)
                            .addComponent(radioBoton_Merge)
                            .addComponent(radioBoton_Quicksort)
                            .addComponent(btn_Ver))
                        .addGap(0, 150, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(label_Titulo)
                .addGap(18, 18, 18)
                .addComponent(radioBoton_Intercambio)
                .addGap(18, 18, 18)
                .addComponent(radioBoton_Seleccion)
                .addGap(18, 18, 18)
                .addComponent(radioBoton_Shell)
                .addGap(18, 18, 18)
                .addComponent(radioBoton_Merge)
                .addGap(18, 18, 18)
                .addComponent(radioBoton_Quicksort)
                .addGap(18, 18, 18)
                .addComponent(radioBoton_Burbuja)
                .addGap(18, 18, 18)
                .addComponent(btn_Ver)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja el evento del boton 'Ver algoritmo', y controla cual JRadioButton
     * esta seleccionado para mostrar la ventana que corresponde a la opcion.
     * @param evt 
     */
    private void btn_VerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VerActionPerformed
        if(radioBoton_Intercambio.isSelected())
        {
            FRM_Intercambio intercambio = new FRM_Intercambio(this, true);
            intercambio.setVisible(true);
        }
        if(radioBoton_Seleccion.isSelected())
        {
            FRM_Seleccion seleccion = new FRM_Seleccion(this, true);
            seleccion.setVisible(true);
        }
        if(radioBoton_Quicksort.isSelected())
        {
//            FRM_Quicksort quicksort = new FRM_Quicksort(this, true);
//            quicksort.setVisible(true);
            FRM_VentanaQuicksort quicksort = new FRM_VentanaQuicksort(this);
            quicksort.setVisible(true);
        }
        if(radioBoton_Shell.isSelected())
        {
            FRM_Shell shell = new FRM_Shell(this, true);
            shell.setVisible(true);
        }
        if(radioBoton_Merge.isSelected())
        {
            
        }
        if(radioBoton_Burbuja.isSelected())
        {
            FRM_Burbuja burbuja = new FRM_Burbuja(this, true);
            burbuja.setVisible(true);
        }
    }//GEN-LAST:event_btn_VerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FRM_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRM_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRM_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRM_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRM_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Ver;
    private javax.swing.ButtonGroup grupoBotones;
    private javax.swing.JLabel label_Titulo;
    private javax.swing.JRadioButton radioBoton_Burbuja;
    private javax.swing.JRadioButton radioBoton_Intercambio;
    private javax.swing.JRadioButton radioBoton_Merge;
    private javax.swing.JRadioButton radioBoton_Quicksort;
    private javax.swing.JRadioButton radioBoton_Seleccion;
    private javax.swing.JRadioButton radioBoton_Shell;
    // End of variables declaration//GEN-END:variables
}
