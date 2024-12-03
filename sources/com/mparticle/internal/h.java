package com.mparticle.internal;

import com.mparticle.BuildConfig;
import com.mparticle.MParticle;
import com.mparticle.consent.CCPAConsent;
import com.mparticle.consent.ConsentState;
import com.mparticle.consent.GDPRConsent;
import com.mparticle.e;
import com.mparticle.kits.LeanplumKit;
import com.mparticle.kits.ReportingMessage;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.a;
import org.json.b;

public class h extends b {

    /* renamed from: a  reason: collision with root package name */
    private long f22479a;

    protected h() {
    }

    public static h a(boolean z10, b bVar, b bVar2, e eVar) throws JSONException {
        String g10;
        h hVar = new h();
        if (BuildConfig.MP_DEBUG.booleanValue()) {
            hVar.put("echo", true);
        }
        hVar.put("dt", (Object) "h");
        hVar.put("id", (Object) UUID.randomUUID().toString());
        hVar.put("ct", System.currentTimeMillis());
        hVar.put("sdk", (Object) BuildConfig.VERSION_NAME);
        hVar.put("oo", bVar.H());
        hVar.put("uitl", bVar.R() / 1000);
        hVar.put("mpcv", (Object) bVar.v());
        hVar.put("stl", bVar.O() / 1000);
        hVar.put("mpid", (Object) String.valueOf(eVar.d()));
        hVar.put("dbg", b.u().equals(MParticle.Environment.Development));
        hVar.put(LeanplumKit.DEVICE_ID_TYPE_DAS, (Object) bVar.t());
        if (z10 && (g10 = bVar.f(eVar.d()).g()) != null) {
            hVar.put("uad", (Object) new a(g10));
            bVar.T().b();
        }
        hVar.put("ck", (Object) bVar2);
        hVar.put("cms", (Object) bVar.J());
        hVar.put("ia", (Object) bVar.A());
        hVar.a(bVar.b(eVar.d()));
        hVar.a(eVar.b(), eVar.c());
        return hVar;
    }

    public void b(b bVar) {
        try {
            if (!has("fsr")) {
                put("fsr", (Object) new a());
            }
            getJSONArray("fsr").E(bVar);
        } catch (JSONException unused) {
        }
    }

    public void c(b bVar) {
        try {
            if (!has("sh")) {
                put("sh", (Object) new a());
            }
            getJSONArray("sh").E(bVar);
        } catch (JSONException unused) {
        }
    }

    public void d(b bVar) {
        try {
            put("ai", (Object) bVar);
        } catch (JSONException unused) {
        }
    }

    public void e(b bVar) {
        try {
            put("di", (Object) bVar);
        } catch (JSONException unused) {
        }
    }

    public void f(b bVar) {
        try {
            put("ua", (Object) bVar);
        } catch (JSONException unused) {
        }
    }

    public a d() {
        try {
            return getJSONArray("msgs");
        } catch (JSONException unused) {
            return null;
        }
    }

    public a e() {
        try {
            return getJSONArray("sh");
        } catch (JSONException unused) {
            return null;
        }
    }

    public b b() {
        try {
            return getJSONObject("di");
        } catch (JSONException unused) {
            return null;
        }
    }

    public long c() {
        return this.f22479a;
    }

    public void a(ConsentState consentState) {
        if (consentState != null) {
            try {
                b bVar = new b();
                put("con", (Object) bVar);
                Map<String, GDPRConsent> gDPRConsentState = consentState.getGDPRConsentState();
                if (gDPRConsentState != null) {
                    b bVar2 = new b();
                    bVar.put("gdpr", (Object) bVar2);
                    for (Map.Entry next : gDPRConsentState.entrySet()) {
                        if (((com.mparticle.consent.a) next.getValue()) != null) {
                            a(bVar2, (String) next.getKey(), (com.mparticle.consent.a) next.getValue());
                        }
                    }
                }
                CCPAConsent cCPAConsentState = consentState.getCCPAConsentState();
                if (cCPAConsentState != null) {
                    b bVar3 = new b();
                    bVar.put("ccpa", (Object) bVar3);
                    a(bVar3, "data_sale_opt_out", cCPAConsentState);
                }
            } catch (JSONException unused) {
            }
        }
    }

    public void a(String str, Integer num) throws JSONException {
        if (str != null) {
            b bVar = new b();
            bVar.put("id", (Object) str);
            if (num != null) {
                bVar.put(ReportingMessage.MessageType.SCREEN_VIEW, (Object) num);
            }
            put("ctx", (Object) new b().put("dpln", (Object) bVar));
        }
    }

    public void a(b bVar) {
        try {
            if (!has("msgs")) {
                put("msgs", (Object) new a());
            }
            getJSONArray("msgs").E(bVar);
        } catch (JSONException unused) {
        }
    }

    public b a() {
        try {
            return getJSONObject("ai");
        } catch (JSONException unused) {
            return null;
        }
    }

    public void a(a aVar) {
        try {
            put("ui", (Object) aVar);
        } catch (JSONException unused) {
        }
    }

    public void a(long j10) {
        this.f22479a += j10;
    }

    private void a(b bVar, String str, com.mparticle.consent.a aVar) throws JSONException {
        b bVar2 = new b();
        bVar.put(str, (Object) bVar2);
        bVar2.put("c", aVar.isConsented());
        if (aVar.getDocument() != null) {
            bVar2.put("d", (Object) aVar.getDocument());
        }
        bVar2.put("ts", (Object) aVar.getTimestamp());
        if (aVar.getLocation() != null) {
            bVar2.put("l", (Object) aVar.getLocation());
        }
        if (aVar.getHardwareId() != null) {
            bVar2.put("h", (Object) aVar.getHardwareId());
        }
    }
}
