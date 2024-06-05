
package bank.management.system;
import javax.swing.*;
import java.awt.*;// For using image class
import java.awt.event.*;// For performing Action(ActionListener package)

public class PinChange extends JFrame implements ActionListener{

     JPasswordField pin, repin;
     JButton back,change;
     String pinnumber;

    PinChange(String pinnumber){
       this.pinnumber=pinnumber;
        
    
        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text= new JLabel("Change Your Pin");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,300,500,35);
        image.add(text);
        
        JLabel newPin= new JLabel("New PIN");
        newPin.setForeground(Color.WHITE);
        newPin.setFont(new Font("System",Font.BOLD,16));
        newPin.setBounds(165,350,80,25);
        image.add(newPin);
        
        pin= new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,10));
        pin.setBounds(320,350,180,20);
        image.add(pin);
        
        JLabel rePin= new JLabel("Re-Enter New PIN");
        rePin.setForeground(Color.WHITE);
        rePin.setFont(new Font("System",Font.BOLD,16));
        rePin.setBounds(165,390,180,20);
        image.add(rePin);
        
        repin= new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,10));
        repin.setBounds(320,390,180,20);
        image.add(repin);
        
        change= new JButton("CHANGE");
        change.setBounds(355,450,150,30);
        change.addActionListener(this);
        image.add(change);
        
        back= new JButton("BACK");
        back.setBounds(355,500,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
}
        
        
        public void actionPerformed(ActionEvent ae)
        {
        if(ae.getSource()==change){
         try{
            String npin= pin.getText();
            String rpin= repin.getText();
            if(!npin.equals(rpin))
            {
              JOptionPane.showMessageDialog(null,"Entered PIN not matched");
              return;
             }
            if(npin.equals(""))
            {
              JOptionPane.showMessageDialog(null,"Please Enter New PIN");
               return;
            }
 
            if(rpin.equals(""))
            {
            JOptionPane.showMessageDialog(null, "Please Re-Enter new PIN");
            return;
           }
           conn con= new conn();
           String query1= "Update bank set pin= '"+rpin+"' where pin ='"+pinnumber+"'";
           String query2="Update signup3 set pinnumber= '"+rpin+"' where pinnumber= '"+pinnumber+"'";
           String query3= "Update login set pin= '"+rpin+"' where pin= '"+pinnumber+"'";

           con.s.executeUpdate(query1);
           con.s.executeUpdate(query2);
           con.s.executeUpdate(query3);

           JOptionPane.showMessageDialog(null,"PIN changed successfully");
           
           setVisible(false);
           new Transactions(rpin).setVisible(true);
           }
         catch(Exception e)
         {
          System.out.println(e);
      
         }
}
    else
        {
         setVisible(false);
         new Transactions(pinnumber).setVisible(true);
}
}


    public static void main(String args[])
{
       new PinChange("").setVisible(true);
        
      }

}
