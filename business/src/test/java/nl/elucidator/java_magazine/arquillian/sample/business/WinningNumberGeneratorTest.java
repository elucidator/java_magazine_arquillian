package nl.elucidator.java_magazine.arquillian.sample.business;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class WinningNumberGeneratorTest {

    @Test
    public void winningNumber_should_return_0(){
        WinningNumberGenerator gen = new WinningNumberGenerator();
        gen.SALT = 0;
        assertThat(gen.draw(),is(0));
    }

}