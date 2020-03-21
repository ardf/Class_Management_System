package StudentsDB;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class Print_Data implements ActionListener{
    JFrame f;
    JLabel l1,aid,l2,aid1,l3,aid2,head;
    String usn,name,gender;
    int active;
    JButton b1,b2;


    Print_Data(String id){
        try{
            MysqlCon c = new MysqlCon();
            Connection con = c.getCon();
            String str = "select * from myclass where USN = '"+id+"'";
            Statement stmt = (Statement)con.createStatement();
            ResultSet rs= stmt.executeQuery(str);

            while(rs.next()){

                usn = rs.getString("USN");
                name = rs.getString("Name");
                gender = rs.getString("Gender");
                active = rs.getInt("Active");

            }
        }catch(Exception e){
            e.printStackTrace();
        }

        f=new JFrame("Print Data");
        f.setSize(400,350);
        f.setLocation(400,150);
        f.setBackground(Color.white);
        f.setLayout(null);



        head = new JLabel("Student Details");
        head.setBounds(50,10,250,30);
        head.setFont(new Font("serif",Font.BOLD,25));
        f.add(head);

        l1 = new JLabel("USN: ");
        l1.setBounds(50,70,120,30);
        l1.setFont(new Font("serif",Font.BOLD,20));
        f.add(l1);

        if(id!=null) {
            aid = new JLabel(id);
        }
        else
            aid = new JLabel("----");
        aid.setBounds(150,70,200,30);
        aid.setFont(new Font("serif",Font.BOLD,20));
        f.add(aid);

        l2 = new JLabel("Name:");
        l2.setBounds(50,120,100,30);
        l2.setFont(new Font("serif",Font.BOLD,20));
        f.add(l2);

        if(name!=null) {
            aid1 = new JLabel(name);
        }
        else
            aid1 = new JLabel("----");
        aid1.setBounds(150,120,300,30);
        aid1.setFont(new Font("serif",Font.BOLD,20));
        f.add(aid1);


        l3 = new JLabel("Gender:");
        l3.setBounds(50,170,200,30);
        l3.setFont(new Font("serif",Font.BOLD,20));
        f.add(l3);
        if(gender!=null) {
            aid2 = new JLabel(gender);
        }
        else
            aid2 = new JLabel("----");
        aid2.setBounds(150,170,300,30);
        aid2.setFont(new Font("serif",Font.BOLD,20));
        f.add(aid2);

        b1=new JButton("Return");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(50,250,100,30);
        b1.addActionListener(this);
        f.add(b1);

   /*     b2=new JButton("Exit");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(180,250,100,30);
        b2.addActionListener(this);
        f.add(b2);

    */
        if(name!=null) {
            f.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null,"Record Not Found");
        }

    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b1){
            f.setVisible(false);
        }
     /*   if(ae.getSource()==b2){
            f.setVisible(false);
            System.exit(0);
        }

     */
    }
    public static void main(String[] args){
        new Print_Data("2AB18CS004");
    }
}