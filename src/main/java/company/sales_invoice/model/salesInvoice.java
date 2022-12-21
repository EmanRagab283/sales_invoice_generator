
package company.sales_invoice.model;

import java.util.ArrayList;

/**
 *
 * @author Eman Ragab
 */
public class salesInvoice {
    private int invoiceNumber;
   private String invoiceDate;
   private String customerName;
   private ArrayList <invoiceItem> invoiceItems;
   
    public double getTotal() {
        double total=0.0;
        for( invoiceItem invoiceItem :getInvoiceItems())
        {
            total += invoiceItem.getitemTotal();
            
        }
        return total;
    }

    public ArrayList<invoiceItem> getInvoiceItems() {
        //lazy loading
        if(invoiceItems==null)
        {
             invoiceItems=new ArrayList<>();
        }
        return invoiceItems;
    }
   

    public salesInvoice() {
    }
   

    public salesInvoice(int invoiceNumber, String invoiceDate, String customerName) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

   public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }   
   
    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
    
      public String getAsCSV() {
        return invoiceNumber  + "," + invoiceDate + "," + customerName;
    }
      

    @Override
    public String toString() {
        return "salesInvoice{" + "invoiceNumber=" + invoiceNumber + ", invoiceDate=" + invoiceDate + ", customerName=" + customerName + '}';
    }
   
   
    
}
