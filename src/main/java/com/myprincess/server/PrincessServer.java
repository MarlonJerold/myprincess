package com.myprincess.server;

import com.myprincess.PrincessBanner;
import com.myprincess.Router.Router;
import com.myprincess.configuration.ConfigurationLoader;
import com.myprincess.configuration.ServerConfig;
import com.myprincess.logs.PrincessLog;
import com.myprincess.rest.context.Context;
import com.sun.net.httpserver.HttpServer;

import java.io.OutputStream;
import java.net.InetSocketAddress;

public class PrincessServer {

    private final Router router;

    public PrincessServer(Router router) {
        this.router = router;
    }

    public void start() throws Exception {

        ServerConfig config = ConfigurationLoader.loadServerConfig();

        HttpServer server = HttpServer.create(
                new InetSocketAddress(config.getPort()),
                0
        );

        server.createContext("/", exchange -> {

            String method = exchange.getRequestMethod();
            String path = exchange.getRequestURI().getPath();

            Context ctx = new Context();

            router.handle(method, path, ctx);

            Object body = ctx.getBody();
            int status = ctx.getStatus();

            if (body == null) {
                body = "";
            }

            byte[] responseBytes = body.toString().getBytes();

            exchange.sendResponseHeaders(status, responseBytes.length);

            OutputStream os = exchange.getResponseBody();
            os.write(responseBytes);
            os.close();
        });

        server.start();

    }
}