package com.myprincess;

import com.myprincess.Router.Router;
import com.myprincess.logs.PrincessLog;
import com.myprincess.server.PrincessServer;

import java.lang.reflect.Method;

public class PrincessApplication {

    private final Class<?> applicationClass;

    public PrincessApplication(Class<?> applicationClass) {
        this.applicationClass = applicationClass;
    }

    public void run(String[] args) {

        try {

            PrincessBanner.print();
            PrincessLog.info("Princess Framework...");
            PrincessLog.info("Application: " + applicationClass.getName());

            long start = System.currentTimeMillis();

            Router router = new Router();

            Object instance = applicationClass.getDeclaredConstructor().newInstance();

            for (Method method : applicationClass.getDeclaredMethods()) {

                if (method.getName().equals("registerRoutes")) {
                    method.invoke(instance, router);
                }
            }

            int port = 8080;
            PrincessServer server = new PrincessServer(router);
            server.start();

            long end = System.currentTimeMillis();

            PrincessLog.info("Creating web server on port " + port + "...");
            PrincessLog.info("Princess started successfully in " + (end - start) + "ms");

        } catch (Exception e) {
            throw new RuntimeException("Failed to start Princess Framework", e);
        }
    }
}