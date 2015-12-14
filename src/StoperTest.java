import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoperTest extends junit.framework.TestCase {

    Stoper stoper;
    JLabel wyswietlacz;
    public void setUp() {
        stoper = new Stoper();
    }




    @org.junit.Test
    public void testResetStoper()  {

        stoper.startStoper(wyswietlacz);
        stoper.resetStoper();

        assertTrue(stoper.isFirstClickStart() == true);
        assertTrue(stoper.isFirstClickStop() == true);
        assertTrue(stoper.getStopTime() == 0);


    }



}