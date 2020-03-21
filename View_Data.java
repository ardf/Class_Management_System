package StudentsDB;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class View_Data implements ActionListener{
    JFrame f;
    JTextField t;
    JButton b1,b2;
    JLabel l;

    View_Data()
    {
        f = new JFrame("View Data");
        f.setSize(400,350);
        f.setLocation(400,150);
        f.setBackground(Color.white);
        f.setLayout(null);

        l = new JLabel("Enter USN");
        l.setBounds(20,10,100,30);
        l.setFont(new Font("serif",Font.BOLD,20));
        f.add(l);

        t = new JTextField("");
        t.setBounds(130,10,200,30);
        t.setBackground(Color.white);
        t.setFont(new Font("serif",Font.BOLD,20));
        f.add(t);

        b1 = new JButton("Search");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(20,50,100,30);
        b1.addActionListener(this);
        f.add(b1);

        b2=new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(130,50,100,30);
        b2.addActionListener(this);
        f.add(b2);
        f.setVisible(true);

    }
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {
            if(t.getText().length()!=10)
            {
                JOptionPane.showMessageDialog(null,"Invalid Input");
                t.setText("");
                f.setVisible(true);

            }
            else {
                new Print_Data(t.getText());
                t.setText("");
            }
        }
        if(ae.getSource()==b2){
            f.setVisible(false);
        }
    }
        public static void main(String[] args)
    {
        new View_Data();
    }
}
