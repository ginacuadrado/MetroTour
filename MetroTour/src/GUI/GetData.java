
package GUI;

import static javax.swing.JOptionPane.showMessageDialog;


public class GetData extends javax.swing.JFrame {
 
    public GetData() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Enunciado = new javax.swing.JLabel();
        RutasEmpresa = new javax.swing.JTextField();
        PedidosRealizar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Siguiente = new javax.swing.JButton();
        Logo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Close = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingresar Datos");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.white);
        setLocation(new java.awt.Point(200, 200));
        setMaximumSize(new java.awt.Dimension(600, 450));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(600, 450));
        setResizable(false);
        getContentPane().setLayout(null);

        Enunciado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Enunciado.setText("Antes de iniciar, ingrese los siguientes datos:");
        getContentPane().add(Enunciado);
        Enunciado.setBounds(20, 180, 440, 22);

        RutasEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RutasEmpresaActionPerformed(evt);
            }
        });
        getContentPane().add(RutasEmpresa);
        RutasEmpresa.setBounds(330, 250, 220, 30);

        PedidosRealizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PedidosRealizarActionPerformed(evt);
            }
        });
        getContentPane().add(PedidosRealizar);
        PedidosRealizar.setBounds(330, 300, 220, 30);

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel2.setText("Cantidad de pedidos a realizar:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 300, 330, 20);

        Siguiente.setBackground(new java.awt.Color(255, 204, 0));
        Siguiente.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        Siguiente.setForeground(new java.awt.Color(255, 255, 255));
        Siguiente.setText("SIGUIENTE");
        Siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiguienteActionPerformed(evt);
            }
        });
        getContentPane().add(Siguiente);
        Siguiente.setBounds(230, 350, 140, 40);

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dust Road Co..png"))); // NOI18N
        getContentPane().add(Logo);
        Logo.setBounds(150, -10, 300, 200);

        jLabel5.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel5.setText("Cantidad de rutas de la empresa:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 250, 330, 20);

        jLabel3.setText("(Mínimo 2, Máximo 6)");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 320, 160, 14);

        Close.setBackground(new java.awt.Color(255, 204, 0));
        Close.setText("Cerrar");
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });
        getContentPane().add(Close);
        Close.setBounds(520, 0, 80, 30);

        jLabel4.setText("(Mínimo 2, Máximo 6)");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 270, 160, 14);

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/WhiteBackground.jpg"))); // NOI18N
        Background.setText("jLabel7");
        Background.setMaximumSize(new java.awt.Dimension(600, 450));
        Background.setMinimumSize(new java.awt.Dimension(600, 450));
        Background.setPreferredSize(new java.awt.Dimension(600, 450));
        getContentPane().add(Background);
        Background.setBounds(-10, -10, 620, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RutasEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RutasEmpresaActionPerformed

                 
    }//GEN-LAST:event_RutasEmpresaActionPerformed

    private void SiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguienteActionPerformed
    
            String rutas = RutasEmpresa.getText().trim();
            String pedidos = PedidosRealizar.getText().trim();
                   
         
            //Validación si el jtext field está vacío o contiene alguna caracter diferente de números
            if(rutas.equals("")||pedidos.equals("")||!rutas.matches("\\d+")||!pedidos.matches("\\d+"))
            {
                showMessageDialog(null,"Los datos ingresados no pueden ser utilizados");
                RutasEmpresa.setText(null);
                PedidosRealizar.setText(null);
            }
            
            else
            {
               //Convierto en int para comparar valores numéricos
                int a = Integer.parseInt(rutas);
                int b = Integer.parseInt(pedidos);
                
                //Validación mínimo 2 y máximo 6 de cada campo
                if(a<=1||a>7||b>7||b<=1)
                {
                    showMessageDialog(null,"Por favor solo ingrese datos numéricos enteros entre 1 y 6 en cada campo");
                    RutasEmpresa.setText(null);
                    PedidosRealizar.setText(null); 
                }
                else
                {
                    setVisible(false);  //Oculta la vista getData
                    
                    int recursos[] = new int[a];         
                    int maximos[][] = new int[b][a]; 
                    
                   //Abrir MainView que realizará las operaciones
                    MainView mv = new MainView(recursos,maximos);
                    mv.setVisible(true);
                    
                }
            }
  
       
    }//GEN-LAST:event_SiguienteActionPerformed

    private void PedidosRealizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PedidosRealizarActionPerformed
       
    }//GEN-LAST:event_PedidosRealizarActionPerformed

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        int n=0;
        System.exit(n);
    }//GEN-LAST:event_CloseActionPerformed
    

    
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
            java.util.logging.Logger.getLogger(GetData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GetData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GetData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GetData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GetData().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton Close;
    private javax.swing.JLabel Enunciado;
    private javax.swing.JLabel Logo;
    private javax.swing.JTextField PedidosRealizar;
    private javax.swing.JTextField RutasEmpresa;
    private javax.swing.JButton Siguiente;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables

   
}
