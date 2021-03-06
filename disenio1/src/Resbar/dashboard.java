
import java.awt.Color;
import javax.swing.ImageIcon;
import AppPackage.AnimationClass;
import Modelo.Ordenes;
import Resbar.ControladorAgregarOrden;
//import Resbar.Parametros;
import Resbar.PrinterService;
import Resbar.controladorOrdenes;
import Resbar.controladorcategoria;
import Resbar.modificar_orden;
import Resbar.productos;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Timer;
import java.util.TimerTask;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JOptionPane;
import br.com.adilson.util.Extenso;
import br.com.adilson.util.PrinterMatrix;
import conexion.Conector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
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
 * @author NERIO
 */
public class dashboard extends javax.swing.JFrame {

    /**
     * Creates new form dashboard
     */
    
    
     DefaultTableModel modeloOrdenes = new DefaultTableModel(){
         @Override
         public boolean isCellEditable(int fila, int columna) {
            if(columna==4){
            return true;
            }else{
            return false;
            }
         }
     
     
     };
             
    ResultSet rs = null;
    controladorOrdenes ordenes = new controladorOrdenes();
    ControladorAgregarOrden agregarorden = new ControladorAgregarOrden();
    
    public dashboard() {
        initComponents();
        
        //le pone el nombre  a las columnas en la tabla
       modeloOrdenes.addColumn("IdOrden");
        modeloOrdenes.addColumn("Mesero");
        modeloOrdenes.addColumn("Mesa");
        modeloOrdenes.addColumn("Cliente");
        llenar();//metodo para llenar la tabla ordenes
     
         this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/imagenrestaurante.png")).getImage());
          this.setExtendedState(JFrame.MAXIMIZED_BOTH);//maximiza el frame al tamaño de la pantalla completa
          rbtnmodomesa.setVisible(false);
          rbtnmodocaja.setVisible(false);
          lblmensaje.setVisible(false);
          ticket_X ticket=new ticket_X();
       ticket.setVisible(false);
       btnnuevaorden.requestFocus();
       
          
          
    }

    
     public void llenar(){
        
         ControladorAgregarOrden cao = new ControladorAgregarOrden();
       
       modeloOrdenes.setRowCount(0);
        for(Ordenes orden:cao.findAll())
        {
             String[] or=new String[4];
            
            or[0]=orden.getIdOrden().toString();
            or[1]=orden.getMesero();
            or[2]=orden.getMesa();
            or[3]=orden.getCliente();
          
            modeloOrdenes.addRow(or);
        }
       
        tblordenes.setModel(modeloOrdenes);
       
    
    
    }
    
    
    
     public void tiempo(){
          lblmensaje.setVisible(true);
          if(rbtnmodomesa.isSelected()==true){
          lblmensaje.setText("Modo Mesa Activado");
          }else{
           lblmensaje.setText("Modo Caja Activado");
          }
          Timer timer=new Timer();
          TimerTask task=new TimerTask(){
          @Override
          public void run(){
          lblmensaje.setVisible(false);
          }
          };
          timer.schedule(task, 1000);
          }
     
     
     
     
     
     
          
     public void imprimir(){
          
         
                     String datoo = modeloOrdenes.getValueAt(tblordenes.getSelectedRow(),0).toString();
           
            int datoooo =Integer.parseInt(datoo);
       


             Conector cnt = new Conector();
             
             if (tblordenes.getSelectedRow() != -1) //saber si esta seleccionada la fila en la tabla

       {
            
                
             
         try {
             JasperReport reporte= (JasperReport) JRLoader.loadObject("ticket.jasper");
                 Map parametro = new HashMap(); //Un objeto que mapea claves a los valores
                  parametro.put("id",datoooo);
                  
                  JasperPrint j= JasperFillManager.fillReport(reporte, parametro, cnt.getConexion());
                  JasperViewer jv= new JasperViewer(j,false);
                  jv.setTitle("ticketes");
                  jv.setVisible(true);
                  
             
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"error al mostrar el reporte"+e);
         }  
     
            
        } else {
             
             JOptionPane.showMessageDialog(null, "Seleccione una Orden,para modificar", null, JOptionPane.WARNING_MESSAGE);
            
        }

         
         
         
              
// 
//         StringBuilder builder = new StringBuilder();
//
//        PrinterMatrix printer = new PrinterMatrix();
//
//        Extenso e = new Extenso();
//
//        e.setNumber(101.85);
//
//
//        //Definir el tamanho del papel para la impresion  aca 25 lineas y 80 columnas
//        printer.setOutSize(10, 80);
//        //Imprimir * de la 2da linea a 25 en la columna 1;
//       // printer.printCharAtLin(2, 25, 1, "*");
//        //Imprimir * 1ra linea de la columa de 1 a 80
//       printer.printCharAtCol(1, 1, 80, "=");
//        //Imprimir Encabezado nombre del La EMpresa
//       printer.printTextWrap(1, 2, 30, 80, "FACTURA DE VENTA");
//       //printer.printTextWrap(linI, linE, colI, colE, null);
//       printer.printTextWrap(2, 3, 1, 22, "Num. Boleta : " );
//       printer.printTextWrap(2, 3, 25, 55, "Fecha de Emision: ");
//       printer.printTextWrap(2, 3, 60, 80, "Hora: 12:22:51");
//       printer.printTextWrap(3, 3, 1, 80, "Vendedor.  : " +" - " );
//       printer.printTextWrap(4, 4, 1, 80, "CLIENTE: " );
//       printer.printTextWrap(5, 5, 1, 80, "RUC/CI.: " );
//       printer.printTextWrap(6, 6, 1, 80, "DIRECCION: " + "");
//       printer.printCharAtCol(7, 1, 80, "=");
//       printer.printTextWrap(7, 8, 1, 80, "Codigo          Descripcion                Cant.      P  P.Unit.      P.Total");
//       printer.printCharAtCol(9, 1, 80, "-");
//       
//        printer.toFile("impresion.txt");
//
//      FileInputStream inputStream = null;
//        try {
//            inputStream = new FileInputStream("impresion.txt");
//        } catch (FileNotFoundException ex) {
//            ex.printStackTrace();
//        }
//        if (inputStream == null) {
//            return;
//        }
//
//        DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
//        Doc document = new SimpleDoc(inputStream, docFormat, null);
//
//        PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
//
//        PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
//
//
//        if (defaultPrintService != null) {
//            DocPrintJob printJob = defaultPrintService.createPrintJob();
//            try {
//                printJob.print(document, attributeSet);
//
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        } else {
//            JOptionPane.showMessageDialog(null,"No existen impresoras instaladas");
//           
//        }
//        
//        
//        PrinterService printerService = new PrinterService(); 
//
//     System.out.println(printerService.getPrinters()); 
//
//     //print some stuff. Change the printer name to your thermal printer name. 
//     printerService.printString("POS-80C", "\n\n testing testing 1 2 3eeeee \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); 
//
//     // cut that paper! 
//     byte[] cutP = new byte[] { 0x1d, 'V', 1 }; 
//
//     printerService.printBytes("POS-80C", cutP); 
//

           
          
          } 
          
     
     
     
     
  
     
     
   
     
     
     
     
     
          
          
     
      public void mostrar(){
           lblmensaje.setVisible(true);
          
          lblmensaje.setText("Imprimiendo....");
          final ticket_X ticket=new ticket_X();
       ticket.setVisible(true);
          Timer timer=new Timer();
          TimerTask task=new TimerTask(){
              
          @Override
          public void run(){
              lblmensaje.setVisible(false);
          ticket.setVisible(false);
          }
          };
          timer.schedule(task, 5000);
          
          }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnnuevaorden = new javax.swing.JButton();
        btnagregarproducto = new javax.swing.JButton();
        btnmodificarorden = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblordenes = new javax.swing.JTable();
        btnimprimirorden = new javax.swing.JButton();
        btncobrarorden = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblmenu = new javax.swing.JLabel();
        lblproducto = new javax.swing.JLabel();
        lblconfiguracion = new javax.swing.JLabel();
        lblestadistica = new javax.swing.JLabel();
        lblcategoria = new javax.swing.JLabel();
        rbtnmodomesa = new javax.swing.JRadioButton();
        rbtnmodocaja = new javax.swing.JRadioButton();
        lblmodo = new javax.swing.JLabel();
        lblmensaje = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtfiltro = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnnuevaorden.setBackground(new java.awt.Color(102, 255, 102));
        btnnuevaorden.setForeground(new java.awt.Color(0, 102, 204));
        btnnuevaorden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nueva_orden.png"))); // NOI18N
        btnnuevaorden.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nueva_orden2.png"))); // NOI18N
        btnnuevaorden.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nueva_orden1.png"))); // NOI18N
        btnnuevaorden.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnnuevaordenMouseMoved(evt);
            }
        });
        btnnuevaorden.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnnuevaordenMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnnuevaordenMouseEntered(evt);
            }
        });
        btnnuevaorden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevaordenActionPerformed(evt);
            }
        });
        jPanel1.add(btnnuevaorden, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 250, -1, -1));

        btnagregarproducto.setBackground(new java.awt.Color(102, 255, 102));
        btnagregarproducto.setForeground(new java.awt.Color(0, 102, 204));
        btnagregarproducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar.png"))); // NOI18N
        btnagregarproducto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnagregarproducto.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar2.png"))); // NOI18N
        btnagregarproducto.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar1.png"))); // NOI18N
        btnagregarproducto.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnagregarproductoMouseMoved(evt);
            }
        });
        btnagregarproducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnagregarproductoMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnagregarproductoMouseEntered(evt);
            }
        });
        btnagregarproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarproductoActionPerformed(evt);
            }
        });
        jPanel1.add(btnagregarproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 350, -1, -1));

        btnmodificarorden.setBackground(new java.awt.Color(102, 255, 102));
        btnmodificarorden.setForeground(new java.awt.Color(0, 102, 204));
        btnmodificarorden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificar.png"))); // NOI18N
        btnmodificarorden.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificar2.png"))); // NOI18N
        btnmodificarorden.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificar1.png"))); // NOI18N
        btnmodificarorden.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnmodificarordenMouseMoved(evt);
            }
        });
        btnmodificarorden.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnmodificarordenMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnmodificarordenMouseEntered(evt);
            }
        });
        btnmodificarorden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarordenActionPerformed(evt);
            }
        });
        jPanel1.add(btnmodificarorden, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 450, -1, -1));

        tblordenes.setBackground(new java.awt.Color(204, 255, 255));
        tblordenes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 255, 0), 2, true));
        tblordenes.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        tblordenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cuenta", "Mesero", "Mesa", "Cliente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tblordenes.setToolTipText("Ordenes");
        tblordenes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblordenes.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblordenes);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 1190, 500));

        btnimprimirorden.setBackground(new java.awt.Color(102, 255, 102));
        btnimprimirorden.setForeground(new java.awt.Color(0, 102, 205));
        btnimprimirorden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imprimir.png"))); // NOI18N
        btnimprimirorden.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imprimir2.png"))); // NOI18N
        btnimprimirorden.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imprimir1.png"))); // NOI18N
        btnimprimirorden.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnimprimirordenMouseMoved(evt);
            }
        });
        btnimprimirorden.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnimprimirordenMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnimprimirordenMouseEntered(evt);
            }
        });
        btnimprimirorden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirordenActionPerformed(evt);
            }
        });
        jPanel1.add(btnimprimirorden, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 550, -1, -1));

        btncobrarorden.setBackground(new java.awt.Color(102, 255, 102));
        btncobrarorden.setForeground(new java.awt.Color(0, 102, 204));
        btncobrarorden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pagar.png"))); // NOI18N
        btncobrarorden.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pagar2.png"))); // NOI18N
        btncobrarorden.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pagar1.png"))); // NOI18N
        btncobrarorden.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btncobrarordenMouseMoved(evt);
            }
        });
        btncobrarorden.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btncobrarordenMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btncobrarordenMouseEntered(evt);
            }
        });
        btncobrarorden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncobrarordenActionPerformed(evt);
            }
        });
        jPanel1.add(btncobrarorden, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 640, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenrestaurante.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 12, 144, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 38)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 102));
        jLabel2.setText("RESBAR");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 0, 269, 46));

        lblmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Menu_32px.png"))); // NOI18N
        lblmenu.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblmenuMouseMoved(evt);
            }
        });
        lblmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblmenuMouseClicked(evt);
            }
        });
        jPanel1.add(lblmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 10, 31, 34));

        lblproducto.setForeground(new java.awt.Color(204, 0, 0));
        lblproducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono-productos-png-4.png"))); // NOI18N
        lblproducto.setText("Productos");
        lblproducto.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblproductoMouseMoved(evt);
            }
        });
        lblproducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblproductoMouseClicked(evt);
            }
        });
        jPanel1.add(lblproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 40, -1, -1));

        lblconfiguracion.setForeground(new java.awt.Color(204, 0, 0));
        lblconfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/configuracion.png"))); // NOI18N
        lblconfiguracion.setText("Configuracion");
        lblconfiguracion.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblconfiguracionMouseMoved(evt);
            }
        });
        lblconfiguracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblconfiguracionMouseClicked(evt);
            }
        });
        jPanel1.add(lblconfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 160, -1, -1));

        lblestadistica.setForeground(new java.awt.Color(204, 0, 0));
        lblestadistica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/estadisticas.png"))); // NOI18N
        lblestadistica.setText("Estadisticas");
        lblestadistica.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblestadisticaMouseMoved(evt);
            }
        });
        lblestadistica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblestadisticaMouseClicked(evt);
            }
        });
        jPanel1.add(lblestadistica, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 120, -1, -1));

        lblcategoria.setForeground(new java.awt.Color(204, 0, 0));
        lblcategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/categorias-png-4.png"))); // NOI18N
        lblcategoria.setText("Categorias");
        lblcategoria.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblcategoriaMouseMoved(evt);
            }
        });
        lblcategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblcategoriaMouseClicked(evt);
            }
        });
        jPanel1.add(lblcategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 80, -1, -1));

        rbtnmodomesa.setBackground(new java.awt.Color(102, 204, 102));
        buttonGroup1.add(rbtnmodomesa);
        rbtnmodomesa.setForeground(new java.awt.Color(204, 0, 0));
        rbtnmodomesa.setSelected(true);
        rbtnmodomesa.setText("Modo Mesa");
        rbtnmodomesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtnmodomesaMouseClicked(evt);
            }
        });
        jPanel1.add(rbtnmodomesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 150, 110, -1));

        rbtnmodocaja.setBackground(new java.awt.Color(102, 204, 102));
        buttonGroup1.add(rbtnmodocaja);
        rbtnmodocaja.setForeground(new java.awt.Color(204, 0, 0));
        rbtnmodocaja.setText("Modo Caja");
        rbtnmodocaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtnmodocajaMouseClicked(evt);
            }
        });
        jPanel1.add(rbtnmodocaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 180, 110, -1));

        lblmodo.setForeground(new java.awt.Color(204, 0, 0));
        lblmodo.setText("Modo Mesa");
        jPanel1.add(lblmodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 720, 90, -1));

        lblmensaje.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        lblmensaje.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(lblmensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 10, 220, 40));

        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Search_32px_2.png"))); // NOI18N
        jLabel3.setText("Filtrar:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        txtfiltro.setBackground(new java.awt.Color(0, 255, 204));
        txtfiltro.setText("BUSCAR POR MESA");
        txtfiltro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtfiltroFocusLost(evt);
            }
        });
        txtfiltro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtfiltroMouseClicked(evt);
            }
        });
        txtfiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfiltroActionPerformed(evt);
            }
        });
        txtfiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfiltroKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfiltroKeyReleased(evt);
            }
        });
        jPanel1.add(txtfiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 340, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnuevaordenMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnnuevaordenMouseMoved
        // TODO add your handling code here:
        String texto="Nueva Orden";
btnnuevaorden.setToolTipText(texto);//el metodo setToolTipTex hace que cuando pongo el puntero del raton sobre el boton muestre el nombre del boton
    }//GEN-LAST:event_btnnuevaordenMouseMoved

    private void btnnuevaordenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevaordenActionPerformed
        // TODO add your handling code here:
        if(rbtnmodomesa.isSelected()==true){
        nueva_orden NuevaOrden= new nueva_orden();
       NuevaOrden.setVisible(true);
       this.dispose();
        }else{
        nueva_orden_modo_caja NuevaOrdenCaja= new nueva_orden_modo_caja();
       NuevaOrdenCaja.setVisible(true);
       this.dispose();
        }
    }//GEN-LAST:event_btnnuevaordenActionPerformed

    private void btnagregarproductoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnagregarproductoMouseMoved
        // TODO add your handling code here:
        String texto="Agregar Producto";
btnagregarproducto.setToolTipText(texto);//el metodo setToolTipTex hace que cuando pongo el puntero del raton sobre el boton muestre el nombre del boton
   
    }//GEN-LAST:event_btnagregarproductoMouseMoved

    private void btnmodificarordenMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmodificarordenMouseMoved
        // TODO add your handling code here:
        String texto="Modificar Orden";
btnmodificarorden.setToolTipText(texto);//el metodo setToolTipTex hace que cuando pongo el puntero del raton sobre el boton muestre el nombre del boton
   
    }//GEN-LAST:event_btnmodificarordenMouseMoved

    private void btnimprimirordenMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnimprimirordenMouseMoved
String texto="Imprimir Orden";
btnimprimirorden.setToolTipText(texto);//el metodo setToolTipTex hace que cuando pongo el puntero del raton sobre el boton muestre el nombre del boton
   
        // TODO add your handling code here:
    }//GEN-LAST:event_btnimprimirordenMouseMoved

    private void btncobrarordenMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncobrarordenMouseMoved
String texto="Cobrar Orden";
btncobrarorden.setToolTipText(texto);//el metodo setToolTipTex hace que cuando pongo el puntero del raton sobre el boton muestre el nombre del boton
   
        // TODO add your handling code here:
    }//GEN-LAST:event_btncobrarordenMouseMoved

    private void btnnuevaordenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnnuevaordenMouseEntered
        // TODO add your handling code here:
        btnnuevaorden.setBackground(new Color(0,204,51));//cambia el color del boton cuando paso el puntero sobre el boton
    }//GEN-LAST:event_btnnuevaordenMouseEntered

    private void btnnuevaordenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnnuevaordenMouseExited
        // TODO add your handling code here:
        btnnuevaorden.setBackground(new Color(102,255,102));//devuelve el color al boton como estaba despues de quitar el puntero del boton
    }//GEN-LAST:event_btnnuevaordenMouseExited

    private void btnagregarproductoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnagregarproductoMouseEntered
        // TODO add your handling code here:
         btnagregarproducto.setBackground(new Color(0,204,51));
    }//GEN-LAST:event_btnagregarproductoMouseEntered

    private void btnmodificarordenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmodificarordenMouseEntered
        // TODO add your handling code here:
         btnmodificarorden.setBackground(new Color(0,204,51));
    }//GEN-LAST:event_btnmodificarordenMouseEntered

    private void btnimprimirordenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnimprimirordenMouseEntered
        // TODO add your handling code here:
         btnimprimirorden.setBackground(new Color(0,204,51));
    }//GEN-LAST:event_btnimprimirordenMouseEntered

    private void btncobrarordenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncobrarordenMouseEntered
        // TODO add your handling code here:
         btncobrarorden.setBackground(new Color(0,204,51));
    }//GEN-LAST:event_btncobrarordenMouseEntered

    private void btnagregarproductoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnagregarproductoMouseExited
        // TODO add your handling code here:
         btnagregarproducto.setBackground(new Color(102,255,102));
    }//GEN-LAST:event_btnagregarproductoMouseExited

    private void btnmodificarordenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmodificarordenMouseExited
        // TODO add your handling code here:
         btnmodificarorden.setBackground(new Color(102,255,102));
    }//GEN-LAST:event_btnmodificarordenMouseExited

    private void btnimprimirordenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnimprimirordenMouseExited
        // TODO add your handling code here:
         btnimprimirorden.setBackground(new Color(102,255,102));
    }//GEN-LAST:event_btnimprimirordenMouseExited

    private void btncobrarordenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncobrarordenMouseExited
        // TODO add your handling code here:
         btncobrarorden.setBackground(new Color(102,255,102));
    }//GEN-LAST:event_btncobrarordenMouseExited

     String observacion="";
     int ordenid;
     public void Observacion(int idorden){
             rs = null;
             rs=agregarorden.buscarobervacion(idorden);
         String[] dato=new String[1]; 
        
        try {
            while (rs.next()) {
                dato[0]=rs.getString(1);
                
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", 0);
        }
       
             observacion=dato[0];
             }
    
    private void btnagregarproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarproductoActionPerformed
        
        
             
       
        if (tblordenes.getSelectedRow() != -1) //saber si esta seleccionada la fila en la tabla

        {     
           
             String orden=this.modeloOrdenes.getValueAt(this.tblordenes.getSelectedRow(),0).toString();
             ordenid=Integer.parseInt(orden);
             Observacion(ordenid);
            
            agregar_producto ap = new agregar_producto(this.modeloOrdenes.getValueAt(this.tblordenes.getSelectedRow(),0).toString(),observacion);
          
           
            ap.setVisible(true);
           
            
            
            
        } else {
             
             JOptionPane.showMessageDialog(null, "Seleccione una Orden,para agregar mas productos", null, JOptionPane.WARNING_MESSAGE);
            
        }
         

    }//GEN-LAST:event_btnagregarproductoActionPerformed

    private void btnmodificarordenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarordenActionPerformed
        // TODO add your handling code here:
//        if(rbtnmodomesa.isSelected()==true){
//           
//        modificar_orden modificar=new modificar_orden();
//        modificar.setVisible(true);
//        
//        }else{
//       
//        }


if (tblordenes.getSelectedRow() != -1) //saber si esta seleccionada la fila en la tabla

        {
            
          // modificar_orden mo=new modificar_orden(this.modeloOrdenes.getValueAt(this.tblordenes.getSelectedRow(),0).toString());
            
//          controladorOrdenes co=new controladorOrdenes ();
//          Ordenes orden = new Ordenes();
//          
//          char estado=orden.getEstado();
          
          
          
     {
            
            
            //String id=this.modeloOrdenes.getValueAt(this.tblordenes.getSelectedRow(),0).toString();
             
             int id=Integer.parseInt(this.modeloOrdenes.getValueAt(this.tblordenes.getSelectedRow(),0).toString());
             String mesa=this.modeloOrdenes.getValueAt(this.tblordenes.getSelectedRow(),2).toString();
             String mesero=this.modeloOrdenes.getValueAt(this.tblordenes.getSelectedRow(),1).toString();
             String cliente=this.modeloOrdenes.getValueAt(this.tblordenes.getSelectedRow(),3).toString();
             String orden=this.modeloOrdenes.getValueAt(this.tblordenes.getSelectedRow(),0).toString();
             ordenid=Integer.parseInt(orden);
             Observacion(ordenid);
              modificar_orden mo=new modificar_orden(id,mesa,mesero,cliente,observacion);
             
           mo.setVisible(true);
            
            }
             
             
           
            
            
            
        } else {
             
             JOptionPane.showMessageDialog(null, "Seleccione una Orden,para modificar", null, JOptionPane.WARNING_MESSAGE);
            
        }





    }//GEN-LAST:event_btnmodificarordenActionPerformed

    private void btncobrarordenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncobrarordenActionPerformed
        // TODO add your handling code here:
        if (tblordenes.getSelectedRow() != -1) //saber si esta seleccionada la fila en la tabla

        {
            
          // modificar_orden mo=new modificar_orden(this.modeloOrdenes.getValueAt(this.tblordenes.getSelectedRow(),0).toString());
            
//          controladorOrdenes co=new controladorOrdenes ();
//          Ordenes orden = new Ordenes();
//          
//          char estado=orden.getEstado();
          
          
          
     {
            
            
            //String id=this.modeloOrdenes.getValueAt(this.tblordenes.getSelectedRow(),0).toString();
             
             int id=Integer.parseInt(this.modeloOrdenes.getValueAt(this.tblordenes.getSelectedRow(),0).toString());
             String mesa=this.modeloOrdenes.getValueAt(this.tblordenes.getSelectedRow(),2).toString();
             String mesero=this.modeloOrdenes.getValueAt(this.tblordenes.getSelectedRow(),1).toString();
             String cliente=this.modeloOrdenes.getValueAt(this.tblordenes.getSelectedRow(),3).toString();
              
             cobrar_orden cobrar=new cobrar_orden (id,mesa,mesero,cliente);
             cobrar.setVisible(true);
            }
             
             
           
            
            
            
        } else {
             
             JOptionPane.showMessageDialog(null, "Seleccione una Orden,para cobrar", null, JOptionPane.WARNING_MESSAGE);
            
        }
       
        //this.dispose();
    }//GEN-LAST:event_btncobrarordenActionPerformed

    private void lblmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblmenuMouseClicked
        // TODO add your handling code here:
        AnimationClass producto = new AnimationClass();
        producto.jLabelXLeft(1400, 1220, 20, 10, lblproducto);//mueve de posicion de derecha a izquierda
        producto.jLabelXLeft(1220, 1400, 20, 10, lblproducto);//mueve de posicion de izquierda a derecha
        
        AnimationClass categoria = new AnimationClass();
        categoria.jLabelXLeft(1400, 1220, 20, 10, lblcategoria);//mueve de posicion de derecha a izquierda
        categoria.jLabelXLeft(1220, 1400, 20, 10, lblcategoria);//mueve de posicion de izquierda a derecha
        
        AnimationClass estadistica = new AnimationClass();
        estadistica.jLabelXLeft(1400, 1220, 20, 10, lblestadistica);//mueve de posicion de derecha a izquierda
        estadistica.jLabelXLeft(1220, 1400, 20, 10, lblestadistica);//mueve de posicion de izquierda a derecha
        
        AnimationClass configuracion = new AnimationClass();
        configuracion.jLabelXLeft(1400, 1220, 20, 10, lblconfiguracion);//mueve de posicion de derecha a izquierda
        configuracion.jLabelXLeft(1220, 1400, 20, 10, lblconfiguracion);//mueve de posicion de izquierda a derecha
        
    }//GEN-LAST:event_lblmenuMouseClicked

    private void lblproductoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblproductoMouseMoved
        // TODO add your handling code here:
        String texto="Productos";
        lblproducto.setToolTipText(texto);//el metodo setToolTipTex hace que cuando pongo el puntero del raton sobre el boton muestre el nombre del boton
   
    }//GEN-LAST:event_lblproductoMouseMoved

    private void lblcategoriaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcategoriaMouseMoved
        // TODO add your handling code here:
        String texto="Categorias";
        lblcategoria.setToolTipText(texto);//el metodo setToolTipTex hace que cuando pongo el puntero del raton sobre el boton muestre el nombre del boton
   
    }//GEN-LAST:event_lblcategoriaMouseMoved

    private void lblestadisticaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblestadisticaMouseMoved
        // TODO add your handling code here:
        String texto="Estadisticas";
        lblestadistica.setToolTipText(texto);//el metodo setToolTipTex hace que cuando pongo el puntero del raton sobre el boton muestre el nombre del boton
   
    }//GEN-LAST:event_lblestadisticaMouseMoved

    private void lblconfiguracionMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblconfiguracionMouseMoved
        // TODO add your handling code here:
        String texto="Configuracion";
        lblconfiguracion.setToolTipText(texto);//el metodo setToolTipTex hace que cuando pongo el puntero del raton sobre el boton muestre el nombre del boton
   
    }//GEN-LAST:event_lblconfiguracionMouseMoved

    private void lblmenuMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblmenuMouseMoved
        // TODO add your handling code here:
        String texto="Menu";
        lblmenu.setToolTipText(texto);//el metodo setToolTipTex hace que cuando pongo el puntero del raton sobre el boton muestre el nombre del boton
   
    }//GEN-LAST:event_lblmenuMouseMoved

    private void lblestadisticaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblestadisticaMouseClicked
        // TODO add your handling code here:
        estadisticas_v estadisticas=new estadisticas_v();
        estadisticas.setVisible(true);
    }//GEN-LAST:event_lblestadisticaMouseClicked

    private void lblconfiguracionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblconfiguracionMouseClicked
        // TODO add your handling code here:
        //rbtnmodomesa.setVisible(true);
        //rbtnmodocaja.setVisible(true);
        Parametros parametros=new Parametros();
        parametros.setVisible(true);
        
    }//GEN-LAST:event_lblconfiguracionMouseClicked

    private void rbtnmodomesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnmodomesaMouseClicked
        // TODO add your handling code here:
        rbtnmodomesa.setVisible(false);
        rbtnmodocaja.setVisible(false);
         btnmodificarorden.setEnabled(true);
        lblmodo.setText("Modo Mesa");
        tiempo();
        
    }//GEN-LAST:event_rbtnmodomesaMouseClicked

    private void rbtnmodocajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnmodocajaMouseClicked
        // TODO add your handling code here:
        rbtnmodomesa.setVisible(false);
        rbtnmodocaja.setVisible(false);
         btnmodificarorden.setEnabled(false);
        lblmodo.setText("Modo Caja");
        tiempo();
    }//GEN-LAST:event_rbtnmodocajaMouseClicked

    private void btnimprimirordenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirordenActionPerformed
        // TODO add your handling code here:
          if (tblordenes.getSelectedRow() != -1) //saber si esta seleccionada la fila en la tabla

        {
            String estado="I";
            String id=this.modeloOrdenes.getValueAt(this.tblordenes.getSelectedRow(),0).toString();
            imprimir();
            agregarorden.cambiarestadoorden(id, estado);
            llenar();
            
        }else{
          JOptionPane.showMessageDialog(null, "Seleccione una orden a imprimir");
          }
        
        
        
        
        
        
       
       
       
    }//GEN-LAST:event_btnimprimirordenActionPerformed

    private void lblproductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblproductoMouseClicked
        // TODO add your handling code here:
      
        productos produ=new productos();
        produ.setVisible(true);
    }//GEN-LAST:event_lblproductoMouseClicked

    private void lblcategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcategoriaMouseClicked
        // TODO add your handling code here:
          categorias cate=new categorias();
        cate.setVisible(true);
    }//GEN-LAST:event_lblcategoriaMouseClicked

    private void txtfiltroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtfiltroMouseClicked
        // TODO add your handling code here:
        txtfiltro.setText("");
    }//GEN-LAST:event_txtfiltroMouseClicked

    private void txtfiltroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfiltroFocusLost
        // TODO add your handling code here:
        txtfiltro.setText("BUSCAR POR MESA");
    }//GEN-LAST:event_txtfiltroFocusLost

    
    
      public void filtrar(int mesa){
      rs=null;
      rs=agregarorden.filtrarbymesa(mesa);
      
      
       modeloOrdenes.setRowCount(0);
        String[] dato=new String[4];
        
        try {
            while (rs.next()) {
                dato[0]=rs.getString(1);
                dato[1]=rs.getString(2);
                dato[2]=rs.getString(3);
                dato[3]=rs.getString(4);
                modeloOrdenes.addRow(dato);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", 0);
        }
        tblordenes.setModel(modeloOrdenes);
    
      
      }
    private void txtfiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfiltroKeyReleased
        if(txtfiltro.getText().isEmpty()){
        llenar();
        }
        else{  
        filtrar( Integer.parseInt(txtfiltro.getText()));
        }
        
    }//GEN-LAST:event_txtfiltroKeyReleased

    private void txtfiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfiltroActionPerformed

    private void txtfiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfiltroKeyTyped
        // TODO add your handling code here:
         char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != '.') && (caracter != '/') && (caracter != '-')) {
            evt.consume();
        } else if (((caracter > '0') || (caracter < '9'))) {
            evt.consume();
            txtfiltro.setText(txtfiltro.getText() + String.valueOf(caracter));
        }
    }//GEN-LAST:event_txtfiltroKeyTyped

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
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                    new dashboard().setVisible(true);
              
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregarproducto;
    private javax.swing.JButton btncobrarorden;
    private javax.swing.JButton btnimprimirorden;
    private javax.swing.JButton btnmodificarorden;
    private javax.swing.JButton btnnuevaorden;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblcategoria;
    private javax.swing.JLabel lblconfiguracion;
    private javax.swing.JLabel lblestadistica;
    private javax.swing.JLabel lblmensaje;
    private javax.swing.JLabel lblmenu;
    private javax.swing.JLabel lblmodo;
    private javax.swing.JLabel lblproducto;
    private javax.swing.JRadioButton rbtnmodocaja;
    private javax.swing.JRadioButton rbtnmodomesa;
    private javax.swing.JTable tblordenes;
    private javax.swing.JTextField txtfiltro;
    // End of variables declaration//GEN-END:variables
}
