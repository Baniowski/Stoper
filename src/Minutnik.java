import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.awt.event.*;
import javax.swing.*;

public class Minutnik extends MinutnikTest {
    private int secs;
    private int mins;
    private int hours;
    Calendar ActualTime;
    Calendar startTime;
    final Timer timer;
    String zeroDate;

    JLabel wyswietlacz;
    String Time;

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    TimeZone timezone = TimeZone.getTimeZone("GMT+0");

    public int getSecs() {
        return secs;
    }

    public void setSecs(int secs) {
        this.secs = secs;
    }

    public int getMins() {
        return mins;
    }

    public void setMins(int mins) {
        this.mins = mins;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public Minutnik() {

        sdf.setTimeZone(timezone);

        ActionListener timerListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                minusSecs();
                refreshTime(wyswietlacz);
                if(hours == 0 && mins == 0 && secs == 0){
                    timer.stop();
                }
            }

        };
        timer=new Timer(1000,timerListener);
        timer.setInitialDelay(1);
    }

    public void plusHours() {
        hours++;
    }

    public void plusMins() {
    if(mins == 59){
        hours++;
        mins = 0;
    }
        else{
        mins++;
    }
    }

    public void plusSecs() {
        if(mins == 59 && secs == 59){
            hours++;
            mins = 0;
            secs = 0;
        }
        else if (mins != 59 && secs == 59){
            mins++;
            secs = 0;
        }

        else {
            secs++;
        }
    }
    public void minusHours() {
        if(hours > 0) {
            hours --;
        }
    }

    public void minusMins() {
        if(hours > 0){
            int minsTmp = (mins - 1) + 60;
            mins = minsTmp % 60;
            hours = hours - (1 - minsTmp / 60);
        } else {
            if(mins > 0) {
                mins--;
            }
        }
    }

    public void minusSecs() {
        if(hours > 0 && mins == 0) {
            int secsTmp = (secs - 1) + 60;
            secs = secsTmp % 60;
            hours = hours - (1 - secsTmp / 60);
            mins = ((mins - (1-secsTmp/60)) + 60) % 60;

        } else if(mins > 0) {
            int secsTmp = (secs - 1) + 60;
            secs = secsTmp % 60;
            mins = mins - (1 - secsTmp / 60);
        } else {
            if(secs > 0) {
                secs--;
            }
        }
    }

    public void refreshTime(JLabel wyswietlacz) {
        this.wyswietlacz = wyswietlacz;
        wyswietlacz.setText(sdf.format(((getHours() * 3600000) + ((getMins()) * 60000) + (getSecs() * 1000))));
    }


    public void startMinutnik(JLabel wyswietlacz) {


        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        this.wyswietlacz = wyswietlacz;
        timer.start();
        startTime = Calendar.getInstance();
    }

    public void stopMinutnik() {

        timer.stop();
        startTime = Calendar.getInstance();

    }

    public String getTime() {

        Time = sdf.format(startTime.getTimeInMillis() + ((getHours() * 3600000) + ((getMins()) * 60000) + (getSecs() * 1000)) - ActualTime.getTimeInMillis());
        return Time;

    }

    public void reset(){
        hours = 0;
        mins = 0;
        secs = 0;
    }

}


