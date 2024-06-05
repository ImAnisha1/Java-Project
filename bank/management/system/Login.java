
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;// for using result


public class Login extends JFrame implements ActionListener{
    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login()
    {
        setTitle("Automated Taller Machine");
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel label= new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        JLabel text =new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);
        
        JLabel cardno =new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 250, 30);
        add(cardno);
        
        cardTextField= new JTextField();
        cardTextField.setBounds(300, 150, 250, 30);
        add(cardTextField);
        
        
        JLabel pin =new JLabel("Pin:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 250, 30);
        add(pin);
        
        pinTextField= new JPasswordField();
        pinTextField.setBounds(300, 220, 250, 30);
        add(pinTextField);
        
        login = new JButton("Sign In");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("Clear");
        clear.setBounds(450, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);

        add(clear);
        
        signup = new JButton("Sign Up");
        signup.setBounds(300, 350, 250, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        
        getContentPane().setBackground(Color.WHITE);
     setSize(800,400);
     setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== clear){
        cardTextField.setText("");    
        pinTextField.setText("");
        
        }
        else if(ae.getSource()== signup)
        {
            setVisible(false);
            new signupOne().setVisible(true);
         }
        else if(ae.getSource()== login)
        {
            conn c=new conn();
            String cardnumber=cardTextField.getText();
            String pinnumber=pinTextField.getText();
            String query="Select * from login where cardnumber='"+cardnumber+"'and pin='"+pinnumber+"'";
            try{
                ResultSet rs= c.s.executeQuery(query);
                if(rs.next())
                {
                setVisible(false);//User successful login happened
                new Transactions(pinnumber).setVisible(true);
                }else
                {
                JOptionPane.showMessageDialog(null, "Incorrect card number or pin");}
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }

    
    public static void main(String args[]) {
        new Login();
        
    }
}

