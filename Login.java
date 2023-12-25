import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{

    JButton login,clear,register;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login(){
        
        setTitle("A.T.M");

        setLayout(null); 
        //image in the login screen
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/logo.png"));
        Image i2 = i1.getImage().getScaledInstance (100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); //converting image i2 into imageIcon
        JLabel label = new JLabel(i3) ;
        label.setBounds(70,30,100,100);
        add(label);
        //for adding text WELCOME TO ATM  on atm login screen
        JLabel text = new JLabel("WELCOME TO ATM ");
        text.setBounds(250,70,400,40); 
        text.setFont(new Font("Osward",Font.BOLD,33) );
        add(text);
        //for taking Card number as input from user for login .
        JLabel cardno = new JLabel("card no : ");
        cardno.setBounds(100,170,200,40); 
        cardno.setFont(new Font("Osward",Font.BOLD,33) );
        add(cardno);
        //text field to take input .
        cardTextField = new JTextField();
        cardTextField.setBounds(270,175,350,40);
        cardTextField.setFont(new Font("OSWARD",Font.BOLD,16));
        add(cardTextField);

        //for taking password  as input from user for login .
        JLabel pin = new JLabel("Pin : ");
        pin.setBounds(100,250,400,40); 
        pin.setFont(new Font("Osward",Font.BOLD,33) );
        add(pin);
        //text field to take input .
        pinTextField = new JPasswordField();
        pinTextField.setBounds(270,250,350,40);
        pinTextField.setFont(new Font("OSWARD",Font.BOLD,16));
        add(pinTextField);
        // LOGIN button after clicking on it user get into his/her account if card number and password is correct .
        login = new JButton("LOGIN");
        login.setBounds(300,325,100,60);
        login.setForeground(Color.BLACK);
        login.setFont(new Font("Osward",Font.BOLD,15) );
        login.addActionListener(this);
        add(login);
        //CLEAR button which is used to clear both text field
        clear = new JButton("CLEAR");
        clear.setBounds(460,325,100,60);
        clear.setForeground(Color.BLACK);
        clear.setFont(new Font("Osward",Font.BOLD,15) );
        clear.addActionListener(this);
        add(clear);
        //NEW REGISTERATION button for new registration.
        register = new JButton("NEW REGISTERATION ");
        register.setBounds(300,399,260,60);
        register.setForeground(Color.BLACK);
        register.setFont(new Font("Osward",Font.BOLD,15) );
        register.addActionListener(this);
        add(register);

        getContentPane().setBackground(Color.lightGray);

        setSize(800,550);
        setVisible(true);
        setLocation(400,200);

    }

    public void actionPerformed(ActionEvent ae){
        //if any action happned in login page like clocking on button
        if (ae.getSource() == clear){
        //if you clibk on clear button
            cardTextField.setText("");
            pinTextField.setText("");
        }

        else if (ae.getSource() == login){
            //if you click on login button
            Conne conne = new Conne();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "SELECT * FROM login WHERE CARD_NUMBER = '"+cardnumber+"' and PASSWORD = '"+pinnumber+"'";

            try{
                ResultSet rs = conne.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Atm(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"INCORRECT CARD NUMBER OR PIN ");
                }
            }
            catch (Exception e){
                System.out.println(e);
            }

        }

        else if  (ae.getSource() == register){
            //if you click on new registration button
                setVisible(false);
                new Signup("").setVisible(true);
        }
        
    }

    public static void main(String args[]){

        new Login();
    }
}