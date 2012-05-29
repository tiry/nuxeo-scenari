package eu.scenari.nuxeo.client.shell;

import java.io.File;
import java.io.IOException;

import org.nuxeo.ecm.automation.client.model.Document;

import eu.scenari.nuxeo.client.RemoteNuxeo;

public class Main {

    protected static final String INJECTFILE_CMD = "injectFile";

    protected static void help() {
        System.out.println("Commands:");
        System.out.println(INJECTFILE_CMD
                + " {filePath}: inject a Scenari archive from a file");
    }

    public static void main(String args[]) throws IOException {
        String cmd = null;
        if (args.length > 1) {
            cmd = args[0];
        } else {
            help();
            return;
        }
        if ("help".equals(cmd)) {
            help();
            return;
        } else if (INJECTFILE_CMD.equals(cmd)) {
            String filePath = (String) args[1];
            File zipFile = new File(filePath);
            if (!zipFile.exists()) {
                System.out.println("Unable to find file " + filePath);
                return;
            }
            RemoteNuxeo injector = new RemoteNuxeo();
            try {
                System.out.println("#### Calling inject on remote Nuxeo ...");

                long t0 = System.currentTimeMillis();
                Document doc = injector.createScenariDocInNuxeo(zipFile);
                long dt = System.currentTimeMillis() - t0;
                System.out.println("Document " + doc.getId() + " created in "
                        + dt + " ms");
            } catch (Exception e) {
                throw new IOException(e);
            }
        }
    }
}
