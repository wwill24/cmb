package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.b;

public final class AFc1kSDK implements AFc1hSDK<Map<String, Object>> {
    public static Map<String, Object> AFInAppEventType(String str) throws JSONException {
        Object obj;
        try {
            HashMap hashMap = new HashMap();
            b bVar = new b(str);
            Iterator<String> keys = bVar.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (bVar.isNull(next)) {
                    obj = null;
                } else {
                    obj = bVar.get(next);
                }
                hashMap.put(next, obj);
            }
            hashMap.remove("is_cache");
            return hashMap;
        } catch (JSONException e10) {
            AFLogger.afErrorLogForExcManagerOnly("error while paring GCD response", e10);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("string_response", str);
            return hashMap2;
        }
    }

    public final /* synthetic */ Object values(String str) throws JSONException {
        return AFInAppEventType(str);
    }
}
