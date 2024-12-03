package com.leanplum.internal;

import android.text.Editable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.a;
import org.json.b;

public class JsonConverter {
    public static Map<String, Object> fromJson(String str) {
        if (str == null) {
            return null;
        }
        try {
            return mapFromJson(new b(str));
        } catch (JSONException e10) {
            Log.e("Error converting " + str + " from JSON", (Throwable) e10);
            return null;
        }
    }

    public static <T> List<T> listFromJson(a aVar) {
        Object obj;
        if (aVar == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(aVar.o());
        for (int i10 = 0; i10 < aVar.o(); i10++) {
            Object p10 = aVar.p(i10);
            if (!(p10 == null || p10 == (obj = b.NULL))) {
                if (p10 instanceof b) {
                    p10 = mapFromJson((b) p10);
                } else if (p10 instanceof a) {
                    p10 = listFromJson((a) p10);
                } else if (!obj.equals(p10)) {
                }
                arrayList.add(p10);
            }
            p10 = null;
            arrayList.add(p10);
        }
        return (List) CollectionUtil.uncheckedCast(arrayList);
    }

    public static <T> List<T> listFromJsonOrDefault(a aVar) {
        if (aVar == null) {
            return new ArrayList();
        }
        return listFromJson(aVar);
    }

    public static a listToJsonArray(Iterable<?> iterable) throws JSONException {
        if (iterable == null) {
            return null;
        }
        a aVar = new a();
        for (Object next : iterable) {
            if (next instanceof Map) {
                next = mapToJsonObject((Map) CollectionUtil.uncheckedCast(next));
            } else if (next instanceof Iterable) {
                next = listToJsonArray((Iterable) next);
            } else if (next == null) {
                next = b.NULL;
            }
            aVar.E(next);
        }
        return aVar;
    }

    public static <T> Map<String, T> mapFromJson(b bVar) {
        Object obj;
        if (bVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = bVar.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = bVar.opt(next);
            if (!(opt == null || opt == (obj = b.NULL))) {
                if (opt instanceof b) {
                    opt = mapFromJson((b) opt);
                } else if (opt instanceof a) {
                    opt = listFromJson((a) opt);
                } else if (!obj.equals(opt)) {
                }
                hashMap.put(next, CollectionUtil.uncheckedCast(opt));
            }
            opt = null;
            hashMap.put(next, CollectionUtil.uncheckedCast(opt));
        }
        return hashMap;
    }

    public static <T> Map<String, T> mapFromJsonOrDefault(b bVar) {
        if (bVar == null) {
            return new HashMap();
        }
        return mapFromJson(bVar);
    }

    public static b mapToJsonObject(Map<String, ?> map) throws JSONException {
        if (map == null) {
            return null;
        }
        b bVar = new b();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            Object value = next.getValue();
            if (value instanceof Map) {
                value = mapToJsonObject((Map) CollectionUtil.uncheckedCast(value));
            } else if (value instanceof Iterable) {
                value = listToJsonArray((Iterable) value);
            } else if (value instanceof Editable) {
                value = value.toString();
            } else if (value == null) {
                value = b.NULL;
            }
            bVar.put(str, value);
        }
        return bVar;
    }

    public static String toJson(Map<String, ?> map) {
        if (map == null) {
            return null;
        }
        try {
            return mapToJsonObject(map).toString();
        } catch (JSONException e10) {
            Log.e("Error converting " + map + " to JSON", (Throwable) e10);
            return null;
        }
    }
}
