
package company.sales_invoice.controller;

import company.sales_invoice.model.invoiceItem;
import company.sales_invoice.model.invoicesModel;
import company.sales_invoice.model.linesTableModel;
import company.sales_invoice.model.salesInvoice;
import company.sales_invoice.view.salesInvoice_Dialog;
import company.sales_invoice.view.salesInvoice_items_Dialog;
import company.sales_invoice.view.sales_invoice_frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Eman Ragab
 */
public class invoiceController implements ActionListener,ListSelectionListener {

    private sales_invoice_frame myframe;
    private salesInvoice_Dialog invoice_Dialog;
    private salesInvoice_items_Dialog Invoice_items_Dialog ;
    
     @Override
    public void valueChanged(ListSelectionEvent e)
    {
        int selected_index=myframe.getInvoiceTable().getSelectedRow();
        if(selected_index != -1){
        System.out.print("selected rows"  + selected_index);
        salesInvoice current_invoice=myframe.getSalesInvoices().get(selected_index);
        myframe.getInvoicenumberlLabel().setText(""+current_invoice.getInvoiceNumber()); 
        myframe.getCustomerNameLabel().setText(current_invoice.getCustomerName());
        myframe.getInvoiceDateLabel().setText(current_invoice.getInvoiceDate());
        myframe.getInvoiceTotalLabel().setText(""+current_invoice.getTotal()); 
        linesTableModel linestablemodel= new linesTableModel(current_invoice.getInvoiceItems());
        myframe.getItemsTable().setModel(linestablemodel);
        linestablemodel.fireTableDataChanged();
        
        
        }
        
    }
    
    
    
    
    
    
    public invoiceController(sales_invoice_frame myframe)
    {
        this.myframe=myframe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand=e.getActionCommand();
    System.out.println("Action"+actionCommand);
    
    switch(actionCommand){
        case"Load File":
            Load_File();
            break;
        case"Save File":
            Save_File();
            break;
        case"Create New Invoice":
            Create_New_Invoice();
            break;
        case"Delete Invoice":
            Delete_Invoice();
            break;     
        case"create New Item":
            createNewItem();
            break;
        case"delete Item":
            deleteItem();
            break;  
             case"createInvoiceok":
            create_Invoice_ok();
            break;
             case"createInvoiceCancel":
           create_Invoice_Cancel();
            break;
            case"create line ok":
            create_line_ok();
            break;
        case"create line Cancel":
           create_line_Cancel();
            break;
        
    }
   
    }

    private void Load_File() 
    {
        JFileChooser fileChooser=new JFileChooser();
        try{
        int Dialog=fileChooser.showOpenDialog(myframe);
        //if user choose open 
        if(Dialog==JFileChooser.APPROVE_OPTION){
          File header_file=  fileChooser.getSelectedFile();
         Path path = Paths.get(header_file.getAbsolutePath());//path of file as object of path
        List<String> lines=  Files.readAllLines(path);
        System.out.println("done");
       ArrayList<salesInvoice> salesInvoiceArray=new ArrayList<>();
       
        for(String line :lines)
        {
            try{
           String[] line_parts = line.split(",");
           //invoiceNumber invoiceDate  customerName
           int invoiceNumber=parseInt(line_parts[0]);
           String invoiceDate=line_parts[1];
           String customerName=line_parts[2];
           salesInvoice salesInvoice=new salesInvoice( invoiceNumber,invoiceDate,customerName);
           salesInvoiceArray.add(salesInvoice);
        }
            catch(Exception ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(myframe, "Error in line format",
                                "Error", JOptionPane.ERROR_MESSAGE);
            }}
        
        // System.out.println("check");
        
      Dialog= fileChooser.showOpenDialog(myframe);
      if(Dialog== JFileChooser.APPROVE_OPTION){
          File line_file=  fileChooser.getSelectedFile();
          Path line_path = Paths.get(line_file.getAbsolutePath());
          List<String> items_lines=  Files.readAllLines(line_path);
                   // System.out.println("lines done");

 for(String line :items_lines)
        {
           try{
           String[] items_parts = line.split(",");
            //invoiceNumber     productName   productPrice   productCount
           int invoiceNumber=parseInt(items_parts[0]);
           String productName =items_parts[1];
           double productPrice=Double.parseDouble(items_parts[2]);
           int productCount=parseInt(items_parts[3]);
           
            salesInvoice s_invoice=null;
            for(salesInvoice salesInvoice:salesInvoiceArray){
                if(salesInvoice.getInvoiceNumber()==invoiceNumber)
                {
                 s_invoice= salesInvoice;
                 break;
                }
            }
           invoiceItem invoiceItem=new invoiceItem(productName,productPrice,productCount,s_invoice);
           s_invoice.getInvoiceItems().add(invoiceItem);

        }
      
        catch(Exception ex)
        {
             ex.printStackTrace();
             JOptionPane.showMessageDialog(myframe, "Error in line format", "Error",
                     JOptionPane.ERROR_MESSAGE);
        }
        }  
      }
          myframe.setSalesInvoices(salesInvoiceArray);
          
          invoicesModel invoices_model= new invoicesModel(salesInvoiceArray);
          
          myframe.setInvoicesModel(invoices_model);
          
          myframe.getInvoiceTable().setModel(invoices_model);
          myframe.getInvoicesModel().fireTableDataChanged();
        } }
        catch(IOException ex)
        {
           ex.printStackTrace();
           JOptionPane.showMessageDialog(myframe, "Cannot read file", "Error", JOptionPane.ERROR_MESSAGE);

        }
         
    }
        
    

    private void Save_File() 
    {
          ArrayList<salesInvoice> invoices = myframe.getSalesInvoices();
                 
        String headers = "";
        String lines = "";
        for (salesInvoice invoice : invoices) {
            String invCSV = invoice.getAsCSV();
            headers += invCSV;
            headers += "\n";

            for (invoiceItem invoice_Item : invoice.getInvoiceItems()) {
                String lineCSV = invoice_Item.getAsCSV();
                lines += lineCSV;
                lines += "\n";
            }    }  
        
          try {
            JFileChooser FileChooser = new JFileChooser();
            int result = FileChooser.showSaveDialog(myframe);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = FileChooser.getSelectedFile();
                FileWriter file_writer= new FileWriter(headerFile);
                file_writer.write(headers);
                file_writer.flush();
                file_writer.close();
                result = FileChooser.showSaveDialog(myframe);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File lineFile = FileChooser.getSelectedFile();
                    FileWriter file_writer2 = new FileWriter(lineFile);
                    file_writer2.write(lines);
                    file_writer2.flush();
                   file_writer2.close();
                }
            }
        } catch (Exception ex) {

        }
    }
        
    

    private void Create_New_Invoice()
    {
        invoice_Dialog= new salesInvoice_Dialog(myframe);
        invoice_Dialog.setVisible(true);
    }

  
    private void Delete_Invoice()
    {
     int selectedRow=myframe.getInvoiceTable().getSelectedRow();
        if(selectedRow!=-1)
        {
            myframe.getSalesInvoices().remove(selectedRow);
            myframe.getInvoicesModel().fireTableDataChanged();
        
        }
    }

    private void createNewItem()
    {
        Invoice_items_Dialog=new salesInvoice_items_Dialog(myframe);
        Invoice_items_Dialog.setVisible(true);
    }
    
    private void deleteItem()
    {
         int selectedRow=myframe.getItemsTable().getSelectedRow();
        if(selectedRow!=-1)
        {
              linesTableModel lines_Model = (linesTableModel) myframe.getItemsTable().getModel();
             lines_Model.getItems().remove(selectedRow);
               lines_Model.fireTableDataChanged();
              myframe.getInvoicesModel().fireTableDataChanged();
            
        }   
    }

     private void create_Invoice_ok() {
         String date = invoice_Dialog.getInvDateField().getText();
        String customer_name = invoice_Dialog.getCustNameField().getText();
        int num = myframe.getNextNumber();        
        try {
            String[] dateParts = date.split("-");  
            if (dateParts.length < 3) {
                JOptionPane.showMessageDialog(myframe, "Wrong date format", 
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int day = Integer.parseInt(dateParts[0]);
                int month = Integer.parseInt(dateParts[1]);
                int year = Integer.parseInt(dateParts[2]);
                if (day > 31 || month > 12) {
                    JOptionPane.showMessageDialog(myframe, "Wrong date format", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    salesInvoice salesInvoice = new salesInvoice(num, date, customer_name);
                    myframe.getSalesInvoices().add(salesInvoice);
                    myframe.getInvoicesModel().fireTableDataChanged();
                    invoice_Dialog.setVisible(false);
                    invoice_Dialog.dispose();
                    invoice_Dialog = null;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(myframe, "Wrong date format", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    

    private void create_Invoice_Cancel() {
        invoice_Dialog.setVisible(false);
        invoice_Dialog.dispose();
        invoice_Dialog=null;
    }
    
      private void create_line_Cancel() {
     
        Invoice_items_Dialog.setVisible(false);
        Invoice_items_Dialog.dispose();
        Invoice_items_Dialog=null;
    }


    
   private void create_line_ok() {
      String item = Invoice_items_Dialog .getItemNameField().getText();
        String countStr = Invoice_items_Dialog .getItemCountField().getText();
        String priceStr = Invoice_items_Dialog .getItemPriceField().getText();
        int count = Integer.parseInt(countStr);
        double price = Double.parseDouble(priceStr);
        int selected_Invoice = myframe.getInvoiceTable().getSelectedRow();
               
        if (selected_Invoice != -1) {
            salesInvoice invoice = myframe.getSalesInvoices().get(selected_Invoice);
                    
            invoiceItem invoiceItem = new invoiceItem(item, price, count, invoice);
            invoice.getInvoiceItems().add(invoiceItem);
                 
            linesTableModel  linesTableModel = (linesTableModel ) myframe.getItemsTable().getModel();
                    
            linesTableModel.fireTableDataChanged();
            myframe.getInvoicesModel().fireTableDataChanged();
                  
        }
        Invoice_items_Dialog.setVisible(false);
        Invoice_items_Dialog.dispose();
        Invoice_items_Dialog = null;    
    
    }

  

 

    
}
