/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package company.sales_invoice.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
//import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eman Ragab
 */
public class invoicesModel extends AbstractTableModel {
    private  ArrayList <salesInvoice> salesInvoices;
    private  String[] cols={"NO." , "Date" , "Customer Name" , "total"};

    public invoicesModel(ArrayList<salesInvoice> salesInvoices) {
        this.salesInvoices = salesInvoices;
    }
    
    
    @Override
    public int getRowCount(){
        return salesInvoices.size();
    }

 
    @Override
    public int getColumnCount(){
        return cols.length;
    }    
    @Override
  public String  getColumnName(int col){
        return cols[col];
    }
   @Override
  public Object getValueAt(int rowIndex ,int columnIndex){
      salesInvoice salesInvoice=salesInvoices.get(rowIndex);
     
       switch (columnIndex)
      {
          case 0:
              return salesInvoice.getInvoiceNumber();
          case 1: return salesInvoice.getInvoiceDate();
          case 2: return salesInvoice.getCustomerName();
          case 3: return salesInvoice.getTotal();
           default:  return "";
      }
      
    }
    
}
