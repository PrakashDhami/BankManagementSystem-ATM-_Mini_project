import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener{
     long random;
     JTextArea tname,fatherName,dobTextArea,youremail,youradress,yourstate,pincode,yourcity;
     JButton next;
     JRadioButton male,female,other,married ,unmarried,other1 ;

    Signup(String Formnumber){
        setLayout(null);
        setTitle("New Account registration form 1");
        Random ram = new Random();
        random = Math.abs(ram.nextLong()%1000+2000);
        JLabel formno = new JLabel("APPLICATION NO . "+ random);
        formno.setFont(new Font("Dialog",Font.BOLD,40));
        formno.setBounds(160,10,500,50);
        add(formno);

        JLabel personalDetails = new JLabel("Page 1 : Personal Details");
        personalDetails.setFont(new Font("Dialog",Font.BOLD,25));
        personalDetails.setBounds(240,70,500,40);
        add(personalDetails);

        JLabel name = new JLabel("NAME : ");
        tname = new JTextArea();
        tname.setBounds(350,150,325,35);
        tname.setFont(new Font("Dialog",Font.BOLD,20));
        add(tname);
        name.setFont(new Font("Dialog",Font.BOLD,25));
        name.setBounds(90,150,500,40);
        add(name);

        JLabel fname = new JLabel("FATHER'S NAME : ");
        fatherName = new JTextArea();
        fatherName.setBounds(350,210,325,35);
        fatherName.setFont(new Font("Dialog",Font.BOLD,20));
        add(fatherName);
        fname.setFont(new Font("Dialog",Font.BOLD,25));
        fname.setBounds(90,210,500,40);
        add(fname);

        JLabel dob = new JLabel("DATE OF BIRTH : ");
        dobTextArea = new JTextArea();
        dobTextArea.setBounds(350,270,325,40);
        dobTextArea.setFont(new Font("Dialog",Font.BOLD,20));
        add(dobTextArea);
        dob.setFont(new Font("Dialog",Font.BOLD,25));
        dob.setBounds(90,270,500,40);
        add(dob);

        JLabel gender = new JLabel("GENDER : ");
        gender.setFont(new Font("Dialog",Font.BOLD,25));
        gender.setBounds(90,330,500,40);
        add(gender);
        male = new JRadioButton("male");
        male.setBounds(350,330,100,40);
        male.setFont(new Font("Dialog",Font.BOLD,20));
        add(male);
        female = new JRadioButton("female");
        female.setBounds(450,330,120,40);
        female.setFont(new Font("Dialog",Font.BOLD,20));
        add(female);

        other = new JRadioButton("other");
        other.setBounds(575,330,120,40);
        other.setFont(new Font("Dialog",Font.BOLD,20));
        add(other);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        JLabel email = new JLabel("EMAIL ADRESS : ");
        youremail = new JTextArea();
        youremail.setBounds(350,390,325,35);
        youremail.setFont(new Font("Dialog",Font.BOLD,20));
        add(youremail);
        email.setFont(new Font("Dialog",Font.BOLD,25));
        email.setBounds(90,390,500,40);
        add(email);

        JLabel marital = new JLabel("MARITAL STATUS : ");
        marital.setFont(new Font("Dialog",Font.BOLD,25));
        marital.setBounds(90,450,500,40);
        add(marital);

        married = new JRadioButton("married");
        married.setBounds(350,450,120,40);
        married.setFont(new Font("Dialog",Font.BOLD,20));
        add(married);
        unmarried = new JRadioButton("unmarried");
        unmarried.setBounds(460,450,145,40);
        unmarried.setFont(new Font("Dialog",Font.BOLD,20));
        add(unmarried);

        other1 = new JRadioButton("other");
        other1.setBounds(600,450,120,40);
        other1.setFont(new Font("Dialog",Font.BOLD,20));
        add(other1);

        ButtonGroup maritalStatus = new ButtonGroup();
        maritalStatus.add(married);
        maritalStatus.add(unmarried);
        maritalStatus.add(other1);


        JLabel adress = new JLabel("ADRESS : ");
        youradress = new JTextArea();
        youradress.setBounds(350,510,325,35);
        youradress.setFont(new Font("Dialog",Font.BOLD,20));
        add(youradress);
        adress.setFont(new Font("Dialog",Font.BOLD,25));
        adress.setBounds(90,510,500,40);
        add(adress);

        JLabel city = new JLabel("CITY : ");
        yourcity = new JTextArea();
        yourcity.setBounds(350,570,325,35);
        yourcity.setFont(new Font("Dialog",Font.BOLD,20));
        add(yourcity);
        city.setFont(new Font("Dialog",Font.BOLD,25));
        city.setBounds(90,570,500,40);
        add(city);

        JLabel state = new JLabel("STATE : ");
        yourstate = new JTextArea();
        yourstate.setBounds(350,630,325,35);
        yourstate.setFont(new Font("Dialog",Font.BOLD,20));
        add(yourstate);
        state.setFont(new Font("Dialog",Font.BOLD,25));
        state.setBounds(90,630,500,40);
        add(state);

        JLabel pin = new JLabel("pincode : ");
        pincode = new JTextArea();
        pincode.setBounds(350,690,325,35);
        pincode.setFont(new Font("Dialog",Font.BOLD,20));
        add(pincode);
        pin.setFont(new Font("Dialog",Font.BOLD,25));
        pin.setBounds(90,690,500,40);
        add(pin);

        JButton next = new JButton("NEXT");
        next.setBounds(390,800,100,40);
        next.setFont(new Font("Italic",Font.BOLD,25));
        next.setForeground(Color.GRAY);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.LIGHT_GRAY); // making background color LIGHT_GRAY
        setSize(800,900);
        setLocation(400,50);
        setVisible(true);

    }
    
    public void actionPerformed(ActionEvent ae) {
        String Formnumber = "" + random;
        String Name = tname.getText();
        String FatherName = fatherName.getText();
        String Dateofbirth = dobTextArea.getText();
        String Gender = null;
        if (male.isSelected()) {
            Gender = "male";
        } else if (female.isSelected()) {
            Gender = "female";
        } else if (other.isSelected()) {
            Gender = "other";
        }
        String Email = youremail.getText();
        String Marital = null;
        if (married.isSelected()) {
            Marital = "married";
        } else if (unmarried.isSelected()) {
            Marital = "unmarried";
        } else if (other1.isSelected()) {
            Marital = "other";
        }
        String Adress = youradress.getText();
        String City = yourcity.getText();
        String Pincode = pincode.getText();
        String State = yourstate.getText();

        try {
            if (Name.equals("")) {
                JOptionPane.showMessageDialog(null, "enter your name");
            } else {
                Conne c = new Conne();
                String query = "insert into signup values('" +Formnumber+ "','" + Name + "','" + FatherName + "','"
                + Dateofbirth + "','" + Gender + "','" + Email + "','" + Marital + "','" + Adress + "','" + City + "','"
                + Pincode + "','" + State + "')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupNext(Formnumber).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main ( String args[]){

        new Signup("");
    }
}