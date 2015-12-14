import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;
public class MinutnikTest extends junit.framework.TestCase {

    Minutnik minutnik;

    protected void setUp(){
        minutnik = new Minutnik();
    }

    @org.junit.Test
    public void testPlusHours(){
        minutnik.plusHours();
        assertTrue(minutnik.getHours() == 1);
        minutnik.plusHours();
        assertTrue(minutnik.getHours() == 2);
    }

    @Test
    public void testPlusMins(){
        minutnik.setMins(59);
        minutnik.plusMins();
        assertTrue(minutnik.getHours() == 1);
        assertTrue(minutnik.getMins() == 0);
        minutnik.plusMins();
        assertTrue(minutnik.getMins() == 1);
    }

    @Test
    public void testPlusSecs(){
        minutnik.setMins(59);
        minutnik.setSecs(59);
        minutnik.plusSecs();
        assertTrue(minutnik.getSecs() == 0);
        assertTrue(minutnik.getMins() == 0);
        assertTrue(minutnik.getHours() == 1);
        minutnik.plusSecs();
        assertTrue(minutnik.getSecs() == 1);
    }

    @Test
    public void testMinusHours(){
        minutnik.setHours(1);
        minutnik.minusHours();
        assertTrue(minutnik.getHours() == 0);
        minutnik.minusHours();
        assertTrue(minutnik.getHours() == 0);
    }

    @Test
    public void testMinusMins(){
        minutnik.setHours(2);
        minutnik.setMins(1);
        minutnik.minusMins();
        assertTrue(minutnik.getMins() == 0);
        minutnik.minusMins();
        assertTrue(minutnik.getHours() == 1);
        assertTrue(minutnik.getMins() == 59);
    }

    @Test
    public void testMinusSecs(){
        minutnik.setHours(2);
        minutnik.setMins(0);
        minutnik.setSecs(1);
        minutnik.minusSecs();
        assertTrue(minutnik.getSecs() == 0);
        minutnik.minusSecs();
        assertTrue(minutnik.getHours() == 1);
        assertTrue(minutnik.getMins() == 59);
        assertTrue(minutnik.getMins() == 59);
    }

    @Test
    public void testGetTime(){

    }

    @Test
    public void testReset(){

    }
}