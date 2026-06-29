package com.myprincess.configuration;

import java.io.InputStream;
import java.util.Properties;

public class ConfigurationLoader {

    public static ServerConfig loadServerConfig() {

        ServerConfig config = new ServerConfig();

        config.setHost("localhost");
        config.setPort(8080);

        try {

            InputStream input =
                    ConfigurationLoader.class
                            .getClassLoader()
                            .getResourceAsStream("application.properties");

            if (input == null) {
                return config;
            }

            Properties properties = new Properties();
            properties.load(input);

            String port = properties.getProperty("server.port");

            if (port != null) {
                config.setPort(Integer.parseInt(port));
            }

            String host = properties.getProperty("server.host");

            if (host != null) {
                config.setHost(host);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return config;
    }

}