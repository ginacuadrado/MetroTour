/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controllers.Algoritmo;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author pc ready
 */
public class MainView extends javax.swing.JFrame {

    //Declaración de las matrices
    private int recursos[], maximos[][];
    private int asignacion[][];
    public static JTextField text[][];
    public static JTextField text2[];
    
    public MainView(int recursos[], int maximos[][]) 
    {
        //Inicialización de matrices
        this.recursos = recursos;
        this.maximos = maximos;
        this.asignacion = maximos;
  
        initComponents();
        
        //JTextFields para rellenar la matriz de requerimientos máximos
        this.text = new JTextField[getFilas()-1][getColumnas()-1];
              
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
                        text[i-1][j-1] = new JTextField("0");
                        jPanel1.add(text[i-1][j-1]);
                    }else{
                        JLabel orden = new JLabel("Orden "+i);
                        orden.setFont(new java.awt.Font("Segoe UI Symbol", 1, 9));
                        jPanel1.add(orden);
                    }
                }
            }
        }
        
        //JTextField para rellenar el vector de recursos (camiones)
        this.text2 = new JTextField[getColumnas()-1];
        
        //Formateo de los JTextFields dentro de un JPanel con etiquetas
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
                        text2[j-1] = new JTextField("0");
                        jPanel2.add(text2[j-1]);
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

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        zBackground = new javax.swing.JLabel();
        zBackground1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(923, 1200));
        setResizable(false);
        getContentPane().setLayout(null);

        jButton1.setText("Ejecutar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(190, 560, 73, 23);

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        //Variable local de control
        int check = 0;
        String temp;
        boolean check1 = true, check2 = true;
        
        //Validación de que el contenido de la matriz sea solo dígitos
        for(int i = 0; i < this.text.length; i++){
            for (int j = 0; j < this.text[0].length; j++){
                
                temp = this.text[i][j].getText();
                
                if((temp.equals(""))||!(temp.matches("\\d+"))){
                    if(check == 0){
                        check++;
                        check1 = false;
                    }
                    this.text[i][j].setText("0");
                }
            }
        }
        
        //Validación de que el contenido del vector sea solo dígitos
        for(int i = 0; i < this.text2.length; i++){
            temp = this.text2[i].getText();
            
            if((temp.equals(""))||!(temp.matches("\\d+"))){
                if(check <= 1){
                    check++;
                    check2 = false;
                }
                this.text2[i].setText("0");
            }
        }
        
        //Mensaje de error en caso de que algun dato no sea valido
        if(check >= 1){
            showMessageDialog(null,"Los datos ingresados tienen que ser exclusivamente números enteros positivos ó 0");
        }
        
        //Si se cumplen ambas condiciones, continuar con la ejecucion
        if(check1 && check2){
            //Bloquear boton para evitar que se active la funcion en medio de la ejecucion
            this.jButton1.setEnabled(false);
            
            //Bloquear los jTextFields del vector y la matriz para evitar que se alteren os valores en medio de la
            //ejecucion por causa de un input de usuario
            
            for(int i = 0; i < this.text.length; i++){
                for(int j = 0; j < this.text[0].length; j++){
                    this.text[i][j].setEditable(false);
                    
                    //Pasar el valor contenido en el jTextField [i][j] a su respectiva ubicacion [i][j] dentro de
                    //la matriz maxima
                    this.maximos[i][j] = Integer.parseInt(text[i][j].getText());
                }
            }
            
            for(int i = 0; i < this.text2.length; i++) {
                this.text2[i].setEditable(false);
                
                //Pasar el valor contenido en el jTextField [i] a su respectiva ubicación [i] dentro
                //del vector de recursos
                this.recursos[i] = Integer.parseInt(text2[i].getText());
            }
            
            //Validacion para que los valores maximos no superen la cantidad de tipos de recursos existentes
            //String para almacenar errores en la asignacion de maximos
            String msg = "";
            
            for(int j = 0; j < this.recursos.length; j++){
                for(int i = 0; i < this.maximos.length; i++){
                    if(this.recursos[j] < this.maximos[i][j]){
                        msg = msg + "\n• El número de camiones asignados en la Ruta "+(j+1)+" para la Orden "+(i+1)+" supera el máximo disponible.";
                        check++;
                    }
                }
            }
            
            //Si se consiguen errores en la cantidad de tipos de recurso asignados, se reportan los errores y se
            //vuelven a habilitar los campos, de lo contrario se prosigue con la ejecucion del algoritmo.
            if(check == 0){
                this.asignacion = this.maximos;
                Algoritmo banquero =  new Algoritmo(this.maximos, this.asignacion, this.recursos);
            } else {
                showMessageDialog(null,"Se han encontrado los siguientes errores:" + msg);
                this.jButton1.setEnabled(true);
                
                for(int i = 0; i < this.text.length; i++){
                    for(int j = 0; j < this.text[0].length; j++){
                        this.text[i][j].setEditable(true);
                    }
                }
                
                for(int i = 0; i < this.text2.length; i++){
                    this.text2[i].setEditable(true);
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel zBackground;
    private javax.swing.JLabel zBackground1;
    // End of variables declaration//GEN-END:variables
}
