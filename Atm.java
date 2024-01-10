
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;


public class Atm extends JFrame implements ActionListener{
    JButton deposit,withdrawl,fastcash,mstatement,pchange,benquiry,exit;
    JLabel text,text1,text2;
    String pinnumber;
    Atm(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("image/atm.png"));
        Image i2 = i1.getImage().getScaledInstance (800, 950, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3) ;
        image.setBounds(0,0,800,900);
        add(image);

    // j label
        text = new JLabel("Select Options ");
        text.setBounds(340,210,150,35);
        text.setFont(new Font("Serif",Font.BOLD,22));
        image.add(text);

        text1 = new JLabel("WELC");
        text1.setBounds(160,100,250,60);
        text1.setFont(new Font("Serif",Font.BOLD,66));
        image.add(text1);

        text2 = new JLabel("ME");
        text2.setBounds(450,100,250,60);
        text2.setFont(new Font("Serif",Font.BOLD,66));
        image.add(text2);

        // j buttons
        //Deposit button
        deposit = new JButton("DEPOSIT");
        deposit.setBounds(240,270,150,35);
        deposit.setFont(new Font("Serif",Font.BOLD,16));
        deposit.addActionListener(this);
        image.add(deposit);

        //withdrawl button
        withdrawl = new JButton("WITHDRAWL");
        withdrawl.setBounds(240,320,150,35);
        withdrawl.setFont(new Font("Serif",Font.BOLD,15));
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        //fastcash button
        fastcash = new JButton("FASTCASH");
        fastcash.setBounds(410,270,150,35);
        fastcash.setFont(new Font("Serif",Font.BOLD,15));
        fastcash.addActionListener(this);
        image.add(fastcash);

        //MINI STATEMENT button
        mstatement = new JButton("MINI-STSTEMENT");
        mstatement.setBounds(410,320,150,35);
        mstatement.setFont(new Font("Serif",Font.BOLD,15));
        mstatement.addActionListener(this);
        image.add(mstatement);

        //PIN CHANGE  button
        pchange = new JButton("PIN CHANGE");
        pchange.setBounds(410,370,150,35);
        pchange.setFont(new Font("Serif",Font.BOLD,15));
        pchange.addActionListener(this);
        image.add(pchange);

        //BALENCE ENQUIRY  button
        benquiry = new JButton("BALANCE CHECK");
        benquiry.setBounds(240,370,150,35);
        benquiry.setFont(new Font("Serif",Font.BOLD,15));
        benquiry.addActionListener(this);
        image.add(benquiry);

        //exit   button
        exit = new JButton("EXIT");
        exit.setBounds(300,420,200,35);
        exit.setFont(new Font("Serif",Font.BOLD,25));
        exit.addActionListener(this);
        image.add(exit);
    setSize(800,900);
    setLocation(400,100);
   // setUndecorated(true);
    setVisible(true);
        getContentPane().setBackground(Color.GRAY);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }else if (ae.getSource()==deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource()==withdrawl) {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource()==fastcash){
            setVisible(false);
            new Fastc(pinnumber).setVisible(true);

        } else if (ae.getSource()==pchange) {
            setVisible(false);
            new Pchange(pinnumber).setVisible(true);

        } else if (ae.getSource()==benquiry) {
            setVisible(false);
            new Balence(pinnumber).setVisible(true);
        } else if (ae.getSource()==mstatement) {

            new Statement(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new Atm("");
    }
}
