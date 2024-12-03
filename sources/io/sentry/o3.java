package io.sentry;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.leanplum.internal.Constants;
import io.sentry.SentryItemType;
import io.sentry.util.l;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import org.jetbrains.annotations.ApiStatus;
import org.jivesoftware.smackx.jingle_filetransfer.element.Range;

@ApiStatus.Internal
public final class o3 implements c1 {

    /* renamed from: a  reason: collision with root package name */
    private final String f31364a;

    /* renamed from: b  reason: collision with root package name */
    private final String f31365b;

    /* renamed from: c  reason: collision with root package name */
    private final SentryItemType f31366c;

    /* renamed from: d  reason: collision with root package name */
    private final int f31367d;

    /* renamed from: e  reason: collision with root package name */
    private final Callable<Integer> f31368e;

    /* renamed from: f  reason: collision with root package name */
    private final String f31369f;

    /* renamed from: g  reason: collision with root package name */
    private Map<String, Object> f31370g;

    public static final class a implements s0<o3> {
        private Exception c(String str, h0 h0Var) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            h0Var.b(SentryLevel.ERROR, str2, illegalStateException);
            return illegalStateException;
        }

        /* renamed from: b */
        public o3 a(y0 y0Var, h0 h0Var) throws Exception {
            y0Var.b();
            HashMap hashMap = null;
            int i10 = 0;
            SentryItemType sentryItemType = null;
            String str = null;
            String str2 = null;
            String str3 = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                char c10 = 65535;
                switch (y10.hashCode()) {
                    case -1106363674:
                        if (y10.equals(Range.ATTR_LENGTH)) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case -734768633:
                        if (y10.equals(Constants.Keys.FILENAME)) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case -672977706:
                        if (y10.equals("attachment_type")) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case 3575610:
                        if (y10.equals("type")) {
                            c10 = 3;
                            break;
                        }
                        break;
                    case 831846208:
                        if (y10.equals(FirebaseAnalytics.Param.CONTENT_TYPE)) {
                            c10 = 4;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        i10 = y0Var.v();
                        break;
                    case 1:
                        str2 = y0Var.H0();
                        break;
                    case 2:
                        str3 = y0Var.H0();
                        break;
                    case 3:
                        sentryItemType = (SentryItemType) y0Var.E0(h0Var, new SentryItemType.a());
                        break;
                    case 4:
                        str = y0Var.H0();
                        break;
                    default:
                        if (hashMap == null) {
                            hashMap = new HashMap();
                        }
                        y0Var.N0(h0Var, hashMap, y10);
                        break;
                }
            }
            if (sentryItemType != null) {
                o3 o3Var = new o3(sentryItemType, i10, str, str2, str3);
                o3Var.c(hashMap);
                y0Var.h();
                return o3Var;
            }
            throw c("type", h0Var);
        }
    }

    @ApiStatus.Internal
    public o3(SentryItemType sentryItemType, int i10, String str, String str2, String str3) {
        this.f31366c = (SentryItemType) l.c(sentryItemType, "type is required");
        this.f31364a = str;
        this.f31367d = i10;
        this.f31365b = str2;
        this.f31368e = null;
        this.f31369f = str3;
    }

    public int a() {
        Callable<Integer> callable = this.f31368e;
        if (callable == null) {
            return this.f31367d;
        }
        try {
            return callable.call().intValue();
        } catch (Throwable unused) {
            return -1;
        }
    }

    public SentryItemType b() {
        return this.f31366c;
    }

    public void c(Map<String, Object> map) {
        this.f31370g = map;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        if (this.f31364a != null) {
            a1Var.N(FirebaseAnalytics.Param.CONTENT_TYPE).I(this.f31364a);
        }
        if (this.f31365b != null) {
            a1Var.N(Constants.Keys.FILENAME).I(this.f31365b);
        }
        a1Var.N("type").O(h0Var, this.f31366c);
        if (this.f31369f != null) {
            a1Var.N("attachment_type").I(this.f31369f);
        }
        a1Var.N(Range.ATTR_LENGTH).E((long) a());
        Map<String, Object> map = this.f31370g;
        if (map != null) {
            for (String next : map.keySet()) {
                Object obj = this.f31370g.get(next);
                a1Var.N(next);
                a1Var.O(h0Var, obj);
            }
        }
        a1Var.h();
    }

    o3(SentryItemType sentryItemType, Callable<Integer> callable, String str, String str2, String str3) {
        this.f31366c = (SentryItemType) l.c(sentryItemType, "type is required");
        this.f31364a = str;
        this.f31367d = -1;
        this.f31365b = str2;
        this.f31368e = callable;
        this.f31369f = str3;
    }

    o3(SentryItemType sentryItemType, Callable<Integer> callable, String str, String str2) {
        this(sentryItemType, callable, str, str2, (String) null);
    }
}
