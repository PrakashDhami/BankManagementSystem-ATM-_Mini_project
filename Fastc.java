import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;


public class Fastc extends JFrame implements ActionListener{
    JButton deposit,withdrawl,fastcash,mstatement,pchange,benquiry,back;
    JLabel text,text1,text2;
    String pinnumber;
    Fastc(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("image/atm.png"));
        Image i2 = i1.getImage().getScaledInstance (800, 950, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3) ;
        image.setBounds(0,0,800,900);
        add(image);

        // j label
        text = new JLabel("Select The Amount ");
        text.setBounds(290,210,250,35);
        text.setFont(new Font("Serif",Font.BOLD,29));
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
        deposit = new JButton("RS 100");
        deposit.setBounds(240,270,150,35);
        deposit.setFont(new Font("Serif",Font.BOLD,20));
        deposit.setForeground(Color.BLUE);
        deposit.addActionListener(this);
        image.add(deposit);

        //withdrawl button
        withdrawl = new JButton("RS 200");
        withdrawl.setBounds(240,320,150,35);
        withdrawl.setFont(new Font("Serif",Font.BOLD,20));
        withdrawl.setForeground(Color.BLUE);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        //fastcash button
        fastcash = new JButton("RS 500");
        fastcash.setBounds(410,270,150,35);
        fastcash.setFont(new Font("Serif",Font.BOLD,20));
        fastcash.setForeground(Color.BLUE);
        fastcash.addActionListener(this);
        image.add(fastcash);

        //MINI STATEMENT button
        mstatement = new JButton("RS 1000");
        mstatement.setBounds(410,320,150,35);
        mstatement.setFont(new Font("Serif",Font.BOLD,20));
        mstatement.setForeground(Color.BLUE);
        mstatement.addActionListener(this);
        image.add(mstatement);

        //PIN CHANGE  button
        pchange = new JButton("RS 15000");
        pchange.setBounds(410,370,150,35);
        pchange.setFont(new Font("Serif",Font.BOLD,20));
        pchange.setForeground(Color.BLUE);
        pchange.addActionListener(this);
        image.add(pchange);

        //BALENCE ENQUIRY  button
        benquiry = new JButton("RS 10000");
        benquiry.setBounds(240,370,150,35);
        benquiry.setFont(new Font("Serif",Font.BOLD,20));
        benquiry.setForeground(Color.BLUE);
        benquiry.addActionListener(this);
        image.add(benquiry);

        //exit   button
        back = new JButton("BACK");
        back.setBounds(300,420,200,35);
        back.setFont(new Font("Serif",Font.BOLD,25));
        back.addActionListener(this);
        image.add(back);



        setSize(800,900);
        setLocation(400,100);
        setUndecorated(true);
        setVisible(true);
        getContentPane().setBackground(Color.GRAY);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Atm(pinnumber).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conne conne = new Conne();
            try{
                ResultSet rs = conne.s.executeQuery("SELECT * FROM bank WHERE PASSWORD = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("TYPE").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("AMOUNT"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("AMOUNT"));
                    }
                }


                if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }

                Date date= new Date();
                String query = "INSERT INTO bank VALUES ('"+pinnumber+"','" +date+ "','Withdraw','" +amount+ "')";
                conne.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"RS "+amount+"Debited Sucessfully");
                setVisible(false);
                new Atm(pinnumber).setVisible(true);
                System.out.println("total balance is "+balance);


            }catch(Exception e){
                System.out.println(e);
            }

        }

    }
    public static void main(String args[]){

        new Fastc("");
    }
}
