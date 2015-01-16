package nl.elucidator.java_magazine.arquillian.sample.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityManager;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class JpaRespositoryTest {

    @Mock
    private EntityManager em;
    @InjectMocks
    private JpaRepository repo = new JpaRepository();

    @Test
    public void insertUserTest() {
        User user = new User("Jhon", 42);

        repo.create(user);
        verify(em, times(1)).persist(user);
    }
}