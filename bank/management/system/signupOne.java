
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class signupOne extends JFrame implements ActionListener{
    long random;
    JTextField nameTextField,fnameTextField,dateTextField,emailTextField, addressTextField,
    cityTextField, stateTextField,pinTextField;
    JButton next; 
    JRadioButton male,female,other,married,unmarried;
            
    signupOne()
    {
        setLayout(null);
        Random ran= new Random();
        random= (Math.abs(ran.nextLong()% 900L)+ 1000L);
        
        JLabel formno= new JLabel("Application Form No ="+ random);
        formno.setBounds(140,20,600,40);
        formno.setFont(new Font("Raileway", Font.BOLD,38));
        add(formno);
        
        JLabel personalDetails= new JLabel("Page 1: Personal Details");
        personalDetails.setBounds(290,80,400,30);
        personalDetails.setFont(new Font("Raileway", Font.BOLD,22));
        add(personalDetails);
        
        JLabel name= new JLabel("Name:");
        name.setBounds(100,140,100,30);
        name.setFont(new Font("Raileway", Font.BOLD,20));
        add(name);
        
        nameTextField= new JTextField();
        nameTextField.setBounds(300,140,400,30);
        nameTextField.setFont(new Font("Raileway", Font.BOLD,14));
        add(nameTextField);
        
        JLabel fname= new JLabel("Father's Name:");
        fname.setBounds(100,190,200,30);
        fname.setFont(new Font("Raileway", Font.BOLD,20));
        add(fname);
        
        fnameTextField= new JTextField();
        fnameTextField.setBounds(300,190,400,30);
        fnameTextField.setFont(new Font("Raileway", Font.BOLD,14));
        add(fnameTextField);
        
        JLabel dob= new JLabel("Date of Birth:");
        dob.setBounds(100,240,200,30);
        dob.setFont(new Font("Raileway", Font.BOLD,20));
        add(dob);
        
        dateTextField= new JTextField();
        dateTextField.setBounds(300,240,400,30);
        dateTextField.setFont(new Font("Raileway", Font.BOLD,14));
        add(dateTextField);

        
        
                
        JLabel gender= new JLabel("Gender:");
        gender.setBounds(100,290,200,30);
        gender.setFont(new Font("Raileway", Font.BOLD,20));
        add(gender);
        
        male= new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female= new JRadioButton("Female");
        female.setBounds(450,290,60,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gendergroup= new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email= new JLabel("Email Address:");
        email.setBounds(100,340,200,30);
        email.setFont(new Font("Raileway", Font.BOLD,20));
        add(email);
        
        emailTextField= new JTextField();
        emailTextField.setBounds(300,340,400,30);
        emailTextField.setFont(new Font("Raileway", Font.BOLD,14));
        add(emailTextField);

        
        JLabel marital= new JLabel("Marital Status:");
        marital.setBounds(100,390,150,30);
        marital.setFont(new Font("Raileway", Font.BOLD,20));
        add(marital);
        
        married= new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried= new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        other= new JRadioButton("others");
        other.setBounds(630,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup maritalgroup= new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);
        
        JLabel address= new JLabel("Address:");
        address.setBounds(100,440,200,30);
        address.setFont(new Font("Raileway", Font.BOLD,20));
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setBounds(300,440,400,30);
        addressTextField.setFont(new Font("Raileway", Font.BOLD,14));
        add(addressTextField);
        
        JLabel city= new JLabel("City:");
        city.setBounds(100,490,200,30);
        city.setFont(new Font("Raileway", Font.BOLD,20));
        add(city);
        
        cityTextField= new JTextField();
        cityTextField.setBounds(300,490,400,30);
        cityTextField.setFont(new Font("Raileway", Font.BOLD,14));
        add(cityTextField);
        
        JLabel state= new JLabel("State:");
        state.setBounds(100,540,200,30);
        state.setFont(new Font("Raileway", Font.BOLD,20));
        add(state);
        
        stateTextField= new JTextField();
        stateTextField.setBounds(300,540,400,30);
        stateTextField.setFont(new Font("Raileway", Font.BOLD,14));
        add(stateTextField);
        
        JLabel pincode= new JLabel("Pin Code:");
        pincode.setBounds(100,590,200,30);
        pincode.setFont(new Font("Raileway", Font.BOLD,20));
        add(pincode);
        
        pinTextField= new JTextField();
        pinTextField.setBounds(300,590,400,30);
        pinTextField.setFont(new Font("Raileway", Font.BOLD,14));
        add(pinTextField);

        
        next= new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD, 14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        
        

        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public void  actionPerformed(ActionEvent ae)
    {
        String formno= ""+ random;
        String name= nameTextField.getText();
        String fname= fnameTextField.getText();
        String dob= dateTextField.getText();
        String gender= null;
        if(male.isSelected())
        {
        gender= "Male";
        }
        else if(female.isSelected())
        {
        gender="Female";
        }
        
        String email= emailTextField.getText();
        String marital=null;
        if(married.isSelected())
        {
         marital="Married";
        }
        else if(unmarried.isSelected())
        {
        marital="Unmarried";
        }
        else if(other.isSelected())
        {
        marital="Other";
        }
        String address= addressTextField.getText();
        String city= cityTextField.getText();
        String state= stateTextField.getText();
        String pin= pinTextField.getText();
        
        try{
            if(name.equals(""))
            {
            JOptionPane.showMessageDialog(null, "Name is required");
            }
            else{
             conn c= new conn();
            String query= "insert into signup values('"+formno+"','"+name+"','"+fname+"'"
                    + ",'"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"
                    +city+"','"+state+"','" +pin+"')";
            c.s.executeUpdate(query);
            
            setVisible(false);
            new Signup2(formno).setVisible(true);
           }
            
        }
        catch(Exception e)
        {
        System.out.println(e);
        }
                
    }

        public static void main(String args[]) {
            new signupOne();
        
    }
}
