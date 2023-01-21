
package company.sales_invoice.controller;
import company.sales_invoice.model.invoiceItem;
import company.sales_invoice.model.invoicesModel;
import company.sales_invoice.model.linesTableModel;
import company.sales_invoice.model.salesInvoice;
import company.sales_invoice.view.salesInvoiceDialog;
import company.sales_invoice.view.salesInvoiceItemsDialog;
import company.sales_invoice.view.salesInvoiceFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eman Ragab
 */
public class invoiceController implements ActionListener,ListSelectionListener {

    private salesInvoiceFrame myframe;
    private salesInvoiceDialog invoice_Dialog;
    private salesInvoiceItemsDialog InvoiceItemsDialog ;
    
    
     public invoiceController(salesInvoiceFrame myframe)
    {
        this.myframe=myframe;
    }

    
     @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand=e.getActionCommand();
    System.out.println("Action : "+actionCommand);
    
    switch(actionCommand){
        case"Load File":
            Load_File();
            break;
        case"Save File":
            Save_File();
            break;
        case"Create New Invoice":
            CreateNewInvoice();
            break;
        case"Delete Invoice":
            DeleteInvoice();
            break;     
        case"create New Item":
            createNewItem();
            break;
        case"Delete Item":
            deleteItem();
            break;
             case"createInvoiceOK":
                createInvoiceok();
            break;
             case"createInvoiceCancel":
           createInvoiceCancel();
            break;   
            case"createLineOK":
            createlineok();
            break;
        case"createLineCancel":
           createlineCancel();
            break;
        
    }
   
    }

    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        int selected_index=myframe.getInvoiceTable().getSelectedRow();
        int SelectedItem =myframe.getItemsTable().getSelectedRow();
        
        System.out.println("selected row" +" " + selected_index);

        if(selected_index != -1){
        
        salesInvoice current_invoice=myframe.getSalesInvoices().get(selected_index);
        
        myframe.getInvoicenumberlLabel().setText(""+current_invoice.getInvoiceNumber()); 
        myframe.getCustomerNameLabel().setText(current_invoice.getCustomerName());
        myframe.getInvoiceDateLabel().setText(current_invoice.getInvoiceDate());
        myframe.getInvoiceTotalLabel().setText(""+current_invoice.getTotal()); 
       
        linesTableModel linestablemodel= new linesTableModel(current_invoice.getInvoiceItems());
        myframe.getItemsTable().setModel(linestablemodel);
        linestablemodel.fireTableDataChanged();
        if(SelectedItem != -1){
            myframe.getInvoicesModel().fireTableDataChanged();}
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
        
    

    private void CreateNewInvoice()
    {
        invoice_Dialog= new salesInvoiceDialog(myframe);
        invoice_Dialog.setVisible(true);
    }

    private void createNewItem()
    {
        InvoiceItemsDialog=new salesInvoiceItemsDialog(myframe);
        InvoiceItemsDialog.setVisible(true);
    }
    
private void deleteItem() {
         int selectedItem= myframe.getItemsTable().getSelectedRow();         
         if(selectedItem !=-1 && selectedItem !=-1 )
         {    System.out.println(selectedItem);
             linesTableModel model=(linesTableModel) myframe.getItemsTable().getModel();
             model.getItems().remove(selectedItem);
             model.fireTableDataChanged();
             myframe.getInvoicesModel().fireTableDataChanged();
     
         }
     }
    private void DeleteInvoice()
    {
     int selectedRow=myframe.getInvoiceTable().getSelectedRow();
        if(selectedRow!=-1)
        {
             System.out.println(selectedRow);
            myframe.getSalesInvoices().remove(selectedRow);
            myframe.getInvoicesModel().fireTableDataChanged();
        
        }
    }
    
    
     private void createInvoiceok() {
        
        DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
         String date = invoice_Dialog.getInvDateField().getText();
        String customer_name = invoice_Dialog.getCustNameField().getText();
        int num = myframe.getNextNumber();        
        try {
            formatter.parse(date);
                salesInvoice salesInvoice = new salesInvoice(num, date, customer_name);
                    myframe.getSalesInvoices().add(salesInvoice);
                    myframe.getInvoicesModel().fireTableDataChanged();
                    invoice_Dialog.setVisible(false);
                    invoice_Dialog.dispose();
                    invoice_Dialog = null;
  
        }
        catch(ParseException x)
        
        {    JOptionPane.showMessageDialog(myframe,
                              "Wrong date format", "Error", JOptionPane.ERROR_MESSAGE);
        }
  
    }
     
     
        private void createlineok() {
      String item = InvoiceItemsDialog .getItemNameField().getText();
        String countStr = InvoiceItemsDialog .getItemCountField().getText();
        String priceStr = InvoiceItemsDialog .getItemPriceField().getText();
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
        InvoiceItemsDialog.setVisible(false);
        InvoiceItemsDialog.dispose();
        InvoiceItemsDialog = null;    
    
    }

    private void createInvoiceCancel() 
    {
        invoice_Dialog.setVisible(false);
        invoice_Dialog.dispose();
        invoice_Dialog=null;
    }
    
      private void createlineCancel() {
        InvoiceItemsDialog.setVisible(false);
        InvoiceItemsDialog.dispose();
        InvoiceItemsDialog=null;
    }
 

}