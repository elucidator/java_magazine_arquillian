package nl.elucidator.java_magazine.arquillian.sample.web;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(Arquillian.class)
public class HelloWorldIT {

    private WebTarget target;
    @ArquillianResource
    private URL base;

    @Deployment
    public static Archive<?> createDeployment() {

        final WebArchive webArchive = ShrinkWrap.create(WebArchive.class)
                .addPackage(EEApplication.class.getPackage()).addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
        System.out.println("webArchive.toString(true) = " + webArchive.toString(true));
        return webArchive;
    }

    @Before
    public void setUp() throws MalformedURLException {
        Client client = ClientBuilder.newClient();
        target = client.target(URI.create(new URL(base, "resources/hello").toExternalForm()));
    }

    @Test
    public void findPerson() {
        final String message =
                target.path("{name}").resolveTemplate("name", "Pieter").request(MediaType.TEXT_PLAIN).get(String.class);

        assertThat(message, notNullValue());
        assertThat(message, is("Hello Pieter"));
    }

}