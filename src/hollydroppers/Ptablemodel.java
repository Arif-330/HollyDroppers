/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hollydroppers;

/**
 *
 * @author Arif
 */
import static hollydroppers.Dtablemodel.totalcredit;
import static hollydroppers.HollyDroppersFrame2.ptable;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
//import org.omg.CORBA.INTERNAL;
//import org.omg.CORBA.Object;



public class Ptablemodel extends DefaultTableModel {
    Statement statement=null;
    ResultSet resultset=null;
    Connection con;
    int size=0;
            float totalcgpa=0;
        float credit=0;
        static float  cgpa=0;
        static float totalcredit=0;
        static float emptycredit=0;
   
        
    static int[] checkarray=new int[15];
    Ptablemodel(){}        
    Ptablemodel(String sql){
       setColumnIdentifiers(new String[]{"y/s","Code","Title","Credit","Cgpa","Select"});
       totalcredit=0;emptycredit=0;
        
    try{
        
       Class.forName("com.mysql.jdbc.Driver");
       con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hollydropersdata","root","");
       statement=con.createStatement();
       resultset=statement.executeQuery(sql);
      
       while(resultset.next()){
           size++;
       }
       checkarray=new int[size];
       System.out.println(size);
       setRowCount(size);
       Statement st = statement;
       ResultSet rs=resultset;
       rs=st.executeQuery(sql);
       int i=0;
     
       
       while(rs.next()){
               
               String s=rs.getInt(2)+"/"+rs.getInt(3);
                setValueAt(s, i,0);
                setValueAt(rs.getString(4), i,1);
                setValueAt(rs.getString(5), i,2);
                setValueAt(rs.getFloat(6), i,3);
                setValueAt(rs.getString(7), i,4);
                
                credit=rs.getFloat(6);
                switch(rs.getString(7)){
                    case "A+":
                        totalcgpa+=rs.getFloat(6)*4;
                        totalcredit=totalcredit+rs.getFloat(6);
                        break;
                    case "A":
                        totalcgpa+=credit*3.75;
                        totalcredit=totalcredit+rs.getFloat(6);
                        break;
                    case "A-":
                        totalcgpa+=credit*3.50;
                        totalcredit=totalcredit+rs.getFloat(6);
                        break;
                    case "B+":
                        totalcgpa+=credit*3.25;
                        totalcredit=totalcredit+rs.getFloat(6);
                        break;
                    case "B":
                        totalcgpa+=credit*3.00;
                       totalcredit=totalcredit+rs.getFloat(6);
                        break;
                    case "B-":
                        totalcgpa+=credit*2.75;
                        totalcredit=totalcredit+rs.getFloat(6);
                        break;
                    case "C+":
                        totalcgpa+=credit*2.50;
                        totalcredit=totalcredit+rs.getFloat(6);
                        break;
                    case "C":
                        totalcgpa+=credit*2.25;
                       totalcredit=totalcredit+rs.getFloat(6);
                        break;
                    case "C-":
                        totalcgpa+=credit*2.00;
                        totalcredit=totalcredit+rs.getFloat(6);
                        break;
                   case "Empty":
                        //totalcgpa+=credit*0;
                        emptycredit=emptycredit+rs.getFloat(6);
                       
                        break;
                    default:
                        break;
                }
                i++;
           
       }
       if(totalcredit==0)
           cgpa=0;
       else
           cgpa=totalcgpa/totalcredit;
       addTableModelListener(new Ptablemodel.Tablemodel());
       System.out.println("total credit:"+totalcredit);
       
    }catch(Exception e){
        System.out.println("Error : "+e);
        e.printStackTrace();
    }
   }
    
    public void tableChanged(TableModelEvent  te){
        System.out.println(te.getColumn()); 
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) { 
        
        if(columnIndex==5)
            return Boolean.class;
       
        else
        return super.getClass();
    }
    public boolean isCellEditable(int row,int col){
        return col==5;
    }
    

    
    /* public void setValueAt(Boolean aValue, int row, int column) {
            System.out.println("value of checkbox:"+ aValue);
           Vector rowData = (Vector)getDataVector().get(row);
        if (aValue instanceof Boolean && column == 4) {
     
       
        rowData.set(4, (boolean)aValue);
        fireTableCellUpdated(row, column);
      }


    }*/
    
    public class Tablemodel implements TableModelListener{
        public void tableChanged(TableModelEvent te){
      
            if(checkarray[te.getFirstRow()]==0){
                checkarray[te.getFirstRow()]=1;
                System.out.println(checkarray[te.getFirstRow()]);
            }else{
                checkarray[te.getFirstRow()]=0;
                
            }
            for(int i=0;i<checkarray.length;i++){
           
              System.out.print(checkarray[i] + " ");
            }
              
            
 
            
            
           
        }
    }
    public float getcgpa(){
        return cgpa;
    }

    public float gettotal(){
        System.out.println("total credit:"+(totalcredit+emptycredit));
        return (emptycredit+totalcredit);
    }
    public int[] getcheckarray(){
       
 
        return checkarray;
    }

}

