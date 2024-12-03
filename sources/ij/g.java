package ij;

import androidx.annotation.NonNull;
import mj.d;
import mj.e;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private final jj.a f29975a;

    /* renamed from: b  reason: collision with root package name */
    private final mj.a f29976b;

    /* renamed from: c  reason: collision with root package name */
    private final oj.a f29977c;

    /* renamed from: d  reason: collision with root package name */
    private final c f29978d;

    /* renamed from: e  reason: collision with root package name */
    private final nj.a f29979e;

    /* renamed from: f  reason: collision with root package name */
    private final d f29980f;

    /* renamed from: g  reason: collision with root package name */
    private final j f29981g;

    public static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public jj.a f29982a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public mj.a f29983b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public oj.a f29984c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public c f29985d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public nj.a f29986e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public d f29987f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public j f29988g;

        b() {
        }

        @NonNull
        public g h(@NonNull jj.a aVar, @NonNull j jVar) {
            this.f29982a = aVar;
            this.f29988g = jVar;
            if (this.f29983b == null) {
                this.f29983b = mj.a.a();
            }
            if (this.f29984c == null) {
                this.f29984c = new oj.b();
            }
            if (this.f29985d == null) {
                this.f29985d = new d();
            }
            if (this.f29986e == null) {
                this.f29986e = nj.a.a();
            }
            if (this.f29987f == null) {
                this.f29987f = new e();
            }
            return new g(this);
        }
    }

    @NonNull
    public nj.a a() {
        return this.f29979e;
    }

    @NonNull
    public c b() {
        return this.f29978d;
    }

    @NonNull
    public j c() {
        return this.f29981g;
    }

    @NonNull
    public oj.a d() {
        return this.f29977c;
    }

    @NonNull
    public jj.a e() {
        return this.f29975a;
    }

    private g(@NonNull b bVar) {
        this.f29975a = bVar.f29982a;
        this.f29976b = bVar.f29983b;
        this.f29977c = bVar.f29984c;
        this.f29978d = bVar.f29985d;
        this.f29979e = bVar.f29986e;
        this.f29980f = bVar.f29987f;
        this.f29981g = bVar.f29988g;
    }
}
