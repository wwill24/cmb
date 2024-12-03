package w3;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.bumptech.glide.h;
import d4.f;
import f4.j;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

class g {

    /* renamed from: a  reason: collision with root package name */
    private final g3.a f18211a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f18212b;

    /* renamed from: c  reason: collision with root package name */
    private final List<b> f18213c;

    /* renamed from: d  reason: collision with root package name */
    final h f18214d;

    /* renamed from: e  reason: collision with root package name */
    private final m3.d f18215e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f18216f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f18217g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f18218h;

    /* renamed from: i  reason: collision with root package name */
    private com.bumptech.glide.g<Bitmap> f18219i;

    /* renamed from: j  reason: collision with root package name */
    private a f18220j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f18221k;

    /* renamed from: l  reason: collision with root package name */
    private a f18222l;

    /* renamed from: m  reason: collision with root package name */
    private Bitmap f18223m;

    /* renamed from: n  reason: collision with root package name */
    private i3.h<Bitmap> f18224n;

    /* renamed from: o  reason: collision with root package name */
    private a f18225o;

    /* renamed from: p  reason: collision with root package name */
    private d f18226p;

    /* renamed from: q  reason: collision with root package name */
    private int f18227q;

    /* renamed from: r  reason: collision with root package name */
    private int f18228r;

    /* renamed from: s  reason: collision with root package name */
    private int f18229s;

    static class a extends c4.c<Bitmap> {

        /* renamed from: d  reason: collision with root package name */
        private final Handler f18230d;

        /* renamed from: e  reason: collision with root package name */
        final int f18231e;

        /* renamed from: f  reason: collision with root package name */
        private final long f18232f;

        /* renamed from: g  reason: collision with root package name */
        private Bitmap f18233g;

        a(Handler handler, int i10, long j10) {
            this.f18230d = handler;
            this.f18231e = i10;
            this.f18232f = j10;
        }

        /* access modifiers changed from: package-private */
        public Bitmap e() {
            return this.f18233g;
        }

        /* renamed from: h */
        public void f(@NonNull Bitmap bitmap, f<? super Bitmap> fVar) {
            this.f18233g = bitmap;
            this.f18230d.sendMessageAtTime(this.f18230d.obtainMessage(1, this), this.f18232f);
        }

        public void k(Drawable drawable) {
            this.f18233g = null;
        }
    }

    public interface b {
        void a();
    }

    private class c implements Handler.Callback {
        c() {
        }

        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                g.this.m((a) message.obj);
                return true;
            } else if (i10 != 2) {
                return false;
            } else {
                g.this.f18214d.p((a) message.obj);
                return false;
            }
        }
    }

    interface d {
        void a();
    }

    g(com.bumptech.glide.c cVar, g3.a aVar, int i10, int i11, i3.h<Bitmap> hVar, Bitmap bitmap) {
        this(cVar.f(), com.bumptech.glide.c.t(cVar.h()), aVar, (Handler) null, i(com.bumptech.glide.c.t(cVar.h()), i10, i11), hVar, bitmap);
    }

    private static i3.b g() {
        return new e4.d(Double.valueOf(Math.random()));
    }

    private static com.bumptech.glide.g<Bitmap> i(h hVar, int i10, int i11) {
        return hVar.h().a(((b4.c) ((b4.c) b4.c.n0(l3.a.f15995b).l0(true)).g0(true)).W(i10, i11));
    }

    private void l() {
        boolean z10;
        if (this.f18216f && !this.f18217g) {
            if (this.f18218h) {
                if (this.f18225o == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                j.a(z10, "Pending target must be null when starting from the first frame");
                this.f18211a.f();
                this.f18218h = false;
            }
            a aVar = this.f18225o;
            if (aVar != null) {
                this.f18225o = null;
                m(aVar);
                return;
            }
            this.f18217g = true;
            long uptimeMillis = SystemClock.uptimeMillis() + ((long) this.f18211a.e());
            this.f18211a.b();
            this.f18222l = new a(this.f18212b, this.f18211a.g(), uptimeMillis);
            this.f18219i.a(b4.c.o0(g())).B0(this.f18211a).u0(this.f18222l);
        }
    }

    private void n() {
        Bitmap bitmap = this.f18223m;
        if (bitmap != null) {
            this.f18215e.c(bitmap);
            this.f18223m = null;
        }
    }

    private void p() {
        if (!this.f18216f) {
            this.f18216f = true;
            this.f18221k = false;
            l();
        }
    }

    private void q() {
        this.f18216f = false;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f18213c.clear();
        n();
        q();
        a aVar = this.f18220j;
        if (aVar != null) {
            this.f18214d.p(aVar);
            this.f18220j = null;
        }
        a aVar2 = this.f18222l;
        if (aVar2 != null) {
            this.f18214d.p(aVar2);
            this.f18222l = null;
        }
        a aVar3 = this.f18225o;
        if (aVar3 != null) {
            this.f18214d.p(aVar3);
            this.f18225o = null;
        }
        this.f18211a.clear();
        this.f18221k = true;
    }

    /* access modifiers changed from: package-private */
    public ByteBuffer b() {
        return this.f18211a.getData().asReadOnlyBuffer();
    }

    /* access modifiers changed from: package-private */
    public Bitmap c() {
        a aVar = this.f18220j;
        return aVar != null ? aVar.e() : this.f18223m;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        a aVar = this.f18220j;
        if (aVar != null) {
            return aVar.f18231e;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public Bitmap e() {
        return this.f18223m;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f18211a.c();
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return this.f18229s;
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return this.f18211a.h() + this.f18227q;
    }

    /* access modifiers changed from: package-private */
    public int k() {
        return this.f18228r;
    }

    /* access modifiers changed from: package-private */
    public void m(a aVar) {
        d dVar = this.f18226p;
        if (dVar != null) {
            dVar.a();
        }
        this.f18217g = false;
        if (this.f18221k) {
            this.f18212b.obtainMessage(2, aVar).sendToTarget();
        } else if (!this.f18216f) {
            this.f18225o = aVar;
        } else {
            if (aVar.e() != null) {
                n();
                a aVar2 = this.f18220j;
                this.f18220j = aVar;
                for (int size = this.f18213c.size() - 1; size >= 0; size--) {
                    this.f18213c.get(size).a();
                }
                if (aVar2 != null) {
                    this.f18212b.obtainMessage(2, aVar2).sendToTarget();
                }
            }
            l();
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [i3.h, i3.h<android.graphics.Bitmap>, java.lang.Object] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void o(i3.h<android.graphics.Bitmap> r3, android.graphics.Bitmap r4) {
        /*
            r2 = this;
            java.lang.Object r0 = f4.j.d(r3)
            i3.h r0 = (i3.h) r0
            r2.f18224n = r0
            java.lang.Object r0 = f4.j.d(r4)
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            r2.f18223m = r0
            com.bumptech.glide.g<android.graphics.Bitmap> r0 = r2.f18219i
            b4.c r1 = new b4.c
            r1.<init>()
            com.bumptech.glide.request.a r3 = r1.i0(r3)
            com.bumptech.glide.g r3 = r0.a(r3)
            r2.f18219i = r3
            int r3 = f4.k.g(r4)
            r2.f18227q = r3
            int r3 = r4.getWidth()
            r2.f18228r = r3
            int r3 = r4.getHeight()
            r2.f18229s = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.g.o(i3.h, android.graphics.Bitmap):void");
    }

    /* access modifiers changed from: package-private */
    public void r(b bVar) {
        if (this.f18221k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        } else if (!this.f18213c.contains(bVar)) {
            boolean isEmpty = this.f18213c.isEmpty();
            this.f18213c.add(bVar);
            if (isEmpty) {
                p();
            }
        } else {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
    }

    /* access modifiers changed from: package-private */
    public void s(b bVar) {
        this.f18213c.remove(bVar);
        if (this.f18213c.isEmpty()) {
            q();
        }
    }

    g(m3.d dVar, h hVar, g3.a aVar, Handler handler, com.bumptech.glide.g<Bitmap> gVar, i3.h<Bitmap> hVar2, Bitmap bitmap) {
        this.f18213c = new ArrayList();
        this.f18214d = hVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f18215e = dVar;
        this.f18212b = handler;
        this.f18219i = gVar;
        this.f18211a = aVar;
        o(hVar2, bitmap);
    }
}
