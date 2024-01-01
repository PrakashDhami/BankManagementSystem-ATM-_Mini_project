import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupNext extends JFrame implements ActionListener{
    JTextArea tname,fatherName,dobTextArea,youremail,youradress,yourstate,pincode,yourcity;
    JButton next;
    JRadioButton syes,sno,eyes,eno ;
    JComboBox occupation,religion,category,income,educational ;
    String formnumber;

    SignupNext( String Formnumber){
        this.formnumber=Formnumber;
        setLayout(null);
        setTitle("New Account registration form 2");

        JLabel AdditionalDetails = new JLabel("Page 2 : Additional Details");
        AdditionalDetails.setFont(new Font("Dialog",Font.BOLD,25));
        AdditionalDetails.setBounds(240,70,500,40);
        add(AdditionalDetails);

        // Religion label
        JLabel name = new JLabel("Religion : ");
        tname = new JTextArea();
        name.setFont(new Font("Dialog",Font.BOLD,25));
        name.setBounds(90,150,500,40);
        add(name);
        // Religion combo box
        String valreligions[]={"Hindu","Muslim","Sikh","Chistian","Other"};
        religion = new JComboBox(valreligions);
        religion.setBounds(350,150,325,35);
        religion.setFont(new Font("Dialog",Font.BOLD,15));
        add(religion);

        //Category label
        JLabel fname = new JLabel("Category : ");
        fname.setFont(new Font("Dialog",Font.BOLD,25));
        fname.setBounds(90,210,500,40);
        add(fname);
        //Category combo box
        String valcategory[]={"General","OBC","Sc","ST","Other"};
        category = new JComboBox(valcategory);
        category.setBounds(350,210,325,35);
        category.setFont(new Font("Dialog",Font.BOLD,15));
        add(category);

        // income label
        JLabel dob = new JLabel("Income : ");
        dob.setFont(new Font("Dialog",Font.BOLD,25));
        dob.setBounds(90,270,500,40);
        add(dob);
        // income combo box
        String valincome[]={"NO Income","<50,000","<1,00,000","<2,00,000","Up to 5,00,000"};
        income = new JComboBox(valincome);
        income.setBounds(350,270,325,40);
        income.setFont(new Font("Dialog",Font.BOLD,15));
        add(income);
        //educatioal label
        JLabel gender = new JLabel("Educationl");
        JLabel email = new JLabel("Qualification : ");
        email.setFont(new Font("Dialog",Font.BOLD,25));
        email.setBounds(90,365,250,20);
        add(email);
        gender.setFont(new Font("Dialog",Font.BOLD,25));
        gender.setBounds(90,330,500,40);
        add(gender);
        //educational combo box

        String valeducational[]={"Non-Graduate","Graduate","Post Graduation","Other"};
        educational = new JComboBox(valeducational);
        educational.setBounds(350,345,325,40);
        educational.setFont(new Font("Dialog",Font.BOLD,15));
        add(educational);

        //occupation label
        JLabel marital = new JLabel("Occupation : ");
        marital.setFont(new Font("Dialog",Font.BOLD,25));
        marital.setBounds(90,430,500,40);
        add(marital);

        //occupation combo box

        String valoccupation[]={"Salaried","Self-Employed","Bussiness","Student","Retired","Other"};
        occupation = new JComboBox(valoccupation);
        occupation.setBounds(350,430,325,40);
        occupation.setFont(new Font("Dialog",Font.BOLD,15));
        add(occupation);
        //pan card detail
        JLabel pan = new JLabel("Pan Number :");
        youradress = new JTextArea();
        youradress.setBounds(350,510,325,20);
        youradress.setFont(new Font("Dialog",Font.BOLD,20));
        add(youradress);
        pan.setFont(new Font("Dialog",Font.BOLD,25));
        pan.setBounds(90,510,500,40);
        add(pan);
        //adhar card detail
        JLabel adhar = new JLabel("Adhar Number : ");
        yourcity = new JTextArea();
        yourcity.setBounds(350,570,325,20);
        yourcity.setFont(new Font("Dialog",Font.BOLD,20));
        add(yourcity);
        adhar.setFont(new Font("Dialog",Font.BOLD,25));
        adhar.setBounds(90,570,500,40);
        add(adhar);
        //Senior Citizen label

        JLabel state = new JLabel("Senior Citizen : ");
        state.setFont(new Font("Dialog",Font.BOLD,25));
        state.setBounds(90,630,500,40);
        add(state);

        //Senior Citizen Radio Button
        syes = new JRadioButton("yes");
        syes.setBounds(350,630,100,35);
        syes.setFont(new Font("Dialog",Font.BOLD,20));
        add(syes);
        sno= new JRadioButton("no");
        sno.setBounds(450,630,100,35);
        sno.setFont(new Font("Dialog",Font.BOLD,20));
        add(sno);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(syes);
        genderGroup.add(sno);
        //label for account exist
        JLabel pin = new JLabel("Account Exist : ");
        pin.setFont(new Font("Dialog",Font.BOLD,25));
        pin.setBounds(90,690,500,40);
        add(pin);
        //radio button for account exist
        eyes = new JRadioButton("yes");
        eyes.setBounds(350,690,100,35);
        eyes.setFont(new Font("Dialog",Font.BOLD,20));
        add(eyes);
        eno= new JRadioButton("no");
        eno.setBounds(450,690,100,35);
        eno.setFont(new Font("Dialog",Font.BOLD,20));
        add(eno);

        ButtonGroup genderGroup1 = new ButtonGroup();
        genderGroup1.add(eyes);
        genderGroup1.add(eno);

        JButton next = new JButton("NEXT");
        next.setBounds(390,800,100,40);
        next.setFont(new Font("Italic",Font.BOLD,25));
        next.setForeground(Color.GRAY);
        next.addActionListener(this);
        add(next);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setSize(800,900);
        setLocation(400,50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String creligion = (String) religion.getSelectedItem();
        String ccategory = (String) category.getSelectedItem();
        String cincome = (String) income.getSelectedItem();
        String ceducationqualification = (String) educational.getSelectedItem();
        String coccupation = (String) occupation.getSelectedItem();
        String cpan = youradress.getText();
        String cadhr = yourcity.getText();
        String  scitizen=null;
        if(syes.isSelected()){//slected yes
            scitizen="yes";
        }
        else if(sno.isSelected()){//slected no
            scitizen="no";
        }
        String eaccount=null;
        if(eyes.isSelected()){
            //slected yes
            eaccount="yes";
        }
        else if(eno.isSelected()){
            //slected no
            eaccount="no";
        }

        try{
            if (cpan.equals("")){
                JOptionPane.showMessageDialog(null,"enter pan number ");
            }
            else{
                Conne c = new Conne();
                String query = "insert into signupNext values('"+formnumber+"','"+creligion+"','"+ccategory+"','"+cincome+"','"+ceducationqualification+"','"+coccupation+"','"+cpan+"','"+cadhr+"','"+scitizen+"','"+eaccount+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupNextNext(formnumber).setVisible(true);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String args[]){

        new SignupNext("");
    }
}
