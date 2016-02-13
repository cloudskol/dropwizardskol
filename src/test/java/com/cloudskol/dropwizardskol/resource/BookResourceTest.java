package com.cloudskol.dropwizardskol.resource;

import com.cloudskol.dropwizardskol.DropwizardSkolApplication;
import com.cloudskol.dropwizardskol.DropwizardSkolConfiguration;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Environment;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * @author tham
 */

public class BookResourceTest {
    private final Environment environment = mock(Environment.class);
    private final JerseyEnvironment jerseyEnvironment = mock(JerseyEnvironment.class);
    private static final DropwizardSkolApplication application = new DropwizardSkolApplication();
    private static final DropwizardSkolConfiguration configuration = new DropwizardSkolConfiguration();

    @Before
    public void setUp() {
        when(environment.jersey()).thenReturn(jerseyEnvironment);
    }

    @Ignore
    @Test
    public void testBooksResource() throws Exception {
        application.run(configuration, environment);

        verify(jerseyEnvironment).register(isA(BookResource.class));
    }
}
