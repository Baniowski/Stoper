import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class MinutnikEkran extends JPanel {
    boolean isClicked = false;

    public MinutnikEkran(String title) {
        super();


        final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");


        final JButton buttonStart = new JButton("Start/Stop");
        final JButton buttonReset = new JButton("Reset");
        final JButton buttondodajGodziny = new JButton("+H");
        final JButton buttonodejmijGodziny = new JButton("-H");
        final JButton buttondodajMinuty = new JButton("+M");
        final JButton buttonodejmijMinuty = new JButton("-M");
        final JButton buttondodajSekundy = new JButton("+S");
        final JButton buttonodejmijSekundy = new JButton("-S");

        final Minutnik minutnik = new Minutnik();

        final JLabel wyswietlaczMinutnika = new JLabel();

        TimeZone timezone = TimeZone.getTimeZone("GMT+0");
        sdf.setTimeZone(timezone);
        wyswietlaczMinutnika.setText(sdf.format(new Date(0)));


        add(wyswietlaczMinutnika);
        add(buttonStart);
        add(buttonReset);
        add(buttondodajGodziny);
        add(buttonodejmijGodziny);
        add(buttondodajMinuty);
        add(buttonodejmijMinuty);
        add(buttondodajSekundy);
        add(buttonodejmijSekundy);


        buttondodajGodziny.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                minutnik.plusHours();
                minutnik.refreshTime(wyswietlaczMinutnika);
            }
        });

        buttondodajMinuty.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                minutnik.plusMins();
                minutnik.refreshTime(wyswietlaczMinutnika);
            }
        });

        buttondodajSekundy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                minutnik.plusSecs();
                minutnik.refreshTime(wyswietlaczMinutnika);
            }
        });

        buttonodejmijGodziny.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                minutnik.minusHours();
                minutnik.refreshTime(wyswietlaczMinutnika);
            }
        });

        buttonodejmijMinuty.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                minutnik.minusMins();
                minutnik.refreshTime(wyswietlaczMinutnika);
            }
        });

        buttonodejmijSekundy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                minutnik.minusSecs();
                minutnik.refreshTime(wyswietlaczMinutnika);
            }
        });

        buttonStart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (!isClicked) {

                    minutnik.startMinutnik(wyswietlaczMinutnika);
                    isClicked = true;
                } else {
                    minutnik.stopMinutnik();
                    isClicked = false;
                }
            }
        });

        buttonReset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                minutnik.stopMinutnik();
                wyswietlaczMinutnika.setText(sdf.format(new Date(0)));
                minutnik.reset();
                isClicked = false;
            }
        });
    }
}







