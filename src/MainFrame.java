import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainFrame extends JFrame {

    public MainFrame(String title) {
        super(title);


        final JLabel timeLabel = new JLabel();

        //Guziki ekran główny
        final JButton buttonMinutnik = new JButton("Minutnik");
        final JButton buttonStoper = new JButton("Stoper");
        final JButton buttonWyjdz = new JButton("Wyjdz");
        final JButton buttonWyjdzDoEkranuGlownego = new JButton("Wyjdz");
        final JButton buttonWyjdzDoEkranuGlownego2 = new JButton("Wyjdz");

        // Ekran glowny content
        final Container ekran = getContentPane();
        ekran.setLayout(new OverlayLayout(ekran));
        final JPanel ekranGlowny = new JPanel();

        ekranGlowny.setLayout(new BoxLayout(ekranGlowny,1));
        ekranGlowny.add(timeLabel);
        ekranGlowny.add(buttonStoper);
        ekranGlowny.add(buttonMinutnik);
        ekranGlowny.add(buttonWyjdz);
        ekran.add(ekranGlowny);


        // Ekran stopera inicjalizacja
        final JPanel ekranStopera = new StoperEkran("Stoper");
        ekranStopera.setLayout(new BoxLayout(ekranStopera,1));

        final JPanel ekranMinutnika = new MinutnikEkran("Minutnik");
        ekranMinutnika.setLayout(new BoxLayout(ekranMinutnika,1));



        ekran.add(ekranStopera);
        ekranStopera.setVisible(false);
        ekran.add(ekranMinutnika);
        ekranMinutnika.setVisible(false);
        ekranMinutnika.add(buttonWyjdzDoEkranuGlownego);
        ekranStopera.add(buttonWyjdzDoEkranuGlownego2);


        final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        // Guziki


        buttonStoper.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ekranGlowny.setVisible(false);
                ekranStopera.setVisible(true);
            }
        });


        buttonMinutnik.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                ekranGlowny.setVisible(false);
                ekranMinutnika.setVisible(true);
            }
        });

        buttonWyjdz.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonWyjdzDoEkranuGlownego.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                ekranGlowny.setVisible(true);
                ekranStopera.setVisible(false);
                ekranMinutnika.setVisible(false);
            }
        });

        buttonWyjdzDoEkranuGlownego2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                ekranGlowny.setVisible(true);
                ekranStopera.setVisible(false);
                ekranMinutnika.setVisible(false);
            }
        });



        ActionListener timerListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Date date = new Date();

                String time = sdf.format(date);
                timeLabel.setText(time);
            }
        };
        Timer timer = new Timer(1000, timerListener);
        // to make sure it doesn't wait one second at the start
        timer.setInitialDelay(0);
        timer.start();
    }



}