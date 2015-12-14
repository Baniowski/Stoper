import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.Caret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


public class StoperEkran extends JPanel {

    boolean isClicked=false;

    public StoperEkran(String title) {
        super();


        // Guziki stoper
        final JButton buttonStart = new JButton("Start/Stop");
        final JButton buttonRunda = new JButton("Split");
        final JButton buttonReset = new JButton("Reset");

        final Stoper stoper = new Stoper();

        final JLabel wyswietlacz = new JLabel();
        final JTextArea wyswietlaczRund = new JTextArea();


        TimeZone timezone = TimeZone.getTimeZone("GMT+0");
        final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        sdf.setTimeZone(timezone);
        wyswietlacz.setText(sdf.format(new Date(0)));


        setLayout(new BoxLayout(this,1));
        add(wyswietlacz);
        add(wyswietlaczRund);
        add(buttonStart);
        add(buttonRunda);
        add(buttonReset);


        this.setBackground(Color.cyan);


        buttonStart.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isClicked){
                    stoper.startStoper(wyswietlacz);
                    isClicked = true;
                }
                else{

                    isClicked = false;
                    stoper.stopStoper();
                }
            }
        });



        buttonReset.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                stoper.resetStoper();
                isClicked = false;
                wyswietlaczRund.setText(null);
            }
        });

        buttonRunda.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                wyswietlaczRund.setText(wyswietlacz.getText() + '\n' + wyswietlaczRund.getText());
            }
        });
    }

}