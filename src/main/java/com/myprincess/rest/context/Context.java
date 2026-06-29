
package com.myprincess.rest.context;

import java.util.HashMap;
import java.util.Map;

public class Context {

    private Map<String, String> pathParams = new HashMap<>();

    private int status;
    private Object body;

    public String param(String key) {
        return pathParams.get(key);
    }

    public void setPathParams(Map<String, String> params) {
        this.pathParams = params;
    }

    public void json(int status, Object body) {
        this.status = status;
        this.body = body;

        System.out.println("STATUS: " + status);
        System.out.println("BODY: " + body);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}