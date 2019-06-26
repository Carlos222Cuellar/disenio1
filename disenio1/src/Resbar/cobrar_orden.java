
import Resbar.controladorproducto;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carlos
 */
public class cobrar_orden extends javax.swing.JFrame {

    /**
     * Creates new form cobrar_orden
     */
    
    DefaultTableModel modeloorden = new DefaultTableModel(){
      //se sobreescribe el metodo
        @Override
         public boolean isCellEditable(int fila, int columna) {
            if(columna==4){
            return true;//retorna true para que las coliumnas se puedan editar solo si son identicas a 4
            }else{
            return false;//si son diferentes a 4 la celda no se podra editar
            }
         }
    };
    ResultSet rs = null;
    controladorproducto productos = new controladorproducto();
    
    private void sumarcelda(){
    double sumarcolumna=0;
    for(int i=0;i<tblorden.getRowCount();i++){
    sumarcolumna=sumarcolumna+Double.parseDouble(modeloorden.getValueAt(i,3).toString());
    txttotal.setText(String.valueOf(sumarcolumna));
    }
    }
    
    public cobrar_orden(int id,String mesa,String mesero,String cliente) {
        initComponents();
        this.txtid.setText(Integer.toString(id));
        this.txtmesa.setText(mesa);
        this.txtmesero.setText(mesero);
        this.txtcliente.setText(cliente);
         this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/imagenrestaurante.png")).getImage());
         this.setTitle("Cobrar Orden");
         this.setLocationRelativeTo(null);
         String Id=this.txtid.getText();
         llenar(Id);
         sumarcelda();
    }

    
    
        private void llenar(String Id){
    
       rs=null;
        rs = productos.findByIdOrden(Id);
       //le pone el nombre  a las columnas en la tabla
        modeloorden.addColumn("Producto");
        modeloorden.addColumn("Cantidad");
        modeloorden.addColumn("P/u");
        modeloorden.addColumn("Subtotal");
        String[] dato=new String[4];
        
        try {
            while (rs.next()) {
                dato[0]=rs.getString(1);
                dato[1]=rs.getString(2);
                dato[2]=rs.getString(3);
                dato[3]=rs.getString(3);
                modeloorden.addRow(dato);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", 0);
        }
        tblorden.setModel(modeloorden);
    
    
    
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
        txtid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtmesa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtmesero = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblorden = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        btncobrar = new javax.swing.JButton();
        txtcliente = new javax.swing.JTextField();
        btnsalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("Orden");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        txtid.setEditable(false);
        txtid.setBackground(new java.awt.Color(0, 255, 204));
        jPanel1.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 70, -1));

        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("Mesa");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, -1));

        txtmesa.setEditable(false);
        txtmesa.setBackground(new java.awt.Color(0, 255, 204));
        jPanel1.add(txtmesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 50, -1));

        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("Mesero");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, -1, -1));

        txtmesero.setEditable(false);
        txtmesero.setBackground(new java.awt.Color(0, 255, 204));
        jPanel1.add(txtmesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 180, -1));

        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("Cliente");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, -1));

        tblorden.setBackground(new java.awt.Color(204, 255, 255));
        tblorden.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 255, 0), 2, true));
        tblorden.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        tblorden.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Cantidad", "P/u", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblorden.setToolTipText("Cobrar Orden");
        jScrollPane1.setViewportView(tblorden);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 410, 123));

        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setText("Total");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 50, -1));

        txttotal.setEditable(false);
        txttotal.setBackground(new java.awt.Color(0, 255, 204));
        jPanel1.add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 90, -1));

        btncobrar.setBackground(new java.awt.Color(102, 204, 102));
        btncobrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cobro1.png"))); // NOI18N
        btncobrar.setText("Cobrar");
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
        jPanel1.add(btncobrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, -1, -1));

        txtcliente.setEditable(false);
        txtcliente.setBackground(new java.awt.Color(0, 255, 204));
        jPanel1.add(txtcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 180, -1));

        btnsalir.setBackground(new java.awt.Color(102, 204, 102));
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dispose.png"))); // NOI18N
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
        jPanel1.add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncobrarActionPerformed
        // TODO add your handling code here:
        
        efectuar_cobro cobro=new efectuar_cobro(txttotal.getText());
        cobro.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btncobrarActionPerformed

    private void btncobrarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncobrarMouseMoved
        // TODO add your handling code here:
        String texto="Cobrar";
btncobrar.setToolTipText(texto);//el metodo setToolTipTex hace que cuando pongo el puntero del raton sobre el boton muestre el nombre del boton
  
    }//GEN-LAST:event_btncobrarMouseMoved

    private void btncobrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncobrarMouseEntered
        // TODO add your handling code here:
         btncobrar.setBackground(new Color(0,204,51));//cambia el color del boton cuando paso el puntero sobre el boton
    }//GEN-LAST:event_btncobrarMouseEntered

    private void btncobrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncobrarMouseExited
        // TODO add your handling code here:
         btncobrar.setBackground(new Color(102,204,102));//cambia el color del boton cuando paso el puntero sobre el boton
    }//GEN-LAST:event_btncobrarMouseExited

    private void btnsalirMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsalirMouseMoved
        // TODO add your handling code here:
        String texto="Salir";
        btnsalir.setToolTipText(texto);//el metodo setToolTipTex hace que cuando pongo el puntero del raton sobre el boton muestre el nombre del boton
  
    }//GEN-LAST:event_btnsalirMouseMoved

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnsalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsalirMouseEntered
        // TODO add your handling code here:
          btnsalir.setBackground(new Color(0,204,51));//cambia el color del boton cuando paso el puntero sobre el boton
    }//GEN-LAST:event_btnsalirMouseEntered

    private void btnsalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsalirMouseExited
        // TODO add your handling code here:
          btnsalir.setBackground(new Color(102,204,102));//cambia el color del boton cuando paso el puntero sobre el boton
    }//GEN-LAST:event_btnsalirMouseExited

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
            java.util.logging.Logger.getLogger(cobrar_orden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cobrar_orden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cobrar_orden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cobrar_orden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cobrar_orden(0,"","","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncobrar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblorden;
    private javax.swing.JTextField txtcliente;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtmesa;
    private javax.swing.JTextField txtmesero;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
