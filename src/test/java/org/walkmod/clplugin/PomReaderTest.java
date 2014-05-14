package org.walkmod.clplugin;

import java.io.File;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

public class PomReaderTest extends TestCase {
	

    @Test
    public void testeable() {
        assertTrue(true);
    }

    @Test
    public void testResolveShouldRetrievePomDependencies() {
        File pom = new File("src/test/resources/pom-test.xml");
        assertTrue(pom.exists());
        PomReader reader = new PomReader(pom);
        List dependencies = reader.resolve();
        assertFalse(dependencies.isEmpty());
    }
	

}

