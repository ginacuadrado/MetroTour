/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author pc ready
 */
public class MainView extends javax.swing.JFrame {

    //Declaración de las matrices
    int recursos[], maximos[][];
    int disponibles[],asignacion[][];
    
    public MainView(int recursos[], int maximos[][]) 
    {
        //Inicialización de matrices
        this.recursos= recursos;
        this.maximos= maximos;
        this.disponibles= recursos;
        this.asignacion=maximos;
  
        initComponents();
        
        //JTextFields para rellenar la matriz de requerimientos máximos
        JTextField text[][] = new JTextField[getFilas()-1][getColumnas()-1];
              
        //Formateo de los JTextFields dentro de un JPanel con etiquetas
        for (int i = 0; i < getFilas(); i++) {
            for(int j = 0; j < getColumnas(); j++){
                if(i==0){
                    if(j==0){
                        JLabel vacio = new JLabel(" ");
                        jPanel1.add(vacio);
                    } else {
                        JLabel ruta = new JLabel("Ruta "+j);
                        ruta.setFont(new java.awt.Font("Segoe UI Symbol", 1, 9));
                        jPanel1.add(ruta);
                    }
                }else{
                    if(j!=0){
                        text[i-1][j-1] = new JTextField("("+(i-1)+","+(j-1)+")");
                        jPanel1.add(text[i-1][j-1]);
                    }else{
                        JLabel orden = new JLabel("Orden "+i);
                        orden.setFont(new java.awt.Font("Segoe UI Symbol", 1, 9));
                        jPanel1.add(orden);
                    }
                }
            }
        }
        
        JTextField text2[] = new JTextField[getColumnas()-1];
        
        for (int i = 0; i < 2; i++) {
            for(int j = 0; j < getColumnas(); j++){
                if(i==0){
                    if(j==0){
                        JLabel vacio = new JLabel(" ");
                        jPanel2.add(vacio);
                    } else {
                        JLabel ruta = new JLabel("Ruta "+j);
                        ruta.setFont(new java.awt.Font("Segoe UI Symbol", 1, 9));
                        jPanel2.add(ruta);
                    }
                }else{
                    if(j!=0){
                        text2[i-1] = new JTextField(""+(i-1));
                        jPanel2.add(text2[i-1]);
                    }else{
                        JLabel camiones = new JLabel("Camiones");
                        camiones.setFont(new java.awt.Font("Segoe UI Symbol", 1, 8));
                        jPanel2.add(camiones);
                    }
                }
            }
        }
                    
        
        revalidate();
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        zBackground = new javax.swing.JLabel();
        zBackground1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dust Road Co..png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(420, -50, 320, 190);

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));
        jPanel2.setLayout(new java.awt.GridLayout(2, getColumnas()));
        getContentPane().add(jPanel2);
        jPanel2.setBounds(60, 180, 330, 70);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));
        jPanel1.setLayout(new java.awt.GridLayout(getFilas(), getColumnas()));
        getContentPane().add(jPanel1);
        jPanel1.setBounds(60, 290, 330, 250);

        zBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/WhiteBackground.jpg"))); // NOI18N
        getContentPane().add(zBackground);
        zBackground.setBounds(190, 0, 1360, 650);

        zBackground1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/WhiteBackground.jpg"))); // NOI18N
        getContentPane().add(zBackground1);
        zBackground1.setBounds(-30, -10, 1140, 650);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() 
            {
                
            }
        });
    }
    
    public int getColumnas() {
         return this.maximos[0].length+1;
    }
    
     public int getFilas() {
        return this.maximos.length+1;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel zBackground;
    private javax.swing.JLabel zBackground1;
    // End of variables declaration//GEN-END:variables
}
