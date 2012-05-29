package eu.scenari.automation;

import java.io.Serializable;

import org.nuxeo.ecm.automation.core.annotations.Context;
import org.nuxeo.ecm.automation.core.annotations.Operation;
import org.nuxeo.ecm.automation.core.annotations.OperationMethod;
import org.nuxeo.ecm.automation.core.annotations.Param;
import org.nuxeo.ecm.core.api.Blob;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;

@Operation(id = PublishFolder.ID, category = "Scenari", label = "PublishFolder", description = "Publish a Scenari Document in Nuxeo")
public class PublishFolder {

    public static final String ID = "Scenari.PublishFolder";

    @Context
    protected CoreSession session;

    @Param(name = "file", required = false)
    protected Blob file;

    @OperationMethod
    public DocumentModel publishFolder(Blob blob) throws Exception {

        DocumentModel doc = session.createDocumentModel("/", "scenari", "File");
        doc.setPropertyValue("dc:title", "Scenari File");
        doc.setPropertyValue("file:content", (Serializable) blob);

        return session.createDocument(doc);
    }

    @OperationMethod
    public DocumentModel publishFolder() throws Exception {
        return publishFolder(file);
    }

}
