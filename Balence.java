import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;

public class Balence extends JFrame implements ActionListener {
    JLabel text,text1,text2;
    JButton back;
    String pinnumber;
    Balence(String pinnumber){
        this.pinnumber=pinnumber;

        setLayout(null);

        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("image/atm.png"));
        Image i2 = i1.getImage().getScaledInstance (800, 950, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3) ;
        image.setBounds(0,0,800,900);
        add(image);

        text = new JLabel("YOUR BALANCE IS ");
        text.setBounds(250,225,300,35);
        text.setFont(new Font("Serif",Font.BOLD,30));
        image.add(text);

        text1 = new JLabel("WELC");
        text1.setBounds(160,100,250,60);
        text1.setFont(new Font("Serif",Font.BOLD,66));
        image.add(text1);

        text2 = new JLabel("ME");
        text2.setBounds(450,100,250,60);
        text2.setFont(new Font("Serif",Font.BOLD,66));
        image.add(text2);

        back = new JButton("BACK");
        back.setBounds(470,405,90,40);
        back.setFont(new Font("Serif",Font.BOLD,22));
        back.addActionListener(this);
        image.add(back);

        Conne conne = new Conne();
        int balance = 0;
        try {
            ResultSet rs = conne.s.executeQuery("SELECT * FROM bank  where PASSWORD = '" +pinnumber+ "'");


            while (rs.next()) {
                if (rs.getString("TYPE").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("AMOUNT"));
                } else {
                    balance -= Integer.parseInt(rs.getString("AMOUNT"));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }

        JLabel amount = new JLabel("RS . "+balance);
        amount.setBounds(255,300,400,40);
        amount.setFont(new Font("Serif",Font.BOLD, 30));
        amount.setForeground(Color.GREEN);
        image.add(amount);



        setSize(800,850);
        setLocation(400,100);
//        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
            if (ae.getSource()==back){
                setVisible(false);
                new Atm(pinnumber).setVisible(true);
            }
    }

    public static void main (String ags[]){

        new Balence("");
    }
}
