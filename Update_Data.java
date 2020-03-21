package StudentsDB;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Update_Data implements ActionListener{

    JFrame f;
    JTextField t,t1,t2,t3,t4;
    JButton b1,b2,b3;
    JLabel l,l1,l2,l3,l4;
    String usn,gender,name;
    String active;

    Update_Data()
    {
        f = new JFrame("Update Record");
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

        l4 = new JLabel("USN: ");
        l4.setBounds(20,20,120,30);
        l4.setFont(new Font("serif",Font.BOLD,20));
        f.add(l4);

        t4 = new JTextField("");
        t4.setBounds(110,20,200,30);
        t4.setBackground(Color.white);
        t4.setFont(new Font("serif", Font.PLAIN, 20));
        f.add(t4);

        l1 = new JLabel("Name: ");
        l1.setBounds(20, 60, 120, 30);
        l1.setFont(new Font("serif", Font.BOLD, 20));
        f.add(l1);

        t1 = new JTextField("");
        t1.setBounds(110, 60, 200, 30);
        t1.setBackground(Color.white);
        t1.setFont(new Font("serif", Font.PLAIN, 20));
        f.add(t1);

        l2 = new JLabel("Gender: ");
        l2.setBounds(20, 100, 120, 30);
        l2.setFont(new Font("serif", Font.BOLD, 20));
        f.add(l2);

        t2 = new JTextField("");
        t2.setBounds(110, 100, 200, 30);
        t2.setBackground(Color.white);
        t2.setFont(new Font("serif", Font.PLAIN, 20));
        f.add(t2);

        l3 = new JLabel("Active: ");
        l3.setBounds(20, 140, 120, 30);
        l3.setFont(new Font("serif", Font.BOLD, 20));
        f.add(l3);

        t3 = new JTextField("");
        t3.setBounds(110, 140, 200, 30);
        t3.setBackground(Color.white);
        t3.setFont(new Font("serif", Font.PLAIN, 20));
        f.add(t3);

        b3=new JButton("Update");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(20,220,100,30);
        b3.addActionListener(this);
        f.add(b3);

        t.setVisible(true);
        l.setVisible(true);
        b1.setVisible(true);
        b2.setVisible(true);
        b3.setVisible(false);
        t1.setVisible(false);
        l1.setVisible(false);
        t2.setVisible(false);
        l2.setVisible(false);
        t3.setVisible(false);
        l3.setVisible(false);
        l4.setVisible(false);
        t4.setVisible(false);

    }
    public void update(){
        try{
            MysqlCon c = new MysqlCon();
            Connection con = c.getCon();
            Statement stmt = con.createStatement();
            String str = "update myclass set USN = '"+t4.getText()+ "',Name = '"+t1.getText()+"',Gender = '"+t2.getText()+"',Active = "+t3.getText()+" where USN = '"+usn+"'";
            stmt.executeUpdate(str);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {
            if (t.getText().length() != 10) {
                JOptionPane.showMessageDialog(null, "Invalid Input");
                t.setText("");
            } else {
                try {
                    MysqlCon c = new MysqlCon();
                    Connection con = c.getCon();
                    String str = "select * from myclass where USN = '" + t.getText() + "'";
                    Statement stmt = (Statement) con.createStatement();
                    ResultSet rs = stmt.executeQuery(str);

                    while (rs.next()) {

                        usn = rs.getString("USN");
                        name = rs.getString("Name");
                        gender = rs.getString("Gender");
                        active = rs.getString("Active");

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (usn != null) {
                    t1.setText(name);
                    t2.setText(gender);
                    t3.setText(active);
                    t4.setText(usn);

                    t.setVisible(!true);
                    l.setVisible(!true);
                    b1.setVisible(false);
                    b2.setBounds(150, 220, 100, 30);
                    b3.setVisible(true);
                    t1.setVisible(!false);
                    l1.setVisible(!false);
                    t2.setVisible(!false);
                    l2.setVisible(!false);
                    t3.setVisible(!false);
                    l3.setVisible(!false);
                    l4.setVisible(true);
                    t4.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Record Not Found");
                    t.setText("");
                }

            }
        }
        if (ae.getSource() == b2) {
            f.setVisible(false);
        }
        if (ae.getSource() == b3) {
            if (t2.getText().equals("M") || t2.getText().equals("F")) {
                if (t3.getText().equals("1") || t3.getText().equals("0")) {
                    update();
                    JOptionPane.showMessageDialog(null,"Record Updated Successfully");
                    t.setVisible(true);
                    t.setText("");
                    l.setVisible(true);
                    b1.setVisible(true);
                    b2.setVisible(true);
                    b2.setBounds(130,50,100,30);
                    b3.setVisible(false);
                    t1.setVisible(false);
                    l1.setVisible(false);
                    t2.setVisible(false);
                    l2.setVisible(false);
                    t3.setVisible(false);
                    l3.setVisible(false);
                    l4.setVisible(false);
                    t4.setVisible(false);


                } else {
                    JOptionPane.showMessageDialog(null, "Active Field should be either '1' or '0' ");
                    t3.setText("");
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Gender Field should be either 'M' or 'F' ");
                t2.setText("");
            }

        }

    }

    public static void main(String[] args){
        new Update_Data();
    }

}
