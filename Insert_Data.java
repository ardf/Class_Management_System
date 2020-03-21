package StudentsDB;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Insert_Data implements ActionListener{

    JFrame f;
    JLabel l1,l2,l3,head;
    JTextField t1,t2,t3;
    JButton b1,b2;

    Insert_Data() {
        f = new JFrame("Insert Data");
        f.setBackground(Color.WHITE);
        f.setSize(400, 442);
        f.setLocation(400, 150);
        f.setBackground(Color.white);
        f.setLayout(null);

        head = new JLabel("Enter new student details:");
        head.setBounds(40, 30, 350, 30);
        head.setFont(new Font("serif", Font.BOLD, 25));
        f.add(head);


        l1 = new JLabel("USN: ");
        l1.setBounds(40, 100, 120, 30);
        l1.setFont(new Font("serif", Font.BOLD, 20));
        f.add(l1);

        t1 = new JTextField("");
        t1.setBounds(130, 100, 200, 30);
        t1.setBackground(Color.white);
        t1.setFont(new Font("serif", Font.BOLD, 20));
        f.add(t1);

        l2 = new JLabel("Name: ");
        l2.setBounds(40, 140, 120, 30);
        l2.setFont(new Font("serif", Font.BOLD, 20));
        f.add(l2);

        t2 = new JTextField("");
        t2.setBounds(130, 140, 200, 30);
        t2.setBackground(Color.white);
        t2.setFont(new Font("serif", Font.BOLD, 20));
        f.add(t2);

        l3 = new JLabel("Gender: ");
        l3.setBounds(40, 180, 120, 30);
        l3.setFont(new Font("serif", Font.BOLD, 20));
        f.add(l3);

        t3 = new JTextField("");
        t3.setBounds(130, 180, 200, 30);
        t3.setBackground(Color.white);
        t3.setFont(new Font("serif", Font.BOLD, 20));
        f.add(t3);

        b1=new JButton("Insert");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(40,250,100,30);
        b1.addActionListener(this);
        f.add(b1);

        b2=new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(180,250,100,30);
        b2.addActionListener(this);
        f.add(b2);

        f.setVisible(true);
    }
    public void insert()
    {

        try{
            MysqlCon c = new MysqlCon();
            Connection con = c.getCon();
            String str = "insert into myclass values('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"',1)";
            Statement stmt = (Statement)con.createStatement();
            stmt.executeUpdate(str);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

  public void actionPerformed(ActionEvent ae){

      if(ae.getSource()==b1){

          if(t3.getText().length()!=1 || t1.getText().length()!=10 || t2.getText().length()==0)
          {
              JOptionPane.showMessageDialog(null,"Invalid Data");
              t1.setText("");
              t2.setText("");
              t3.setText("");
              f.setVisible(true);
          }
          else {
              insert();
              JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
              f.setVisible(false);
              new Print_Data(t1.getText());
          }
      }
      if(ae.getSource()==b2){
          f.setVisible(false);
      }
  }
    public static void main(String[] args)
    {
        new Insert_Data();
    }
}
