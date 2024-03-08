import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class Statement extends JFrame {
    String pinnumber;

    Statement(String pinnumber) {
        this.pinnumber=pinnumber;

        setLayout(null);
        setTitle("Statement");

        JLabel text = new JLabel();
        add(text);

        JLabel statement = new JLabel("YOUR BANK");
        statement.setBounds(120,20,200,40);
        statement.setFont(new Font("Serif",Font.BOLD,25));
        add(statement);

        // card detail

        JLabel card = new JLabel();
        card.setBounds(20,80,300,40);
        card.setFont(new Font("Serif",Font.BOLD,15));
        add(card);

        JLabel mini = new JLabel();
        mini.setBounds(30,125,350,300);
        mini.setFont(new Font("Serif",Font.BOLD,15));
        mini.setBackground(Color.CYAN);
        add(mini);

        JLabel bal = new JLabel();
        bal.setBounds(30,500,270,50);
        bal.setFont(new Font("Serif",Font.BOLD,15));
        bal.setForeground(Color.BLUE);
        add(bal);

        Conne conne1 = new Conne();
        int balance = 0;
        try {
            ResultSet rs = conne1.s.executeQuery("SELECT * FROM bank  where PASSWORD = '" +pinnumber+ "'");


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
        bal.setText("your balance Current is : RS."+balance);

        try{
            Conne conne = new Conne();
            ResultSet rs = conne.s.executeQuery("SELECT * FROM login WHERE PASSWORD = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number : "+rs.getString("CARD_NUMBER").substring(0,4)+ "XXXXXXXX" +rs.getString("CARD_NUMBER").substring(12));
            }

        }catch (Exception e){
            System.out.println(e);
        }

        try{
            Conne conne = new Conne();
            ResultSet rs = conne.s.executeQuery("SELECT * FROM bank WHERE PASSWORD = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" +rs.getString("DATE") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("TYPE")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("AMOUNT")+"<br><br><html>");

            }

        }catch(Exception e){
            System.out.println(e);
        }



        setSize(400,600);
        setLocation(100,100);
//        setUndecorated(true);
        setVisible(true);
    }

    public static void main (String args[]){

        new Statement("");
    }
}
