package io.sentry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class x0 {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<c> f31787a = new ArrayList<>();

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31788a;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                io.sentry.vendor.gson.stream.JsonToken[] r0 = io.sentry.vendor.gson.stream.JsonToken.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31788a = r0
                io.sentry.vendor.gson.stream.JsonToken r1 = io.sentry.vendor.gson.stream.JsonToken.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31788a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.sentry.vendor.gson.stream.JsonToken r1 = io.sentry.vendor.gson.stream.JsonToken.END_ARRAY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f31788a     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.sentry.vendor.gson.stream.JsonToken r1 = io.sentry.vendor.gson.stream.JsonToken.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f31788a     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.sentry.vendor.gson.stream.JsonToken r1 = io.sentry.vendor.gson.stream.JsonToken.END_OBJECT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f31788a     // Catch:{ NoSuchFieldError -> 0x003e }
                io.sentry.vendor.gson.stream.JsonToken r1 = io.sentry.vendor.gson.stream.JsonToken.NAME     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f31788a     // Catch:{ NoSuchFieldError -> 0x0049 }
                io.sentry.vendor.gson.stream.JsonToken r1 = io.sentry.vendor.gson.stream.JsonToken.STRING     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f31788a     // Catch:{ NoSuchFieldError -> 0x0054 }
                io.sentry.vendor.gson.stream.JsonToken r1 = io.sentry.vendor.gson.stream.JsonToken.NUMBER     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f31788a     // Catch:{ NoSuchFieldError -> 0x0060 }
                io.sentry.vendor.gson.stream.JsonToken r1 = io.sentry.vendor.gson.stream.JsonToken.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f31788a     // Catch:{ NoSuchFieldError -> 0x006c }
                io.sentry.vendor.gson.stream.JsonToken r1 = io.sentry.vendor.gson.stream.JsonToken.NULL     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f31788a     // Catch:{ NoSuchFieldError -> 0x0078 }
                io.sentry.vendor.gson.stream.JsonToken r1 = io.sentry.vendor.gson.stream.JsonToken.END_DOCUMENT     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.x0.a.<clinit>():void");
        }
    }

    private interface b {
        Object a() throws IOException;
    }

    private interface c {
        Object getValue();
    }

    private static final class f implements c {

        /* renamed from: a  reason: collision with root package name */
        final String f31791a;

        f(String str) {
            this.f31791a = str;
        }

        public Object getValue() {
            return this.f31791a;
        }
    }

    private static final class g implements c {

        /* renamed from: a  reason: collision with root package name */
        final Object f31792a;

        g(Object obj) {
            this.f31792a = obj;
        }

        public Object getValue() {
            return this.f31792a;
        }
    }

    private c d() {
        if (this.f31787a.isEmpty()) {
            return null;
        }
        ArrayList<c> arrayList = this.f31787a;
        return arrayList.get(arrayList.size() - 1);
    }

    private boolean e() {
        if (g()) {
            return true;
        }
        c d10 = d();
        l();
        if (d() instanceof f) {
            f fVar = (f) d();
            l();
            e eVar = (e) d();
            if (fVar == null || d10 == null || eVar == null) {
                return false;
            }
            eVar.f31790a.put(fVar.f31791a, d10.getValue());
            return false;
        } else if (!(d() instanceof d)) {
            return false;
        } else {
            d dVar = (d) d();
            if (d10 == null || dVar == null) {
                return false;
            }
            dVar.f31789a.add(d10.getValue());
            return false;
        }
    }

    private boolean f(b bVar) throws IOException {
        Object a10 = bVar.a();
        if (d() == null && a10 != null) {
            m(new g(a10));
            return true;
        } else if (d() instanceof f) {
            l();
            ((e) d()).f31790a.put(((f) d()).f31791a, a10);
            return false;
        } else if (!(d() instanceof d)) {
            return false;
        } else {
            ((d) d()).f31789a.add(a10);
            return false;
        }
    }

    private boolean g() {
        return this.f31787a.size() == 1;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object i() throws IOException {
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:3|4|5) */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0011, code lost:
        return java.lang.Double.valueOf(r3.u());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        return java.lang.Long.valueOf(r3.x());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0009 */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object h(io.sentry.y0 r3) throws java.io.IOException {
        /*
            r2 = this;
            int r0 = r3.v()     // Catch:{ Exception -> 0x0009 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0009 }
            return r3
        L_0x0009:
            double r0 = r3.u()     // Catch:{ Exception -> 0x0012 }
            java.lang.Double r3 = java.lang.Double.valueOf(r0)     // Catch:{ Exception -> 0x0012 }
            return r3
        L_0x0012:
            long r0 = r3.x()
            java.lang.Long r3 = java.lang.Long.valueOf(r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.x0.h(io.sentry.y0):java.lang.Object");
    }

    private void k(y0 y0Var) throws IOException {
        boolean z10;
        switch (a.f31788a[y0Var.J().ordinal()]) {
            case 1:
                y0Var.a();
                m(new d((a) null));
                break;
            case 2:
                y0Var.g();
                z10 = e();
                break;
            case 3:
                y0Var.b();
                m(new e((a) null));
                break;
            case 4:
                y0Var.h();
                z10 = e();
                break;
            case 5:
                m(new f(y0Var.y()));
                break;
            case 6:
                z10 = f(new t0(y0Var));
                break;
            case 7:
                z10 = f(new u0(this, y0Var));
                break;
            case 8:
                z10 = f(new v0(y0Var));
                break;
            case 9:
                y0Var.E();
                z10 = f(new w0());
                break;
            case 10:
                z10 = true;
                break;
        }
        z10 = false;
        if (!z10) {
            k(y0Var);
        }
    }

    private void l() {
        if (!this.f31787a.isEmpty()) {
            ArrayList<c> arrayList = this.f31787a;
            arrayList.remove(arrayList.size() - 1);
        }
    }

    private void m(c cVar) {
        this.f31787a.add(cVar);
    }

    public Object c(y0 y0Var) throws IOException {
        k(y0Var);
        c d10 = d();
        if (d10 != null) {
            return d10.getValue();
        }
        return null;
    }

    private static final class d implements c {

        /* renamed from: a  reason: collision with root package name */
        final ArrayList<Object> f31789a;

        private d() {
            this.f31789a = new ArrayList<>();
        }

        public Object getValue() {
            return this.f31789a;
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    private static final class e implements c {

        /* renamed from: a  reason: collision with root package name */
        final HashMap<String, Object> f31790a;

        private e() {
            this.f31790a = new HashMap<>();
        }

        public Object getValue() {
            return this.f31790a;
        }

        /* synthetic */ e(a aVar) {
            this();
        }
    }
}
