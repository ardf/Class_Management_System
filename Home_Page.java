package StudentsDB;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Home_Page implements ActionListener {
    JFrame f;
    JButton b1,b2,b3,b4,b5;
    JLabel l1,l2;

    Home_Page(){
        f = new JFrame("Class Management System");
        f.setBounds(400,150,400,500);
        f.setBackground(Color.WHITE);
        f.setLayout(null);


        l1 = new JLabel("Class Management System");
        l1.setFont(new Font("serif",Font.BOLD,29));
        l1.setBounds(20,30,380,40);
        f.add(l1);

        b1 = new JButton("Add Student");
        b1.setFont(new Font("serif",Font.PLAIN,13));
        b1.setBounds(130,110,135,25);
        b1.setBackground(Color.gray);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        f.add(b1);

        b2 = new JButton("View Student");
        b2.setFont(new Font("serif",Font.PLAIN,13));
        b2.setBounds(130,150,135,25);
        b2.setBackground(Color.gray);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        f.add(b2);

        b3 = new JButton("Update Student");
        b3.setFont(new Font("serif",Font.PLAIN,13));
        b3.setBounds(130,190,135,25);
        b3.setBackground(Color.gray);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        f.add(b3);

        b4 = new JButton("Remove Student");
        b4.setFont(new Font("serif",Font.PLAIN,13));
        b4.setBounds(130,230,135,25);
        b4.setBackground(Color.gray);
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this);
        f.add(b4);

        l2 = new JLabel("ALL RIGHTS RESERVED ©");
        l2.setFont(new Font("serif",Font.ITALIC,10));
        l2.setBounds(150,430,380,40);
        f.add(l2);

        b5 = new JButton("Exit");
        b5.setFont(new Font("serif",Font.PLAIN,13));
        b5.setBounds(130,270,135,25);
        b5.setBackground(Color.gray);
        b5.setForeground(Color.WHITE);
        b5.addActionListener(this);
        f.add(b5);


        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b1){
            new Insert_Data();
        }
        if(ae.getSource()==b2){
            new View_Data();
        }
        if(ae.getSource()==b3){
            new Update_Data();
        }
        if(ae.getSource()==b4){
            new Delete_Data();
        }
        if(ae.getSource()==b5)
        {
            System.exit(0);
        }
    }

    public static void main(String[] args){
        new Home_Page();
    }
}
