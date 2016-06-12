/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//tutionee---------------------------------------------------------------------------- 01673769693

package hollydroppers;

/**
 *
 * @author Arifur Rahman
 */
import java.sql.*;
import java.util.Arrays;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public class connectDB {
    
    public Statement statement=null;
    public ResultSet resultset=null;
    Connection con;
    int size;
    static String cgpaselected=""; 
    
    connectDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hollydropersdata","root","");
            statement=con.createStatement();
        }catch(Exception e){
            System.out.println(e.toString());
        }
        
    }
    

    public String[] titlecomboitem(String sql){
       String[] itemcombo=new String[15];
       try{
        resultset=statement.executeQuery(sql);
        int item=0;
        while(resultset.next()){
            item++;
           }
        itemcombo=new String[item];
       // final String[] itemcomboTry =new String[item];
        System.out.println("item number : "+item);
        Statement st=getStatement();
        ResultSet rs=getResultset();
        rs=st.executeQuery(sql);
        //get row size

        int j=0;
        while(rs.next()){
            itemcombo[j]=rs.getString(1);
            j++;
        }
        //itemcombo = Arrays.copyOfRange(itemcomboTry, 0, item);
       }catch(Exception e){
           System.out.println("Error: "+e.toString());
           e.printStackTrace();
       }
       return itemcombo;
    }
    
    public boolean insertdata(String sql){
        try{
            statement.executeUpdate(sql);
             System.out.println("error nai naire naire nai ");
             return true;
        }catch(Exception e){
            System.out.println("error: "+e);
            return false;
        }
        
    }
    public boolean deleterow(String sql){
        try{
            statement=con.prepareStatement(sql);
            statement.execute(sql);
            System.out.println("Error nai delete");
            return true;
        }catch(Exception e){
            System.out.println("error :"+e);
            return false;
        }
    }
    public boolean search(String sql){
        try{
            resultset=statement.executeQuery(sql);
            System.out.println("serch esecute");
            
            if(resultset.absolute(1)){
             
                    cgpaselected=resultset.getString(7);
                System.out.println("cgpa paichi :"+cgpaselected);

                return true;
            }else
                return false;
            
        }catch(Exception e){
            System.out.println("serch esecute");
            return false;
        }
    }
    public String getselectedcgpa(){
        return cgpaselected;
    }
    
    public DefaultTableModel table(String sql){
        DefaultTableModel dtm=new DefaultTableModel();
        try{
            
            resultset =statement.executeQuery(sql);
            
            dtm.setColumnIdentifiers(new String[]{"y/s","Code","Title","Creadit","Select"});
             while(resultset.next()){
                size++;
             }
            System.out.println("kjkdjkjkjkjkjjjjjjj :"+size);
            dtm.setRowCount(size);
        TableColumn tablecolumn;
        
        JCheckBox jcheck=new JCheckBox();
       // tablecolumn.setCellEditor(new DefaultCellEditor(jcheck));
            
            Statement st=getStatement();
            ResultSet rs=getResultset();
            rs=st.executeQuery(sql);
              
       
            //put data in table 
            int i=0;
            while(rs.next()){
                dtm.setValueAt(rs.getInt(2)+"/"+rs.getInt(3), i,0);
                dtm.setValueAt(rs.getString(4), i,1);
                dtm.setValueAt(rs.getString(5), i,2);
                dtm.setValueAt(rs.getString(6), i,3);
                //dtm.setValueAt(5000, i,4);
               // dtm.getColumn(i).setCellEditor(genTable.getDefaultEditor(Boolean.class)); 
                i++;
            }
            
            
            
           
        }catch(Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return dtm;
        
    }
    
    public Statement getStatement(){
        return statement;
    }
    public ResultSet getResultset(){
        return resultset;
    }
    
    public Connection getConnection(){
        return con;
    }
}
