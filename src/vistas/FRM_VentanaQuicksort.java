/**
 * Tarea #3: algoritmos de ordenamiento.
 * Integrantes: Llasuara Peraza, Alexandra Elizondo y Javier Cordero.
 * Profesor: Juan Carlos Arias.
 * Curso: Algoritmos y estructuras de datos.
 * Universidad de Costa Rica - Sede el Pacifico Arnoldo Ferreto Segura.
 * I semestre, 2016.
 */
package vistas;

import hilos.Hilo_Ejecucion;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Javi Cordero
 */
public class FRM_VentanaQuicksort extends javax.swing.JFrame {

    JButton botones[]; //Arreglo de botones que tendra los datos del arreglo de datos.
    int datos[]; //Copia del arreglo de datos de la interfaz principal.
    JLabel labels[]; //Arreglo de etiquetas para mostrar las posiciones del arreglo que se ordena.
    private Hilo_Ejecucion hilo; //Hilo de ejecucion que muestra paso a paso los cambios.
    private Color colorOrigen; //color predeterminado de los componentes.
    private FRM_Principal ventanaPrincipal; //instancia de la ventana principal.
    
    /**
     * Creates new form FRM_Ventana
     */
    public FRM_VentanaQuicksort(FRM_Principal ventanaPrincipal) 
    {
        initComponents();
        this.ventanaPrincipal = ventanaPrincipal;
        
        /**
         * Guarda los botones en el arreglo
         */
        botones = new JButton[]{btn_0,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9};
        /**
         * Obtiene la copia del arreglo de la ventana principal.
         */
        datos = ventanaPrincipal.devolverArreglo();
        /**
         * Guarda las etiquetas en el arreglo.
         */
        labels = new JLabel[]{label_0,label_1,label_2,label_3,label_4,label_5,label_6,label_7,label_8,label_9};
        
        /**
         * Situa las etiquetas en las mismas coordenadas X que lso botones.
         */
        int i = 0;
        for(JLabel l : labels)
        {
            l.setText("");
            l.setLocation(botones[i].getX(), l.getY());
            i++;
        }
        
        /**
         * Establece el color por defecto que tienen los botones.
         */
        colorOrigen = new Color(214,217,223);
        
        /**
         * Instancia el hilo y lo inicia.
         */
        hilo = new Hilo_Ejecucion(this, botones, datos);
        hilo.start();
    }

    /**
     * Devuelve el color que contienen los botones por defecto desde el inicio.
     * @return el color por defecto.
     */
    public Color colorOriginal()
    {
        return colorOrigen;
    }
    
    /**
     * Muestra en la etiqueta el pivote que el algoritmo ha seleccionado.
     * @param txt texto a mostrar.
     */
    public void mostrarPivote(String txt)
    {
        label_pivote.setText(txt);
    }
    
    /**
     * Reinicia las etiquetas cambiando su texto a texto vacio, y el color de 
     * los botones a su color original por defecto.
     */
    public void reiniciarTodo()
    {
        for(JLabel l : labels)
        {
            l.setText("");
        }
        for(JButton b : botones)
        {
            b.setBackground(colorOrigen);
            //b.setBackground(colorOriginal());
        }
    }
    
    /**
     * Cambia el texto de las etiquetas en la posicion especificada por parametros.
     * Si i es igual a j, entonces el texto a mostrar sera "i=j".
     * @param i etiqueta 1
     * @param j etiqueta 2
     */
    public void hacerVisibles(int i, int j)
    {
        if(i == j)
        {
            labels[i].setText("i=j");
            labels[i].setVisible(true);
        }
        else
        {
            labels[i].setText("i");
            labels[i].setVisible(true);

            labels[j].setText("j");
            labels[j].setVisible(true);
        }
    }
    
    /**
     * Les cambia el texto a las etiquetas a texto vacio, en las posiciones
     * especificadas por parametros.
     * @param i
     * @param j 
     */
    public void hacerInvisibles(int i, int j)
    {
        labels[i].setText("");
        
        labels[j].setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_0 = new javax.swing.JButton();
        btn_1 = new javax.swing.JButton();
        btn_2 = new javax.swing.JButton();
        btn_3 = new javax.swing.JButton();
        btn_4 = new javax.swing.JButton();
        btn_5 = new javax.swing.JButton();
        btn_6 = new javax.swing.JButton();
        btn_7 = new javax.swing.JButton();
        btn_8 = new javax.swing.JButton();
        btn_9 = new javax.swing.JButton();
        label_pivote = new javax.swing.JLabel();
        label_0 = new javax.swing.JLabel();
        label_1 = new javax.swing.JLabel();
        label_2 = new javax.swing.JLabel();
        label_3 = new javax.swing.JLabel();
        label_4 = new javax.swing.JLabel();
        label_5 = new javax.swing.JLabel();
        label_6 = new javax.swing.JLabel();
        label_7 = new javax.swing.JLabel();
        label_8 = new javax.swing.JLabel();
        label_9 = new javax.swing.JLabel();
        btn_Pausa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        btn_0.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        btn_0.setText("X");

        btn_1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        btn_1.setText("X");

        btn_2.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        btn_2.setText("X");

        btn_3.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        btn_3.setText("X");

        btn_4.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        btn_4.setText("X");

        btn_5.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        btn_5.setText("X");

        btn_6.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        btn_6.setText("X");

        btn_7.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        btn_7.setText("X");

        btn_8.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        btn_8.setText("X");

        btn_9.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        btn_9.setText("X");

        label_pivote.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        label_pivote.setText("Pivote:");

        label_0.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        label_0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_0.setText("X");

        label_1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        label_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_1.setText("X");

        label_2.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        label_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_2.setText("X");

        label_3.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        label_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_3.setText("X");

        label_4.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        label_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_4.setText("X");

        label_5.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        label_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_5.setText("X");

        label_6.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        label_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_6.setText("X");

        label_7.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        label_7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_7.setText("X");

        label_8.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        label_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_8.setText("X");

        label_9.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        label_9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_9.setText("X");

        btn_Pausa.setText("PAUSE");
        btn_Pausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PausaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_pivote)
                                .addGap(88, 88, 88))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_0, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_Pausa)
                                .addGap(82, 82, 82))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(label_5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label_6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(label_7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_0, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(30, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_0, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_0, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Pausa)
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(label_pivote)
                        .addContainerGap(42, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean inPause = false;
    private void btn_PausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PausaActionPerformed
        if(!inPause)
        {
            hilo.suspend();
            inPause = true;
            btn_Pausa.setText("PLAY");
        }
        else
        {
            hilo.resume();
            inPause = false;
            btn_Pausa.setText("PAUSE");
        }
        
    }//GEN-LAST:event_btn_PausaActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if(evt.getKeyCode() == 90)
        {
            hilo.suspend();
        }
        if(evt.getKeyCode() == 88)
        {
            hilo.resume();
        }
    }//GEN-LAST:event_formKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ventanaPrincipal.reiniciar();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_0;
    private javax.swing.JButton btn_1;
    private javax.swing.JButton btn_2;
    private javax.swing.JButton btn_3;
    private javax.swing.JButton btn_4;
    private javax.swing.JButton btn_5;
    private javax.swing.JButton btn_6;
    private javax.swing.JButton btn_7;
    private javax.swing.JButton btn_8;
    private javax.swing.JButton btn_9;
    private javax.swing.JButton btn_Pausa;
    private javax.swing.JLabel label_0;
    private javax.swing.JLabel label_1;
    private javax.swing.JLabel label_2;
    private javax.swing.JLabel label_3;
    private javax.swing.JLabel label_4;
    private javax.swing.JLabel label_5;
    private javax.swing.JLabel label_6;
    private javax.swing.JLabel label_7;
    private javax.swing.JLabel label_8;
    private javax.swing.JLabel label_9;
    private javax.swing.JLabel label_pivote;
    // End of variables declaration//GEN-END:variables
}
