package com.google.android.gms.common.api.internal;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.api.m;
import com.google.android.gms.common.api.n;
import com.google.android.gms.common.internal.p;
import java.lang.ref.WeakReference;

public final class u2<R extends j> extends n<R> implements k<R> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public m f38768a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public u2 f38769b = null;

    /* renamed from: c  reason: collision with root package name */
    private volatile l f38770c = null;

    /* renamed from: d  reason: collision with root package name */
    private f f38771d = null;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Object f38772e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private Status f38773f = null;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final WeakReference f38774g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final s2 f38775h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f38776i = false;

    public u2(WeakReference weakReference) {
        Looper looper;
        p.l(weakReference, "GoogleApiClient reference must not be null");
        this.f38774g = weakReference;
        d dVar = (d) weakReference.get();
        if (dVar != null) {
            looper = dVar.l();
        } else {
            looper = Looper.getMainLooper();
        }
        this.f38775h = new s2(this, looper);
    }

    /* access modifiers changed from: private */
    public final void l(Status status) {
        synchronized (this.f38772e) {
            this.f38773f = status;
            n(status);
        }
    }

    private final void m() {
        if (this.f38768a != null || this.f38770c != null) {
            d dVar = (d) this.f38774g.get();
            if (!(this.f38776i || this.f38768a == null || dVar == null)) {
                dVar.s(this);
                this.f38776i = true;
            }
            Status status = this.f38773f;
            if (status != null) {
                n(status);
                return;
            }
            f fVar = this.f38771d;
            if (fVar != null) {
                fVar.setResultCallback(this);
            }
        }
    }

    private final void n(Status status) {
        synchronized (this.f38772e) {
            m mVar = this.f38768a;
            if (mVar != null) {
                ((u2) p.k(this.f38769b)).l((Status) p.l(mVar.a(status), "onFailure must not return null"));
            } else if (o()) {
                ((l) p.k(this.f38770c)).b(status);
            }
        }
    }

    private final boolean o() {
        return (this.f38770c == null || ((d) this.f38774g.get()) == null) ? false : true;
    }

    /* access modifiers changed from: private */
    public static final void p(j jVar) {
        if (jVar instanceof h) {
            try {
                ((h) jVar).release();
            } catch (RuntimeException unused) {
                "Unable to release ".concat(String.valueOf(jVar));
            }
        }
    }

    public final void a(j jVar) {
        synchronized (this.f38772e) {
            if (!jVar.getStatus().i0()) {
                l(jVar.getStatus());
                p(jVar);
            } else if (this.f38768a != null) {
                j2.a().submit(new r2(this, jVar));
            } else if (o()) {
                ((l) p.k(this.f38770c)).c(jVar);
            }
        }
    }

    @NonNull
    public final <S extends j> n<S> b(@NonNull m<? super R, ? extends S> mVar) {
        boolean z10;
        u2 u2Var;
        synchronized (this.f38772e) {
            boolean z11 = true;
            if (this.f38768a == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            p.p(z10, "Cannot call then() twice.");
            if (this.f38770c != null) {
                z11 = false;
            }
            p.p(z11, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.f38768a = mVar;
            u2Var = new u2(this.f38774g);
            this.f38769b = u2Var;
            m();
        }
        return u2Var;
    }

    /* access modifiers changed from: package-private */
    public final void j() {
        this.f38770c = null;
    }

    public final void k(f fVar) {
        synchronized (this.f38772e) {
            this.f38771d = fVar;
            m();
        }
    }
}
