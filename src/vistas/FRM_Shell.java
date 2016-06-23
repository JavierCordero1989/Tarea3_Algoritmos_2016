/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import hilos.Hilo_Ejecucion;
import javax.swing.JLabel;

/**
 *
 * @author Javi Cordero
 */
public class FRM_Shell extends javax.swing.JDialog {

    private FRM_Principal principal;
    private int[] arregloDatos;
    private Hilo_Ejecucion hilo;
    private JLabel[] arregloEtiquetas;
    
    /**
     * Creates new form FRM_Shell
     */
    public FRM_Shell(FRM_Principal principal, boolean modal) 
    {
        super(principal, modal);
        initComponents();
        
        setTitle("Algoritmo de ordenamiento de Shell");
        setLocationRelativeTo(null);
        this.principal = principal;
        arregloDatos = principal.devolverArreglo();
        
        llenarArregloEtiquetas();
        cambiarTextos();
        
        label_mensaje.setVisible(false);
        hilo = new Hilo_Ejecucion(this, arregloDatos, arregloEtiquetas);
        
        hilo.start();
    }//Fin del constructor.
    
    public void mostrarMensaje()
    {
        label_mensaje.setVisible(true);
    }
    
    public void llenarArregloEtiquetas()
    {
        int tamanio = arregloDatos.length;
        arregloEtiquetas = new JLabel[tamanio];
        
        arregloEtiquetas[0] = arreglo_0;
        arregloEtiquetas[1] = arreglo_1;
        arregloEtiquetas[2] = arreglo_2;
        arregloEtiquetas[3] = arreglo_3;
        arregloEtiquetas[4] = arreglo_4;
        arregloEtiquetas[5] = arreglo_5;
        arregloEtiquetas[6] = arreglo_6;
        arregloEtiquetas[7] = arreglo_7;
        arregloEtiquetas[8] = arreglo_8;
        arregloEtiquetas[9] = arreglo_9;
    }
    
    public void cambiarTextos()
    {
        int tamanio = arregloDatos.length;
        
        for(int contador=0; contador<tamanio; contador++)
        {
            arregloEtiquetas[contador].setText("" + arregloDatos[contador]);
        }
    }//Fin del metodo llenarArregloEtiquetas.

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        arreglo_0 = new javax.swing.JLabel();
        arreglo_1 = new javax.swing.JLabel();
        arreglo_2 = new javax.swing.JLabel();
        arreglo_3 = new javax.swing.JLabel();
        arreglo_4 = new javax.swing.JLabel();
        arreglo_5 = new javax.swing.JLabel();
        arreglo_6 = new javax.swing.JLabel();
        arreglo_7 = new javax.swing.JLabel();
        arreglo_8 = new javax.swing.JLabel();
        arreglo_9 = new javax.swing.JLabel();
        label_mensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        arreglo_0.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        arreglo_0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        arreglo_0.setText("X");
        arreglo_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        arreglo_0.setOpaque(true);

        arreglo_1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        arreglo_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        arreglo_1.setText("X");
        arreglo_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        arreglo_1.setOpaque(true);

        arreglo_2.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        arreglo_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        arreglo_2.setText("X");
        arreglo_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        arreglo_2.setOpaque(true);

        arreglo_3.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        arreglo_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        arreglo_3.setText("X");
        arreglo_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        arreglo_3.setOpaque(true);

        arreglo_4.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        arreglo_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        arreglo_4.setText("X");
        arreglo_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        arreglo_4.setOpaque(true);

        arreglo_5.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        arreglo_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        arreglo_5.setText("X");
        arreglo_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        arreglo_5.setOpaque(true);

        arreglo_6.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        arreglo_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        arreglo_6.setText("X");
        arreglo_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        arreglo_6.setOpaque(true);

        arreglo_7.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        arreglo_7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        arreglo_7.setText("X");
        arreglo_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        arreglo_7.setOpaque(true);

        arreglo_8.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        arreglo_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        arreglo_8.setText("X");
        arreglo_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        arreglo_8.setOpaque(true);

        arreglo_9.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        arreglo_9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        arreglo_9.setText("X");
        arreglo_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        arreglo_9.setOpaque(true);

        label_mensaje.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        label_mensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_mensaje.setText("Ha concluido el algoritmo de Shell");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(arreglo_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(arreglo_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(arreglo_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(arreglo_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(arreglo_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(arreglo_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(arreglo_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(arreglo_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(arreglo_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(arreglo_9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label_mensaje, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(arreglo_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arreglo_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arreglo_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arreglo_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arreglo_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arreglo_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arreglo_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arreglo_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arreglo_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arreglo_9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(232, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(142, 142, 142)
                    .addComponent(label_mensaje)
                    .addContainerGap(142, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        principal.reiniciar();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel arreglo_0;
    private javax.swing.JLabel arreglo_1;
    private javax.swing.JLabel arreglo_2;
    private javax.swing.JLabel arreglo_3;
    private javax.swing.JLabel arreglo_4;
    private javax.swing.JLabel arreglo_5;
    private javax.swing.JLabel arreglo_6;
    private javax.swing.JLabel arreglo_7;
    private javax.swing.JLabel arreglo_8;
    private javax.swing.JLabel arreglo_9;
    private javax.swing.JLabel label_mensaje;
    // End of variables declaration//GEN-END:variables
}
