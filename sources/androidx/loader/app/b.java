package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.collection.h;
import androidx.lifecycle.f0;
import androidx.lifecycle.i0;
import androidx.lifecycle.k0;
import androidx.lifecycle.l;
import androidx.lifecycle.t;
import androidx.lifecycle.u;
import androidx.loader.app.a;
import androidx.loader.content.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class b extends a {

    /* renamed from: c  reason: collision with root package name */
    static boolean f6072c = false;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final l f6073a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final c f6074b;

    public static class a<D> extends t<D> implements b.C0068b<D> {

        /* renamed from: l  reason: collision with root package name */
        private final int f6075l;

        /* renamed from: m  reason: collision with root package name */
        private final Bundle f6076m;
        @NonNull

        /* renamed from: n  reason: collision with root package name */
        private final androidx.loader.content.b<D> f6077n;

        /* renamed from: o  reason: collision with root package name */
        private l f6078o;

        /* renamed from: p  reason: collision with root package name */
        private C0066b<D> f6079p;

        /* renamed from: q  reason: collision with root package name */
        private androidx.loader.content.b<D> f6080q;

        a(int i10, Bundle bundle, @NonNull androidx.loader.content.b<D> bVar, androidx.loader.content.b<D> bVar2) {
            this.f6075l = i10;
            this.f6076m = bundle;
            this.f6077n = bVar;
            this.f6080q = bVar2;
            bVar.r(i10, this);
        }

        public void a(@NonNull androidx.loader.content.b<D> bVar, D d10) {
            if (b.f6072c) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onLoadComplete: ");
                sb2.append(this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                o(d10);
                return;
            }
            boolean z10 = b.f6072c;
            m(d10);
        }

        /* access modifiers changed from: protected */
        public void k() {
            if (b.f6072c) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("  Starting: ");
                sb2.append(this);
            }
            this.f6077n.u();
        }

        /* access modifiers changed from: protected */
        public void l() {
            if (b.f6072c) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("  Stopping: ");
                sb2.append(this);
            }
            this.f6077n.v();
        }

        public void n(@NonNull u<? super D> uVar) {
            super.n(uVar);
            this.f6078o = null;
            this.f6079p = null;
        }

        public void o(D d10) {
            super.o(d10);
            androidx.loader.content.b<D> bVar = this.f6080q;
            if (bVar != null) {
                bVar.s();
                this.f6080q = null;
            }
        }

        /* access modifiers changed from: package-private */
        public androidx.loader.content.b<D> p(boolean z10) {
            if (b.f6072c) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("  Destroying: ");
                sb2.append(this);
            }
            this.f6077n.b();
            this.f6077n.a();
            C0066b<D> bVar = this.f6079p;
            if (bVar != null) {
                n(bVar);
                if (z10) {
                    bVar.d();
                }
            }
            this.f6077n.w(this);
            if ((bVar == null || bVar.c()) && !z10) {
                return this.f6077n;
            }
            this.f6077n.s();
            return this.f6080q;
        }

        public void q(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f6075l);
            printWriter.print(" mArgs=");
            printWriter.println(this.f6076m);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f6077n);
            androidx.loader.content.b<D> bVar = this.f6077n;
            bVar.g(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.f6079p != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f6079p);
                C0066b<D> bVar2 = this.f6079p;
                bVar2.a(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(r().d(f()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(h());
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public androidx.loader.content.b<D> r() {
            return this.f6077n;
        }

        /* access modifiers changed from: package-private */
        public void s() {
            l lVar = this.f6078o;
            C0066b<D> bVar = this.f6079p;
            if (lVar != null && bVar != null) {
                super.n(bVar);
                i(lVar, bVar);
            }
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public androidx.loader.content.b<D> t(@NonNull l lVar, @NonNull a.C0065a<D> aVar) {
            C0066b<D> bVar = new C0066b<>(this.f6077n, aVar);
            i(lVar, bVar);
            C0066b<D> bVar2 = this.f6079p;
            if (bVar2 != null) {
                n(bVar2);
            }
            this.f6078o = lVar;
            this.f6079p = bVar;
            return this.f6077n;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append("LoaderInfo{");
            sb2.append(Integer.toHexString(System.identityHashCode(this)));
            sb2.append(" #");
            sb2.append(this.f6075l);
            sb2.append(" : ");
            androidx.core.util.b.a(this.f6077n, sb2);
            sb2.append("}}");
            return sb2.toString();
        }
    }

    /* renamed from: androidx.loader.app.b$b  reason: collision with other inner class name */
    static class C0066b<D> implements u<D> {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final androidx.loader.content.b<D> f6081a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private final a.C0065a<D> f6082b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f6083c = false;

        C0066b(@NonNull androidx.loader.content.b<D> bVar, @NonNull a.C0065a<D> aVar) {
            this.f6081a = bVar;
            this.f6082b = aVar;
        }

        public void a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f6083c);
        }

        public void b(D d10) {
            if (b.f6072c) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("  onLoadFinished in ");
                sb2.append(this.f6081a);
                sb2.append(": ");
                sb2.append(this.f6081a.d(d10));
            }
            this.f6082b.K(this.f6081a, d10);
            this.f6083c = true;
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            return this.f6083c;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            if (this.f6083c) {
                if (b.f6072c) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("  Resetting: ");
                    sb2.append(this.f6081a);
                }
                this.f6082b.b0(this.f6081a);
            }
        }

        public String toString() {
            return this.f6082b.toString();
        }
    }

    static class c extends f0 {

        /* renamed from: f  reason: collision with root package name */
        private static final i0.b f6084f = new a();

        /* renamed from: d  reason: collision with root package name */
        private h<a> f6085d = new h<>();

        /* renamed from: e  reason: collision with root package name */
        private boolean f6086e = false;

        static class a implements i0.b {
            a() {
            }

            @NonNull
            public <T extends f0> T a(@NonNull Class<T> cls) {
                return new c();
            }
        }

        c() {
        }

        @NonNull
        static c h(k0 k0Var) {
            return (c) new i0(k0Var, f6084f).a(c.class);
        }

        /* access modifiers changed from: protected */
        public void d() {
            super.d();
            int o10 = this.f6085d.o();
            for (int i10 = 0; i10 < o10; i10++) {
                this.f6085d.p(i10).p(true);
            }
            this.f6085d.b();
        }

        public void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f6085d.o() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i10 = 0; i10 < this.f6085d.o(); i10++) {
                    a p10 = this.f6085d.p(i10);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f6085d.j(i10));
                    printWriter.print(": ");
                    printWriter.println(p10.toString());
                    p10.q(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void g() {
            this.f6086e = false;
        }

        /* access modifiers changed from: package-private */
        public <D> a<D> i(int i10) {
            return this.f6085d.e(i10);
        }

        /* access modifiers changed from: package-private */
        public boolean j() {
            return this.f6086e;
        }

        /* access modifiers changed from: package-private */
        public void k() {
            int o10 = this.f6085d.o();
            for (int i10 = 0; i10 < o10; i10++) {
                this.f6085d.p(i10).s();
            }
        }

        /* access modifiers changed from: package-private */
        public void l(int i10, @NonNull a aVar) {
            this.f6085d.k(i10, aVar);
        }

        /* access modifiers changed from: package-private */
        public void m(int i10) {
            this.f6085d.l(i10);
        }

        /* access modifiers changed from: package-private */
        public void n() {
            this.f6086e = true;
        }
    }

    b(@NonNull l lVar, @NonNull k0 k0Var) {
        this.f6073a = lVar;
        this.f6074b = c.h(k0Var);
    }

    /* JADX INFO: finally extract failed */
    @NonNull
    private <D> androidx.loader.content.b<D> f(int i10, Bundle bundle, @NonNull a.C0065a<D> aVar, androidx.loader.content.b<D> bVar) {
        try {
            this.f6074b.n();
            androidx.loader.content.b<D> L = aVar.L(i10, bundle);
            if (L != null) {
                if (L.getClass().isMemberClass()) {
                    if (!Modifier.isStatic(L.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + L);
                    }
                }
                a aVar2 = new a(i10, bundle, L, bVar);
                if (f6072c) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("  Created new loader ");
                    sb2.append(aVar2);
                }
                this.f6074b.l(i10, aVar2);
                this.f6074b.g();
                return aVar2.t(this.f6073a, aVar);
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
        } catch (Throwable th2) {
            this.f6074b.g();
            throw th2;
        }
    }

    public void a(int i10) {
        if (this.f6074b.j()) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            if (f6072c) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("destroyLoader in ");
                sb2.append(this);
                sb2.append(" of ");
                sb2.append(i10);
            }
            a i11 = this.f6074b.i(i10);
            if (i11 != null) {
                i11.p(true);
                this.f6074b.m(i10);
            }
        } else {
            throw new IllegalStateException("destroyLoader must be called on the main thread");
        }
    }

    @Deprecated
    public void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f6074b.f(str, fileDescriptor, printWriter, strArr);
    }

    @NonNull
    public <D> androidx.loader.content.b<D> d(int i10, Bundle bundle, @NonNull a.C0065a<D> aVar) {
        if (this.f6074b.j()) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            a i11 = this.f6074b.i(i10);
            if (f6072c) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("initLoader in ");
                sb2.append(this);
                sb2.append(": args=");
                sb2.append(bundle);
            }
            if (i11 == null) {
                return f(i10, bundle, aVar, (androidx.loader.content.b) null);
            }
            if (f6072c) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("  Re-using existing loader ");
                sb3.append(i11);
            }
            return i11.t(this.f6073a, aVar);
        } else {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
    }

    public void e() {
        this.f6074b.k();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("LoaderManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        androidx.core.util.b.a(this.f6073a, sb2);
        sb2.append("}}");
        return sb2.toString();
    }
}
