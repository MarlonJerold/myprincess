package com.myprincess;

import com.myprincess.Router.Router;

public class Application {
    
    public static void registerRoutes(Router router) throws Exception {

        router.get("/hello", ctx -> {
            ctx.json(200, "Hello World");
        });

        router.get("/hello/:id", ctx -> {
            ctx.json(200, "Hello " + ctx.param("id"));
        });

    }

    public static void main(String[] args) {
        new PrincessApplication(Application.class).run(args);
    }

}
