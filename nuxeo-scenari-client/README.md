
nuxeo-scenari-client
====================

## About

This is a simlple Client library to call import API on a remote Nuxeo server from java.
This client is a thin wrapper around automation client.
It can be used as a java library or as a command line tool.

## Building

    mvn clean install

## Generated jars

The build generate 2 jars :

 - the *normal* jar that contains only the specific classes
 - a jar-with-dependencies that can be used in stand alone mode (used for shell)

## Using the client in command line mode

*injecting a Scenari file*

    java -jar nuxeo-scenari-client-1.0-SNAPSHOT-with-deps.jar injectFile someFile.ZIP

