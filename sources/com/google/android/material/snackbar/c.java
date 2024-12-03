package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

class c {

    /* renamed from: e  reason: collision with root package name */
    private static c f20136e;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Object f20137a = new Object();
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Handler f20138b = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: c  reason: collision with root package name */
    private C0241c f20139c;

    /* renamed from: d  reason: collision with root package name */
    private C0241c f20140d;

    class a implements Handler.Callback {
        a() {
        }

        public boolean handleMessage(@NonNull Message message) {
            if (message.what != 0) {
                return false;
            }
            c.this.d((C0241c) message.obj);
            return true;
        }
    }

    interface b {
        void a();

        void b(int i10);
    }

    /* renamed from: com.google.android.material.snackbar.c$c  reason: collision with other inner class name */
    private static class C0241c {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<b> f20142a;

        /* renamed from: b  reason: collision with root package name */
        int f20143b;

        /* renamed from: c  reason: collision with root package name */
        boolean f20144c;

        C0241c(int i10, b bVar) {
            this.f20142a = new WeakReference<>(bVar);
            this.f20143b = i10;
        }

        /* access modifiers changed from: package-private */
        public boolean a(b bVar) {
            return bVar != null && this.f20142a.get() == bVar;
        }
    }

    private c() {
    }

    private boolean a(@NonNull C0241c cVar, int i10) {
        b bVar = cVar.f20142a.get();
        if (bVar == null) {
            return false;
        }
        this.f20138b.removeCallbacksAndMessages(cVar);
        bVar.b(i10);
        return true;
    }

    static c c() {
        if (f20136e == null) {
            f20136e = new c();
        }
        return f20136e;
    }

    private boolean f(b bVar) {
        C0241c cVar = this.f20139c;
        return cVar != null && cVar.a(bVar);
    }

    private boolean g(b bVar) {
        C0241c cVar = this.f20140d;
        return cVar != null && cVar.a(bVar);
    }

    private void l(@NonNull C0241c cVar) {
        int i10 = cVar.f20143b;
        if (i10 != -2) {
            if (i10 <= 0) {
                if (i10 == -1) {
                    i10 = 1500;
                } else {
                    i10 = 2750;
                }
            }
            this.f20138b.removeCallbacksAndMessages(cVar);
            Handler handler = this.f20138b;
            handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), (long) i10);
        }
    }

    private void n() {
        C0241c cVar = this.f20140d;
        if (cVar != null) {
            this.f20139c = cVar;
            this.f20140d = null;
            b bVar = cVar.f20142a.get();
            if (bVar != null) {
                bVar.a();
            } else {
                this.f20139c = null;
            }
        }
    }

    public void b(b bVar, int i10) {
        synchronized (this.f20137a) {
            if (f(bVar)) {
                a(this.f20139c, i10);
            } else if (g(bVar)) {
                a(this.f20140d, i10);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(@NonNull C0241c cVar) {
        synchronized (this.f20137a) {
            if (this.f20139c == cVar || this.f20140d == cVar) {
                a(cVar, 2);
            }
        }
    }

    public boolean e(b bVar) {
        boolean z10;
        synchronized (this.f20137a) {
            if (!f(bVar)) {
                if (!g(bVar)) {
                    z10 = false;
                }
            }
            z10 = true;
        }
        return z10;
    }

    public void h(b bVar) {
        synchronized (this.f20137a) {
            if (f(bVar)) {
                this.f20139c = null;
                if (this.f20140d != null) {
                    n();
                }
            }
        }
    }

    public void i(b bVar) {
        synchronized (this.f20137a) {
            if (f(bVar)) {
                l(this.f20139c);
            }
        }
    }

    public void j(b bVar) {
        synchronized (this.f20137a) {
            if (f(bVar)) {
                C0241c cVar = this.f20139c;
                if (!cVar.f20144c) {
                    cVar.f20144c = true;
                    this.f20138b.removeCallbacksAndMessages(cVar);
                }
            }
        }
    }

    public void k(b bVar) {
        synchronized (this.f20137a) {
            if (f(bVar)) {
                C0241c cVar = this.f20139c;
                if (cVar.f20144c) {
                    cVar.f20144c = false;
                    l(cVar);
                }
            }
        }
    }

    public void m(int i10, b bVar) {
        synchronized (this.f20137a) {
            if (f(bVar)) {
                C0241c cVar = this.f20139c;
                cVar.f20143b = i10;
                this.f20138b.removeCallbacksAndMessages(cVar);
                l(this.f20139c);
                return;
            }
            if (g(bVar)) {
                this.f20140d.f20143b = i10;
            } else {
                this.f20140d = new C0241c(i10, bVar);
            }
            C0241c cVar2 = this.f20139c;
            if (cVar2 == null || !a(cVar2, 4)) {
                this.f20139c = null;
                n();
            }
        }
    }
}
