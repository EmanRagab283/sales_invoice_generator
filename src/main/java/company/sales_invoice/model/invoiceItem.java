package company.sales_invoice.model;

/**
 *
 * @author Eman Ragab
 */
public class invoiceItem {
   //private int invoiceNumber;
   private String productName;
    private double productPrice;
    private int productCount;
    private salesInvoice salesInvoice;
    
    public double getitemTotal() {
        return productPrice * productCount;
    }


       
    public invoiceItem() {
    }
  public invoiceItem( String productName, double productPrice) {
        //this.invoiceNumber = invoiceNumber;
        this.productName = productName;
        this.productPrice = productPrice;

    }

    public salesInvoice getSalesInvoice() {
        return salesInvoice;
    }

    public void setSalesInvoice(salesInvoice salesInvoice) {
        this.salesInvoice = salesInvoice;
    }
    public invoiceItem( String productName, double productPrice, int productCount,salesInvoice salesInvoice) {
        //this.invoiceNumber = invoiceNumber;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCount = productCount;
        this.salesInvoice= salesInvoice;
    }

   /* public int getInvoiceNumber() {
        return invoiceNumber;
    }
     public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }*/

    public String getProductName() {
        return productName;
    }
      public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }
      public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }
     
    public String getAsCSV() {
        return salesInvoice.getInvoiceNumber()+ "," + productName + "," + productPrice + "," + productCount;
    }
  
    @Override
      public String toString() {
         return "invoiceItem{" + "no.=" +salesInvoice.getInvoiceNumber() + ", productName=" + productName + ", productPrice=" + productPrice + ", productCount=" + productCount+ '}';

      }   
      
 
     
   
         
}
