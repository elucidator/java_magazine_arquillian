package nl.elucidator.java_magazine.arquillian.sample.model;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {

    public static final String ADULT_NAME = "Pieter";
    public static final int ADULT_AGE = 44;
    public static final String UNDER_AGE_NAME = "Tycho";
    public static final int UNDER_AGE_AGE = 8;
    private final User adult = new User(ADULT_NAME, ADULT_AGE);
    private final User underAge = new User(UNDER_AGE_NAME, UNDER_AGE_AGE);


    @Test
    public void testGetName() throws Exception {
        assertThat(adult.getName(), is(ADULT_NAME));
        assertThat(underAge.getName(), is(UNDER_AGE_NAME));
    }

    @Test
    public void testGetAge() throws Exception {
        assertThat(adult.getAge(), is(ADULT_AGE));
        assertThat(underAge.getAge(), is(UNDER_AGE_AGE));
    }
}