import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class Deposit extends JFrame implements ActionListener {
    JLabel text,text1,text2;
    JTextField amount;
    JButton deposit,back;
    String pinnumber;



    Deposit(String pinnumber){
        this.pinnumber=pinnumber;

        setLayout(null);

        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("image/atm.png"));
        Image i2 = i1.getImage().getScaledInstance (800, 950, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3) ;
        image.setBounds(0,0,800,900);
        add(image);

        text = new JLabel("Enter The Amount You  Want To Deposit ");
        text.setBounds(230,225,340,35);
        text.setFont(new Font("Serif",Font.BOLD,18));
        image.add(text);

        // text field for deposit of money ;

       amount = new JTextField();
       amount.setBounds(280,275,200,50);
       amount.setFont(new Font("Serif",Font.BOLD,25));
        image.add(amount);


        text1 = new JLabel("WELC");
        text1.setBounds(160,100,250,60);
        text1.setFont(new Font("Serif",Font.BOLD,66));
        image.add(text1);

        text2 = new JLabel("ME");
        text2.setBounds(450,100,250,60);
        text2.setFont(new Font("Serif",Font.BOLD,66));
        image.add(text2);

        //deposit button

        deposit = new JButton("DEPOSIT");
        deposit.setBounds(450,350,100,35);
        deposit.setFont(new Font("Serif",Font.BOLD,16));
        deposit.addActionListener(this);
        image.add(deposit);
        // back button
        back = new JButton("BACK");
        back.setBounds(450,400,100,35);
        back.setFont(new Font("Serif",Font.BOLD,16));
        back.addActionListener(this);
        image.add(back);

        setSize(800,850);
        setLocation(400,100);
//        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae ){

        if(ae.getSource()==deposit){
            String number = amount.getText();
            Date date = new Date();

            if (number.equals("")){
                JOptionPane.showMessageDialog(null,"Enter The Amiunt First ");
            }else{
                try {
                    Conne conne = new Conne();
                    String query = "INSERT INTO bank VALUES ('" +pinnumber+ "','" + date + "','Deposit','" +number+ "')";
                    conne.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "RS . "+number +" Has Been Deposited Sucessfully");
                    setVisible(false);
                    new Atm(pinnumber).setVisible(true);
                }catch (Exception e){
                    System.out.println(e);

                }
            }

        }else if (ae.getSource()== back){
        setVisible(false);
        new Atm(pinnumber).setVisible(true);
        }

    }
    public static void main (String arg[]){
        new Deposit("");
    }
}
