package company.sales_invoice.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;



/**
 *
 * @author Eman Ragab
 */
public class linesTableModel extends AbstractTableModel {
    
    private ArrayList<invoiceItem> items;
      private  String[] cols={"No.","Item Name","item price","Count","item total"};

    public linesTableModel(ArrayList<invoiceItem> items) {
        this.items= items;
    }   
  

    public ArrayList<invoiceItem> getItems() {
        return items;
    }
    
 
    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }
    
      @Override
    public String getColumnName(int col){
        return cols[col];
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        invoiceItem invoiceItem=items.get(rowIndex);

        switch (columnIndex)
        {
            case 0:
            return invoiceItem.getSalesInvoice().getInvoiceNumber();
        case 1: 
            return invoiceItem.getProductName();
        case  2: 
            return invoiceItem.getProductPrice();
         case  3: 
            return invoiceItem.getProductCount();
         case  4: 
            return invoiceItem.getitemTotal();
         default: return ""; 
        }
    }

    
    
}
