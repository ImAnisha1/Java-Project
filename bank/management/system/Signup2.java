
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener{
    long random;
    JTextField  panTextField,aadharTextField;
    JButton next; 
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,occupation,education,income;
    String formno;
            
    Signup2(String formno)
    {
        this.formno=formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails= new JLabel("Page 2: Additional Details");
        additionalDetails.setBounds(290,80,400,30);
        additionalDetails.setFont(new Font("Raleway", Font.BOLD,22));
        add(additionalDetails);
        
        JLabel name= new JLabel("Religion:");
        name.setBounds(100,140,100,30);
        name.setFont(new Font("Raleway", Font.BOLD,20));
        add(name);
        
        String valReligion[]= {"Hindu","Muslim","Sikh","Christan","Other"};
        religion= new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
        JLabel fname= new JLabel("Category:");
        fname.setBounds(100,190,200,30);
        fname.setFont(new Font("Raleway", Font.BOLD,20));
        add(fname);
        
        String valcategory[]={"General","SC","ST","Other"};
        category= new JComboBox(valcategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel dob= new JLabel("Income:");
        dob.setBounds(100,240,200,30);
        dob.setFont(new Font("Raleway", Font.BOLD,20));
        add(dob);
        
        String valincome[]= {"null","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000"};
        income=new JComboBox(valincome);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel gender= new JLabel("Educational");
        gender.setBounds(100,290,200,30);
        gender.setFont(new Font("Raleway", Font.BOLD,20));
        add(gender);
        
        JLabel email= new JLabel("Qualification:");
        email.setBounds(100,315,200,30);
        email.setFont(new Font("Raleway", Font.BOLD,20));
        add(email);
        
        String valeducation[]= {"Non-graduation","Graduate","Post-Graduation","Others"};
        education=new JComboBox(valeducation);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);

        
        JLabel marital= new JLabel("Occupation:");
        marital.setBounds(100,390,200,30);
        marital.setFont(new Font("Raleway", Font.BOLD,20));
        add(marital);
        
        String valoccupation[]= {"Self-employeed","Salaried","Business","Student","Retired","Others"};
        occupation=new JComboBox(valoccupation);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
      
        
        JLabel address= new JLabel("PAN Number:");
        address.setBounds(100,440,200,30);
        address.setFont(new Font("Raleway", Font.BOLD,20));
        add(address);
        
        panTextField = new JTextField();
        panTextField.setBounds(300,440,400,30);
        panTextField.setFont(new Font("Raileway", Font.BOLD,14));
        add(panTextField);
        
        JLabel city= new JLabel("Aadhar Number:");
        city.setBounds(100,490,200,30);
        city.setFont(new Font("Raleway", Font.BOLD,20));
        add(city);
        
        aadharTextField= new JTextField();
        aadharTextField.setBounds(300,490,400,30);
        aadharTextField.setFont(new Font("Raleway", Font.BOLD,14));
        add(aadharTextField);
        
        JLabel state= new JLabel("Senior citizen:");
        state.setBounds(100,540,200,30);
        state.setFont(new Font("Raleway", Font.BOLD,20));
        add(state);
        
        syes= new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno= new JRadioButton("No");
        sno.setBounds(550,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup maritalgroup= new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);
        
        
        JLabel pincode= new JLabel("Existing Account:");
        pincode.setBounds(100,590,200,30);
        pincode.setFont(new Font("Raleway", Font.BOLD,20));
        add(pincode);
        
        eyes= new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno= new JRadioButton("No");
        eno.setBounds(550,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup emaritalgroup= new ButtonGroup();
        emaritalgroup.add(syes);
        emaritalgroup.add(sno);
        
       
        
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
        //String formno= " "+ random;
        String sreligion= (String)religion.getSelectedItem();
        String scategory= (String)category.getSelectedItem();
        String sincome= (String)income.getSelectedItem();
        
        String seducation= (String)education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String seniorcitizen=null;
        if(syes.isSelected())
        {
        seniorcitizen= "Yes";
        }
        else if(sno.isSelected())
        {
        seniorcitizen="No";
        }
        
        String existingAccount=null;
        if(eyes.isSelected())
        {
         existingAccount="Yes";
        }
        else if(eno.isSelected())
        {
        existingAccount="No";
        }
        
        String span= panTextField.getText();
        String saadhar= aadharTextField.getText();
        
        try{
           conn c= new conn();
            String query= "insert into Signup2 values('"+formno+"','"+sreligion+"','"+scategory+"','"
                  +sincome+ "','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"
                    +existingAccount+"')";
            c.s.executeUpdate(query);
            //signUp3
            setVisible(false);
            new Signup3(formno).setVisible(true);
        }
        catch(Exception e)
        {
        System.out.println(e);
        }
                
    }

        public static void main(String args[]) {
            new Signup2("");
        
    }
}
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener{
    long random;
    JTextField panTextField, aadharTextField;
    JButton next; 
    JRadioButton syes, sno, eyes, eno;
    JComboBox<String> religion, category, occupation, education, income;
    String formno;
            
    Signup2(String formno) {
        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setBounds(290, 80, 400, 30);
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        add(additionalDetails);
        
        JLabel name = new JLabel("Religion:");
        name.setBounds(100, 140, 100, 30);
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        add(name);
        
        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox<>(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        JLabel fname = new JLabel("Category:");
        fname.setBounds(100, 190, 200, 30);
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        add(fname);
        
        String valCategory[] = {"General", "SC", "ST", "Other"};
        category = new JComboBox<>(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel dob = new JLabel("Income:");
        dob.setBounds(100, 240, 200, 30);
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        add(dob);
        
        String valIncome[] = {"null", "<1,50,000", "<2,50,000", "<5,00,000", "upto 10,00,000"};
        income = new JComboBox<>(valIncome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel gender = new JLabel("Educational");
        gender.setBounds(100, 290, 200, 30);
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        add(gender);
        
        JLabel email = new JLabel("Qualification:");
        email.setBounds(100, 315, 200, 30);
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        add(email);
        
        String valEducation[] = {"Non-graduation", "Graduate", "Post-Graduation", "Others"};
        education = new JComboBox<>(valEducation);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);
        
        JLabel marital = new JLabel("Occupation:");
        marital.setBounds(100, 390, 200, 30);
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        add(marital);
        
        String valOccupation[] = {"Self-employed", "Salaried", "Business", "Student", "Retired", "Others"};
        occupation = new JComboBox<>(valOccupation);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        JLabel address = new JLabel("PAN Number:");
        address.setBounds(100, 440, 200, 30);
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        add(address);
        
        panTextField = new JTextField();
        panTextField.setBounds(300, 440, 400, 30);
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        add(panTextField);
        
        JLabel city = new JLabel("Aadhar Number:");
        city.setBounds(100, 490, 200, 30);
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        add(city);
        
        aadharTextField = new JTextField();
        aadharTextField.setBounds(300, 490, 400, 30);
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        add(aadharTextField);
        
        JLabel state = new JLabel("Senior Citizen:");
        state.setBounds(100, 540, 200, 30);
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        add(state);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(550, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);
        
        JLabel pincode = new JLabel("Existing Account:");
        pincode.setBounds(100, 590, 200, 30);
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pincode);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(550, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup emaritalgroup = new ButtonGroup();
        emaritalgroup.add(eyes);
        emaritalgroup.add(eno);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        
        String seniorcitizen = null;
        if (syes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }
        
        String existingAccount = null;
        if (eyes.isSelected()) {
            existingAccount = "Yes";
        } else if (eno.isSelected()) {
            existingAccount = "No";
        }
        
        String span = panTextField.getText();
        String saadhar = aadharTextField.getText();
        
        try {
            conn c = new conn();
            String query = "insert into Signup2 values('" + formno + "','" + sreligion + "','" + scategory + "','" +
                    sincome + "','" + seducation + "','" + soccupation + "','" + span + "','" + saadhar + "','" + 
                    seniorcitizen + "','" + existingAccount + "')";
            c.s.executeUpdate(query);
            // Proceed to the next signup page
             new signup3(formno).setVisible(true); 
             setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new Signup2("");
    }
}
