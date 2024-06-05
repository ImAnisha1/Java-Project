package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener {
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;
    String pinnumber;

    Signup3(String formno) {
        this.formno = formno;
        setLayout(null);

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 130, 200, 30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 170, 200, 20);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 170, 240, 20);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 210, 200, 20);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 210, 250, 20);
        add(r4);

        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(r1);
        groupAccount.add(r2);
        groupAccount.add(r3);
        groupAccount.add(r4);

        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 280, 200, 30);
        add(card);

        JLabel cardnumber = new JLabel("XXXX-XXXX-XXXX-4144");
        cardnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        cardnumber.setBounds(330, 280, 300, 30);
        add(cardnumber);

        JLabel carddetails = new JLabel("Your 16 digit card number");
        carddetails.setFont(new Font("Raleway", Font.BOLD, 12));
        carddetails.setBounds(100, 320, 300, 20);
        add(carddetails);

        JLabel pin = new JLabel("Pin Number");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 360, 200, 30);
        add(pin);

        JLabel pinnumber = new JLabel("XXXX");
        pinnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pinnumber.setBounds(330, 360, 200, 30);
        add(pinnumber);

        JLabel pinddetails = new JLabel("Your 4 digit pin number");
        pinddetails.setFont(new Font("Raleway", Font.BOLD, 12));
        pinddetails.setBounds(100, 380, 300, 20);
        add(pinddetails);

        JLabel services = new JLabel("Services required");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 440, 200, 30);
        add(services);

        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 15));
        c1.setBounds(100, 480, 200, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 15));
        c2.setBounds(350, 480, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 15));
        c3.setBounds(100, 520, 200, 30);
        add(c3);

        c4 = new JCheckBox("Email/SMS Alert");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 15));
        c4.setBounds(350, 520, 200, 30);
        add(c4);

        c5 = new JCheckBox("Check Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 15));
        c5.setBounds(100, 560, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 15));
        c6.setBounds(350, 560, 200, 30);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 620, 640, 30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 670, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420, 670, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);

        setSize(870, 840);
        setLocation(350, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = null;
            if (r1.isSelected()) {
                accountType = "Saving Account";
            } else if (r2.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (r3.isSelected()) {
                accountType = "Current Account";
            } else if (r4.isSelected()) {
                accountType = "Recurring Deposit Account";
            }

            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 9000000000000000L) +5040936000000000L);
            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            String facility = "";
            if (c1.isSelected()) {
            facility += "ATM Card, ";
             }
            if (c2.isSelected()) {
            facility += "Internet Banking, ";
             }
            if (c3.isSelected()) {
           facility += "Mobile Banking, ";
           }
           if (c4.isSelected()) {
           facility += "Email/SMS Alert, ";
           }
          if (c5.isSelected()) {
         facility += "Check Book, ";
          }
         if (c6.isSelected()) {
          facility += "E-Statement, ";
          }
         
                 if (!accountType.isEmpty()) {
            // Inserting into the database
            try {
                conn c = new conn();
                String query = "insert into signup3 values('" + formno + "','" + accountType + "','" + cardnumber + "','" + pinnumber + "','" + facility + "')";
                String query2="insert into login values('" + formno + "', '"+ cardnumber + "','" + pinnumber + "' )";
                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Card number: " + cardnumber + "\nPin: " + pinnumber);
                setVisible(false);
                new Deposit(pinnumber).setVisible(false);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select an account type");
        }
    } else if (ae.getSource() == cancel) {
        setVisible(false);
        new Deposit(pinnumber).setVisible(true);
        // Action when cancel button is pressed
    }
}

      public static void main(String args[]) {
         new Signup3("");
     }
}

