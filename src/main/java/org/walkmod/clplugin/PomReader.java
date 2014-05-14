package org.walkmod.clplugin;

import org.apache.archiva.metadata.repository.storage.RepositoryPathTranslator;
import org.apache.archiva.metadata.repository.storage.maven2.RepositoryModelResolver;
import org.apache.maven.model.Model;
import org.apache.maven.model.building.*;

import java.io.File;
import java.util.Collections;
import java.util.List;


public class PomReader {


    private File file;

    public PomReader(File file) {
        this.file = file;
    }

    public List resolve() {

        ModelBuilder builder = new DefaultModelBuilder();
        ModelBuildingRequest req = new DefaultModelBuildingRequest();
        req.setProcessPlugins(false);
        req.setPomFile(getFile());
        assert (getFile().exists());
        req.setModelResolver(new RepositoryModelResolver(null, null)); //TODO change null's
        req.setValidationLevel(ModelBuildingRequest.VALIDATION_LEVEL_MINIMAL);

        Model model;
        try
        {
            model = builder.build( req ).getEffectiveModel();
        }
        catch ( ModelBuildingException e )
        {
            throw new RuntimeException(e);
        }
        return model.getDependencies();

    }

    public File getFile() {
        return file;
    }

}
