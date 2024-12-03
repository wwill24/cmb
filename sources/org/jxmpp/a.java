package org.jxmpp;

public final class a {

    /* renamed from: c  reason: collision with root package name */
    private static a f24258c;

    /* renamed from: d  reason: collision with root package name */
    private static jm.b f24259d;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f24260a;

    /* renamed from: b  reason: collision with root package name */
    public final jm.b f24261b;

    public static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public boolean f24262a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public jm.b f24263b;

        public a c() {
            return new a(this);
        }

        public b d() {
            this.f24262a = true;
            return this;
        }

        public b e(jm.b bVar) {
            this.f24263b = (jm.b) lm.b.a(bVar, "xmppStringprep");
            return this;
        }
    }

    static {
        km.a.f();
    }

    public static b a() {
        return new b();
    }

    public static a b() {
        return f24258c;
    }

    public static void d(jm.b bVar) {
        f24259d = (jm.b) lm.b.a(bVar, "defaultXmppStringprep");
        e();
    }

    private static void e() {
        f24258c = a().d().e(f24259d).c();
    }

    public boolean c() {
        return this.f24260a;
    }

    private a(b bVar) {
        this.f24260a = bVar.f24262a;
        this.f24261b = (jm.b) lm.b.a(bVar.f24263b, "xmppStringprep");
    }
}
