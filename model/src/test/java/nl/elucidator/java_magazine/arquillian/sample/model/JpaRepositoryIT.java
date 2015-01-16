package nl.elucidator.java_magazine.arquillian.sample.model;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Arquillian.class)
public class JpaRepositoryIT {

    @Inject
    JpaRepository repo;

    @Deployment
    public static Archive<?> deployment() {

        WebArchive archive = ShrinkWrap.create(WebArchive.class)
                .addPackage(JpaRepository.class.getPackage())
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml");

        return archive;
    }

    @Test
    public void insertUserTest()  {
        User user = new User("Pieter", 42);
        boolean created = repo.create(user);
        assertThat(created, is(true));
    }
}