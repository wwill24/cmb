package com.google.firebase.database.util;

import com.facebook.internal.ServerProtocol;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.a;
import org.json.b;
import org.json.g;
import org.json.h;

public class JsonMapper {
    public static Map<String, Object> parseJson(String str) throws IOException {
        try {
            return unwrapJsonObject(new b(str));
        } catch (JSONException e10) {
            throw new IOException(e10);
        }
    }

    public static Object parseJsonValue(String str) throws IOException {
        try {
            return unwrapJson(new h(str).j());
        } catch (JSONException e10) {
            throw new IOException(e10);
        }
    }

    public static String serializeJson(Map<String, Object> map) throws IOException {
        return serializeJsonValue(map);
    }

    public static String serializeJsonValue(Object obj) throws IOException {
        if (obj == null) {
            return "null";
        }
        if (obj instanceof String) {
            return b.quote((String) obj);
        }
        if (obj instanceof Number) {
            try {
                return b.numberToString((Number) obj);
            } catch (JSONException e10) {
                throw new IOException("Could not serialize number", e10);
            }
        } else if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue() ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
        } else {
            try {
                g gVar = new g();
                serializeJsonValue(obj, gVar);
                return gVar.toString();
            } catch (JSONException e11) {
                throw new IOException("Failed to serialize JSON", e11);
            }
        }
    }

    private static Object unwrapJson(Object obj) throws JSONException {
        if (obj instanceof b) {
            return unwrapJsonObject((b) obj);
        }
        if (obj instanceof a) {
            return unwrapJsonArray((a) obj);
        }
        if (obj.equals(b.NULL)) {
            return null;
        }
        return obj;
    }

    private static List<Object> unwrapJsonArray(a aVar) throws JSONException {
        ArrayList arrayList = new ArrayList(aVar.o());
        for (int i10 = 0; i10 < aVar.o(); i10++) {
            arrayList.add(unwrapJson(aVar.get(i10)));
        }
        return arrayList;
    }

    private static Map<String, Object> unwrapJsonObject(b bVar) throws JSONException {
        HashMap hashMap = new HashMap(bVar.length());
        Iterator<String> keys = bVar.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, unwrapJson(bVar.get(next)));
        }
        return hashMap;
    }

    private static void serializeJsonValue(Object obj, g gVar) throws IOException, JSONException {
        if (obj instanceof Map) {
            gVar.object();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                gVar.key((String) entry.getKey());
                serializeJsonValue(entry.getValue(), gVar);
            }
            gVar.endObject();
        } else if (obj instanceof Collection) {
            gVar.array();
            for (Object serializeJsonValue : (Collection) obj) {
                serializeJsonValue(serializeJsonValue, gVar);
            }
            gVar.endArray();
        } else {
            gVar.value(obj);
        }
    }
}
