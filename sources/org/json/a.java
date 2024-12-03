package org.json;

import com.facebook.internal.ServerProtocol;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.validator.Var;

public class a implements Iterable<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Object> f24239a;

    public a() {
        this.f24239a = new ArrayList<>();
    }

    private static JSONException M(int i10, String str, Object obj, Throwable th2) {
        if (obj == null) {
            return new JSONException("JSONArray[" + i10 + "] is not a " + str + " (null).", th2);
        } else if ((obj instanceof Map) || (obj instanceof Iterable) || (obj instanceof b)) {
            return new JSONException("JSONArray[" + i10 + "] is not a " + str + " (" + obj.getClass() + ").", th2);
        } else {
            return new JSONException("JSONArray[" + i10 + "] is not a " + str + " (" + obj.getClass() + " : " + obj + ").", th2);
        }
    }

    private void b(Iterable<?> iterable, boolean z10) {
        if (z10) {
            for (Object wrap : iterable) {
                E(b.wrap(wrap));
            }
            return;
        }
        for (Object E : iterable) {
            E(E);
        }
    }

    private void d(Object obj, boolean z10) throws JSONException {
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            ArrayList<Object> arrayList = this.f24239a;
            arrayList.ensureCapacity(arrayList.size() + length);
            int i10 = 0;
            if (z10) {
                while (i10 < length) {
                    E(b.wrap(Array.get(obj, i10)));
                    i10++;
                }
                return;
            }
            while (i10 < length) {
                E(Array.get(obj, i10));
                i10++;
            }
        } else if (obj instanceof a) {
            this.f24239a.addAll(((a) obj).f24239a);
        } else if (obj instanceof Collection) {
            f((Collection) obj, z10);
        } else if (obj instanceof Iterable) {
            b((Iterable) obj, z10);
        } else {
            throw new JSONException("JSONArray initial value should be a string or collection or array.");
        }
    }

    private void f(Collection<?> collection, boolean z10) {
        ArrayList<Object> arrayList = this.f24239a;
        arrayList.ensureCapacity(arrayList.size() + collection.size());
        if (z10) {
            for (Object wrap : collection) {
                E(b.wrap(wrap));
            }
            return;
        }
        for (Object E : collection) {
            E(E);
        }
    }

    public a A(int i10) {
        return E(Integer.valueOf(i10));
    }

    public a B(int i10, int i11) throws JSONException {
        return C(i10, Integer.valueOf(i11));
    }

    public a C(int i10, Object obj) throws JSONException {
        if (i10 < 0) {
            throw new JSONException("JSONArray[" + i10 + "] not found.");
        } else if (i10 < o()) {
            b.testValidity(obj);
            this.f24239a.set(i10, obj);
            return this;
        } else if (i10 == o()) {
            return E(obj);
        } else {
            this.f24239a.ensureCapacity(i10 + 1);
            while (i10 != o()) {
                this.f24239a.add(b.NULL);
            }
            return E(obj);
        }
    }

    public a D(long j10) {
        return E(Long.valueOf(j10));
    }

    public a E(Object obj) {
        b.testValidity(obj);
        this.f24239a.add(obj);
        return this;
    }

    public a F(boolean z10) {
        return E(z10 ? Boolean.TRUE : Boolean.FALSE);
    }

    public boolean H(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        int o10 = o();
        a aVar = (a) obj;
        if (o10 != aVar.o()) {
            return false;
        }
        for (int i10 = 0; i10 < o10; i10++) {
            Object obj2 = this.f24239a.get(i10);
            Object obj3 = aVar.f24239a.get(i10);
            if (obj2 != obj3) {
                if (obj2 == null) {
                    return false;
                }
                if (obj2 instanceof b) {
                    if (!((b) obj2).similar(obj3)) {
                        return false;
                    }
                } else if (obj2 instanceof a) {
                    if (!((a) obj2).H(obj3)) {
                        return false;
                    }
                } else if (!(obj2 instanceof Number) || !(obj3 instanceof Number)) {
                    if (!(obj2 instanceof f) || !(obj3 instanceof f)) {
                        if (!obj2.equals(obj3)) {
                            return false;
                        }
                    } else if (!((f) obj2).a().equals(((f) obj3).a())) {
                        return false;
                    }
                } else if (!b.isNumberSimilar((Number) obj2, (Number) obj3)) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<Object> J() {
        ArrayList arrayList = new ArrayList(this.f24239a.size());
        Iterator<Object> it = this.f24239a.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next == null || b.NULL.equals(next)) {
                arrayList.add((Object) null);
            } else if (next instanceof a) {
                arrayList.add(((a) next).J());
            } else if (next instanceof b) {
                arrayList.add(((b) next).toMap());
            } else {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public String K(int i10) throws JSONException {
        String obj;
        StringWriter stringWriter = new StringWriter();
        synchronized (stringWriter.getBuffer()) {
            obj = L(stringWriter, i10, 0).toString();
        }
        return obj;
    }

    public Writer L(Writer writer, int i10, int i11) throws JSONException {
        int i12;
        try {
            int o10 = o();
            writer.write(91);
            i12 = 0;
            if (o10 == 1) {
                b.writeValue(writer, this.f24239a.get(0), i10, i11);
            } else if (o10 != 0) {
                int i13 = i11 + i10;
                boolean z10 = false;
                while (i12 < o10) {
                    if (z10) {
                        writer.write(44);
                    }
                    if (i10 > 0) {
                        writer.write(10);
                    }
                    b.indent(writer, i13);
                    b.writeValue(writer, this.f24239a.get(i12), i10, i13);
                    i12++;
                    z10 = true;
                }
                if (i10 > 0) {
                    writer.write(10);
                }
                b.indent(writer, i11);
            }
            writer.write(93);
            return writer;
        } catch (Exception e10) {
            throw new JSONException("Unable to write JSONArray value at index: " + i12, e10);
        } catch (Exception e11) {
            throw new JSONException("Unable to write JSONArray value at index: 0", e11);
        } catch (IOException e12) {
            throw new JSONException((Throwable) e12);
        }
    }

    public boolean g(int i10) throws JSONException {
        Object obj = get(i10);
        if (obj.equals(Boolean.FALSE)) {
            return false;
        }
        boolean z10 = obj instanceof String;
        if (z10 && ((String) obj).equalsIgnoreCase("false")) {
            return false;
        }
        if (obj.equals(Boolean.TRUE)) {
            return true;
        }
        if (z10 && ((String) obj).equalsIgnoreCase(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
            return true;
        }
        throw M(i10, "boolean", obj, (Throwable) null);
    }

    public Object get(int i10) throws JSONException {
        Object p10 = p(i10);
        if (p10 != null) {
            return p10;
        }
        throw new JSONException("JSONArray[" + i10 + "] not found.");
    }

    public int getInt(int i10) throws JSONException {
        Object obj = get(i10);
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        try {
            return Integer.parseInt(obj.toString());
        } catch (Exception e10) {
            throw M(i10, Var.JSTYPE_INT, obj, e10);
        }
    }

    public double i(int i10) throws JSONException {
        Object obj = get(i10);
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        try {
            return Double.parseDouble(obj.toString());
        } catch (Exception e10) {
            throw M(i10, "double", obj, e10);
        }
    }

    public boolean isEmpty() {
        return this.f24239a.isEmpty();
    }

    public Iterator<Object> iterator() {
        return this.f24239a.iterator();
    }

    public b j(int i10) throws JSONException {
        Object obj = get(i10);
        if (obj instanceof b) {
            return (b) obj;
        }
        throw M(i10, "JSONObject", obj, (Throwable) null);
    }

    public long m(int i10) throws JSONException {
        Object obj = get(i10);
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        try {
            return Long.parseLong(obj.toString());
        } catch (Exception e10) {
            throw M(i10, "long", obj, e10);
        }
    }

    public String n(int i10) throws JSONException {
        Object obj = get(i10);
        if (obj instanceof String) {
            return (String) obj;
        }
        throw M(i10, "String", obj, (Throwable) null);
    }

    public int o() {
        return this.f24239a.size();
    }

    public Object p(int i10) {
        if (i10 < 0 || i10 >= o()) {
            return null;
        }
        return this.f24239a.get(i10);
    }

    public int q(int i10) {
        return r(i10, 0);
    }

    public int r(int i10, int i11) {
        Number v10 = v(i10, (Number) null);
        if (v10 == null) {
            return i11;
        }
        return v10.intValue();
    }

    public Object remove(int i10) {
        if (i10 < 0 || i10 >= o()) {
            return null;
        }
        return this.f24239a.remove(i10);
    }

    public b s(int i10) {
        Object p10 = p(i10);
        if (p10 instanceof b) {
            return (b) p10;
        }
        return null;
    }

    public long t(int i10) {
        return u(i10, 0);
    }

    public String toString() {
        try {
            return K(0);
        } catch (Exception unused) {
            return null;
        }
    }

    public long u(int i10, long j10) {
        Number v10 = v(i10, (Number) null);
        if (v10 == null) {
            return j10;
        }
        return v10.longValue();
    }

    public Number v(int i10, Number number) {
        Object p10 = p(i10);
        if (b.NULL.equals(p10)) {
            return number;
        }
        if (p10 instanceof Number) {
            return (Number) p10;
        }
        if (p10 instanceof String) {
            try {
                return b.stringToNumber((String) p10);
            } catch (Exception unused) {
            }
        }
        return number;
    }

    public String w(int i10) {
        return y(i10, "");
    }

    public String y(int i10, String str) {
        Object p10 = p(i10);
        if (b.NULL.equals(p10)) {
            return str;
        }
        return p10.toString();
    }

    public a z(double d10) throws JSONException {
        return E(Double.valueOf(d10));
    }

    public a(h hVar) throws JSONException {
        this();
        if (hVar.h() == '[') {
            char h10 = hVar.h();
            if (h10 == 0) {
                throw hVar.k("Expected a ',' or ']'");
            } else if (h10 != ']') {
                hVar.a();
                while (true) {
                    if (hVar.h() == ',') {
                        hVar.a();
                        this.f24239a.add(b.NULL);
                    } else {
                        hVar.a();
                        this.f24239a.add(hVar.j());
                    }
                    char h11 = hVar.h();
                    if (h11 == 0) {
                        throw hVar.k("Expected a ',' or ']'");
                    } else if (h11 == ',') {
                        char h12 = hVar.h();
                        if (h12 == 0) {
                            throw hVar.k("Expected a ',' or ']'");
                        } else if (h12 != ']') {
                            hVar.a();
                        } else {
                            return;
                        }
                    } else if (h11 != ']') {
                        throw hVar.k("Expected a ',' or ']'");
                    } else {
                        return;
                    }
                }
            }
        } else {
            throw hVar.k("A JSONArray text must start with '['");
        }
    }

    public a(String str) throws JSONException {
        this(new h(str));
    }

    public a(Collection<?> collection) {
        if (collection == null) {
            this.f24239a = new ArrayList<>();
            return;
        }
        this.f24239a = new ArrayList<>(collection.size());
        f(collection, true);
    }

    public a(Object obj) throws JSONException {
        this();
        if (obj.getClass().isArray()) {
            d(obj, true);
            return;
        }
        throw new JSONException("JSONArray initial value should be a string or collection or array.");
    }
}
