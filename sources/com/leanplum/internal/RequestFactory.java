package com.leanplum.internal;

import com.leanplum.internal.Request;
import java.util.Map;

public class RequestFactory {
    public static RequestFactory defaultFactory;

    public static synchronized RequestFactory getInstance() {
        RequestFactory requestFactory;
        synchronized (RequestFactory.class) {
            if (defaultFactory == null) {
                defaultFactory = new RequestFactory();
            }
            requestFactory = defaultFactory;
        }
        return requestFactory;
    }

    public Request createRequest(String str, String str2, Request.RequestType requestType, Map<String, Object> map) {
        return new Request(str, str2, requestType, map);
    }
}
