package com.mparticle;

import android.location.Location;
import com.mparticle.internal.InternalSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.a;
import org.json.b;

public class d extends b {

    /* renamed from: a  reason: collision with root package name */
    private Double f22274a = null;

    public d(String str) {
        try {
            put("dt", (Object) str);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }

    public d a(long j10) {
        try {
            put("ct", j10);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return this;
    }

    public d b(String str) {
        try {
            put("n", (Object) str);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return this;
    }

    public d a(b bVar) {
        if (bVar != null && bVar.length() > 0) {
            try {
                put("attrs", (Object) bVar);
                Double d10 = this.f22274a;
                if (d10 != null) {
                    a(d10);
                }
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
        return this;
    }

    public String b() {
        return optString("dt");
    }

    public d b(Double d10) {
        this.f22274a = d10;
        if (d10 != null) {
            try {
                put("el", (Object) d10);
                a(d10);
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
        return this;
    }

    public c a(InternalSession internalSession, Location location, long j10) throws JSONException {
        return new c(this, internalSession, location, j10);
    }

    public d a(String str) {
        if (str != null) {
            try {
                put("dct", (Object) str);
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
        return this;
    }

    private void a(Double d10) {
        try {
            if (!has("attrs")) {
                put("attrs", (Object) new b());
            }
            if (!getJSONObject("attrs").has("EventLength")) {
                getJSONObject("attrs").put("EventLength", (Object) Integer.toString(d10.intValue()));
            }
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }

    public d a(Map<String, List<String>> map) {
        if (map != null) {
            try {
                b bVar = new b();
                for (Map.Entry next : map.entrySet()) {
                    bVar.put((String) next.getKey(), (Object) new a((Collection<?>) (List) next.getValue()));
                }
                put("flags", (Object) bVar);
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public String[] a() {
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = keys();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }
}
