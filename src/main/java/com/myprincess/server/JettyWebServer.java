package com.myprincess.server;

import org.eclipse.jetty.server.Server;

public class JettyWebServer implements WebServer {

    private final Server server;

    public JettyWebServer(int port) {
        this.server = new Server(port);
    }

    @Override
    public void start() {
        
        try {

            server.start();

        } catch (Exception e) {

            e.printStackTrace();
            
            throw new RuntimeException("Failed to start Jetty web server", e);
        }
    }

    @Override
    public void stop() {
        try {

            server.stop();

        } catch (Exception e) {

            e.printStackTrace();
            
            throw new RuntimeException("Failed to stop Jetty web server", e);
        }
    }
}
