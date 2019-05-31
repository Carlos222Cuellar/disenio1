
import Resbar.Producto;
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
 * @author willi
 */
public class productos extends javax.swing.JFrame {

    /**
     * Creates new form productos
     */
    
    DefaultTableModel modeloProducto = new DefaultTableModel();
    ResultSet rs = null;
    Producto productos = new Producto();
    String seleccionado;
    
    
    public productos() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/imagenrestaurante.png")).getImage());
        this.setTitle("Productos");
         this.setLocationRelativeTo(null);
         
         
        modeloProducto.addColumn("IdCategorias");
        modeloProducto.addColumn("nombre");
       
    }
    
    
    private void Producto(String seleccionado) {
        rs = null;
        rs = productos.llenarProductos(seleccionado);
        //modeloProducto.addColumn("IdCategorias");
        //modeloProducto.addColumn("nombre");
        String[] dato=new String[2]; 
        
        try {
            while (rs.next()) {
                dato[0]=rs.getString(1);
                dato[1]=rs.getString(2);
                modeloProducto.addRow(dato);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", 0);
        }
        jtblproducto.setModel(modeloProducto);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbcategorias = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblproducto = new javax.swing.JTable();
        btnnuevo = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Productos");

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 102));
        jLabel1.setText("productos");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 102));
        jLabel3.setText("categorias:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, -1, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/shipping_products_22121.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 80, 70));

        cmbcategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Platos", "Bebidas", "Postres" }));
        cmbcategorias.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbcategoriasItemStateChanged(evt);
            }
        });
        cmbcategorias.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbcategoriasFocusGained(evt);
            }
        });
        cmbcategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbcategoriasActionPerformed(evt);
            }
        });
        jPanel2.add(cmbcategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 218, -1));

        jtblproducto.setBackground(new java.awt.Color(204, 255, 255));
        jtblproducto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 255, 0), 2, true));
        jtblproducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "IdProducto", "Nombre"
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
        jtblproducto.setToolTipText("Productos");
        jScrollPane1.setViewportView(jtblproducto);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 560, 90));

        btnnuevo.setBackground(new java.awt.Color(102, 255, 102));
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar.png"))); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.setBorder(null);
        btnnuevo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnnuevoMouseMoved(evt);
            }
        });
        btnnuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnnuevoMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnnuevoMouseEntered(evt);
            }
        });
        jPanel2.add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 140, 40));

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
        jPanel2.add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 160, 40));

        btneliminar.setBackground(new java.awt.Color(102, 255, 102));
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete.png"))); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.setBorder(null);
        btneliminar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btneliminarMouseMoved(evt);
            }
        });
        btneliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btneliminarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btneliminarMouseEntered(evt);
            }
        });
        jPanel2.add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 110, 40));

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
        jPanel2.add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, 120, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbcategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbcategoriasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbcategoriasActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
         dashboard menu=new dashboard();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnsalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsalirMouseEntered
        // TODO add your handling code here:
         btnsalir.setBackground(new Color(0,204,51));//cambia el color del boton cuando paso el puntero sobre el boton
    }//GEN-LAST:event_btnsalirMouseEntered

    private void btnsalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsalirMouseExited
        // TODO add your handling code here:
         btnsalir.setBackground(new Color(102,255,102));//cambia el color del boton cuando paso el puntero sobre el boton
    }//GEN-LAST:event_btnsalirMouseExited

    private void btneliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneliminarMouseEntered
        // TODO add your handling code here:
         btneliminar.setBackground(new Color(0,204,51));//cambia el color del boton cuando paso el puntero sobre el boton
    }//GEN-LAST:event_btneliminarMouseEntered

    private void btneliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneliminarMouseExited
        // TODO add your handling code here:
         btneliminar.setBackground(new Color(102,255,102));//cambia el color del boton cuando paso el puntero sobre el boton
    }//GEN-LAST:event_btneliminarMouseExited

    private void btnmodificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmodificarMouseEntered
        // TODO add your handling code here:
         btnmodificar.setBackground(new Color(0,204,51));//cambia el color del boton cuando paso el puntero sobre el boton
    }//GEN-LAST:event_btnmodificarMouseEntered

    private void btnmodificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmodificarMouseExited
        // TODO add your handling code here:
         btnmodificar.setBackground(new Color(102,255,102));//cambia el color del boton cuando paso el puntero sobre el boton
    }//GEN-LAST:event_btnmodificarMouseExited

    private void btnnuevoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnnuevoMouseEntered
        // TODO add your handling code here:
         btnnuevo.setBackground(new Color(0,204,51));//cambia el color del boton cuando paso el puntero sobre el boton
    }//GEN-LAST:event_btnnuevoMouseEntered

    private void btnnuevoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnnuevoMouseExited
        // TODO add your handling code here:
         btnnuevo.setBackground(new Color(102,255,102));//cambia el color del boton cuando paso el puntero sobre el boton
    }//GEN-LAST:event_btnnuevoMouseExited

    private void btnnuevoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnnuevoMouseMoved
        // TODO add your handling code here:
        String texto="Nuevo";
        btnnuevo.setToolTipText(texto);//el metodo setToolTipTex hace que cuando pongo el puntero del raton sobre el boton muestre el nombre del boton
    }//GEN-LAST:event_btnnuevoMouseMoved

    private void btnmodificarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmodificarMouseMoved
        // TODO add your handling code here:
        String texto="Modificar";
        btnmodificar.setToolTipText(texto);//el metodo setToolTipTex hace que cuando pongo el puntero del raton sobre el boton muestre el nombre del boton
    }//GEN-LAST:event_btnmodificarMouseMoved

    private void btneliminarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneliminarMouseMoved
        // TODO add your handling code here:
        String texto="Eliminar";
        btneliminar.setToolTipText(texto);//el metodo setToolTipTex hace que cuando pongo el puntero del raton sobre el boton muestre el nombre del boton
    }//GEN-LAST:event_btneliminarMouseMoved

    private void btnsalirMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsalirMouseMoved
        // TODO add your handling code here:
        String texto="Salir";
        btnsalir.setToolTipText(texto);//el metodo setToolTipTex hace que cuando pongo el puntero del raton sobre el boton muestre el nombre del boton
    }//GEN-LAST:event_btnsalirMouseMoved

    private void cmbcategoriasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbcategoriasItemStateChanged
        // TODO add your handling code here:
       cmbcategorias.requestFocus();
        modeloProducto.setRowCount(0);
        seleccionado=String.valueOf(this.cmbcategorias.getSelectedIndex()+1);
        Producto(seleccionado); //invoque al método para llenar la tabla depende de lo que se escoja en el combobox
            
    }//GEN-LAST:event_cmbcategoriasItemStateChanged

    private void cmbcategoriasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbcategoriasFocusGained
        // TODO add your handling code here:
        modeloProducto.setRowCount(0);
        seleccionado=String.valueOf(this.cmbcategorias.getSelectedIndex()+1);
        Producto(seleccionado);
    }//GEN-LAST:event_cmbcategoriasFocusGained

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
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> cmbcategorias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtblproducto;
    // End of variables declaration//GEN-END:variables
}
