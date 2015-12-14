
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Stoper extends StoperTest {

    final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    final Timer timer;
    final Timer timer2;
    Calendar startTime;
    Calendar ActualTime;
    String Time;
    JLabel wyswietlacz;
    boolean firstClickStart = true;
    boolean firstClickStop = true;


    int stopTime = 0;


    public void setStopTime(int stopTime) {
        this.stopTime = stopTime;
    }
    public int getStopTime() {
        return stopTime;
    }


    Calendar stopTimeStart = new Calendar() {
        @Override
        protected void computeTime() {

        }

        @Override
        protected void computeFields() {

        }

        @Override
        public void add(int field, int amount) {

        }

        @Override
        public void roll(int field, boolean up) {

        }

        @Override
        public int getMinimum(int field) {
            return 0;
        }

        @Override
        public int getMaximum(int field) {
            return 0;
        }

        @Override
        public int getGreatestMinimum(int field) {
            return 0;
        }

        @Override
        public int getLeastMaximum(int field) {
            return 0;
        }
    };


    public Timer getTimer2() {
        return timer2;
    }

    public Stoper() {

        ActionListener timerListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ActualTime = Calendar.getInstance();
                TimeZone timezone = TimeZone.getTimeZone("GMT+0");
                sdf.setTimeZone(timezone);
                wyswietlacz.setText(getTime());
            }
        };

        timer = new Timer(1000, timerListener);

        timer.setInitialDelay(0);


        ActionListener timerListener2 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopTime++;
            }
        };

        timer2 = new Timer(1000, timerListener2);

        timer2.setInitialDelay(0);
    }

    public void startStoper(JLabel wyswietlacz) {
        timer2.stop();
        timer.start();

        if(firstClickStart == true) {
            startTime = Calendar.getInstance();
        }
        firstClickStart = false;
        this.wyswietlacz = wyswietlacz;
    }

    public void stopStoper() {

        timer.stop();
        timer2.start();
        if(firstClickStop == true) {
            stopTimeStart = Calendar.getInstance();
        }
        firstClickStop = false;
    }

    public String getTime() {

        Time = sdf.format(new Date(ActualTime.getTimeInMillis() - startTime.getTimeInMillis() - getStopTime()*1000 + 501 ));
        return Time;
    }

    public boolean isFirstClickStart() {
        return firstClickStart;
    }

    public void setFirstClickStart(boolean firstClickStart) {
        this.firstClickStart = firstClickStart;
    }

    public boolean isFirstClickStop() {
        return firstClickStop;
    }

    public void setFirstClickStop(boolean firstClickStop) {
        this.firstClickStop = firstClickStop;
    }

    public void resetStoper(){
        this.stopStoper();
        timer.stop();
        timer2.stop();
        setStopTime(0);
        firstClickStart = true;
        firstClickStop = true;
        wyswietlacz.setText(sdf.format(new Date(0)));
    }
}





