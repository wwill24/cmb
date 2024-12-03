package com.leanplum.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.b;

public class Request {
    private final String apiAction;
    ErrorCallback error;
    private final String httpMethod;
    private final Map<String, Object> params;
    private String requestId = UUID.randomUUID().toString();
    ResponseCallback response;
    private RequestType type;

    public interface ErrorCallback {
        void error(Exception exc);
    }

    public enum RequestType {
        DEFAULT,
        IMMEDIATE
    }

    public interface ResponseCallback {
        void response(b bVar);
    }

    public Request(String str, String str2, RequestType requestType, Map<String, Object> map) {
        this.httpMethod = str;
        this.apiAction = str2;
        this.type = requestType;
        this.params = map == null ? new HashMap<>() : map;
    }

    public String getApiAction() {
        return this.apiAction;
    }

    public String getHttpMethod() {
        return this.httpMethod;
    }

    public Map<String, Object> getParams() {
        return this.params;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public RequestType getType() {
        return this.type;
    }

    public void onError(ErrorCallback errorCallback) {
        this.error = errorCallback;
    }

    public void onResponse(ResponseCallback responseCallback) {
        this.response = responseCallback;
    }

    public void setType(RequestType requestType) {
        this.type = requestType;
    }
}
