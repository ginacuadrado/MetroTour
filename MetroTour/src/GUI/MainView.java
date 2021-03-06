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
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

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
    public static JTextField text3[][];
    
    public MainView(int recursos[], int maximos[][]) 
    {
        //Inicialización de matrices recursos, máximos y asignación
        this.recursos = recursos;   
        this.maximos = maximos;
        this.asignacion = maximos;  //Inicialmente la asignación será igual a máximos
  
        initComponents();
        
        //JTextFields para rellenar la matriz de requerimientos máximos
        this.text = new JTextField[getFilas()-1][getColumnas()-1];
        this.text3 = new JTextField[getFilas()-1][getColumnas()-1];
              
        //Formateo de los JTextFields dentro de un JPanel con sus respectivas etiquetas
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
        
        for (int i = 0; i < getFilas(); i++) {
            for(int j = 0; j < getColumnas(); j++){
                if(i==0){
                    if(j==0){
                        JLabel vacio = new JLabel(" ");
                        jPanel3.add(vacio);
                    } else {
                        JLabel ruta = new JLabel("Ruta "+j);
                        ruta.setFont(new java.awt.Font("Segoe UI Symbol", 1, 9));
                        jPanel3.add(ruta);
                    }
                }else{
                    if(j!=0){
                        text3[i-1][j-1] = new JTextField("0");
                        text3[i-1][j-1].setEditable(false);
                        jPanel3.add(text3[i-1][j-1]);
                    }else{
                        JLabel orden = new JLabel("Orden "+i);
                        orden.setFont(new java.awt.Font("Segoe UI Symbol", 1, 9));
                        jPanel3.add(orden);
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
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        orden = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Close = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        zBackground3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(50, 50));
        setMinimumSize(new java.awt.Dimension(1050, 550));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        jButton1.setBackground(new java.awt.Color(255, 204, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("EJECUTAR ORDENES");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(90, 480, 210, 25);

        jButton2.setBackground(new java.awt.Color(255, 204, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("REPETIR PROCESO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(710, 480, 210, 25);

        jLabel10.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel10.setText("camiones aleatoriamente.");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(370, 300, 270, 70);

        jLabel11.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel11.setText("Nota:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(370, 220, 150, 70);

        jLabel12.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel12.setText("Si hay muchas órdenes y dependiendo de");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(370, 240, 300, 70);

        jLabel13.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel13.setText("la cantidad de camiones disponibles, es");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(370, 260, 300, 70);

        jLabel14.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel14.setText("posible que se tarde un poco en asignar");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(370, 280, 300, 70);

        orden.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        orden.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(orden);
        orden.setBounds(220, 480, 580, 70);

        jLabel9.setBackground(new java.awt.Color(255, 204, 0));
        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel9.setText("Orden de ejecución obtenido:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(390, 420, 240, 70);

        jLabel8.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel8.setText("para obtener el orden de ejecución.");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(670, 180, 330, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LogoMini.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(410, 0, 210, 190);

        jLabel5.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel5.setText("necesarios para completar la orden:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 180, 330, 20);

        jLabel7.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel7.setText("Asigne cantidad de camiones por ruta ");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 160, 330, 20);

        jLabel15.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel15.setText("Asignación aleatoria inicial de camiones");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(670, 160, 330, 20);

        jLabel6.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel6.setText("Asigne los camiones totales por cada ruta:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 40, 330, 20);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/gabarro22795.gif"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(380, 430, 250, 50);

        Close.setBackground(new java.awt.Color(255, 204, 0));
        Close.setText("Cerrar");
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });
        getContentPane().add(Close);
        Close.setBounds(950, 10, 80, 30);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setLayout(new java.awt.GridLayout(2, getColumnas()));
        getContentPane().add(jPanel2);
        jPanel2.setBounds(30, 70, 330, 70);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setLayout(new java.awt.GridLayout(getFilas(), getColumnas()));
        getContentPane().add(jPanel1);
        jPanel1.setBounds(30, 210, 330, 250);

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setLayout(new java.awt.GridLayout(getFilas(), getColumnas()));
        getContentPane().add(jPanel3);
        jPanel3.setBounds(670, 210, 320, 250);

        zBackground3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background.jpg"))); // NOI18N
        getContentPane().add(zBackground3);
        zBackground3.setBounds(10, -180, 1290, 930);

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
            }}
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
          
        //Cerrar ejecución del sistema
            int n=0;
            System.exit(n);
    }//GEN-LAST:event_CloseActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        //Botón que permite reiniciar el proceso
        
        this.jButton1.setEnabled(true);
                
                for(int i = 0; i < this.text.length; i++){
                    for(int j = 0; j < this.text[0].length; j++){
                        this.text[i][j].setEditable(true);
                    }
                }
                
                for(int i = 0; i < this.text2.length; i++){
                    this.text2[i].setEditable(true);
                }
                
                orden.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JButton Close;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JLabel orden;
    private javax.swing.JLabel zBackground3;
    // End of variables declaration//GEN-END:variables
}
