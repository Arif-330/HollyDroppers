/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hollydroppers;

/**
 *
 * @author Arif
 */
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



public class CrntTableModel extends DefaultTableModel {
    Statement statement=null;
    ResultSet resultset=null;
    Connection con;
    int size=0;
    static float totalcredit=0;
    static int[] checkarray=new int[15];
    
    CrntTableModel(){} 
    
    CrntTableModel(String sql){
        
       setColumnIdentifiers(new String[]{"Course","Credit","Select"});
       totalcredit=0;
        
        try{

           Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hollydropersdata","root","");
           statement=con.createStatement();
           resultset=statement.executeQuery(sql);

           while(resultset.next()){
               size++;
           }
           checkarray=new int[size];
           System.out.println("result set size :"+ size);
           setRowCount(size);
           Statement st = statement;
           ResultSet rs=resultset;
           rs=st.executeQuery(sql);
           int i=0;


           while(rs.next()){
               
                String codeTitle = rs.getString(1)+"-" + rs.getString(2);
                
                System.out.println("rs value : "+codeTitle);
                setValueAt(codeTitle, i,0);
                setValueAt(rs.getString(3), i,1);
                totalcredit=totalcredit+rs.getFloat(3);
                i++;

           }
           addTableModelListener(new Tablemodel());
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
        
        if(columnIndex==2)
            return Boolean.class;
       
        else
        return super.getClass();
    }
    public boolean isCellEditable(int row,int col){
        return col==2;
    }
    

    
    
    public class Tablemodel implements TableModelListener{
        public void tableChanged(TableModelEvent te){
      
            if(checkarray[te.getFirstRow()]==0){
                
                checkarray[te.getFirstRow()]=1;
                System.out.println(checkarray[te.getFirstRow()]);
            }else{
                checkarray[te.getFirstRow()]=0;
                // System.out.println("morile kandis nba"+checkarray[3]);
            }
            for(int i=0;i<checkarray.length;i++){
                //System.out.println("thakte jodi na p[ai tomay cai na morile ");
              System.out.print(checkarray[i] + " ");
            }
  
        }
    }
    public float gettotal(){
        System.out.println("total credit:"+totalcredit);
        return totalcredit;
    }
    public int[] getcheckarray(){ 
        return checkarray;
    }

}

