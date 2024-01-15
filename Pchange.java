import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class Pchange extends JFrame implements ActionListener {
    String pinnumber;
    JLabel text,text1,text2,text3,text4;
    JPasswordField newpin,newpin1;
    JButton back,change;
    Pchange( String pinnumber) {
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("image/atm.png"));
        Image i2 = i1.getImage().getScaledInstance (800, 950, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3) ;
        image.setBounds(0,0,800,900);
        add(image);

        text = new JLabel("CHANGE YOUR PIN  ");
        text.setBounds(250,225,300,35);
        text.setFont(new Font("Serif",Font.BOLD,28));
        text.setForeground(Color.BLUE);
        image.add(text);

        text1 = new JLabel("WELC");
        text1.setBounds(160,100,250,60);
        text1.setFont(new Font("Serif",Font.BOLD,66));
        image.add(text1);

        text2 = new JLabel("ME");
        text2.setBounds(450,100,250,60);
        text2.setFont(new Font("Serif",Font.BOLD,66));
        image.add(text2);

        // pin text label

        text3 = new JLabel("New Pin :  ");
        text3.setBounds(250,260,250,25);
        text3.setFont(new Font("Serif",Font.BOLD,25));
        image.add(text3);

        text4 = new JLabel("Re-Enter New Pin :  ");
        text4.setBounds(250,340,250,25);
        text4.setFont(new Font("Serif",Font.BOLD,25));
        image.add(text4);

        //new pin input area

        newpin = new JPasswordField();
        newpin.setBounds(250,285,250,40);
        newpin.setFont(new Font("Serif",Font.BOLD,18));
        image.add(newpin);

        newpin1 = new JPasswordField();
        newpin1.setBounds(250,370,250,40);
        newpin1.setFont(new Font("Serif",Font.BOLD,18));
        image.add(newpin1);
//Back button
        back = new JButton("BACK");
        back.setBounds(470,415,90,40);
        back.setFont(new Font("Serif",Font.BOLD,18));
        back.addActionListener(this);
        image.add(back);
//change button
        change = new JButton("CHANGE");
        change.setBounds(255,415,90,40);
        change.setFont(new Font("Serif",Font.BOLD,18));
        change.addActionListener(this);
        image.add(change);


        setSize(800,850);
        setLocation(400,100);
        setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==back){
                setVisible(false);
                new Atm(pinnumber).setVisible(true);
        }
        if(ae.getSource()==change) {
            try {
                String npin = newpin.getText();
                String rpin = newpin1.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "You have entered different pin !!");
                    return;
                }
                if(newpin.equals("")){
                    JOptionPane.showMessageDialog(null, "pleas eentered first pin !!");
                    return;
                }
                if(newpin1.equals("")){
                    JOptionPane.showMessageDialog(null, "plese re-entered first pin !!");
                    return;
                }
                Conne conne = new Conne();
                String query1 = "UPDATE BANK SET PASSWORD ='"+rpin+"' Where PASSWORD = '"+pinnumber+"'";
                String query2 = "UPDATE login SET PASSWORD='"+rpin+"' Where PASSWORD = '"+pinnumber+"'";
                String query3 = "UPDATE signupNextNext SET PASSWORD='"+rpin+"' Where PASSWORD = '"+pinnumber+"'";
                conne.s.executeUpdate(query1);
                conne.s.executeUpdate(query2);
                conne.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null, "Your Pin Change Sucessfully !!!!");
                setVisible(false);
                new Atm(rpin).setVisible(true);
                }catch (Exception e ){
                System.out.println(e);
            }
            }
        }

    public static  void main (String args[]){
        new Pchange("");
    }
}
