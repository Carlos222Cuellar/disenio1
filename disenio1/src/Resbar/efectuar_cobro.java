
import Resbar.ControladorAgregarOrden;
import conexion.Conector;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carlos
 */
public class efectuar_cobro extends javax.swing.JFrame {

    /**
     * Creates new form efectuar_cobro
     */
    
       ControladorAgregarOrden agregarorden = new ControladorAgregarOrden();
       String ordennn;
    public efectuar_cobro(String total,String id) {
         
        initComponents();
        txtTotal.setText(total);
        ordennn=id;
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/imagenrestaurante.png")).getImage());
        this.setTitle("Efectuar Cobro");
         this.setLocationRelativeTo(null);
    }
    
    
    
      public void imprimir(){
          
         
                 int idd=Integer.parseInt(ordennn);
                   
       


             Conector cnt = new Conector();
        
            
                
             
         try {
             JasperReport reporte= (JasperReport) JRLoader.loadObject("ticket.jasper");
                 Map parametro = new HashMap(); //Un objeto que mapea claves a los valores
                  parametro.put("id",idd);
                  
                  JasperPrint j= JasperFillManager.fillReport(reporte, parametro, cnt.getConexion());
                  JasperViewer jv= new JasperViewer(j,false);
                  jv.setTitle("ticketes");
                  jv.setVisible(true);
                  
             
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"error al mostrar el reporte"+e);
         }  
     
        
         
         
         
             
           
          
          } 
    

    public void mostrar(){
           
          
        
          final exito_de_cobro cobro=new exito_de_cobro(txtTotal.getText(),txtefectivo.getText(),txtcambio.getText());
       cobro.setVisible(true);
          Timer timer=new Timer();
          TimerTask task=new TimerTask(){
              
          @Override
          public void run(){
             
          cobro.setVisible(false);
          }
          };
          timer.schedule(task, 5000);
          this.dispose();
          }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtefectivo = new javax.swing.JTextField();
        txtcambio = new javax.swing.JTextField();
        btncobrar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        lblmensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("Total");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, -1));

        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("Efectivo");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("Cambio");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, -1));

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(0, 255, 204));
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 80, -1));

        txtefectivo.setBackground(new java.awt.Color(0, 255, 204));
        txtefectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtefectivoKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtefectivoKeyReleased(evt);
            }
        });
        jPanel1.add(txtefectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 80, -1));

        txtcambio.setEditable(false);
        txtcambio.setBackground(new java.awt.Color(0, 255, 204));
        jPanel1.add(txtcambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 80, -1));

        btncobrar.setBackground(new java.awt.Color(102, 204, 102));
        btncobrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pagar2.png"))); // NOI18N
        btncobrar.setText("Efectuar Cobro");
        btncobrar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btncobrarMouseMoved(evt);
            }
        });
        btncobrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btncobrarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btncobrarMouseEntered(evt);
            }
        });
        btncobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncobrarActionPerformed(evt);
            }
        });
        jPanel1.add(btncobrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 190, 50));

        btnsalir.setBackground(new java.awt.Color(102, 204, 102));
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dispose.png"))); // NOI18N
        btnsalir.setText("Cancelar");
        btnsalir.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnsalirMouseMoved(evt);
            }
        });
        btnsalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnsalirMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnsalirMouseEntered(evt);
            }
        });
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 150, 50));

        lblmensaje.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(lblmensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 260, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncobrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncobrarMouseEntered
        // TODO add your handling code here:
           btncobrar.setBackground(new Color(0,204,51));//cambia el color del boton cuando paso el puntero sobre el boton
    }//GEN-LAST:event_btncobrarMouseEntered

    private void btncobrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncobrarMouseExited
        // TODO add your handling code here:
           btncobrar.setBackground(new Color(102,204,102));//cambia el color del boton cuando paso el puntero sobre el boton
    }//GEN-LAST:event_btncobrarMouseExited

    private void btncobrarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncobrarMouseMoved
        // TODO add your handling code here:
         String texto="Cobrar";
btncobrar.setToolTipText(texto);//el metodo setToolTipTex hace que cuando pongo el puntero del raton sobre el boton muestre el nombre del boton
  
    }//GEN-LAST:event_btncobrarMouseMoved

    private void btnsalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsalirMouseEntered
        // TODO add your handling code here:
        btnsalir.setBackground(new Color(0,204,51));//cambia el color del boton cuando paso el puntero sobre el boton
    }//GEN-LAST:event_btnsalirMouseEntered

    private void btnsalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsalirMouseExited
        // TODO add your handling code here:
        btnsalir.setBackground(new Color(102,204,102));//cambia el color del boton cuando paso el puntero sobre el boton
    }//GEN-LAST:event_btnsalirMouseExited

    private void btnsalirMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsalirMouseMoved
        // TODO add your handling code here:
        String texto="Salir";
        btnsalir.setToolTipText(texto);//el metodo setToolTipTex hace que cuando pongo el puntero del raton sobre el boton muestre el nombre del boton
  
    }//GEN-LAST:event_btnsalirMouseMoved

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        int valor=JOptionPane.showConfirmDialog(null, "Realmente desea cancelar el cobro?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(valor==0){
            this.dispose();
            cobrar_orden cobrar=new cobrar_orden(0,"","","");
            cobrar.setVisible(false);
        }else{
        
        }
        
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btncobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncobrarActionPerformed
        // TODO add your handling code here:
        mostrar();
         String estado="I";
           
            imprimir();
            agregarorden.cambiarestadoorden(ordennn, estado);
            
          
    }//GEN-LAST:event_btncobrarActionPerformed

    private void txtefectivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtefectivoKeyTyped
        // TODO add your handling code here:
         char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != '.') && (caracter != '/') && (caracter != '-')) {
            evt.consume();
        } else if (((caracter > '0') || (caracter < '9'))) {
            evt.consume();
            txtefectivo.setText(txtefectivo.getText() + String.valueOf(caracter));
        }
    }//GEN-LAST:event_txtefectivoKeyTyped

    private void txtefectivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtefectivoKeyReleased
        // TODO add your handling code here:
        double total1=Double.parseDouble(txtTotal.getText());
        double efectivo=Double.parseDouble(txtefectivo.getText());
        if(efectivo>total1){
        double total2=efectivo-total1;
        txtcambio.setText(String.valueOf(total2));
        }else{
        JOptionPane.showMessageDialog(null," el efectivo no puede ser menor al total");
        }
    }//GEN-LAST:event_txtefectivoKeyReleased

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
            java.util.logging.Logger.getLogger(efectuar_cobro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(efectuar_cobro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(efectuar_cobro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(efectuar_cobro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new efectuar_cobro("","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncobrar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblmensaje;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtcambio;
    private javax.swing.JTextField txtefectivo;
    // End of variables declaration//GEN-END:variables
}
