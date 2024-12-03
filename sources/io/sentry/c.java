package io.sentry;

import io.sentry.protocol.TransactionNameSource;
import io.sentry.protocol.x;
import io.sentry.util.o;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Experimental
public final class c {

    /* renamed from: e  reason: collision with root package name */
    static final Integer f31149e = 8192;

    /* renamed from: f  reason: collision with root package name */
    static final Integer f31150f = 64;

    /* renamed from: a  reason: collision with root package name */
    final Map<String, String> f31151a;

    /* renamed from: b  reason: collision with root package name */
    final String f31152b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f31153c;

    /* renamed from: d  reason: collision with root package name */
    final h0 f31154d;

    @ApiStatus.Internal
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final List<String> f31155a = Arrays.asList(new String[]{"sentry-trace_id", "sentry-public_key", "sentry-release", "sentry-user_id", "sentry-environment", "sentry-user_segment", "sentry-transaction", "sentry-sample_rate"});
    }

    @ApiStatus.Internal
    public c(h0 h0Var) {
        this(new HashMap(), (String) null, true, h0Var);
    }

    private static String g(x xVar) {
        if (xVar.n() != null) {
            return xVar.n();
        }
        Map<String, String> j10 = xVar.j();
        if (j10 != null) {
            return j10.get("segment");
        }
        return null;
    }

    private static boolean m(TransactionNameSource transactionNameSource) {
        if (transactionNameSource == null || TransactionNameSource.URL.equals(transactionNameSource)) {
            return false;
        }
        return true;
    }

    private static Double o(r4 r4Var) {
        if (r4Var == null) {
            return null;
        }
        return r4Var.b();
    }

    private static String p(Double d10) {
        if (!o.e(d10, false)) {
            return null;
        }
        return new DecimalFormat("#.################", DecimalFormatSymbols.getInstance(Locale.ROOT)).format(d10);
    }

    @ApiStatus.Internal
    public void a() {
        this.f31153c = false;
    }

    @ApiStatus.Internal
    public String b(String str) {
        if (str == null) {
            return null;
        }
        return this.f31151a.get(str);
    }

    @ApiStatus.Internal
    public String c() {
        return b("sentry-environment");
    }

    @ApiStatus.Internal
    public String d() {
        return b("sentry-public_key");
    }

    @ApiStatus.Internal
    public String e() {
        return b("sentry-release");
    }

    @ApiStatus.Internal
    public String f() {
        return b("sentry-sample_rate");
    }

    @ApiStatus.Internal
    public String h() {
        return b("sentry-trace_id");
    }

    @ApiStatus.Internal
    public String i() {
        return b("sentry-transaction");
    }

    @ApiStatus.Internal
    public Map<String, Object> j() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry next : this.f31151a.entrySet()) {
            String str = (String) next.getKey();
            String str2 = (String) next.getValue();
            if (!a.f31155a.contains(str) && str2 != null) {
                concurrentHashMap.put(str.replaceFirst("sentry-", ""), str2);
            }
        }
        return concurrentHashMap;
    }

    @ApiStatus.Internal
    public String k() {
        return b("sentry-user_id");
    }

    @ApiStatus.Internal
    public String l() {
        return b("sentry-user_segment");
    }

    @ApiStatus.Internal
    public boolean n() {
        return this.f31153c;
    }

    @ApiStatus.Internal
    public void q(String str, String str2) {
        if (this.f31153c) {
            this.f31151a.put(str, str2);
        }
    }

    @ApiStatus.Internal
    public void r(String str) {
        q("sentry-environment", str);
    }

    @ApiStatus.Internal
    public void s(String str) {
        q("sentry-public_key", str);
    }

    @ApiStatus.Internal
    public void t(String str) {
        q("sentry-release", str);
    }

    @ApiStatus.Internal
    public void u(String str) {
        q("sentry-sample_rate", str);
    }

    @ApiStatus.Internal
    public void v(String str) {
        q("sentry-trace_id", str);
    }

    @ApiStatus.Internal
    public void w(String str) {
        q("sentry-transaction", str);
    }

    @ApiStatus.Internal
    public void x(String str) {
        q("sentry-user_segment", str);
    }

    @ApiStatus.Internal
    public void y(n0 n0Var, x xVar, SentryOptions sentryOptions, r4 r4Var) {
        String str;
        v(n0Var.m().j().toString());
        s(new m(sentryOptions.getDsn()).a());
        t(sentryOptions.getRelease());
        r(sentryOptions.getEnvironment());
        String str2 = null;
        if (xVar != null) {
            str = g(xVar);
        } else {
            str = null;
        }
        x(str);
        if (m(n0Var.e())) {
            str2 = n0Var.getName();
        }
        w(str2);
        u(p(o(r4Var)));
    }

    @ApiStatus.Internal
    public p4 z() {
        String h10 = h();
        String d10 = d();
        if (h10 == null || d10 == null) {
            return null;
        }
        p4 p4Var = new p4(new io.sentry.protocol.o(h10), d10, e(), c(), k(), l(), i(), f());
        p4Var.b(j());
        return p4Var;
    }

    @ApiStatus.Internal
    public c(Map<String, String> map, String str, boolean z10, h0 h0Var) {
        this.f31151a = map;
        this.f31154d = h0Var;
        this.f31153c = z10;
        this.f31152b = str;
    }
}
