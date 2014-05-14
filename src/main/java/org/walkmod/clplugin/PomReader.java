package org.walkmod.clplugin;



import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.MavenResolvedArtifact;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class PomReader {


    private File file;

    public PomReader(File file) {
        this.file = file;
    }

    public List resolve() {
        MavenResolvedArtifact[] artifacts = Maven.resolver().loadPomFromFile(getFile()).resolve().withTransitivity().asResolvedArtifact();
        return Arrays.asList(artifacts);

    }

    public File getFile() {
        return file;
    }

}
