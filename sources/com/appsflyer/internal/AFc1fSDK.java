package com.appsflyer.internal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.b;

public final class AFc1fSDK implements AFc1hSDK<Map<String, String>> {
    public final /* synthetic */ Object values(String str) throws JSONException {
        HashMap hashMap = new HashMap();
        if (!str.trim().isEmpty()) {
            b bVar = new b(str);
            Iterator<String> keys = bVar.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, bVar.optString(next));
            }
        }
        return hashMap;
    }
}
