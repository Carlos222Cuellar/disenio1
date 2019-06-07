
//package Resbar;

import Resbar.controladorparametro;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author karenquintanilla
 */
public class Parametros extends javax.swing.JFrame {

  
    DefaultTableModel modeloParametros = new DefaultTableModel();
    ResultSet rs = null;
    controladorparametro parametros = new controladorparametro();
    
    
    
    
    
    
    public Parametros() {
        initComponents();
       
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/imagenrestaurante.png")).getImage());
        this.setTitle("Parametros");
         this.setLocationRelativeTo(null);
        panelmodificar.setVisible(false);
        llenar();//metodo para llenar la tabla    
        
    }
    

     public void llenar(){
    
       
        rs = parametros.llenarParametros();
       //le pone el nombre  a las columnas en la tabla
        modeloParametros.addColumn("IdParametros");
        modeloParametros.addColumn("nombre");
        modeloParametros.addColumn("valor");
        String[] dato=new String[3];
        
        try {
            while (rs.next()) {
                dato[0]=rs.getString(1);
                dato[1]=rs.getString(2);
                dato[2]=rs.getString(3);
                modeloParametros.addRow(dato);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", 0);
        }
        tblparametros.setModel(modeloParametros);
    
    
    
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelparametros = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblparametros = new javax.swing.JTable();
        btnmodificar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        panelmodificar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtvalor = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btndescartar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelparametros.setBackground(new java.awt.Color(0, 0, 0));
        panelparametros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 102));
        jLabel1.setText("parametros");
        panelparametros.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/categories_gnome_applications_15716.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        panelparametros.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 70, 40));

        tblparametros.setBackground(new java.awt.Color(204, 255, 255));
        tblparametros.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 255, 0), 2, true));
        tblparametros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "IdCategoria", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblparametros.setToolTipText("Categorias");
        tblparametros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblparametrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblparametros);

        panelparametros.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, 90));

        btnmodificar.setBackground(new java.awt.Color(102, 255, 102));
        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificar.png"))); // NOI18N
        btnmodificar.setText("Modificar");
        btnmodificar.setBorder(null);
        btnmodificar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnmodificarMouseMoved(evt);
            }
        });
        btnmodificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnmodificarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnmodificarMouseEntered(evt);
            }
        });
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });
        panelparametros.add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 140, 40));

        btnsalir.setBackground(new java.awt.Color(102, 255, 102));
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1486564399-close_81512.png"))); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.setBorder(null);
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
        panelparametros.add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 150, 40));

        getContentPane().add(panelparametros, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 615, 326));

        panelmodificar.setBackground(new java.awt.Color(0, 0, 0));
        panelmodificar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Modificar Parametros");
        panelmodificar.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 210, 40));

        txtid.setEditable(false);
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });
        panelmodificar.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 180, -1));

        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("IdParametros");
        panelmodificar.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 105, 110, 30));

        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Valor");
        panelmodificar.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 70, 20));
        panelmodificar.add(txtvalor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 180, -1));

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        panelmodificar.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, -1, -1));

        btndescartar.setText("Descartar");
        btndescartar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndescartarActionPerformed(evt);
            }
        });
        panelmodificar.add(btndescartar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, -1, -1));

        getContentPane().add(panelmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 3, 620, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblparametrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblparametrosMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tblparametrosMouseClicked

    private void btnmodificarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmodificarMouseMoved
        // TODO add your handling code here:
        String texto="Modificar";
        btnmodificar.setToolTipText(texto);//el metodo setToolTipTex hace que cuando pongo el puntero del raton sobre el boton muestre el nombre del boton
    }//GEN-LAST:event_btnmodificarMouseMoved

    private void btnmodificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmodificarMouseExited
        // TODO add your handling code here:
        btnmodificar.setBackground(new Color(102,255,102));//cambia el color del boton cuando paso el puntero sobre el boton
    }//GEN-LAST:event_btnmodificarMouseExited

    private void btnmodificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmodificarMouseEntered
        // TODO add your handling code here:
        btnmodificar.setBackground(new Color(0,204,51));//cambia el color del boton cuando paso el puntero sobre el boton
    }//GEN-LAST:event_btnmodificarMouseEntered

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        // TODO add your handling code here:

        if (tblparametros.getSelectedRow() != -1) //saber si esta seleccionada la fila en la tabla

        {
            txtid.setText(modeloParametros.getValueAt(tblparametros.getSelectedRow(), 0).toString());//mando la informacion de la fila a los txt donde se editara la informacion en este caso para el id
            txtvalor.setText(modeloParametros.getValueAt(tblparametros.getSelectedRow(), 2).toString());//mando la informacion de la fila a los txt donde se editara la informacion en este caso para el nombre

            panelparametros.setVisible(false);//deshabilita el panel donde esta tabla
            panelmodificar.setVisible(true);//habilita el panel donde estan los campos a modificar
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un elemento para editar", null, JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btnsalirMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsalirMouseMoved
        // TODO add your handling code here:
        String texto="Salir";
        btnsalir.setToolTipText(texto);//el metodo setToolTipTex hace que cuando pongo el puntero del raton sobre el boton muestre el nombre del boton
    }//GEN-LAST:event_btnsalirMouseMoved

    private void btnsalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsalirMouseExited
        // TODO add your handling code here:
    btnsalir.setBackground(new Color(102,255,102));//cambia el color del boton cuando paso el puntero sobre el boton
    }//GEN-LAST:event_btnsalirMouseExited

    private void btnsalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsalirMouseEntered
        // TODO add your handling code here:
        btnsalir.setBackground(new Color(0,204,51));//cambia el color del boton cuando paso el puntero sobre el boton
    }//GEN-LAST:event_btnsalirMouseEntered

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
//         dashboard kk=new dashboard();
//        kk.setVisible(true);
//        this.dispose();
dashboard menu=new dashboard();
menu.setVisible(true);
this.dispose();




    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed

        if (txtid.getText().equals("") || (txtvalor.getText().equals(""))) {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre de la parametro", null, JOptionPane.WARNING_MESSAGE);
            txtvalor.requestFocus();
        } else {
            String id = txtid.getText();
            String nombre = txtvalor.getText();
            parametros.modificarParametro(id, nombre);
            JOptionPane.showMessageDialog(null,"Modificacion exitosa");
            panelmodificar.setVisible(false);
            panelparametros.setVisible(true);
            ActualizarTabla();

        }

    }//GEN-LAST:event_btnguardarActionPerformed

    
    public void ActualizarTabla(){
    rs = parametros.llenarParametros();
        String[] dato=new String[3];
         modeloParametros.setRowCount(0);
        try {
            while (rs.next()) {
                dato[0]=rs.getString(1);
                dato[1]=rs.getString(2);
                dato[2]=rs.getString(3);
                modeloParametros.addRow(dato);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", 0);
        }
        tblparametros.setModel(modeloParametros);
    
    
    }
    
    
    
    
    
    
    private void btndescartarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndescartarActionPerformed
        panelmodificar.setVisible(false);
        panelparametros.setVisible(true);
    }//GEN-LAST:event_btndescartarActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

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
            java.util.logging.Logger.getLogger(Parametros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Parametros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Parametros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Parametros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Parametros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndescartar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelmodificar;
    private javax.swing.JPanel panelparametros;
    private javax.swing.JTable tblparametros;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtvalor;
    // End of variables declaration//GEN-END:variables
}
