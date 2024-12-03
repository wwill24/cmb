package org.json;

import java.util.Collection;
import java.util.Map;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private boolean f24249a = false;

    /* renamed from: b  reason: collision with root package name */
    protected char f24250b = 'i';

    /* renamed from: c  reason: collision with root package name */
    private final b[] f24251c = new b[200];

    /* renamed from: d  reason: collision with root package name */
    private int f24252d = 0;

    /* renamed from: e  reason: collision with root package name */
    protected Appendable f24253e;

    public i(Appendable appendable) {
        this.f24253e = appendable;
    }

    public static String a(Object obj) throws JSONException {
        if (obj == null || obj.equals((Object) null)) {
            return "null";
        }
        if (obj instanceof f) {
            try {
                String a10 = ((f) obj).a();
                if (a10 != null) {
                    return a10;
                }
                throw new JSONException("Bad value from toJSONString: " + a10);
            } catch (Exception e10) {
                throw new JSONException((Throwable) e10);
            }
        } else if (obj instanceof Number) {
            String numberToString = b.numberToString((Number) obj);
            if (b.NUMBER_PATTERN.matcher(numberToString).matches()) {
                return numberToString;
            }
            return b.quote(numberToString);
        } else if ((obj instanceof Boolean) || (obj instanceof b) || (obj instanceof a)) {
            return obj.toString();
        } else {
            if (obj instanceof Map) {
                return new b((Map<?, ?>) (Map) obj).toString();
            }
            if (obj instanceof Collection) {
                return new a((Collection<?>) (Collection) obj).toString();
            }
            if (obj.getClass().isArray()) {
                return new a(obj).toString();
            }
            if (obj instanceof Enum) {
                return b.quote(((Enum) obj).name());
            }
            return b.quote(obj.toString());
        }
    }
}
