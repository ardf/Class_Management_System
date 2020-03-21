package StudentsDB;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class Delete_Data implements ActionListener{
    JFrame f;
    JTextField t;
    JButton b1,b2,b3,b4;
    JLabel l,l2,l3,l4,l5,l6;
    String name,gender;

    Delete_Data()
    {
        f = new JFrame("Delete Data");
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

        l2 = new JLabel("Name: ");
        l2.setBounds(20,100,100,30);
        l2.setFont(new Font("serif",Font.BOLD,20));
        f.add(l2);
        l2.setVisible(false);

        l3 = new JLabel();
        l3.setBounds(130,100,200,30);
        l3.setFont(new Font("serif",Font.BOLD,20));
        f.add(l3);

        l4 = new JLabel("Gender: ");
        l4.setBounds(20,140,100,30);
        l4.setFont(new Font("serif",Font.BOLD,20));
        f.add(l4);
        l4.setVisible(false);

        l5 = new JLabel();
        l5.setBounds(130,140,200,30);
        l5.setFont(new Font("serif",Font.BOLD,20));
        f.add(l5);



        l6 = new JLabel("Do you really wanna delete this record?");
        l6.setBounds(20,220,300,20);
        l6.setFont(new Font("serif",Font.BOLD,15));
        f.add(l6);
        l6.setVisible(false);

        b3 = new JButton("Yes");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(20,250,100,30);
        b3.addActionListener(this);
        f.add(b3);
        b3.setVisible(false);

        b4 = new JButton("Cancel");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setBounds(130,250,100,30);
        b4.addActionListener(this);
        f.add(b4);
        b4.setVisible(false);



    }

    public void getData()
    {
        try{
            MysqlCon c = new MysqlCon();
            Connection con = c.getCon();
            String str = "select Name,Gender from myclass where USN = '"+t.getText()+"'";
            Statement stmt = (Statement)con.createStatement();
            ResultSet rs = stmt.executeQuery(str);

            while(rs.next())
            {
                name = rs.getString("Name");
                gender = rs.getString("gender");
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public void delete()
    {
        try{
            MysqlCon c = new MysqlCon();
            Connection con = c.getCon();
            String str = "delete from myclass where USN = '"+t.getText()+"'";
            Statement stmt = (Statement)con.createStatement();
            stmt.executeUpdate(str);

        }catch(Exception e){
            e.printStackTrace();
        }
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
                getData();
                if(name != null) {
                    l3.setText(name);
                    l5.setText(gender);
                    f.add(l2);
                    l2.setVisible(true);
                    l3.setVisible(true);
                    l4.setVisible(true);
                    l5.setVisible(true);
                    l6.setVisible(true);
                    b1.setVisible(false);
                    b2.setVisible(false);
                    b3.setVisible(true);
                    b4.setVisible(true);
                    f.setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Record not found");
                    t.setText("");
                }
            }
        }

        if(ae.getSource()==b2){
            f.setVisible(false);
        }

        if(ae.getSource() == b3)
        {
            delete();
            JOptionPane.showMessageDialog(null,"Record deleted succesfully");
            f.setVisible(false);
            new Delete_Data();
        }
        if(ae.getSource()==b4)
        {
            t.setText("");
            b1.setVisible(true);
            b2.setVisible(true);
            l2.setVisible(false);
            l3.setVisible(false);
            l4.setVisible(false);
            l5.setVisible(false);
            l6.setVisible(false);
            b3.setVisible(false);
            b4.setVisible(false);

        }
    }

    public static void main(String[] args)
    {
        new Delete_Data();
    }
}
