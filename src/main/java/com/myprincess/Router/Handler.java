package com.myprincess.Router;

import com.myprincess.rest.context.Context;

@FunctionalInterface
public interface Handler {
    void execute(Context ctx);
}