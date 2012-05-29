package eu.scenari.nuxeo.client;

import java.io.File;

import org.nuxeo.ecm.automation.client.Session;
import org.nuxeo.ecm.automation.client.jaxrs.impl.HttpAutomationClient;
import org.nuxeo.ecm.automation.client.model.Document;
import org.nuxeo.ecm.automation.client.model.FileBlob;

public class RemoteNuxeo {

    protected final HttpAutomationClient client;

    protected final Session session;

    protected static final String PUBLISH_OP = "Scenari.PublishFolder";

    protected static final String IMPORT_OP = "FileManager.Import";

    public RemoteNuxeo() {
        this("http://127.0.0.1:8080/nuxeo/", "Administrator", "Administrator");
    }

    public RemoteNuxeo(String serverUrl, String login, String password) {

        if (!serverUrl.contains("/site/automation")) {
            if (!serverUrl.endsWith("/")) {
                serverUrl = serverUrl + "/";
            }
            serverUrl = serverUrl + "site/automation";
        }

        client = new HttpAutomationClient(serverUrl);
        session = client.getSession(login, password);
    }

    public Document createScenariDocInNuxeo(File file) throws Exception {

        FileBlob fb = new FileBlob(file);
        fb.setMimeType("application/zip");

        Document doc = (Document) session.newRequest(PUBLISH_OP).setInput(fb).execute();
        return doc;
    }

}
