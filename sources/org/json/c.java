package org.json;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f24240a;

    public c(String str) {
        String str2;
        if (str == null) {
            throw new NullPointerException("pointer cannot be null");
        } else if (str.isEmpty() || str.equals("#")) {
            this.f24240a = Collections.emptyList();
        } else {
            if (str.startsWith("#/")) {
                try {
                    str2 = URLDecoder.decode(str.substring(2), "utf-8");
                } catch (UnsupportedEncodingException e10) {
                    throw new RuntimeException(e10);
                }
            } else if (str.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                str2 = str.substring(1);
            } else {
                throw new IllegalArgumentException("a JSON pointer should start with '/' or '#/'");
            }
            this.f24240a = new ArrayList();
            int i10 = -1;
            while (true) {
                int i11 = i10 + 1;
                int indexOf = str2.indexOf(47, i11);
                if (i11 == indexOf || i11 == str2.length()) {
                    this.f24240a.add("");
                } else if (indexOf >= 0) {
                    this.f24240a.add(d(str2.substring(i11, indexOf)));
                } else {
                    this.f24240a.add(d(str2.substring(i11)));
                }
                if (indexOf >= 0) {
                    i10 = indexOf;
                } else {
                    return;
                }
            }
        }
    }

    private static String a(String str) {
        return str.replace("~", "~0").replace(RemoteSettings.FORWARD_SLASH_STRING, "~1");
    }

    private static Object c(Object obj, String str) throws JSONPointerException {
        int parseInt;
        try {
            parseInt = Integer.parseInt(str);
            a aVar = (a) obj;
            if (parseInt < aVar.o()) {
                return aVar.get(parseInt);
            }
            throw new JSONPointerException(String.format("index %s is out of bounds - the array has %d elements", new Object[]{str, Integer.valueOf(aVar.o())}));
        } catch (JSONException e10) {
            throw new JSONPointerException("Error reading value at index position " + parseInt, e10);
        } catch (NumberFormatException e11) {
            throw new JSONPointerException(String.format("%s is not an array index", new Object[]{str}), e11);
        }
    }

    private static String d(String str) {
        return str.replace("~1", RemoteSettings.FORWARD_SLASH_STRING).replace("~0", "~");
    }

    public Object b(Object obj) throws JSONPointerException {
        if (this.f24240a.isEmpty()) {
            return obj;
        }
        for (String next : this.f24240a) {
            if (obj instanceof b) {
                obj = ((b) obj).opt(d(next));
            } else if (obj instanceof a) {
                obj = c(obj, next);
            } else {
                throw new JSONPointerException(String.format("value [%s] is not an array or object therefore its key %s cannot be resolved", new Object[]{obj, next}));
            }
        }
        return obj;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("");
        for (String a10 : this.f24240a) {
            sb2.append('/');
            sb2.append(a(a10));
        }
        return sb2.toString();
    }
}
