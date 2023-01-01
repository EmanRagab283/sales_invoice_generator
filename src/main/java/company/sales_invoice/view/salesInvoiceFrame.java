
package company.sales_invoice.view;

import company.sales_invoice.controller.invoiceController;
import company.sales_invoice.model.invoicesModel;
import company.sales_invoice.model.salesInvoice;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;

public class salesInvoiceFrame extends javax.swing.JFrame {

    public salesInvoiceFrame() {
        initComponents();
    }


    
    
    public JLabel getCustomerNameLabel() {
        return customerNameLabel;
    }

    public JLabel getInvoiceDateLabel() {
        return invoiceDateLabel;
    }

    public JLabel getInvoiceTotalLabel() {
        return invoiceTotalLabel;
    }

    public JLabel getInvoicenumberlLabel() {
        return invoicenumberlLabel;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        invoiceTable = new javax.swing.JTable();
        invoiceTable.getSelectionModel().addListSelectionListener(invoiceController);
        createInvoice_Button = new javax.swing.JButton();
        createInvoice_Button.addActionListener(invoiceController);
        deleteInvoice_Button = new javax.swing.JButton();
        deleteInvoice_Button.addActionListener(invoiceController);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        itemsTable = new javax.swing.JTable();
        itemsTable.getSelectionModel().addListSelectionListener(invoiceController);
        createItem_Button = new javax.swing.JButton();
        createItem_Button.addActionListener(invoiceController);
        invoicenumberlLabel = new javax.swing.JLabel();
        invoiceDateLabel = new javax.swing.JLabel();
        customerNameLabel = new javax.swing.JLabel();
        invoiceTotalLabel = new javax.swing.JLabel();
        delItem = new javax.swing.JButton();
        delItem.addActionListener(invoiceController);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadFile_MenuItem = new javax.swing.JMenuItem();
        loadFile_MenuItem.addActionListener(invoiceController);
        saveFile_MenuItem = new javax.swing.JMenuItem();
        saveFile_MenuItem.addActionListener(invoiceController);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(invoiceTable);

        createInvoice_Button.setText("Create New Invoice");
        createInvoice_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createInvoice_ButtonActionPerformed(evt);
            }
        });

        deleteInvoice_Button.setText("Delete Invoice");
        deleteInvoice_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteInvoice_ButtonActionPerformed(evt);
            }
        });

        jLabel1.setText(" Invoice No. :");

        jLabel2.setText("Invoice Date :");

        jLabel3.setText("Customer Name :");

        jLabel4.setText("Invoice Total  :");

        itemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(itemsTable);

        createItem_Button.setText("create New Item");
        createItem_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createItem_ButtonActionPerformed(evt);
            }
        });

        delItem.setText("Delete Item");
        delItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delItemActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        loadFile_MenuItem.setText("Load File");
        loadFile_MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadFile_MenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(loadFile_MenuItem);

        saveFile_MenuItem.setText("Save File");
        jMenu1.add(saveFile_MenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(createInvoice_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteInvoice_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(invoicenumberlLabel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(invoiceDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(invoiceTotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(12, 12, 12)
                                        .addComponent(customerNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(createItem_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(delItem, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 27, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteInvoice_Button)
                            .addComponent(createInvoice_Button)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(invoicenumberlLabel))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(invoiceDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(customerNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(invoiceTotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createItem_Button)
                            .addComponent(delItem))))
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createInvoice_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createInvoice_ButtonActionPerformed

    }//GEN-LAST:event_createInvoice_ButtonActionPerformed

    private void createItem_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createItem_ButtonActionPerformed
    
    }//GEN-LAST:event_createItem_ButtonActionPerformed

    private void loadFile_MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadFile_MenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loadFile_MenuItemActionPerformed

    private void deleteInvoice_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteInvoice_ButtonActionPerformed
      
        
    }//GEN-LAST:event_deleteInvoice_ButtonActionPerformed

    private void delItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delItemActionPerformed

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
            java.util.logging.Logger.getLogger(salesInvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(salesInvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(salesInvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(salesInvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
   

   

     java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new salesInvoiceFrame().setVisible(true);
            }
        });
    }

   
    
    private invoiceController invoiceController= new invoiceController(this);
    
    //Add arraylist to read data and save it in 
private ArrayList <salesInvoice> salesInvoices;
    
   private invoicesModel invoicesModel;

    public invoicesModel getInvoicesModel() {
          if (invoicesModel == null) {
            invoicesModel = new invoicesModel(getSalesInvoices());
        }
        
        return invoicesModel;
    }

    public void setInvoicesModel(invoicesModel invoicesModel) {
        this.invoicesModel = invoicesModel;
    }

    public JTable getInvoiceTable() {
        return invoiceTable;
    }

    public JTable getItemsTable() {
        return itemsTable;
    }

    public invoiceController getInvoiceController() {
        return invoiceController;
    }
  
    public int getNextNumber()
    {
        int num=0;
        for(salesInvoice invoice:salesInvoices){
            if(invoice.getInvoiceNumber()>num)
                num=invoice.getInvoiceNumber();
        }
        return ++num;
    }

    public ArrayList<salesInvoice> getSalesInvoices() {
        return salesInvoices;
    }

    public void setSalesInvoices(ArrayList<salesInvoice> salesInvoices) {
        this.salesInvoices = salesInvoices;
    }
    //////////////////////////////////////
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createInvoice_Button;
    private javax.swing.JButton createItem_Button;
    private javax.swing.JLabel customerNameLabel;
    private javax.swing.JButton delItem;
    private javax.swing.JButton deleteInvoice_Button;
    private javax.swing.JLabel invoiceDateLabel;
    private javax.swing.JTable invoiceTable;
    private javax.swing.JLabel invoiceTotalLabel;
    private javax.swing.JLabel invoicenumberlLabel;
    private javax.swing.JTable itemsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadFile_MenuItem;
    private javax.swing.JMenuItem saveFile_MenuItem;
    // End of variables declaration//GEN-END:variables
}
