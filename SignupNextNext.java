import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class SignupNextNext extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4 ;
    JButton  submit,cancle;
    JCheckBox c1,c2,c3,c4,c5,c6,c7 ;
    String formnumber;
    SignupNextNext(String formnumber) {
        this.formnumber=formnumber;
        setLayout(null);
        setTitle("Account Detail");
        //Heading
        JLabel l1 = new JLabel(" PAGE 3 ACCOUNT DETAIL ");
        l1.setFont(new Font("Dialog",Font.BOLD,25));
        l1.setBounds(225,40,400,40);
        add(l1);

        //account type jlabel
        JLabel type = new JLabel(" Account Type : ");
        type.setFont(new Font("Dialog",Font.BOLD,25));
        type.setBounds(90,120,300,40);
        add(type);

        // JRadio buttons for type of account
        r1=new JRadioButton("Current");
        r1.setFont(new Font("Dialog",Font.BOLD,20));
        r1.setBounds(350,120,130,40);
        add(r1);
        r2=new JRadioButton("Saving");
        r2.setFont(new Font("Dialog",Font.BOLD,20));
        r2.setBounds(350,150,130,40);
        add(r2);

        r3=new JRadioButton("Fixed Deposit Account");
        r3.setFont(new Font("Dialog",Font.BOLD,20));
        r3.setBounds(350,180,350,40);
        add(r3);
        r4 =new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Dialog",Font.BOLD,20));
        r4.setBounds(350,210,350,40);
        add(r4);
        //Grouping the buttons
        ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(r1);
        bgroup.add(r2);
        bgroup.add(r3);
        bgroup.add(r4);

        // Card number detail
        JLabel card = new JLabel(" Card  Number  : ");
        card.setFont(new Font("Dialog",Font.BOLD,25));
        card.setBounds(90,270,250,35);
        add(card);
        JTextArea texCard=new JTextArea("XXXX-XXXX-XXXX-9088");
        texCard.setFont(new Font("Dialog",Font.BOLD,18));
        texCard.setBounds(350,270,325,35);
        add(texCard);
        JLabel texCard1=new JLabel("Your 16 Digit Card Number ");
        texCard1.setFont(new Font("Dialog",Font.BOLD,12));
        texCard1.setBounds(95,300,325,40);
        add(texCard1);

        //Pin number label
        JLabel pin = new JLabel(" Pin : ");
        pin.setFont(new Font("Dialog",Font.BOLD,25));
        pin.setBounds(120,350,250,35);
        add(pin);
        JLabel pin1=new JLabel("Your 4 Digit Password  ");
        pin1.setFont(new Font("Dialog",Font.BOLD,12));
        pin1.setBounds(95,380,325,30);
        add(pin1);

        // pin number text area
        JTextArea texPin=new JTextArea("XXXX");
        texPin.setFont(new Font("Dialog",Font.BOLD,20));
        texPin.setBounds(350,350,325,40);
        add(texPin);

        // Services required
        JLabel services = new JLabel(" Services required : ");
        services.setFont(new Font("Dialog",Font.BOLD,25));
        services.setBounds(90,450,300,35);
        add(services);

        c1 = new JCheckBox("ATM card ");
        c1.setBounds(110,500,150,30);
        c1.setFont(new Font("Raleway",Font.BOLD,20));
        add(c1);

        c2 = new JCheckBox("Mobile Banking ");
        c2.setBounds(110,550,200,30);
        c2.setFont(new Font("Raleway",Font.BOLD,20));
        add(c2);

        c3 = new JCheckBox("Cheque Book ");
        c3.setBounds(110,600,200,20);
        c3.setFont(new Font("Raleway",Font.BOLD,20));
        add(c3);

        c4 = new JCheckBox("Internet Banking ");
        c4.setBounds(410,500,250,30);
        c4.setFont(new Font("Raleway",Font.BOLD,20));
        add(c4);

        c5 = new JCheckBox("Email & SMS Alerts ");
        c5.setBounds(410,550,250,30);
        c5.setFont(new Font("Raleway",Font.BOLD,20));
        add(c5);

        c6 = new JCheckBox("E-Statement ");
        c6.setBounds(410,600,200,30);
        c6.setFont(new Font("Raleway",Font.BOLD,20));
        add(c6);

        c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge ");
        c7.setBounds(50,670,750,30);
        c7.setFont(new Font("Raleway",Font.BOLD,15));
        add(c7);

        // submit  button
        submit = new JButton("Submit");
        submit.setBackground(Color.GRAY);
        submit.setForeground(Color.black);
        submit.setFont(new Font("Raleway",Font.BOLD,18));
        submit.setBounds(600,750,80,40);
        submit.addActionListener(this);
        add(submit);

        // cancle  button

        cancle = new JButton("Cancle");
        cancle.setBackground(Color.GRAY);
        cancle.setForeground(Color.black);
        cancle.setFont(new Font("Raleway",Font.BOLD,18));
        cancle.setBounds(150,750,80,40);
        cancle.addActionListener(this);
        add(cancle);




        getContentPane().setBackground(Color.LIGHT_GRAY);
        setSize(800,888);
        setLocation(400,50);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==submit){
            String accounttype=null;
            if (r1.isSelected()){
                accounttype="Current account";
            } else if (r2.isSelected()){
                accounttype="Saving account";
            } else if (r3.isSelected()){
                accounttype="Fixed Deposit Account";
            }
            else if (r4.isSelected()){
                accounttype="Recurring Deposit account";
            }

            Random random = new Random();
            String cardnumber= ""+ Math.abs((random.nextLong()%90000000L+5098760000000000L));
            String pinnumber= ""+ Math.abs((random.nextLong()%9000L+1000L));

            String facility = "";
            if (c1.isSelected()) {
                facility = facility +",ATM Card";
            }
            else if (c2.isSelected()) {
                facility = facility + ",Internet Banking";
            }
            else if (c3.isSelected()) {
                facility = facility + ",Mobile Banking";
            }
            else if (c4.isSelected()) {
                        facility = facility + ",EMAIL & SMS Alerts";
            }
            else if (c5.isSelected()) {
                            facility = facility + ",Cheque Book" ;}
            else if (c6.isSelected()) {
                                facility = facility + ",E-Statement";
            }

            try{
                if(accounttype.equals("")){
                    JOptionPane.showMessageDialog(null,"account type is needed");
                }
                Conne conn=new Conne();
                String query1 = "insert into signupNextNext values('"+formnumber+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                String query2 = "insert into login values('"+formnumber+"','"+cardnumber+"','"+pinnumber+"')";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Card number : " + cardnumber + "\n password : "+ pinnumber);
                setVisible(false);
                new Deposit(pinnumber).setVisible(true);
            }
            catch(Exception e){
                System.out.println(e);
            }

        } else if (ae.getSource()==cancle) {
            setVisible(false);
            new Login().setVisible(true);

        }
    }

    public static void main(String args[]){
        new SignupNextNext("");
    }
}
