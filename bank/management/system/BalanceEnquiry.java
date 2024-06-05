
package bank.management.system;
import javax.swing.*;// For JLabel, JFrame
import java.awt.event.*;// For using ActionListener Package
import java.awt.*; // For using Image
import java.sql.*; //importing ResultSet



public class BalanceEnquiry extends JFrame implements ActionListener{
    JButton back;
    String pinnumber;
    
    BalanceEnquiry(String pinnumber){
        
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        back= new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        conn c= new conn();
        int balance=0;
        try{
        ResultSet rs= c.s.executeQuery("Select * from bank where pin= '"+pinnumber+"'");
        
        while(rs.next())
        {
            if(rs.getString("type").equals("Deposit"))
            {
            balance+= Integer.parseInt(rs.getString("amount"));
            }
            else
            {
                balance-= Integer.parseInt(rs.getString("amount"));
            }
        }
        }
        catch(Exception e)
        {
        System.out.println(e);
        }
        JLabel text= new JLabel("Your Current Account Balance Is Rs:"+balance);
        text.setForeground(Color.WHITE);
        text.setBounds(170,300,400,30);
        image.add(text);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
      }
    public void actionPerformed(ActionEvent ae)
    {
      setVisible(false);
      new Transactions(pinnumber).setVisible(true);
    }

    
    public static void main(String args[]) {
        new BalanceEnquiry("");
    }
}
