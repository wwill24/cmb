package b7;

import s9.a;

public class d implements c {

    /* renamed from: a  reason: collision with root package name */
    private final a f7883a;

    /* renamed from: b  reason: collision with root package name */
    private final b f7884b;

    /* renamed from: c  reason: collision with root package name */
    private long f7885c;

    public d(a aVar, b bVar) {
        this.f7883a = aVar;
        this.f7884b = bVar;
    }

    public void a(String str, long j10, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Event ");
        sb2.append(str2);
        sb2.append(" ");
        sb2.append(str);
        sb2.append(" Latency ");
        sb2.append(j10);
        this.f7884b.a(str, j10, str2);
    }

    public void b() {
    }

    public void c() {
    }

    public void d() {
        if (g() && this.f7885c > 0) {
            a("cold start", System.currentTimeMillis() - this.f7885c, "succeeded");
            this.f7885c = 0;
        }
    }

    public void e(boolean z10) {
        if (z10) {
            b();
        } else {
            c();
        }
    }

    public void f() {
        if (g()) {
            this.f7885c = System.currentTimeMillis();
        }
    }

    public boolean g() {
        return this.f7883a.a("SendFlowLatency");
    }
}
