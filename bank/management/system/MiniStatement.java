
package bank.management.system;
import javax.swing.*;
import java.awt.*; //For using color class in java
import java.sql.*;


public class MiniStatement extends JFrame {
    MiniStatement(String pinnumber)
    {
        
        setTitle("Mini Statement");
        setLayout(null);
        
        JLabel mini= new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);
        
        JLabel bank= new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel card =new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel balance= new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        
       try{
           conn con= new conn();
           int bal=0;
           ResultSet rs= con.s.executeQuery("Select * from login where pin = '"+pinnumber+"'");
           while(rs.next())
           {
           card.setText("Card Number : " + rs.getString("cardnumber").substring(0,4)+ "XXXXXXXX"+rs.getString("cardnumber").substring(12));
           if(rs.getString("type").equals("Deposit"))
            {
            bal+= Integer.parseInt(rs.getString("amount"));
            }
            else
            {
                bal-= Integer.parseInt(rs.getString("amount"));
            }
           
           }
           balance.setText("Your current balance is Rs:"+bal);
       }
       catch(Exception e)
       {
        System.out.println(e);
       }
       
       try{
           conn con= new conn();
           ResultSet rs= con.s.executeQuery("Select * from bank where pin='"+pinnumber+"'");
           while(rs.next())
           {
               mini.setText(mini.getText()+ "<html>" + rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
           }
       }
       catch(Exception e){
           System.out.println(e);
       }
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
    }
    

        public static void main(String args[]) {
            new MiniStatement("");
        
    }
}
