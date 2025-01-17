package Vista;

import Modelo.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class NewJInternalProductos extends javax.swing.JInternalFrame {

    // Constructor que deshabilita el campo de ID de producto
    public NewJInternalProductos() {
        initComponents();      
        jTextid_producto.setEnabled(false); // El ID se genera automáticamente, así que se deshabilita
    }
    
    
    // Método para limpiar los campos de texto
    public void LimpiarCampos(){
        jTextid_producto.setText("");
        jTextnombre.setText("");
        jTextdescripcion.setText("");
        jTextprecio.setText("");
    }
    
    
    // Método para obtener y mostrar todos los productos en la tabla
   public void obtenerDatos(){       
    try {
        
        // Se obtiene una lista de productos de la base de datos
        List <Productos> productos = new DAOProductos().ObtenerDatos();
        DefaultTableModel modelo = new DefaultTableModel();
        
        // Se definen las columnas de la tabla
        String[] columnas = {"id_producto", "nombre", "descripcion", "precio"};
        modelo.setColumnIdentifiers(columnas);
        
        // Se llena la tabla con los datos de cada producto
        for(Productos pro : productos){
            String[] renglon = {
                Integer.toString(pro.getId_producto()),
                pro.getNombre(),
                pro.getDescripcion(),
                pro.getPrecio().toString()
            };
            modelo.addRow(renglon);
        }
        jTableproducto.setModel(modelo); // Se actualiza la tabla en la interfaz
        
    }catch(Exception e) {
            
        e.printStackTrace();
        JOptionPane.showMessageDialog(rootPane, "Error al obtener los datos de productos.");
    }
    
}

 public void BusquedaProducto(String dato)throws SQLException {
     try{
         List <Productos> productos = new DAOProductos().ObtenerDatosPro();
     DefaultTableModel modelo = new DefaultTableModel();
     String[] columnas = {"id_producto", "nombre", "descripcion", "precio"};
     modelo.setColumnIdentifiers(columnas);
              // Se llena la tabla con los datos de cada producto
        for(Productos pro : productos){
            String[] renglon = {
                Integer.toString(pro.getId_producto()),
                pro.getNombre(),
                pro.getDescripcion(),
                pro.getPrecio().toString()
            };
            modelo.addRow(renglon);
        }
        jTableproducto.setModel(modelo); // Se actualiza la tabla en la interfaz
     }catch(Exception e) {
            
        e.printStackTrace();
        JOptionPane.showMessageDialog(rootPane, "Error al obtener los datos de productos.");
    }
    
}
         



// Método para actualizar la información de un producto
    public void actualizarProducto() {
    int id=Integer.parseInt(this.jTextid_producto.getText());
     String nomb=this.jTextnombre.getText();       
     String desc=this.jTextdescripcion.getText();        
     float prec=Float.parseFloat(this.jTextprecio.getText());
     
     // Actualiza el producto en la base de datos
     DAOProductos dao=new DAOProductos();
     int res=dao.Actualizar (id, nomb, desc, prec);
     
     // Muestra un mensaje según el resultado de la actualización
     if (res ==1) {
         JOptionPane.showMessageDialog(rootPane, "Producto Actualizado!");
     }else{
         JOptionPane.showMessageDialog(rootPane, "¡Ocurrió un ERROR!");
     }  
     
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
        jLabel4 = new javax.swing.JLabel();
        jTextid_producto = new javax.swing.JTextField();
        jTextnombre = new javax.swing.JTextField();
        jTextdescripcion = new javax.swing.JTextField();
        jTextprecio = new javax.swing.JTextField();
        jButtonAgregar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonActualizar = new javax.swing.JButton();
        jButtonBorrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextBuscarPro = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableproducto = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registar Producto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("ID_Producto");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Descripcion");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Precio");

        jButtonAgregar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonAgregar.setText("Agregar ");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jButtonEditar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonActualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        jButtonBorrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonBorrar.setText("Borrar");
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Buscar");

        jTextBuscarPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextBuscarProKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(76, 76, 76))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextid_producto, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                            .addComponent(jTextnombre)
                            .addComponent(jTextdescripcion)
                            .addComponent(jTextprecio))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonAgregar)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel5)
                                .addGap(33, 33, 33)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextBuscarPro)
                                .addGap(147, 147, 147))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonEditar)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonActualizar)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonBorrar)
                                .addGap(38, 38, 38))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextid_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAgregar)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonActualizar)
                    .addComponent(jButtonBorrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextBuscarPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos registrados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jTableproducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableproducto);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
// Método llamado al hacer clic en "Agregar" para insertar un nuevo producto
    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        String nomb=jTextnombre.getText();
        String desc=jTextdescripcion.getText();
        float prec=Float.parseFloat(this.jTextprecio.getText());
        
        // Valida que los campos no estén vacíos
        if (nomb.contentEquals("")|| desc.contentEquals("")|| prec==0){
             JOptionPane.showMessageDialog(rootPane,
                "Todos los campos son obligatorios");
        }else{
            try{
                Productos pro=new DAOProductos().Insertar(nomb, desc, prec);
                 JOptionPane.showMessageDialog(rootPane, "Registro agregado");
            }catch(Exception e){
                 e.printStackTrace();
                JOptionPane.showMessageDialog(rootPane, "No se agregó el registro");
            }
        }
        obtenerDatos();// Actualiza la tabla
        LimpiarCampos(); // Limpia los campos de texto
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    // Método para llenar los campos con los datos del producto seleccionado en la tabla para editarlo
    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
         int fila=this.jTableproducto.getSelectedRow();//Se obtiene la fila seleccionada
            if (fila==-1) {
                JOptionPane.showMessageDialog(rootPane, "Seleccione un registro de la tabla");
            }
                        else{ //Se toma cada campo de la tabla del registro seleccionado
                // y se asgina a una variable
                try{
                    // Captura los datos del producto seleccionado
                    int id=Integer.parseInt((String) this.jTableproducto.getValueAt (fila, 0).toString());
                    String nomb=(String) this.jTableproducto.getValueAt (fila,1);
                    String desc=(String) this.jTableproducto.getValueAt (fila, 2);
                    String prec=(String) this.jTableproducto.getValueAt (fila,3);
                    
                    // Muestra los datos en los campos de texto para su edición
                    jTextid_producto.setText(""+id);
                    jTextnombre.setText(nomb);
                    jTextdescripcion.setText (desc);
                    jTextprecio.setText(prec);

                 
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    // Método llamado al hacer clic en "Actualizar" para guardar los cambios en el producto
    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        actualizarProducto();
        obtenerDatos();
        LimpiarCampos();
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    // Método llamado al hacer clic en "Borrar" para eliminar el producto seleccionado
    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarActionPerformed
        int fila=this.jTableproducto.getSelectedRow();   
      if (fila==-1){
      JOptionPane.showMessageDialog(rootPane, "Seleccione un registro de la tabla");    
    }else {
     int id=Integer.parseInt((String) this.jTableproducto.getValueAt (fila, 0).toString());
     DAOProductos dao=new DAOProductos();
     dao.Eliminar (id);
     obtenerDatos ();
         }
    }//GEN-LAST:event_jButtonBorrarActionPerformed

    private void jTextBuscarProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextBuscarProKeyReleased

        String datoprod = jTextBuscarPro.getText().trim();

        if(datoprod.isEmpty()) {
            obtenerDatos();
    // Si el campo está vacío, muestra todos los productos o un mensaje
    System.out.println("El campo de búsqueda está vacío. Mostrando todos los productos.");
} else {
    try {
         BusquedaProducto(datoprod);
        int numeroProducto = Integer.parseInt(datoprod);
        // Ahora puedes usar numeroProducto como un int
    } catch (NumberFormatException e) {
        System.out.println("El valor ingresado no es un número válido");
    }       catch (SQLException ex) {
                Logger.getLogger(NewJInternalProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
}
    }//GEN-LAST:event_jTextBuscarProKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableproducto;
    private javax.swing.JTextField jTextBuscarPro;
    private javax.swing.JTextField jTextdescripcion;
    private javax.swing.JTextField jTextid_producto;
    private javax.swing.JTextField jTextnombre;
    private javax.swing.JTextField jTextprecio;
    // End of variables declaration//GEN-END:variables
}
