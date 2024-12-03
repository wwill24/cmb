package io.sentry.clientreport;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.sentry.SentryLevel;
import io.sentry.a1;
import io.sentry.c1;
import io.sentry.h0;
import io.sentry.s0;
import io.sentry.vendor.gson.stream.JsonToken;
import io.sentry.y0;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;
import org.jivesoftware.smackx.jingle.element.JingleReason;

@ApiStatus.Internal
public final class e implements c1 {

    /* renamed from: a  reason: collision with root package name */
    private final String f31174a;

    /* renamed from: b  reason: collision with root package name */
    private final String f31175b;

    /* renamed from: c  reason: collision with root package name */
    private final Long f31176c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, Object> f31177d;

    public static final class a implements s0<e> {
        private Exception c(String str, h0 h0Var) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            h0Var.b(SentryLevel.ERROR, str2, illegalStateException);
            return illegalStateException;
        }

        /* renamed from: b */
        public e a(y0 y0Var, h0 h0Var) throws Exception {
            y0Var.b();
            String str = null;
            String str2 = null;
            Long l10 = null;
            HashMap hashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                char c10 = 65535;
                switch (y10.hashCode()) {
                    case -1285004149:
                        if (y10.equals(FirebaseAnalytics.Param.QUANTITY)) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case -934964668:
                        if (y10.equals(JingleReason.ELEMENT)) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case 50511102:
                        if (y10.equals("category")) {
                            c10 = 2;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        l10 = y0Var.x0();
                        break;
                    case 1:
                        str = y0Var.H0();
                        break;
                    case 2:
                        str2 = y0Var.H0();
                        break;
                    default:
                        if (hashMap == null) {
                            hashMap = new HashMap();
                        }
                        y0Var.N0(h0Var, hashMap, y10);
                        break;
                }
            }
            y0Var.h();
            if (str == null) {
                throw c(JingleReason.ELEMENT, h0Var);
            } else if (str2 == null) {
                throw c("category", h0Var);
            } else if (l10 != null) {
                e eVar = new e(str, str2, l10);
                eVar.d(hashMap);
                return eVar;
            } else {
                throw c(FirebaseAnalytics.Param.QUANTITY, h0Var);
            }
        }
    }

    public e(String str, String str2, Long l10) {
        this.f31174a = str;
        this.f31175b = str2;
        this.f31176c = l10;
    }

    public String a() {
        return this.f31175b;
    }

    public Long b() {
        return this.f31176c;
    }

    public String c() {
        return this.f31174a;
    }

    public void d(Map<String, Object> map) {
        this.f31177d = map;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        a1Var.N(JingleReason.ELEMENT).I(this.f31174a);
        a1Var.N("category").I(this.f31175b);
        a1Var.N(FirebaseAnalytics.Param.QUANTITY).G(this.f31176c);
        Map<String, Object> map = this.f31177d;
        if (map != null) {
            for (String next : map.keySet()) {
                a1Var.N(next).O(h0Var, this.f31177d.get(next));
            }
        }
        a1Var.h();
    }

    public String toString() {
        return "DiscardedEvent{reason='" + this.f31174a + '\'' + ", category='" + this.f31175b + '\'' + ", quantity=" + this.f31176c + '}';
    }
}
