package com.myprincess.Router;

import com.myprincess.rest.context.Context;

import java.util.HashMap;
import java.util.Map;

public class Router {

    private final Map<String, Handler> routes = new HashMap<>();

    public void get(String path, Handler handler) {
        routes.put("GET:" + path, handler);
    }

    public void handle(String method, String path, Context c) {

        Handler handler = findHandler(method, path, c);

        handler.execute(c);
    }
    private Handler findHandler(String method, String path, Context ctx) {

        for (String key : routes.keySet()) {

            String route = key.split(":", 2)[1];

            if (match(route, path)) {

                ctx.setPathParams(extractParams(route, path));

                return routes.get(key);
            }
        }

        throw new RuntimeException("Route not found: " + path);
    }

    private Map<String, String> extractParams(String route, String path) {

        Map<String, String> params = new HashMap<>();

        String[] routeParts = route.split("/");
        String[] pathParts = path.split("/");

        for (int i = 0; i < routeParts.length; i++) {

            if (routeParts[i].startsWith(":")) {

                String key = routeParts[i].substring(1); // remove ":"
                String value = pathParts[i];

                params.put(key, value);
            }
        }

        return params;
    }

    private boolean match(String route, String path) {

        String[] routeParts = route.split("/");
        String[] pathParts = path.split("/");

        if (routeParts.length != pathParts.length) return false;

        for (int i = 0; i < routeParts.length; i++) {

            if (routeParts[i].startsWith(":")) continue;

            if (!routeParts[i].equals(pathParts[i])) {
                return false;
            }
        }

        return true;
    }
}


